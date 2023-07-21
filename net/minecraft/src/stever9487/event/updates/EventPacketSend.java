package net.minecraft.src.stever9487.event.updates;

import net.minecraft.src.Packet;
import net.minecraft.src.stever9487.event.Event;

public class EventPacketSend extends Event {
    public Packet packet;

    public EventPacketSend(Packet packet){
        this.packet = packet;
    }

    public Packet getPacket() {
        return this.packet;
    }
}
