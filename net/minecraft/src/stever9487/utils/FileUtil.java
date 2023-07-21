package net.minecraft.src.stever9487.utils;

import net.minecraft.src.EntityRenderer;
import net.minecraft.src.stever9487.Client;
import net.minecraft.src.stever9487.hacks.ClockSpeed;
import net.minecraft.src.stever9487.hacks.KillAura;

import java.io.File;
import java.io.IOException;

public class FileUtil {
    public static File shid;

    public static void loadAll() {
        createFS();

        try{
            Client.hacksLoad();
            Client.keybindsLoad();
            KillAura.settingsLoad();
            ClockSpeed.settingsLoad();
            EntityRenderer.fovLoad();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    public static void saveAll() {
        try{
            Client.hacksSave();
            Client.keybindsSave();
            KillAura.settingsSave();
            ClockSpeed.settingsSave();
            EntityRenderer.fovSave();
        }catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void createFS() {
        shid = new File("Shid Client");
        if(!shid.exists()) {
            shid.mkdirs();
        }
    }
}
