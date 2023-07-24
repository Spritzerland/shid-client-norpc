package net.minecraft.src;

public class ScaledResolution {
	private int scaledWidth;
	private int scaledHeight;
	public double field_25121_a;
	public double field_25120_b;
	public int scaleFactor;
	public int screenSize = 2;

	public ScaledResolution(int var1, int var2) {
		this.scaledWidth = var1;
		this.scaledHeight = var2;
		this.scaleFactor = 1;
		if(screenSize == 0) {
			screenSize = 1000;
		}

		//for(this.scaleFactor = 1; this.scaledWidth / (this.scaleFactor + 1) >= 320 && this.scaledHeight / (this.scaleFactor + 1) >= 240; ++this.scaleFactor) {}
		while(this.scaleFactor < screenSize && this.scaledWidth / (this.scaleFactor + 1) >= 320 && this.scaledHeight / (this.scaleFactor + 1) >= 240) {
			++this.scaleFactor;
		}

		/*--scaleFactor;
		if(scaleFactor < 1) {
			scaleFactor = 1;
		}*/

		this.field_25121_a = (double)this.scaledWidth / (double)this.scaleFactor;
		this.field_25120_b = (double)this.scaledHeight / (double)this.scaleFactor;
		this.scaledWidth = (int)Math.ceil(this.field_25121_a);
		this.scaledHeight = (int)Math.ceil(this.field_25120_b);

		//this.scaledWidth /= this.scaleFactor;
		//this.scaledHeight /= this.scaleFactor;
	}

	public int getScaledWidth() {
		return this.scaledWidth;
	}

	public int getScaledHeight() {
		return this.scaledHeight;
	}
}
