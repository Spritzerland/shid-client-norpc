package net.minecraft.src.stever9487;

import net.minecraft.src.Packet3Chat;
import net.minecraft.src.stever9487.event.Event;

import java.util.ArrayList;

public class Hack {
    public ArrayList<Event> listeners = new ArrayList<>();
    protected boolean isKeyDown = false;
    public boolean toggle = false;
    public String name;
    public int boost;
    public String category;
    public int key;
    private boolean isBinding;
    private boolean opened;

    public Hack(String name, String category, int key) {
        this.name = name;
        this.category = category;
        this.key = key;
    }

    public void onEnable() {}
    public void onDisable() {}

    public String getPrefix() {return "";}
    protected String formatPrefix(String s) {
        return " §7" + s;
    }

    public String getName() { return this.name; }
    public String getCategory() {
        return this.category;
    }
    public int getKey() {return this.key;}
    public boolean isToggled(){return this.toggle;}

    public void toggle() {
        this.toggle = !this.toggle;
        Client.addChatMessage("\u00A76" + this.getName() + (this.isToggled() ? "\u00A7a ON" : "\u00A7c OFF"));
        if(Client.hacks[5].isToggled()) {
            Client.mc.func_20001_q().addToSendQueue(new Packet3Chat("(Shid Client) " + this.getName() + (this.isToggled() ? " ON" : " OFF")));
        }

        if(this.isToggled()){
            this.onEnable();
        }else{
            this.onDisable();
        }
    }

    public void setToggle(boolean toggle){this.toggle = toggle;}
    public void onUpdate(Event e){}
    public int setKey(int i){return this.key = i;}
}
