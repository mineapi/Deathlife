package me.mineapi.deathlife;

import me.mineapi.deathlife.Commands.CommandHandler;
import me.mineapi.deathlife.Module.ModuleManager;
import me.xcalibur8.lastlife.LastLife;
import me.xcalibur8.lastlife.services.api.LastLifeAPI;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class DeathLife extends JavaPlugin {
    public static ModuleManager moduleManager;
    public static JavaPlugin plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;

        Bukkit.getPluginCommand("withdraw").setExecutor(new CommandHandler());

        moduleManager = new ModuleManager();
        moduleManager.enableModule("custom_items");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        moduleManager.disableModules();
    }
}
