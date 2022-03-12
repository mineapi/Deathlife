package me.mineapi.deathlife.Item;

import org.bukkit.entity.Player;

public abstract class UsableItem extends Item {
    public abstract void onLeftClick(Player player);
    public abstract void onRightClick(Player player);
}
