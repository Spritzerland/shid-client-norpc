package net.minecraft.src.stever9487.hacks;

import net.minecraft.src.FontRenderer;
import net.minecraft.src.ScaledResolution;
import net.minecraft.src.stever9487.Client;
import net.minecraft.src.stever9487.Hack;
import net.minecraft.src.stever9487.event.EventListener;
import net.minecraft.src.stever9487.event.EventRegistry;
import net.minecraft.src.stever9487.event.updates.EventAfterDebug;

public class ServerStatus extends Hack implements EventListener<EventAfterDebug> {
	public ServerStatus() {
		super("ServerStatus", "Test", -1);
		EventRegistry.registerListener(EventAfterDebug.class, this);
	}

	public void drawCenteredString(FontRenderer fontRenderer, String s, int x, int y, int color) {
		fontRenderer.drawStringWithShadow(s, x - fontRenderer.getStringWidth(s) / 2, y, color);
	}

	public void handleEvent(EventAfterDebug event) {
		if(Client.mc.theWorld.multiplayerWorld) {
			ScaledResolution scaledResolution = new ScaledResolution(Client.mc.displayWidth, Client.mc.displayHeight);
			if(Client.mc.func_20001_q().netManager.timeSinceLastRead >= 20) {
				double time = (double)Client.mc.func_20001_q().netManager.timeSinceLastRead / 20.0D;
				this.drawCenteredString(Client.mc.fontRenderer, "Server has been frozen for: " + String.format("%.1f", new Object[]{Double.valueOf(time)}) + "s", scaledResolution.getScaledWidth() / 2, 10, 16777215);
			}
		}
	}
}
