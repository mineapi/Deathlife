package me.mineapi.deathlife.GUI;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.ArrayList;
import java.util.List;

public class GUIManager implements Listener {
    public List<GUIBuilder> GUIs;

    public GUIManager() {
        GUIs = new ArrayList<>();
    }

    public void addGUI(GUIBuilder gui) {
        GUIs.add(gui);
    }

    @EventHandler
    public void clickListener(InventoryClickEvent event) {
        for (int i = 0; i < GUIs.size(); i++) {
            if (GUIs.get(i).inventory == event.getInventory()) {
                event.setCancelled(true);
                for (int j = 0; j < GUIs.get(i).getButtons().length; j++) {
                    if (GUIs.get(i).getButtons()[j].item.getItemMeta().equals(event.getCurrentItem().getItemMeta())) {
                        GUIs.get(i).getButtons()[j].callBack.accept((Player)event.getWhoClicked());
                    }
                }
            }
        }
    }
}
