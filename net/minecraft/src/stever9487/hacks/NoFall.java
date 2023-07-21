package net.minecraft.src.stever9487.hacks;

import net.minecraft.src.Packet10Flying;
import net.minecraft.src.Packet11PlayerPosition;
import net.minecraft.src.Packet12PlayerLook;
import net.minecraft.src.Packet13PlayerLookMove;
import net.minecraft.src.stever9487.Client;
import net.minecraft.src.stever9487.Hack;
import net.minecraft.src.stever9487.event.Event;
import net.minecraft.src.stever9487.event.EventListener;
import net.minecraft.src.stever9487.event.EventRegistry;
import net.minecraft.src.stever9487.event.updates.EventPacketSend;
import net.minecraft.src.stever9487.event.updates.EventPlayerUpdate;

public class NoFall extends Hack implements EventListener {
	public NoFall() {
		super("NoFall", "Test", -1);
		EventRegistry.registerListener(EventPlayerUpdate.class, this);
		EventRegistry.registerListener(EventPacketSend.class, this);
	}

	public void onGroundMethod(EventPacketSend e) {
		if(e.getPacket() instanceof Packet10Flying) {
			Packet10Flying packet = (Packet10Flying) e.getPacket();
			packet.onGround = true;
		}

		if(e.getPacket() instanceof Packet11PlayerPosition) {
			Packet11PlayerPosition packet = (Packet11PlayerPosition) e.getPacket();
			packet.onGround = true;
		}

		if(e.getPacket() instanceof Packet12PlayerLook) {
			Packet12PlayerLook packet = (Packet12PlayerLook) e.getPacket();
			packet.onGround = true;
		}

		if(e.getPacket() instanceof Packet13PlayerLookMove) {
			Packet13PlayerLookMove packet = (Packet13PlayerLookMove) e.getPacket();
			packet.onGround = true;
		}
	}

	public void handleEvent(Event e) {
		if(e instanceof EventPlayerUpdate && e.isPre && Client.mc.thePlayer.fallDistance > 2.0F && Client.mc.isMultiplayerWorld()) {
			Client.mc.func_20001_q().addToSendQueue(new Packet10Flying());
		}else if(e instanceof EventPacketSend) {
			this.onGroundMethod((EventPacketSend)e);
		}
	}
}
