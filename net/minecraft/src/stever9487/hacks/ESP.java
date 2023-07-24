package net.minecraft.src.stever9487.hacks;

import net.minecraft.src.*;
import net.minecraft.src.stever9487.Client;
import net.minecraft.src.stever9487.Hack;
import net.minecraft.src.stever9487.event.EventListener;
import net.minecraft.src.stever9487.event.EventRegistry;
import net.minecraft.src.stever9487.event.updates.EventOnEntityRender;
import net.minecraft.src.stever9487.utils.RenderUtil;

import java.awt.*;

public class ESP extends Hack implements EventListener<EventOnEntityRender> {
	public static boolean players = true;
	public static boolean items = true;
	public static boolean mobs = true;
	public static boolean animals = true;
	public ESP() {
		super("ESP", "Test", -1);
		EventRegistry.registerListener(EventOnEntityRender.class, this);
	}

	public void handleEvent(EventOnEntityRender event) {
		for(Object o : Client.mc.theWorld.loadedEntityList) {
			Entity e = (Entity) o;
			double cX = e.posX;
			double cY = e.posY;
			double cZ = e.posZ;
			double renderX = cX - RenderManager.renderPosX;
			double renderY = cY - RenderManager.renderPosY;
			double renderZ = cZ - RenderManager.renderPosZ;
			if(e instanceof EntityPlayer && e != Client.mc.thePlayer && players) {
				if(Client.friends.contains(((EntityPlayer) e).field_771_i)) {
					RenderUtil.drawOutlinedEntityESP(renderX, renderY, renderZ, e.width, e.height * 1.1, 0.1f, 0.8f, 0.1f, 1.0f);
				}else {
					RenderUtil.drawOutlinedEntityESP(renderX, renderY, renderZ, e.width, e.height * 1.1, 0.709f, 0.576f, 0.858f, 1.0f);
				}
			}else if(e instanceof EntityItem && items) {
				RenderUtil.drawOutlinedEntityESP(renderX, renderY, renderZ, e.width, e.height * 1.8, 0.709f, 0.576f, 0.858f, 1.0f);
			}else if(e instanceof EntityMobs && mobs) {
				RenderUtil.drawOutlinedEntityESP(renderX, renderY, renderZ, e.width, e.height, 0.980f, 0f, 0.274f, 1.0f);
			}else if(e instanceof EntityAnimals && animals) {
				RenderUtil.drawOutlinedEntityESP(renderX, renderY, renderZ, e.width, e.height * 1.2, 0f, 0.980f, 0.176f, 1.0f);
			}
		}
	}
}
