package me.mineapi.deathlife.Commands;

import org.bukkit.command.CommandSender;

public abstract class MinecraftCommand {
    public abstract String name();

    public abstract void execute(CommandSender sender, String[] args);
}
