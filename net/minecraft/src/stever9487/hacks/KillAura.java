package net.minecraft.src.stever9487.hacks;

import net.minecraft.src.*;
import net.minecraft.src.stever9487.Client;
import net.minecraft.src.stever9487.Hack;
import net.minecraft.src.stever9487.event.EventListener;
import net.minecraft.src.stever9487.event.EventRegistry;
import net.minecraft.src.stever9487.event.updates.EventMPPlayerUpdate;
import net.minecraft.src.stever9487.utils.FileUtil;
import org.lwjgl.input.Keyboard;

import java.io.*;
import java.util.List;

public class KillAura extends Hack implements EventListener<EventMPPlayerUpdate> {
	public static boolean mobs;
	public static boolean animals;
	public static boolean players;
	public static int radius;

	public KillAura() {
		super("KillAura", "Test", Keyboard.KEY_K);
		EventRegistry.registerListener(EventMPPlayerUpdate.class, this);
	}

	public boolean canBeAttacked(Entity e){
		return e instanceof EntityMobs && mobs || e instanceof EntityAnimals && animals || e instanceof EntityPlayer && players && !Client.friends.contains(((EntityPlayer)e).field_771_i) ? true : false;
	}

	public static void settingsSave() throws IOException {
		File file = new File(FileUtil.shid.getAbsolutePath(), "killaura.txt");
		file.createNewFile();
		FileWriter fileWriter = new FileWriter(file);
		fileWriter.write("mobs:" + mobs + "\n");
		fileWriter.write("animals:" + animals + "\n");
		fileWriter.write("players:" + players + "\n");
		fileWriter.write("radius:" + radius + "\n");
		fileWriter.close();
	}

	public static void settingsLoad() throws IOException {
		File file = new File(FileUtil.shid.getAbsolutePath(), "killaura.txt");
		if(!file.exists()) {
			mobs = true;
			animals = true;
			players = false;
			radius = 7;
		}

		if(file.exists()) {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

			while(true) {
				String s = bufferedReader.readLine();
				if(s == null) break;
				String[] args = s.split(":");
				if(args[0].equals("mobs")) {
					mobs = Boolean.parseBoolean(args[1]);
				}else if(args[0].equals("animals")) {
					animals = Boolean.parseBoolean(args[1]);
				}else if(args[0].equals("players")) {
					players = Boolean.parseBoolean(args[1]);
				}else if(args[0].equals("radius")) {
					radius = Integer.parseInt(args[1]);
				}
			}
		}
	}

	public String getPrefix() {
		return this.formatPrefix(radius + this.formatPrefix((players ? "P" : "") + (mobs ? "M" : "") + (animals ? "A" : "")));
	}

	public void handleEvent(EventMPPlayerUpdate event) {
		if(event.isPre && Client.mc.isMultiplayerWorld()) {
			List<?> list = Client.mc.theWorld.getEntitiesWithinAABBExcludingEntity(Client.mc.thePlayer, AxisAlignedBB.getBoundingBox(Client.mc.thePlayer.posX - radius, Client.mc.thePlayer.posY - radius, Client.mc.thePlayer.posZ - radius, Client.mc.thePlayer.posX + radius, Client.mc.thePlayer.posY + radius, Client.mc.thePlayer.posZ + radius));
			for(int i = 0; i < list.size(); ++i) {
				Entity e = (Entity)list.get(i);
				if(this.canBeAttacked(e)) {
					Client.mc.func_20001_q().addToSendQueue(new Packet7(0, e.field_620_ab, 1));
				}
			}
		}
	}
}
