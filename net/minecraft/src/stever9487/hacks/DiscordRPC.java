package net.minecraft.src.stever9487.hacks;

import net.minecraft.src.stever9487.Hack;
import net.minecraft.src.stever9487.utils.Discord;

public class DiscordRPC extends Hack {
	public DiscordRPC() {
		super("DiscordRPC", "Test", -1);
	}

	public void onEnable() {
		Discord.startRPC();
	}

	public void onDisable() {
		Discord.stopRPC();
	}
}
