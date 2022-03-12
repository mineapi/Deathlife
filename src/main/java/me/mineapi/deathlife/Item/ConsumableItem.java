package me.mineapi.deathlife.Item;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public abstract class ConsumableItem extends UsableItem {
    @Override
    public void onLeftClick(Player player) {
        for (ItemStack item:
                player.getInventory()) {
            ItemStack newItem = item;

            if (item.getItemMeta() == this.itemStack().getItemMeta()) {
                if (item.getAmount() > 1) {
                    newItem.setAmount(item.getAmount() - 1);
                } else {
                    newItem = new ItemStack(Material.AIR);
                }

                player.getInventory().removeItem(item);
                player.getInventory().addItem(newItem);
            }
        }
    }

    @Override
    public void onRightClick(Player player) {
        ItemStack handItem = player.getInventory().getItemInMainHand();
        if (handItem.getAmount() > 1) {
            ItemStack modifiedItem = handItem;
            modifiedItem.setAmount(handItem.getAmount() - 1);
            handItem = modifiedItem;
        } else {
            handItem = new ItemStack(Material.AIR);
        }

        player.getInventory().remove(player.getInventory().getItemInMainHand());
        player.getInventory().addItem(handItem);
    }
}
