package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class Packet9 extends Packet {
	public void processPacket(NetHandler var1) {
		var1.func_9448_a(this);
	}

	public void readPacketData(DataInputStream var1) {
	}

	public void writePacketData(DataOutputStream var1) {
	}

	public int getPacketSize() {
		return 0;
	}
}
