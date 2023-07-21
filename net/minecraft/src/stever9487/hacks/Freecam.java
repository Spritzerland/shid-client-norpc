package net.minecraft.src.stever9487.hacks;

import net.minecraft.src.Packet0KeepAlive;
import net.minecraft.src.Packet10Flying;
import net.minecraft.src.Packet11PlayerPosition;
import net.minecraft.src.Packet13PlayerLookMove;
import net.minecraft.src.stever9487.Client;
import net.minecraft.src.stever9487.Hack;
import net.minecraft.src.stever9487.event.Event;
import net.minecraft.src.stever9487.event.EventListener;
import net.minecraft.src.stever9487.event.EventRegistry;
import net.minecraft.src.stever9487.event.updates.EventPacketSend;
import net.minecraft.src.stever9487.event.updates.EventPlayerUpdate;
import org.lwjgl.input.Keyboard;

public class Freecam extends Hack implements EventListener {
	public Freecam() {
		super("Freecam", "Test", Keyboard.KEY_C);
		EventRegistry.registerListener(EventPlayerUpdate.class, this);
		EventRegistry.registerListener(EventPacketSend.class, this);
	}

	public void toggle() {
		super.toggle();
		Client.hacks[7].setToggle(this.isToggled());
		Fly.instance.setToggle(this.isToggled());
	}

	public void handleEvent(Event e) {
		if(e instanceof EventPlayerUpdate && e.isPre && Client.mc.theWorld.multiplayerWorld) {
			Client.mc.func_20001_q().addToSendQueue(new Packet0KeepAlive());
			e.isCancelled = true;
		}else if(e instanceof EventPacketSend){
			EventPacketSend ev = (EventPacketSend)e;
			if(ev.getPacket() instanceof Packet10Flying || ev.getPacket() instanceof Packet11PlayerPosition || ev.getPacket() instanceof Packet13PlayerLookMove){
				ev.isCancelled = true;
			}
		}
	}
}
