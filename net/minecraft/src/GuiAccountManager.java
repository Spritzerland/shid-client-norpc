package net.minecraft.src;

import org.lwjgl.input.Keyboard;

public class GuiAccountManager extends GuiScreen {
	private GuiScreen updateCounter;
	private int parentScreen = 0;
	private String username = "";

	public GuiAccountManager(GuiScreen var1) {
		this.updateCounter = var1;
	}

	public void updateScreen() {
		++this.parentScreen;
	}

	public void initGui() {
		Keyboard.enableRepeatEvents(true);
		this.controlList.clear();
		this.controlList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 96 + 12, "Change"));
		this.controlList.add(new GuiButton(1, this.width / 2 - 100, this.height / 4 + 120 + 12, "Cancel"));
		this.username = this.mc.session.playerName;
		((GuiButton)this.controlList.get(0)).enabled = this.username.length() > 0;
	}

	public void onGuiClosed() {
		Keyboard.enableRepeatEvents(false);
	}

	protected void actionPerformed(GuiButton var1) {
		if(var1.enabled) {
			if(var1.id == 1) {
				this.mc.displayGuiScreen(this.updateCounter);
			} else if(var1.id == 0) {
				this.mc.session.playerName = username;
				this.mc.displayGuiScreen(this.updateCounter);
			}

		}
	}

	protected void keyTyped(char var1, int var2) {
		if(var1 == 22) {
			String var3 = GuiScreen.getClipboardString();
			if(var3 == null) {
				var3 = "";
			}

			int var4 = 32 - this.username.length();
			if(var4 > var3.length()) {
				var4 = var3.length();
			}

			if(var4 > 0) {
				this.username = this.username + var3.substring(0, var4);
			}
		}

		if(var1 == 13) {
			this.actionPerformed((GuiButton)this.controlList.get(0));
		}

		if(var2 == 14 && this.username.length() > 0) {
			this.username = this.username.substring(0, this.username.length() - 1);
		}

		if(FontAllowedCharacters.field_20157_a.indexOf(var1) >= 0 && this.username.length() < 32) {
			this.username = this.username + var1;
		}

		((GuiButton)this.controlList.get(0)).enabled = this.username.length() > 0;
	}

	public void drawScreen(int var1, int var2, float var3) {
		this.drawDefaultBackground();
		this.drawCenteredString(this.fontRenderer, "Account Manager", this.width / 2, this.height / 4 - 60 + 20, 16777215);
		this.drawString(this.fontRenderer, "New username:", this.width / 2 - 100, this.height / 4 - 10 + 50 + 18 - 22, 10526880);
		int var5 = this.width / 2 - 100;
		int var6 = this.height / 4 - 10 + 50 + 18;
		short var7 = 200;
		byte var8 = 20;
		this.drawRect(var5 - 1, var6 - 1, var5 + var7 + 1, var6 + var8 + 1, -6250336);
		this.drawRect(var5, var6, var5 + var7, var6 + var8, -16777216);
		this.drawString(this.fontRenderer, this.username + (this.parentScreen / 6 % 2 == 0 ? "_" : ""), var5 + 4, var6 + (var8 - 8) / 2, 14737632);
		super.drawScreen(var1, var2, var3);
	}
}
