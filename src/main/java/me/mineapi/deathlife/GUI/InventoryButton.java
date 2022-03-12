package me.mineapi.deathlife.GUI;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.lang.reflect.Method;
import java.util.function.Consumer;

public class InventoryButton {
    ItemStack item;
    Consumer<Player> callBack;

    public InventoryButton(ItemStack item, Consumer<Player> callBack) {
        this.item = item;
        this.callBack = callBack;
    }
}
