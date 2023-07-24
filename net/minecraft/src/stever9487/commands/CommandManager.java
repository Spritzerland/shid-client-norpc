package net.minecraft.src.stever9487.commands;

import net.minecraft.src.GuiChat;
import net.minecraft.src.stever9487.Client;
import net.minecraft.src.stever9487.commands.cmds.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandManager {
    public static List<Command> commands = new ArrayList<>();
    public static String prefix = ".";

    public CommandManager() {
        commands.add(new Help());
        commands.add(new Hacks());
        commands.add(new Toggle());
        commands.add(new Binds());
        commands.add(new Bind());
        commands.add(new Unbind());
        commands.add(new FOV());
        commands.add(new Speed());
        commands.add(new Friends());
        commands.add(new KillAuraConfig());
    }

    public void handleMessage(String msg) {
        if(!msg.startsWith(prefix)) return;
        GuiChat.isMsgCancelled = true;
        msg = msg.substring(prefix.length());
        boolean foundCommand = false;

        if(msg.split(" ").length > 0) {
            String commandName = msg.split(" ")[0];

            for(Command c : commands) {
                if(c.aliases.contains(commandName) || c.name.equalsIgnoreCase(commandName)){
                    c.onCommand(Arrays.copyOfRange(msg.split(" "), 1, msg.split(" ").length), msg);
                    foundCommand = true;
                    break;
                }
            }
            if(!foundCommand) {
                Client.addChatMessage("\u00A7cUnknown command \"" + commandName.toLowerCase() + "\"");
            }
        }
    }
}
