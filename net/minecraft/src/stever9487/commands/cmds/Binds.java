package net.minecraft.src.stever9487.commands.cmds;

import net.minecraft.src.stever9487.Client;
import net.minecraft.src.stever9487.Hack;
import net.minecraft.src.stever9487.commands.Command;
import org.lwjgl.input.Keyboard;

import java.util.HashSet;
import java.util.Set;

public class Binds extends Command {
    public Binds() {
        super("binds", "Show current hack keybinds", "binds", "binds");
    }

    public void onCommand(String[] args, String command){
        String hacks = "";
        Set<String> addedHacks = new HashSet<>();
        for(Hack h : Client.hacksList) {
            if(!addedHacks.contains(h.name) && h.key != -1) {
                hacks = hacks + h.name + " - " + Keyboard.getKeyName(h.key) + ", ";
                addedHacks.add(h.name);
            }
        }
        hacks = hacks.substring(0, hacks.length() - 2);
        Client.addChatMessage(hacks);
    }
}