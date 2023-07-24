package net.minecraft.src;

import java.awt.*;
import java.util.Random;

import net.minecraft.src.stever9487.Client;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

public class GuiMainMenu extends GuiScreen {
	private static final Random rand = new Random();
	String[] minecraftLogo = new String[]{"  **** *   * ***** **** ",
			                              " *     *   *   *   *   *",
			                              "  ***  *****   *   *   *",
			                              "     * *   *   *   *   *",
			                              " ****  *   * ***** **** "};
	private LogoEffectRandomizer[][] logoEffects;
	private float updateCounter = 0.0F;
	private String splashText = "AlphaAnarchy is cool now =P";

	public GuiMainMenu() {

	}

	public void updateScreen() {
		++this.updateCounter;
		if(this.logoEffects != null) {
			for(int var1 = 0; var1 < this.logoEffects.length; ++var1) {
				for(int var2 = 0; var2 < this.logoEffects[var1].length; ++var2) {
					this.logoEffects[var1][var2].func_875_a();
				}
			}
		}

	}

	protected void keyTyped(char var1, int var2) {
	}

	public void initGui() {
		StringTranslate var2 = StringTranslate.func_20162_a();
		int var4 = this.height / 4 + 48;
		this.controlList.add(new GuiButton(0, this.width / 2 - 100, var4 + 96, 98, 20, "Options"));
		this.controlList.add(new GuiButton(1, this.width / 2 - 100, var4, "Singleplayer"));
		this.controlList.add(new GuiButton(2, this.width / 2 - 100, var4 + 24, "Multiplayer"));
		this.controlList.add(new GuiButton(3, this.width / 2 - 100, var4 + 48, "Texture Packs"));
		this.controlList.add(new GuiButton(4, this.width / 2 - 100, var4 + 72, "Account Manager"));
		this.controlList.add(new GuiButton(5, this.width / 2 + 2, var4 + 96, 98, 20, "Quit"));

	}

	protected void actionPerformed(GuiButton var1) {
		if(var1.id == 0) {
			this.mc.displayGuiScreen(new GuiOptions(this, this.mc.gameSettings));
		}

		if(var1.id == 1) {
			this.mc.displayGuiScreen(new GuiSelectWorld(this));
		}

		if(var1.id == 2) {
			this.mc.displayGuiScreen(new GuiMultiplayer(this));
		}

		if(var1.id == 3) {
			this.mc.displayGuiScreen(new GuiTexturePacks(this));
		}

		if(var1.id == 4) {
			this.mc.displayGuiScreen(new GuiAccountManager(this));
		}

		if(var1.id == 5) {
			this.mc.shutdown();
		}

	}

	public int getColor(){
		float a = 4.0F;
		float b = (float)(System.currentTimeMillis() % (long)((int)(a * 1000.0F))) / (a * 1000.0F);
		return Color.HSBtoRGB(b, 0.8F, 1.0F);
	}

