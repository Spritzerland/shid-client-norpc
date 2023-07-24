package net.minecraft.src.stever9487.hacks;

import net.minecraft.src.*;
import net.minecraft.src.stever9487.Client;
import net.minecraft.src.stever9487.Hack;
import net.minecraft.src.stever9487.event.EventListener;
import net.minecraft.src.stever9487.event.EventRegistry;
import net.minecraft.src.stever9487.event.updates.EventOnEntityRender;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;

public class Nametags extends Hack implements EventListener<EventOnEntityRender> {
	public Nametags() {
		super("NameTags", "Test", -1);
		EventRegistry.registerListener(EventOnEntityRender.class, this);
	}

	public static void renderNameTag(EntityPlayer e) {
		/*String username = getDisplayName(e);
		FontRenderer fontRenderer = Client.mc.fontRenderer;
		double renderTicks = Client.mc.timer.renderPartialTicks;
		double doubleX = e.lastTickPosX + (e.posX - e.lastTickPosX) * renderTicks;
		double doubleY = e.lastTickPosY + (e.posY - e.lastTickPosY) * renderTicks;
		double doubleZ = e.lastTickPosZ + (e.posZ - e.lastTickPosZ) * renderTicks;
		float X = (float)doubleX;
		boolean isSneaking = e.isSneaking();
		float height = e.height + 0.5F - (isSneaking ? 0.25F : 0.0F);
		float Y = (float)doubleY + height;
		float Z = (float)doubleZ;
		float renderX = (float)(X - (RenderManager.field_1222_l));
		float renderY = (float)(Y - (RenderManager.field_1221_m));
		float renderZ = (float)(Z - (RenderManager.field_1220_n));

		float var12 = 2.5F;
		float var13 = (float)(1.0D / 60.0D) * var12;
		GL11.glPushMatrix();
		GL11.glTranslatef(renderX, renderY, renderZ);
		GL11.glNormal3f(0.0F, 1.0F, 0.0F);
		GL11.glRotatef(-RenderManager.field_1225_i, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(RenderManager.field_1224_j, 1.0F, 0.0F, 0.0F);
		GL11.glScalef(-var13, -var13, var13);
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glDepthMask(false);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		Tessellator var14 = Tessellator.instance;

		GL11.glDisable(GL11.GL_TEXTURE_2D);
		var14.startDrawingQuads();
		int var16 = fontRenderer.getStringWidth(username) / 2;
		var14.setColorRGBA_F(0.0F, 0.0F, 0.0F, 0.25F);
		if(Client.friends.contains(e.field_771_i)) var14.setColorRGBA_F(0.0F, 0.5F, 0.0F, 0.25F);
		var14.addVertex(-var16 - 1, -1, 0.0D);
		var14.addVertex(-var16 - 1, 8, 0.0D);
		var14.addVertex(var16 + 1, 8, 0.0D);
		var14.addVertex(var16 + 1, -1, 0.0D);
		var14.draw();
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glDepthMask(true);
		ArrayList<ItemStack> items = getRenderStacks(e);
		int xOffset = items.size() * 8;
		for(ItemStack stack : items) {
			xOffset -= 16;
			renderItemStack(stack, xOffset, -20, 0.7f);
		}
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		fontRenderer.drawString(username, -fontRenderer.getStringWidth(username) / 2, 0, -1);
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_BLEND);
		//GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glPopMatrix();*/
		// i hate this
		try{
			String username = getDisplayName(e);
			FontRenderer fontRenderer = Client.mc.fontRenderer;
			double renderTicks = Client.mc.timer.renderPartialTicks;
			double doubleX = e.lastTickPosX + (e.posX - e.lastTickPosX) * renderTicks;
			double doubleY = e.lastTickPosY + (e.posY - e.lastTickPosY) * renderTicks;
			double doubleZ = e.lastTickPosZ + (e.posZ - e.lastTickPosZ) * renderTicks;
			float X = (float)doubleX;
			boolean isSneaking = e.isSneaking();
			float height = e.height + 0.5F - (isSneaking ? 0.25F : 0.0F);
			float Y = (float)doubleY + height;
			float Z = (float)doubleZ;
			float renderX = (float)(X - (RenderManager.field_1222_l));
			float renderY = (float)(Y - (RenderManager.field_1221_m));
			float renderZ = (float)(Z - (RenderManager.field_1220_n));
			float scale = 1.6F;
			float size = (float)((float)((1.0D / 60.0D) * scale) * (Math.sqrt(e.getDistanceToEntity(RenderManager.instance.field_1226_h))) / 2.0D);
			GL11.glPushMatrix();
			GL11.glTranslatef(renderX, renderY, renderZ);
			GL11.glNormal3f(0.0F, 1.0F, 0.0F);
			GL11.glRotatef(-RenderManager.field_1225_i, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(RenderManager.field_1224_j, 1.0F, 0.0F, 0.0F);
			GL11.glScalef(-size, -size, size);
			GL11.glDisable(GL11.GL_LIGHTING);
			Tessellator tessellator = Tessellator.instance;
			GL11.glDepthMask(false);
			GL11.glDisable(GL11.GL_DEPTH_TEST);
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

			GL11.glDisable(GL11.GL_TEXTURE_2D);
			tessellator.startDrawingQuads();
			int width = fontRenderer.getStringWidth(username) / 2;
			if(Client.friends.contains(e.field_771_i)) {
				tessellator.setColorRGBA_F(0.0F, 0.5F, 0.0F, 0.25F);
			}else {
				tessellator.setColorRGBA_F(0.0F, 0.0F, 0.0F, 0.25F);
			}
			tessellator.addVertex(-width - 1, -1, 0.0D);
			tessellator.addVertex(-width - 1, 8, 0.0D);
			tessellator.addVertex(width + 1, 8, 0.0D);
			tessellator.addVertex(width + 1, -1, 0.0D);
			tessellator.draw();
			GL11.glEnable(GL11.GL_TEXTURE_2D);
			ArrayList<ItemStack> items = getRenderStacks(e);
			int xOffset = items.size() * 8;
			for(ItemStack stack : items) {
				xOffset -= 16;
				renderItemStack(stack, xOffset, -20, 0.7f);
			}
			fontRenderer.drawString(username, -width, 0, 553648127);
			//GL11.glEnable(GL11.GL_DEPTH_TEST);
			GL11.glDepthMask(true);
			fontRenderer.drawString(username, -width, 0, -1);
			GL11.glDisable(GL11.GL_BLEND);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			GL11.glPopMatrix();
		}catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static String getDisplayName(EntityPlayer e) {
		String[] colors = {
				"§4",
				"§6",
				"§2"
		};
		int distance = Math.round(Client.mc.thePlayer.getDistanceToEntity(e));
		return e.field_771_i + " " + colors[Math.round(0.1F * Math.min(distance, 20))] + distance;
	}

	public static ArrayList<ItemStack> getRenderStacks(EntityPlayer e) {
		ArrayList<ItemStack> stacks = new ArrayList<>();
		for(ItemStack stack : e.inventory.armorInventory) {
			if(stack != null) {
				Item item = stack.getItem();
				if(item != null) stacks.add(stack);
			}
		}
		if(e.inventory.mainInventory != null) stacks.add(e.inventory.mainInventory[0]);
		return stacks;
	}

	public static void renderItemStack(ItemStack item, int xOffset, int yOffset, float scale){
		GL11.glPushMatrix();
		GL11.glDepthMask(true);
		GL11.glScalef(scale, scale, scale);
		RenderHelper.enableStandardItemLighting();
		GL11.glDepthMask(true);
		//GL11.glEnable(GL11.GL_DEPTH_TEST);
		GuiIngame.itemRenderer.renderItemIntoGUI(Client.mc.fontRenderer, Client.mc.renderEngine, item, xOffset, yOffset);
		GuiIngame.itemRenderer.renderItemOverlayIntoGUI(Client.mc.fontRenderer, Client.mc.renderEngine, item, xOffset, yOffset);
		RenderHelper.disableStandardItemLighting();
		GL11.glScalef(0.5F, 0.5F, 0.5F);
		//GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glPopMatrix();
	}

	public void handleEvent(EventOnEntityRender e) {
		for(EntityPlayer p : Client.mc.theWorld.playerEntities) {
			if(p != Client.mc.thePlayer) {
				renderNameTag(p);
			}
		}
	}
}
