package net.minecraft.src.stever9487.commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Command {
    public String name, description, syntax;
    public List<String> aliases = new ArrayList<>();

    public Command(String name, String description, String syntax, String...aliases) {
        this.name = name;
        this.description = description;
        this.syntax = syntax;
        this.aliases = Arrays.asList(aliases);
    }

    public void onCommand(String[] args, String command) {}
    public String getName(){return name;}
}
