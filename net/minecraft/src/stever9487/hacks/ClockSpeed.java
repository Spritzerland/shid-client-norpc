package net.minecraft.src.stever9487.hacks;

import net.minecraft.src.stever9487.Hack;
import net.minecraft.src.stever9487.utils.FileUtil;

import java.io.*;

public class ClockSpeed extends Hack {
	public static float speed;
	public ClockSpeed() {
		super("ClockSpeed", "Test", -1);
	}

	public static void settingsSave() throws IOException {
		File file = new File(FileUtil.shid.getAbsolutePath(), "clockspeed.txt");
		file.createNewFile();
		FileWriter fileWriter = new FileWriter(file);
		fileWriter.write(String.valueOf(speed));
		fileWriter.close();
	}

	public static void settingsLoad() throws IOException {
		File file = new File(FileUtil.shid.getAbsolutePath(), "clockspeed.txt");
		if(!file.exists()) {
			speed = 1.17F;
		}

		if(file.exists()) {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
			String s = bufferedReader.readLine();
			speed = Float.parseFloat(s);
		}
	}

	public String getPrefix() { return this.formatPrefix(String.valueOf(this.speed));}
}
