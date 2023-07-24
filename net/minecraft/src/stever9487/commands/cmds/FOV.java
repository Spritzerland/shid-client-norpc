package net.minecraft.src.stever9487.commands.cmds;

import net.minecraft.src.EntityRenderer;
import net.minecraft.src.stever9487.Client;
import net.minecraft.src.stever9487.commands.Command;

public class FOV extends Command {
    public FOV() {
        super("fov", "Read/write to current FOV", "fov [fov]", "fov");
    }

    public void onCommand(String[] args, String command){
        if(args.length == 1) {
            try{
                EntityRenderer.fov = Float.parseFloat(args[0]);
                Client.addChatMessage("Set FOV to " + EntityRenderer.fov);
            }catch(Exception ex){
                ex.printStackTrace();
                Client.addChatMessage("Invalid argument!");
            }
        }else{
            Client.addChatMessage("Current FOV: " + EntityRenderer.fov);
        }
    }
}
