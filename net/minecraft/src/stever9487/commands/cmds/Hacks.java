package net.minecraft.src.stever9487.commands.cmds;

import net.minecraft.src.stever9487.Client;
import net.minecraft.src.stever9487.Hack;
import net.minecraft.src.stever9487.commands.Command;

import java.util.HashSet;
import java.util.Set;

public class Hacks extends Command {
    public Hacks() {
        super("hacks", "Hack list", "hacks", "hacks");
    }

    public void onCommand(String[] args, String command){
        String hacks = "";
        Set<String> addedHacks = new HashSet<>();
        for(Hack h : Client.hacksList) {
            if(!addedHacks.contains(h.name)) {
                hacks = hacks + h.name + ", ";
                addedHacks.add(h.name);
            }
        }
        hacks = hacks.substring(0, hacks.length() - 2);
        Client.addChatMessage(hacks);
    }
}