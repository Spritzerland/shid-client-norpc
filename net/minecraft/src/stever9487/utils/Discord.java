package net.minecraft.src.stever9487.utils;

import club.minnced.discord.rpc.DiscordEventHandlers;
import club.minnced.discord.rpc.DiscordRPC;
import club.minnced.discord.rpc.DiscordRichPresence;
import net.minecraft.src.stever9487.Client;

public class Discord {
    public static DiscordRichPresence discordRichPresence = new DiscordRichPresence();
    private static DiscordRPC discordRPC = DiscordRPC.INSTANCE;
    private static long startTimestamp = System.currentTimeMillis() / 1000L;

    public static void startRPC() {
        DiscordEventHandlers eventHandlers = new DiscordEventHandlers();
        eventHandlers.disconnected = ((var1, var2) -> System.out.println("Discord RPC disconnected"));
        discordRPC.Discord_Initialize("1132765481913307156", eventHandlers, true, null);
        updateRPC();
    }

    public static void updateRPC() {
        Thread thread = new Thread(() -> {
            while(true) {
                try {
                    discordRichPresence.largeImageKey = "bigimg";
                    discordRichPresence.largeImageText = "Created by stever9487";
                    discordRichPresence.startTimestamp = startTimestamp;
                    discordRichPresence.details = "On version " + Client.currentVersion;
                    if(Client.mc.theWorld.multiplayerWorld) {
                        discordRichPresence.state = "Playing Multiplayer as " + Client.mc.session.playerName;
                    }else if(Client.mc.theWorld == null) {
                        discordRichPresence.state = "In main menu";
                    }else if(!Client.mc.theWorld.multiplayerWorld) {
                        discordRichPresence.state = "Playing Singleplayer";
                    }
                    discordRPC.Discord_UpdatePresence(discordRichPresence);
                }catch(Throwable ignored) {}

                try{
                    Thread.sleep(10000);
                }catch(Exception ex) {
                    ex.printStackTrace();
                    break;
                }
            }
        });
        thread.start();
    }

    public static void stopRPC() {
        discordRPC.Discord_Shutdown();
        discordRPC.Discord_ClearPresence();
    }
}
