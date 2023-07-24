package net.minecraft.src.stever9487.hud;

import net.minecraft.src.stever9487.Client;
import net.minecraft.src.stever9487.Hack;
import net.minecraft.src.stever9487.event.EventListener;
import net.minecraft.src.stever9487.event.EventRegistry;
import net.minecraft.src.stever9487.event.updates.EventAfterDebug;

public class ClientName extends Hack implements EventListener<EventAfterDebug> {
    public ClientName() {
        super("ClientName", "Test", -1);
        EventRegistry.registerListener(EventAfterDebug.class, this);
    }

    public void handleEvent(EventAfterDebug event){
        Client.mc.ingameGUI.drawString(Client.mc.fontRenderer, "\u00A76Shid \u00A77Client", 2, 2, 16777215);
    }
}
