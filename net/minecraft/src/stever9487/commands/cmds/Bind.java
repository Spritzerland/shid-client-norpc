package net.minecraft.src.stever9487.commands.cmds;

import net.minecraft.src.stever9487.Client;
import net.minecraft.src.stever9487.Hack;
import net.minecraft.src.stever9487.commands.Command;
import org.lwjgl.input.Keyboard;

public class Bind extends Command {
    public Bind() {
        super("bind", "Bind a hack to a key", "bind <hack> <key>", "bind");
    }

    public void onCommand(String[] args, String command){
        if(args.length == 2) {
            String hackName = args[0];
            int key = Keyboard.getKeyIndex(args[1].toUpperCase());
            boolean foundHack = false;
            for(Hack hack : Client.hacks) {
                if(hack.name.toLowerCase().startsWith(hackName.toLowerCase())) {
                    hack.setKey(key);
                    Client.addChatMessage("Binded " + hack.getName() + " to key " + Keyboard.getKeyName(hack.getKey()));
                    foundHack = true;
                    break;
                }
            }
            if(!foundHack) {
                Client.addChatMessage("Couldn\'t find hack \"" + hackName.toLowerCase() + "\"");
            }
        }else{
            Client.addChatMessage("Usage: " + this.syntax);
        }
    }
}