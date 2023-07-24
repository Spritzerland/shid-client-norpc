package net.minecraft.src.stever9487.hacks;

import net.minecraft.src.EntityPlayerSP;
import net.minecraft.src.stever9487.Client;
import net.minecraft.src.stever9487.Hack;
import net.minecraft.src.stever9487.event.Event;
import net.minecraft.src.stever9487.event.EventListener;
import net.minecraft.src.stever9487.event.EventRegistry;
import net.minecraft.src.stever9487.event.updates.EventPacketSend;
import net.minecraft.src.stever9487.event.updates.EventPlayerUpdate;
import org.lwjgl.input.Keyboard;

public class Fly extends Hack implements EventListener {
	public static Fly instance;

	public Fly() {
		super("Fly", "Test", Keyboard.KEY_Z);
		instance = this;
		EventRegistry.registerListener(EventPlayerUpdate.class, this);
		EventRegistry.registerListener(EventPacketSend.class, this);
	}

	public void runFly(EntityPlayerSP entityPlayerSP){
		if(instance.isToggled()) {
			entityPlayerSP.onGround = false;
			entityPlayerSP.motionX = 0.0D;
			entityPlayerSP.motionY = 0.0D;
			entityPlayerSP.motionZ = 0.0D;
			double d = entityPlayerSP.rotationYaw + 90.0D;
			boolean flag = Keyboard.isKeyDown(Keyboard.KEY_W);
			boolean flag1 = Keyboard.isKeyDown(Keyboard.KEY_S);
			boolean flag2 = Keyboard.isKeyDown(Keyboard.KEY_A);
			boolean flag3 = Keyboard.isKeyDown(Keyboard.KEY_D);
			if(flag) {
				if(flag2) {
					d -= 45.0D;
				} else if(flag3) {
					d += 45.0D;
				}
			} else if(flag1) {
				d += 180.0D;
				if(flag2) {
					d += 45.0D;
				} else if(flag3) {
					d -= 45.0D;
				}
			} else if(flag2) {
				d -= 90.0D;
			} else if(flag3) {
				d += 90.0D;
			}

			if(flag || flag2 || flag1 || flag3) {
				entityPlayerSP.motionX = Math.cos(Math.toRadians(d));
				entityPlayerSP.motionZ = Math.sin(Math.toRadians(d));
			}

			if(Keyboard.isKeyDown(Keyboard.KEY_SPACE) && Client.mc.field_6289_L) {
				entityPlayerSP.motionY = entityPlayerSP.motionY + 1.0D;
			} else if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) && Client.mc.field_6289_L) {
				entityPlayerSP.motionY = entityPlayerSP.motionY - 1.0D;
			}
			if(!Client.hacks[8].isToggled()) {
				entityPlayerSP.motionX /= 5.0D;
				entityPlayerSP.motionY /= 5.0D;
				entityPlayerSP.motionZ /= 5.0D;
			}
		}
	}

	public void handleEvent(Event e) {
		if(e instanceof EventPlayerUpdate && e.isPre) {
			this.runFly(Client.mc.thePlayer);
		}
		/*else if(e instanceof EventPacketSend && ((EventPacketSend)e).packet instanceof Packet10Flying) { // NoCheat "bypass", works better without this tho
			int i = this.packetAmount++;
			if(i > 10) {
				this.packetAmount = 0;
				Popbob.mc.getSendQueue().addToSendQueue(new Packet19EntityAction(Popbob.mc.thePlayer, 3));
			}
		}*/
	}
}
