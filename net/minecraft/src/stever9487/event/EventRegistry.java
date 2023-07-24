package net.minecraft.src.stever9487.event;

import net.minecraft.src.stever9487.Hack;
import net.minecraft.src.stever9487.event.updates.EventPacketSend;

import java.util.ArrayList;
import java.util.HashMap;

public class EventRegistry {
    public static HashMap<Class<? extends Event>, ArrayList<EventListener<? extends Event>>> listeners = new HashMap<>();

    public static void registerListener(Class<? extends Event> class1, EventListener<? extends Event> listener){
        if(listeners.get(class1) == null) {
            listeners.put(class1, new ArrayList<>());
        }
        listeners.get(class1).add(listener);
    }

    public static void handleEvent(Event event) {
        ArrayList arr = listeners.get(event.getClass());
        if(arr != null) {
            int index = 0;
            do {
                EventListener el = (EventListener) arr.get(index++);
                if(!(el instanceof Hack) || ((Hack)el).isToggled()){
                    el.handleEvent(event);
                }
            } while(index < arr.size());
        }
    }
}
