package net.minecraft.src.stever9487.hacks;

import net.minecraft.src.ItemFood;
import net.minecraft.src.ItemStack;
import net.minecraft.src.stever9487.Client;
import net.minecraft.src.stever9487.Hack;
import net.minecraft.src.stever9487.event.EventListener;
import net.minecraft.src.stever9487.event.EventRegistry;
import net.minecraft.src.stever9487.event.updates.EventPlayerUpdate;
import net.minecraft.src.stever9487.utils.Timer;

public class AutoEat extends Hack implements EventListener<EventPlayerUpdate> {
	private static Timer timer = new Timer();

	public AutoEat() {
		super("AutoEat", "Test", -1);
		EventRegistry.registerListener(EventPlayerUpdate.class, this);
	}

	public void handleEvent(EventPlayerUpdate e) {
		if(e.isPre && Client.mc.thePlayer.health < 20) {
			for(int i = 0; i < 9; ++i) {
				int prevItem = Client.mc.thePlayer.inventory.currentItem;
				ItemStack stack = Client.mc.thePlayer.inventory.getStackInSlot(i);
				if(stack != null && stack.getItem() instanceof ItemFood && timer.hasTimeElapsed(10L, false)) {
					Client.mc.thePlayer.inventory.currentItem = i;
					Client.mc.playerController.sendUseItem(Client.mc.thePlayer, Client.mc.theWorld, Client.mc.thePlayer.inventory.getStackInSlot(i));
					Client.mc.thePlayer.inventory.currentItem = prevItem;
					timer.reset();
				}
			}
		}
	}
}
