package net.minecraft.src.stever9487.commands.cmds;

import net.minecraft.src.stever9487.Client;
import net.minecraft.src.stever9487.Hack;
import net.minecraft.src.stever9487.commands.Command;

public class Unbind extends Command {
    public Unbind() {
        super("unbind", "Unbind a hack from its key", "unbind <hack>", "unbind");
    }

    public void onCommand(String[] args, String command){
        if(args.length == 1) {
            String hackName = args[0];
            boolean foundHack = false;
            for(Hack hack : Client.hacks) {
                if(hack.getName().toLowerCase().startsWith(hackName.toLowerCase())){
                    hack.setKey(-1);
                    foundHack = true;
                    Client.addChatMessage("Unbinded " + hack.getName());
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