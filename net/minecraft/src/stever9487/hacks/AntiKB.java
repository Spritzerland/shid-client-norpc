package net.minecraft.src.stever9487.hacks;

import net.minecraft.src.Packet28;
import net.minecraft.src.stever9487.Client;
import net.minecraft.src.stever9487.Hack;
import net.minecraft.src.stever9487.event.EventListener;
import net.minecraft.src.stever9487.event.EventRegistry;
import net.minecraft.src.stever9487.event.updates.EventPacketReceive;

public class AntiKB extends Hack implements EventListener<EventPacketReceive> {
	public AntiKB() {
		super("AntiKB", "Test", -1);
		EventRegistry.registerListener(EventPacketReceive.class, this);
	}

	public void handleEvent(EventPacketReceive event) {
		if(event.packet instanceof Packet28 && ((Packet28)event.packet).field_6367_a == Client.mc.thePlayer.field_620_ab){
			event.isCancelled = true;
		}
	}
}
