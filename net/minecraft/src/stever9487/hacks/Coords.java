package net.minecraft.src.stever9487.hacks;

import net.minecraft.src.MathHelper;
import net.minecraft.src.ScaledResolution;
import net.minecraft.src.stever9487.Client;
import net.minecraft.src.stever9487.Hack;
import net.minecraft.src.stever9487.event.EventListener;
import net.minecraft.src.stever9487.event.EventRegistry;
import net.minecraft.src.stever9487.event.updates.EventAfterDebug;

public class Coords extends Hack implements EventListener<EventAfterDebug> {
	public Coords() {
		super("Coords", "Test", -1);
		EventRegistry.registerListener(EventAfterDebug.class, this);
	}

	private String getCurrentDirection() {
		int f = (MathHelper.floor_double((double)(Client.mc.thePlayer.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3);
		switch(f){
			case 0:
				return "+Z";
			case 1:
				return "-X";
			case 2:
				return "-Z";
			case 3:
				return "+X";
			default:
				return "Unknown";
		}
	}

	public void handleEvent(EventAfterDebug e) {
		ScaledResolution scaledResolution = new ScaledResolution(Client.mc.displayWidth, Client.mc.displayHeight);
		int X = MathHelper.floor_double(Client.mc.thePlayer.posX);
		int Y = MathHelper.floor_double(Client.mc.thePlayer.posY);
		int Z = MathHelper.floor_double(Client.mc.thePlayer.posZ);
		Client.mc.fontRenderer.drawStringWithShadow("§6XYZ §7" + X + ", " + Y + ", " + Z, scaledResolution.getScaledWidth() - Client.mc.fontRenderer.getStringWidth("§6XYZ §7" + X + ", " + Y + ", " + Z) - 2, scaledResolution.getScaledHeight() - 20, -1);
		Client.mc.fontRenderer.drawStringWithShadow("§6Direction §7" + getCurrentDirection(), scaledResolution.getScaledWidth() - Client.mc.fontRenderer.getStringWidth("§6Direction §7" + getCurrentDirection()) - 2, scaledResolution.getScaledHeight() - 10, -1);
	}
}
