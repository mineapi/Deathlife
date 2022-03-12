package me.mineapi.deathlife.Item.Consumables;

import me.mineapi.deathlife.Item.ConsumableItem;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class LifeTotem extends ConsumableItem {
    @Override
    public String name() {
        return "Life";
    }

    @Override
    public ItemStack itemStack() {
        ItemStack itemStack = new ItemStack(Material.TOTEM_OF_UNDYING);
        ItemMeta itemMeta = itemStack.getItemMeta();

        itemMeta.setDisplayName(ChatColor.GOLD + name());
        itemMeta.setLore(List.of(new String[] {ChatColor.DARK_GRAY + "Hold this and right click", ChatColor.DARK_GRAY + "to gain another life"}));
        itemMeta.addEnchant(Enchantment.DURABILITY, 10, true);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    @Override
    public void onLeftClick(Player player) {
    }

    @Override
    public void onRightClick(Player player) {

    }
}
