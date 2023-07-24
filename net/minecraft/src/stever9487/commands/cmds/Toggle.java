package net.minecraft.src.stever9487.commands.cmds;

import net.minecraft.src.stever9487.Client;
import net.minecraft.src.stever9487.Hack;
import net.minecraft.src.stever9487.commands.Command;

public class Toggle extends Command {
    public Toggle() {
        super("toggle", "Toggle a hack by name. You don\'t have to write it\'s full name.", "toggle/t <name>", "t");
    }

    public void onCommand(String[] args, String command){
        if(args.length == 1) {
            String hackName = args[0];
            boolean foundHack = false;
            for(Hack hack : Client.hacks) {
                if(hack.getName().toLowerCase().startsWith(hackName.toLowerCase())){
                    hack.toggle();
                    foundHack = true;
                    break;
                }
            }
            if(!foundHack){
                Client.addChatMessage("Couldn\'t find hack \"" + hackName.toLowerCase() + "\"");
            }
        }else{
            Client.addChatMessage("Usage: " + this.syntax);
        }
    }
}