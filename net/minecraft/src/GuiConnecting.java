package net.minecraft.src;

import net.minecraft.client.Minecraft;

public class GuiConnecting extends GuiScreen {
	private NetClientHandler clientHandler;
	private boolean cancelled = false;

	public GuiConnecting(Minecraft var1, String var2, int var3) {
		var1.func_6261_a((World)null);
		(new ThreadConnectToServer(this, var1, var2, var3)).start();
	}

	public void updateScreen() {
		if(this.clientHandler != null) {
			this.clientHandler.processReadPackets();
		}

	}

	protected void keyTyped(char var1, int var2) {
	}

	public void initGui() {
		StringTranslate var1 = StringTranslate.func_20162_a();
		this.controlList.clear();
		this.controlList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 120 + 12, var1.func_20163_a("gui.cancel")));
	}

	protected void actionPerformed(GuiButton var1) {
		if(var1.id == 0) {
			this.cancelled = true;
			if(this.clientHandler != null) {
				this.clientHandler.disconnect();
			}

			this.mc.displayGuiScreen(new GuiMainMenu());
		}

	}

	public void drawScreen(int var1, int var2, float var3) {
		this.drawDefaultBackground();
		StringTranslate var4 = StringTranslate.func_20162_a();
		if(this.clientHandler == null) {
			this.drawCenteredString(this.fontRenderer, var4.func_20163_a("connect.connecting"), this.width / 2, this.height / 2 - 50, 16777215);
			this.drawCenteredString(this.fontRenderer, "", this.width / 2, this.height / 2 - 10, 16777215);
		} else {
			this.drawCenteredString(this.fontRenderer, var4.func_20163_a("connect.authorizing"), this.width / 2, this.height / 2 - 50, 16777215);
			this.drawCenteredString(this.fontRenderer, this.clientHandler.field_1209_a, this.width / 2, this.height / 2 - 10, 16777215);
		}

		super.drawScreen(var1, var2, var3);
	}

	static NetClientHandler setNetClientHandler(GuiConnecting var0, NetClientHandler var1) {
		return var0.clientHandler = var1;
	}

	static boolean isCancelled(GuiConnecting var0) {
		return var0.cancelled;
	}

	static NetClientHandler getNetClientHandler(GuiConnecting var0) {
		return var0.clientHandler;
	}
}
