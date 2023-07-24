package net.minecraft.src.stever9487.commands.cmds;

import net.minecraft.src.stever9487.Client;
import net.minecraft.src.stever9487.commands.Command;
import net.minecraft.src.stever9487.hacks.KillAura;

public class KillAuraConfig extends Command {
    public KillAuraConfig() {
        super("killaura", "KillAura configuration", "killaura/ka [players/animals/mobs/radius] [newRadius]", "ka");
    }

    public void onCommand(String[] args, String command){
        if(args.length < 1) {
            Client.addChatMessage("Radius: " + KillAura.radius);
            Client.addChatMessage("PlayerAura: " + (KillAura.players ? "\u00A7aON" : "\u00A7cOFF"));
            Client.addChatMessage("MobAura: " + (KillAura.mobs ? "\u00A7aON" : "\u00A7cOFF"));
            Client.addChatMessage("AnimalAura: " + (KillAura.animals ? "\u00A7aON" : "\u00A7cOFF"));
        }else{
            if(args[0].equalsIgnoreCase("radius")) {
                try{
                    KillAura.radius = Integer.parseInt(args[1]);
                    Client.addChatMessage("Successfully set radius to " + KillAura.radius);
                } catch(Exception ex) {
                    Client.addChatMessage("Invalid radius!");
                }
            }else if(args[0].equalsIgnoreCase("players")) {
                KillAura.players = !KillAura.players;
                Client.addChatMessage("Toggled PlayerAura " + (KillAura.players ? "\u00A7aON" : "\u00A7cOFF"));
            }else if(args[0].equalsIgnoreCase("mobs")) {
                KillAura.mobs = !KillAura.mobs;
                Client.addChatMessage("Toggled MobAura " + (KillAura.mobs ? "\u00A7aON" : "\u00A7cOFF"));
            }else if(args[0].equalsIgnoreCase("animals")) {
                KillAura.animals = !KillAura.animals;
                Client.addChatMessage("Toggled AnimalAura " + (KillAura.animals ? "\u00A7aON" : "\u00A7cOFF"));
            }
        }
    }
}