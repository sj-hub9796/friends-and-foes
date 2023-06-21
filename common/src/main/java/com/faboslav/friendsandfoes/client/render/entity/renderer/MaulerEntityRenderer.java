package com.faboslav.friendsandfoes.client.render.entity.renderer;

import com.faboslav.friendsandfoes.FriendsAndFoes;
import com.faboslav.friendsandfoes.client.render.entity.model.MaulerEntityModel;
import com.faboslav.friendsandfoes.entity.MaulerEntity;
import com.faboslav.friendsandfoes.init.FriendsAndFoesEntityModelLayer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
@SuppressWarnings({"rawtypes", "unchecked"})
public final class MaulerEntityRenderer extends MobEntityRenderer<MaulerEntity, MaulerEntityModel<MaulerEntity>>
{
	private static final float SHADOW_RADIUS = 0.35F;

	public MaulerEntityRenderer(EntityRendererFactory.Context context) {
		super(context, new MaulerEntityModel(context.getPart(FriendsAndFoesEntityModelLayer.MAULER_LAYER)), SHADOW_RADIUS);
	}

	@Override
	public Identifier getTexture(MaulerEntity mauler) {
		return FriendsAndFoes.makeID("textures/entity/mauler/" + mauler.getMaulerType().getName() + ".png");
	}

	@Override
	public void render(
		MaulerEntity mauler,
		float f,
		float tickDelta,
		MatrixStack matrixStack,
		VertexConsumerProvider vertexConsumerProvider,
		int i
	) {
		this.shadowRadius = mauler.isBurrowedDown() ? 0.0F:SHADOW_RADIUS;
		super.render(mauler, f, tickDelta, matrixStack, vertexConsumerProvider, i);
	}

	@Override
	protected void scale(MaulerEntity mauler, MatrixStack matrixStack, float f) {
		float size = mauler.getSize();
		matrixStack.scale(size, size, size);
	}
}