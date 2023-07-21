package net.minecraft.src.stever9487.utils;

public class Timer {
    public long lastMS = System.currentTimeMillis();

    public void reset() {
        this.lastMS = System.currentTimeMillis();
    }

    public boolean hasTimeElapsed(long time, boolean reset) {
        if(System.currentTimeMillis() - this.lastMS <= time) {
            return false;
        } else {
            if(reset) {
                this.reset();
            }
            return true;
        }
    }
}
