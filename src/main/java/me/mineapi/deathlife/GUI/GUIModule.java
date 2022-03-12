package me.mineapi.deathlife.GUI;

import me.mineapi.deathlife.DeathLife;
import me.mineapi.deathlife.Module.Module;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

public class GUIModule extends Module {
    public GUIManager manager;

    public GUIModule(boolean enableOnStart) {
        super(enableOnStart);
    }

    @Override
    public void preLoad() {

    }

    @Override
    public void onLoad() {
        manager = new GUIManager();
        Bukkit.getPluginManager().registerEvents(manager, DeathLife.plugin);
    }

    @Override
    public void onDisable() {

    }
}
