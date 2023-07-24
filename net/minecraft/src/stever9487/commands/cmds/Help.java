package net.minecraft.src.stever9487.commands.cmds;

import net.minecraft.src.stever9487.Client;
import net.minecraft.src.stever9487.commands.Command;
import net.minecraft.src.stever9487.commands.CommandManager;

import java.util.HashSet;
import java.util.Set;

public class Help extends Command {
    public Help() {
        super("help", "Command help", "help [command]", "cmds", "commands");
    }

    public void onCommand(String[] args, String command){
        if(args.length == 1) {
            boolean foundCommand = false;
            for(Command c : CommandManager.commands) {
                if(c.name.equalsIgnoreCase(args[0])){
                    foundCommand = true;
                    Client.addChatMessage("Syntax: " + c.syntax);
                    Client.addChatMessage("Description: " + c.description);
                    break;
                }
            }
            if(!foundCommand){
                Client.addChatMessage("Unknown command \"" + args[0] + "\"");
            }
        }else{
            String cmds = "";
            Set<String> addedCommands = new HashSet<>();
            for(Command c : CommandManager.commands) {
                if(!addedCommands.contains(c.name)) {
                    cmds = cmds + c.name + ", ";
                    addedCommands.add(c.name);
                }
            }
            cmds = cmds.substring(0, cmds.length() - 2);
            Client.addChatMessage(cmds);
        }
    }
}