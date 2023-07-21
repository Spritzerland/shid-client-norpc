package net.minecraft.src.stever9487.hud;

import net.minecraft.src.ScaledResolution;
import net.minecraft.src.stever9487.Client;
import net.minecraft.src.stever9487.Hack;
import net.minecraft.src.stever9487.event.EventListener;
import net.minecraft.src.stever9487.event.EventRegistry;
import net.minecraft.src.stever9487.event.updates.EventAfterDebug;

import java.awt.*;
import java.util.Collections;
import java.util.Comparator;

public class ArrayList extends Hack implements EventListener<EventAfterDebug> {
    public ArrayList(){
        super("ArrayList", "Test", -1);
        EventRegistry.registerListener(EventAfterDebug.class, this);
    }

    public int getColor() {
        float a = 4.0F;
        float b = (float)(System.currentTimeMillis() % (long)((int)(a * 1000.0F))) / (a * 1000.0F);
        return Color.HSBtoRGB(b, 0.8F, 1.0F);
    }

    public void handleEvent(EventAfterDebug event) {
        ScaledResolution scaledResolution = new ScaledResolution(Client.mc.displayWidth, Client.mc.displayHeight);
        int width = scaledResolution.getScaledWidth();
        java.util.ArrayList arrayList = new java.util.ArrayList();

        int i;
        for(i = 0; i < Client.hacksList.size(); ++i) {
            if(Client.hacksList.get(i).isToggled()){
                arrayList.add(Client.hacksList.get(i).getPrefix() + Client.hacksList.get(i).getName());
            }
        }

        i = 0;
        Collections.sort(arrayList, new Comparator() {
            public int compare(String s, String s1) {
                return Client.mc.fontRenderer.getStringWidth(s1) - Client.mc.fontRenderer.getStringWidth(s);
            }

            public int compare(Object var1, Object var2) {return this.compare((String)var1, (String)var2);}
        });
        int i2 = 0;
        for(int k2 = 0; i2 < arrayList.size(); k2 += 10){
            String s = (String)arrayList.get(i2);
            Client.mc.fontRenderer.drawStringWithShadow(s, (int)(width - Client.mc.fontRenderer.getStringWidth(s) - 2), k2 + 2, this.getColor());
            ++i;
            ++i2;
        }
    }
}
