package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class RenderZombieSimple extends RenderLiving {
	private float field_204_f;

	public RenderZombieSimple(ModelBase var1, float var2, float var3) {
		super(var1, var2 * var3);
		this.field_204_f = var3;
	}

	protected void a(EntityZombieSimple var1, float var2) {
		GL11.glScalef(this.field_204_f, this.field_204_f, this.field_204_f);
	}

	protected void preRenderCallback(EntityLiving var1, float var2) {
		this.a((EntityZombieSimple)var1, var2);
	}
}