	public void drawScreen(int var1, int var2, float var3) {
		this.drawDefaultBackground();
		Tessellator var4 = Tessellator.instance;
		this.drawLogo(var3);
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, this.mc.renderEngine.getTexture("/gui/logo.png"));
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		var4.setColorOpaque_I(16777215);
		GL11.glPushMatrix();
		GL11.glTranslatef((float)(this.width / 2 + 90), 70.0F, 0.0F);
		GL11.glRotatef(-20.0F, 0.0F, 0.0F, 1.0F);
		float var5 = 1.8F - MathHelper.abs(MathHelper.sin((float)(System.currentTimeMillis() % 1000L) / 1000.0F * (float)Math.PI * 2.0F) * 0.1F);
		var5 = var5 * 100.0F / (float)(this.fontRenderer.getStringWidth(this.splashText) + 32);
		GL11.glScalef(var5, var5, var5);
		this.drawCenteredString(this.fontRenderer, this.splashText, 0, -8, this.getColor());
		GL11.glPopMatrix();
		this.drawString(this.fontRenderer, "Shid Client", 2, 2, 16777215);
		this.drawString(this.fontRenderer, "Created by stever9487", this.width - this.fontRenderer.getStringWidth("Created by stever9487") - 2, 2, 16777215);
		if(Client.needsUpdate) {
			this.drawString(this.fontRenderer, "\u00A7aUpdate available!", 2, this.height - 10, 16777215);
		}else if(Client.latestVersion == null) {
			this.drawString(this.fontRenderer, "\u00A7cChecking for updates...", 2, this.height - 10, 16777215);
		}
		super.drawScreen(var1, var2, var3);
	}

	private void drawLogo(float var1) {
		int var3;
		if(this.logoEffects == null) {
			this.logoEffects = new LogoEffectRandomizer[this.minecraftLogo[0].length()][this.minecraftLogo.length];

			for(int var2 = 0; var2 < this.logoEffects.length; ++var2) {
				for(var3 = 0; var3 < this.logoEffects[var2].length; ++var3) {
					this.logoEffects[var2][var3] = new LogoEffectRandomizer(this, var2, var3);
				}
			}
		}

		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glPushMatrix();
		GL11.glLoadIdentity();
		ScaledResolution var14 = new ScaledResolution(this.mc.displayWidth, this.mc.displayHeight);
		var3 = 120 * var14.scaleFactor;
		GLU.gluPerspective(70.0F, (float)this.mc.displayWidth / (float)var3, 0.05F, 100.0F);
		GL11.glViewport(0, this.mc.displayHeight - var3, this.mc.displayWidth, var3);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glPushMatrix();
		GL11.glLoadIdentity();
		GL11.glDisable(GL11.GL_CULL_FACE);
		GL11.glCullFace(GL11.GL_BACK);
		GL11.glDepthMask(true);
		RenderBlocks var4 = new RenderBlocks();

		for(int var5 = 0; var5 < 3; ++var5) {
			GL11.glPushMatrix();
			GL11.glTranslatef(0.4F, 0.6F, -13.0F);
			if(var5 == 0) {
				GL11.glClear(GL11.GL_DEPTH_BUFFER_BIT);
				GL11.glTranslatef(0.0F, -0.4F, 0.0F);
				GL11.glScalef(0.98F, 1.0F, 1.0F);
				GL11.glEnable(GL11.GL_BLEND);
				GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			}

			if(var5 == 1) {
				GL11.glDisable(GL11.GL_BLEND);
				GL11.glClear(GL11.GL_DEPTH_BUFFER_BIT);
			}

			if(var5 == 2) {
				GL11.glEnable(GL11.GL_BLEND);
				GL11.glBlendFunc(GL11.GL_SRC_COLOR, GL11.GL_ONE);
			}

			GL11.glScalef(1.0F, -1.0F, 1.0F);
			GL11.glRotatef(15.0F, 1.0F, 0.0F, 0.0F);
			GL11.glScalef(0.89F, 1.0F, 0.4F);
			GL11.glTranslatef((float)(-this.minecraftLogo[0].length()) * 0.5F, (float)(-this.minecraftLogo.length) * 0.5F, 0.0F);
			GL11.glBindTexture(GL11.GL_TEXTURE_2D, this.mc.renderEngine.getTexture("/terrain.png"));
			if(var5 == 0) {
				GL11.glBindTexture(GL11.GL_TEXTURE_2D, this.mc.renderEngine.getTexture("/title/black.png"));
			}

			for(int var6 = 0; var6 < this.minecraftLogo.length; ++var6) {
				for(int var7 = 0; var7 < this.minecraftLogo[var6].length(); ++var7) {
					char var8 = this.minecraftLogo[var6].charAt(var7);
					if(var8 != 32) {
						GL11.glPushMatrix();
						LogoEffectRandomizer var9 = this.logoEffects[var7][var6];
						float var10 = (float)(var9.field_1311_b + (var9.field_1312_a - var9.field_1311_b) * (double)var1);
						float var11 = 1.0F;
						float var12 = 1.0F;
						float var13 = 0.0F;
						if(var5 == 0) {
							var11 = var10 * 0.04F + 1.0F;
							var12 = 1.0F / var11;
							var10 = 0.0F;
						}

						GL11.glTranslatef((float)var7, (float)var6, var10);
						GL11.glScalef(var11, var11, var11);
						GL11.glRotatef(var13, 0.0F, 1.0F, 0.0F);
						var4.func_1238_a(Block.tnt, var12);
						GL11.glPopMatrix();
					}
				}
			}

			GL11.glPopMatrix();
		}

		GL11.glDisable(GL11.GL_BLEND);
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glPopMatrix();
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glPopMatrix();
		GL11.glViewport(0, 0, this.mc.displayWidth, this.mc.displayHeight);
		GL11.glEnable(GL11.GL_CULL_FACE);
	}

	static Random getRand() {
		return rand;
	}
}
