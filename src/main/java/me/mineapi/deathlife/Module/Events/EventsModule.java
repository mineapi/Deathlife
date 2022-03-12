package me.mineapi.deathlife.Module.Events;

import me.mineapi.deathlife.DeathLife;
import me.mineapi.deathlife.Events.SecondEvent;
import me.mineapi.deathlife.Module.Module;
import org.bukkit.Bukkit;

public class EventsModule extends Module {

    public EventsModule(boolean enableOnStart) {
        super(enableOnStart);
    }

    @Override
    public void preLoad() {

    }

    @Override
    public void onLoad() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(DeathLife.plugin, new Runnable() {
            @Override
            public void run() {
                Bukkit.getPluginManager().callEvent(new SecondEvent());
            }
        }, 1000, 1000);
    }

    @Override
    public void onDisable() {

    }
}
