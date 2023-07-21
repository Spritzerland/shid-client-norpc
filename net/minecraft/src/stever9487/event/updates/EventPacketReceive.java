package net.minecraft.src.stever9487.event.updates;

import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;
import net.minecraft.src.stever9487.event.Event;

public class EventPacketReceive extends Event {
    public Packet packet;

    public EventPacketReceive(Packet packet) { this.packet = packet; }

    public void process(NetHandler handler) {
        if(!this.isCancelled) {
            this.packet.processPacket(handler);
        }
    }
}
