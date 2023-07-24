package net.minecraft.src;

import net.minecraft.src.stever9487.commands.CommandManager;
import org.lwjgl.input.Keyboard;

public class GuiChat extends GuiScreen {
	private String message = "";
	private int updateCounter = 0;
	private static final String field_20082_i = FontAllowedCharacters.field_20157_a;
	private static CommandManager commandManager = new CommandManager();
	public static boolean isMsgCancelled = false;

	public void initGui() {
		Keyboard.enableRepeatEvents(true);
	}

	public void onGuiClosed() {
		Keyboard.enableRepeatEvents(false);
	}

	public void updateScreen() {
		++this.updateCounter;
	}

	protected void keyTyped(char var1, int var2) {
		if(var2 == 1) {
			this.mc.displayGuiScreen((GuiScreen)null);
		} else if(var2 == 28) {
			commandManager.handleMessage(this.message);
			if(!isMsgCancelled) {
				String var3 = this.message.trim();
				if(var3.length() > 0) {
					this.mc.thePlayer.sendChatMessage(this.message.trim());
				}
			}else{
				isMsgCancelled = false;
			}
			this.mc.displayGuiScreen((GuiScreen)null);
		} else {
			if(var2 == 14 && this.message.length() > 0) {
				this.message = this.message.substring(0, this.message.length() - 1);
			}

			if(field_20082_i.indexOf(var1) >= 0 && this.message.length() < 100) {
				this.message = this.message + var1;
			}

		}
	}

	public void drawScreen(int var1, int var2, float var3) {
		this.drawRect(2, this.height - 14, this.width - 2, this.height - 2, Integer.MIN_VALUE);
		this.drawString(this.fontRenderer, "> " + this.message + (this.updateCounter / 6 % 2 == 0 ? "_" : ""), 4, this.height - 12, 14737632);
	}

	protected void mouseClicked(int var1, int var2, int var3) {
		if(var3 == 0 && this.mc.ingameGUI.field_933_a != null) {
			if(this.message.length() > 0 && !this.message.endsWith(" ")) {
				this.message = this.message + " ";
			}

			this.message = this.message + this.mc.ingameGUI.field_933_a;
			byte var4 = 100;
			if(this.message.length() > var4) {
				this.message = this.message.substring(0, var4);
			}
		}

	}
}
