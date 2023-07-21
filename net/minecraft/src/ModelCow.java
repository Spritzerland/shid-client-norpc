package net.minecraft.src;

public class ModelCow extends ModelQuadraped {
	ModelRenderer udders;
	ModelRenderer horn1;
	ModelRenderer horn2;

	public ModelCow() {
		super(12, 0.0F);
		this.head = new ModelRenderer(0, 0);
		this.head.addBox(-4.0F, -4.0F, -6.0F, 8, 8, 6, 0.0F);
		this.head.setPosition(0.0F, 4.0F, -8.0F);
		this.horn1 = new ModelRenderer(22, 0);
		this.horn1.addBox(-4.0F, -5.0F, -4.0F, 1, 3, 1, 0.0F);
		this.horn1.setPosition(0.0F, 3.0F, -7.0F);
		this.horn2 = new ModelRenderer(22, 0);
		this.horn2.addBox(4.0F, -5.0F, -4.0F, 1, 3, 1, 0.0F);
		this.horn2.setPosition(0.0F, 3.0F, -7.0F);
		this.udders = new ModelRenderer(52, 0);
		this.udders.addBox(-2.0F, -3.0F, 0.0F, 4, 6, 2, 0.0F);
		this.udders.setPosition(0.0F, 14.0F, 6.0F);
		this.udders.rotateAngleX = (float)Math.PI * 0.5F;
		this.body = new ModelRenderer(18, 4);
		this.body.addBox(-6.0F, -10.0F, -7.0F, 12, 18, 10, 0.0F);
		this.body.setPosition(0.0F, 5.0F, 2.0F);
		--this.leg1.offsetX;
		++this.leg2.offsetX;
		this.leg1.offsetZ += 0.0F;
		this.leg2.offsetZ += 0.0F;
		--this.leg3.offsetX;
		++this.leg4.offsetX;
		--this.leg3.offsetZ;
		--this.leg4.offsetZ;
	}

	public void render(float var1, float var2, float var3, float var4, float var5, float var6) {
		super.render(var1, var2, var3, var4, var5, var6);
		this.horn1.render(var6);
		this.horn2.render(var6);
		this.udders.render(var6);
	}

	public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6) {
		super.setRotationAngles(var1, var2, var3, var4, var5, var6);
		this.horn1.rotateAngleY = this.head.rotateAngleY;
		this.horn1.rotateAngleX = this.head.rotateAngleX;
		this.horn2.rotateAngleY = this.head.rotateAngleY;
		this.horn2.rotateAngleX = this.head.rotateAngleX;
	}
}
