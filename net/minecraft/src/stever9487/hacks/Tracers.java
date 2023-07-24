package net.minecraft.src.stever9487.hacks;

import net.minecraft.src.Entity;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.RenderManager;
import net.minecraft.src.Vec3D;
import net.minecraft.src.stever9487.Client;
import net.minecraft.src.stever9487.Hack;
import net.minecraft.src.stever9487.event.EventListener;
import net.minecraft.src.stever9487.event.EventRegistry;
import net.minecraft.src.stever9487.event.updates.EventOnEntityRender;
import net.minecraft.src.stever9487.utils.RenderUtil;

import java.awt.*;

public class Tracers extends Hack implements EventListener<EventOnEntityRender> {
	public Tracers() {
		super("Tracers", "Test", -1);
		EventRegistry.registerListener(EventOnEntityRender.class, this);
	}

	public static Vec3D interpolateEntity(Entity entity, float time) {
		return new Vec3D(entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * time, entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * time, entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * time);
	}

	public void handleEvent(EventOnEntityRender e) {
		for(int x = 0; x < Client.mc.theWorld.playerEntities.size(); x++) {
			EntityPlayer entity = Client.mc.theWorld.playerEntities.get(x);
			if(!entity.field_771_i.contains(" ") && (entity instanceof EntityPlayer) && !entity.field_771_i.equals(Client.mc.thePlayer.field_771_i)) {
				final Vec3D pos = interpolateEntity(entity, Client.mc.timer.renderPartialTicks).subtract(RenderManager.renderPosX, RenderManager.renderPosY, RenderManager.renderPosZ);
				if(pos != null) {
					final boolean bobbing = Client.mc.gameSettings.viewBobbing;
					Client.mc.gameSettings.viewBobbing = false;
					Client.mc.entityRenderer.setupCameraTransform(Client.mc.timer.renderPartialTicks, 0);
					final Vec3D forward = new Vec3D(0, 0, 1).rotatePitch(-(float) Math.toRadians(Client.mc.thePlayer.rotationPitch)).rotateYaw(-(float) Math.toRadians(Client.mc.thePlayer.rotationYaw));
					if(Client.friends.contains(entity.field_771_i)) {
						RenderUtil.drawLine3D((float) forward.xCoord, (float) forward.yCoord, (float) forward.zCoord, (float) pos.xCoord, (float) pos.yCoord + 1.0F, (float) pos.zCoord, 2f, 0.1f, 0.8f, 0.1f, 1.0f);
					}else {
						RenderUtil.drawLine3D((float) forward.xCoord, (float) forward.yCoord, (float) forward.zCoord, (float) pos.xCoord, (float) pos.yCoord + 1.0F, (float) pos.zCoord, 2f, 0.709f, 0.576f, 0.858f, 1.0f);
					}
					Client.mc.gameSettings.viewBobbing = bobbing;
					Client.mc.entityRenderer.setupCameraTransform(Client.mc.timer.renderPartialTicks, 0);
				}
			}
		}
	}
}
