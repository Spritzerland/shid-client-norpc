package net.minecraft.src.stever9487.hacks;

import net.minecraft.src.stever9487.Client;
import net.minecraft.src.stever9487.Hack;
import org.lwjgl.input.Keyboard;

public class Xray extends Hack {
	public static Xray instance;
	public Xray() {
		super("XRay", "Test", Keyboard.KEY_X);
		instance = this;
	}

	public void toggle() {
		super.toggle();
		int posX = (int)Client.mc.thePlayer.posX;
		int posZ = (int)Client.mc.thePlayer.posZ;
		Client.mc.theWorld.func_701_b(posX - 1000, 0, posZ - 1000, posX + 1000, 127, posZ + 1000);
		Client.mc.entityRenderer.func_911_a();
	}
}
