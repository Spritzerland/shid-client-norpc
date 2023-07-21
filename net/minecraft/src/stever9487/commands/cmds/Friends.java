package net.minecraft.src.stever9487.commands.cmds;

import net.minecraft.src.stever9487.Client;
import net.minecraft.src.stever9487.commands.Command;

public class Friends extends Command {
    public Friends() {
        super("friends", "Add/remove friends to/from your friendslist", "friends/f <add/del> <name>", "f");
    }

    public void onCommand(String[] args, String command){
        if(args.length == 2) {
            if(args[0].equalsIgnoreCase("add")) {
                Client.friends.add(args[1]);
                Client.addChatMessage("Added " + args[1] + " to your friendslist!");
            }else if(args[0].equalsIgnoreCase("del")) {
                Client.friends.remove(args[1]);
                Client.addChatMessage("Removed " + args[1] + " from your friendslist!");
            }
        }else{
            Client.addChatMessage("Friends: " + Client.friends.toString());
        }
    }
}