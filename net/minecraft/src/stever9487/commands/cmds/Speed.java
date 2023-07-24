package net.minecraft.src.stever9487.commands.cmds;

import net.minecraft.src.stever9487.Client;
import net.minecraft.src.stever9487.Hack;
import net.minecraft.src.stever9487.commands.Command;
import net.minecraft.src.stever9487.hacks.ClockSpeed;

public class Speed extends Command {
    public Speed() {
        super("speed", "Set current ClockSpeed", "speed <speed>", "speed");
    }

    public void onCommand(String[] args, String command){
        if(args.length == 1) {
            ClockSpeed.speed = Float.parseFloat(args[0]);
            Client.addChatMessage("Set ClockSpeed to " + ClockSpeed.speed);
        }else{
            Client.addChatMessage("Usage: " + this.syntax);
        }
    }
}