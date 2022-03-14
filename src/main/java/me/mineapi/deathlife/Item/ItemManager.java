package me.mineapi.deathlife.Item;

import me.mineapi.deathlife.Item.Consumables.LifeKey;
import me.mineapi.deathlife.Item.Consumables.LifeTotem;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public class ItemManager implements Listener {
    private static List<Item> items = new ArrayList<>();

    public static Item getItem(String name) {
        AtomicReference<Item> returnItem = new AtomicReference<>();

        items.forEach(item -> {
            if (item.name().equals(name))
                returnItem.set(item);
        });

        return returnItem.get();
    }

    @EventHandler
    public void handleConsumableItems(PlayerInteractEvent event) {
        if (event.hasItem()) {
            ItemStack eventItem = event.getItem();
            if (event.hasItem()) {
                for (Item item:
                        items) {
                    if (!Objects.isNull(event.getItem().getItemMeta())) {
                        if (event.getPlayer().getInventory().getItemInMainHand().getType() != Material.AIR) {
                            if (item instanceof UsableItem usableItem && event.getPlayer().getInventory().getItemInMainHand().getItemMeta().equals(item.itemStack().getItemMeta())) {
                                if (event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                                    usableItem.onRightClick(event.getPlayer());
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    static {
        items.add(new LifeTotem());
        items.add(new LifeKey());
    }
}
