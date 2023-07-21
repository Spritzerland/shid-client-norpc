package net.minecraft.src;

import org.lwjgl.input.Keyboard;

public class GuiMultiplayer extends GuiScreen {
	private GuiScreen updateCounter;
	private int parentScreen = 0;
	private String serverAddress = "";

	public GuiMultiplayer(GuiScreen var1) {
		this.updateCounter = var1;
	}

	public void updateScreen() {
		++this.parentScreen;
	}

	public void initGui() {
		StringTranslate var1 = StringTranslate.func_20162_a();
		Keyboard.enableRepeatEvents(true);
		this.controlList.clear();
		this.controlList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 96 + 12, var1.func_20163_a("multiplayer.connect")));
		this.controlList.add(new GuiButton(1, this.width / 2 - 100, this.height / 4 + 120 + 12, var1.func_20163_a("gui.cancel")));
		this.serverAddress = this.mc.gameSettings.lastServer.replaceAll("_", ":");
		((GuiButton)this.controlList.get(0)).enabled = this.serverAddress.length() > 0;
	}

	public void onGuiClosed() {
		Keyboard.enableRepeatEvents(false);
	}

	protected void actionPerformed(GuiButton var1) {
		if(var1.enabled) {
			if(var1.id == 1) {
				this.mc.displayGuiScreen(this.updateCounter);
			} else if(var1.id == 0) {
				this.mc.gameSettings.lastServer = this.serverAddress.replaceAll(":", "_");
				this.mc.gameSettings.saveOptions();
				String[] var2 = this.serverAddress.split(":");
				this.mc.displayGuiScreen(new GuiConnecting(this.mc, var2[0], var2.length > 1 ? this.func_4067_a(var2[1], 25565) : 25565));
			}

		}
	}

	private int func_4067_a(String var1, int var2) {
		try {
			return Integer.parseInt(var1.trim());
		} catch (Exception var4) {
			return var2;
		}
	}

	protected void keyTyped(char var1, int var2) {
		if(var1 == 22) {
			String var3 = GuiScreen.getClipboardString();
			if(var3 == null) {
				var3 = "";
			}

			int var4 = 32 - this.serverAddress.length();
			if(var4 > var3.length()) {
				var4 = var3.length();
			}

			if(var4 > 0) {
				this.serverAddress = this.serverAddress + var3.substring(0, var4);
			}
		}

		if(var1 == 13) {
			this.actionPerformed((GuiButton)this.controlList.get(0));
		}

		if(var2 == 14 && this.serverAddress.length() > 0) {
			this.serverAddress = this.serverAddress.substring(0, this.serverAddress.length() - 1);
		}

		if(FontAllowedCharacters.field_20157_a.indexOf(var1) >= 0 && this.serverAddress.length() < 32) {
			this.serverAddress = this.serverAddress + var1;
		}

		((GuiButton)this.controlList.get(0)).enabled = this.serverAddress.length() > 0;
	}

	public void drawScreen(int var1, int var2, float var3) {
		StringTranslate var4 = StringTranslate.func_20162_a();
		this.drawDefaultBackground();
		this.drawCenteredString(this.fontRenderer, var4.func_20163_a("multiplayer.title"), this.width / 2, this.height / 4 - 60 + 20, 16777215);
		this.drawString(this.fontRenderer, var4.func_20163_a("multiplayer.info1"), this.width / 2 - 140, this.height / 4 - 60 + 60 + 0, 10526880);
		this.drawString(this.fontRenderer, var4.func_20163_a("multiplayer.info2"), this.width / 2 - 140, this.height / 4 - 60 + 60 + 9, 10526880);
		this.drawString(this.fontRenderer, var4.func_20163_a("multiplayer.ipinfo"), this.width / 2 - 140, this.height / 4 - 60 + 60 + 36, 10526880);
		int var5 = this.width / 2 - 100;
		int var6 = this.height / 4 - 10 + 50 + 18;
		short var7 = 200;
		byte var8 = 20;
		this.drawRect(var5 - 1, var6 - 1, var5 + var7 + 1, var6 + var8 + 1, -6250336);
		this.drawRect(var5, var6, var5 + var7, var6 + var8, -16777216);
		this.drawString(this.fontRenderer, this.serverAddress + (this.parentScreen / 6 % 2 == 0 ? "_" : ""), var5 + 4, var6 + (var8 - 8) / 2, 14737632);
		super.drawScreen(var1, var2, var3);
	}
}
