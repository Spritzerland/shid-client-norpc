package net.minecraft.src.stever9487;

import net.minecraft.client.Minecraft;
import net.minecraft.src.stever9487.hacks.*;
import net.minecraft.src.stever9487.utils.FileUtil;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class Client {
    public static Minecraft mc = null;
    public static ArrayList<String> categories = new ArrayList<>();
    public static Hack[] hacks = new Hack[4096];
    public static ArrayList<Hack> hacksList = new ArrayList<>();
    public static ArrayList<String> friends = new ArrayList<>();
    public static String currentVersion = "1.0.0";
    public static String latestVersion;
    public static boolean needsUpdate;

    public Client(Minecraft mc){
        this.mc = mc;
        register();
        checkUpdates();
    }

    public static void checkUpdates() {
        Thread thread = new Thread() {
            public void run() {
                try{
                    URL url = new URL("https://github.com/stever9487/shid-assets/raw/main/version");
                    URLConnection urlConnection = url.openConnection();
                    urlConnection.setUseCaches(false);
                    String s = null;
                    InputStream inputStream = urlConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    s = bufferedReader.readLine();
                    bufferedReader.close();
                    System.out.println("Latest: " + s + ", Current: " + currentVersion);
                    if(!s.equals(currentVersion)){
                        latestVersion = s;
                        needsUpdate = true;
                    }else{
                        latestVersion = s;
                        needsUpdate = false;
                    }
                }catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        };
        thread.start();
    }

    public static void keybindsSave() throws IOException {
        File file = new File(FileUtil.shid.getAbsolutePath(), "keybinds.txt");
        if(file.exists()) {
            FileWriter fileWriter = new FileWriter(file);
            for(int i = 0; i < hacksList.size(); ++i) {
                fileWriter.write(hacksList.get(i).getName() + ":" + hacksList.get(i).getKey() + "\n");
            }
            fileWriter.close();
        }else{
            file.createNewFile();
        }
    }

    public static void keybindsLoad() throws IOException{
        File file = new File(FileUtil.shid.getAbsolutePath(), "keybinds.txt");
        if(file.exists()) {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            int i = 0;
            while(true){
                String s = bufferedReader.readLine();
                if(s == null) break;
                s = s.split(":")[1];
                try {
                    hacksList.get(i).setKey(Integer.parseInt(s));
                }catch(Exception ex){}
                ++i;
            }
        }else file.createNewFile();
    }

    public static void hacksSave() throws IOException {
        File file = new File(FileUtil.shid.getAbsolutePath(), "hacks.txt");
        file.createNewFile();
        FileWriter fileWriter = new FileWriter(file);
        for(int i = 0; i < hacksList.size(); ++i) {
            fileWriter.write(hacksList.get(i).getName() + ":" + hacksList.get(i).isToggled() + "\n");
        }
        fileWriter.close();
    }

    public static void hacksLoad() throws IOException {
        File file = new File(FileUtil.shid.getAbsolutePath(), "hacks.txt");
        if(!file.exists()) {
            hacks[0].setToggle(true);
            hacks[1].setToggle(true);
            hacks[2].setToggle(true);
            hacks[3].setToggle(true);
            hacks[4].setToggle(true);
            hacks[9].setToggle(true);
            hacks[13].setToggle(true);
            hacks[14].setToggle(true);
            hacks[15].setToggle(true);
            hacks[17].setToggle(true);
            hacks[19].setToggle(true);
            hacks[20].setToggle(true);
        }

        if(file.exists()) {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

            while(true) {
                String s = bufferedReader.readLine();
                if(s == null) break;
                String[] as = s.split(":");
                int hackint = findHackByNameInList(as[0]);
                if(hackint == -1) {
                    System.out.println("Hack with name " + as[0] + " was not found");
                }else{
                    hacksList.get(hackint).setToggle(Boolean.parseBoolean(as[1]));
                }
            }
        }
    }

    public static void friendsSave() throws IOException {
        File file = new File(FileUtil.shid.getAbsolutePath(), "friends.txt");
        file.createNewFile();
        FileWriter fileWriter = new FileWriter(file);
        for(int i = 0; i < friends.size(); ++i) {
            fileWriter.write(friends.get(i) + "\n");
        }
        fileWriter.close();
    }

    public static void friendsLoad() throws IOException {
        File file = new File(FileUtil.shid.getAbsolutePath(), "friends.txt");
        if(file.exists()) {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

            while(true) {
                String s = bufferedReader.readLine();
                if(s == null) break;
                friends.add(s);
            }
        }
    }

    public static int findHackByNameInList(String s) {
        for(int i = 0; i < hacksList.size(); ++i) {
            if(hacksList.get(i).getName().equals(s)) {
                return i;
            }
        }
        return -1;
    }

    public static void processKeyInput(int keycode, boolean flag) {
        for(int i = 0; i < hacksList.size(); ++i) {
            if(hacksList.get(i).getKey() == keycode && flag) {
                hacksList.get(i).toggle();
            }
        }
    }

    public static void addChatMessage(String msg) {
        mc.ingameGUI.addChatMessage("\u00A77[\u00A76Shid\u00A77]\u00A7f " + msg);
    }

    private static void addHack(int i, Hack c) {
        hacks[i] = c;
        hacksList.add(c);
    }

    private void register(){
        categories.add("Test");
        addHack(0, new net.minecraft.src.stever9487.hud.ClientName());
        addHack(1, new net.minecraft.src.stever9487.hud.ArrayList());
        addHack(2, new Fullbright());
        addHack(3, new ServerStatus());
        addHack(4, new NoFall());
        addHack(5, new Chat());
        addHack(6, new Fly());
        addHack(7, new NoClip());
        addHack(8, new Freecam());
        addHack(9, new Coords());
        addHack(10, new Step());
        addHack(11, new FastPlace());
        addHack(12, new ClockSpeed());
        addHack(13, new AntiKB());
        addHack(14, new NoPush());
        addHack(15, new Jesus());
        addHack(16, new Instant());
        addHack(17, new KillAura());
        addHack(18, new Xray());
        addHack(19, new AutoEat());
        addHack(20, new VisualRange());

        FileUtil.loadAll();
    }
}
