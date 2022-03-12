package me.mineapi.deathlife.Item.Consumables;

import me.mineapi.deathlife.DeathLife;
import me.mineapi.deathlife.GUI.GUIBuilder;
import me.mineapi.deathlife.GUI.GUIManager;
import me.mineapi.deathlife.GUI.GUIModule;
import me.mineapi.deathlife.GUI.InventoryButton;
import me.mineapi.deathlife.Item.ConsumableItem;
import me.xcalibur8.lastlife.services.api.LastLifeAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;

public class LifeKey extends ConsumableItem {
    @Override
    public String name() {
        return "Revival Key";
    }

    @Override
    public ItemStack itemStack() {
        ItemStack itemStack = new ItemStack(Material.BLAZE_ROD);
        ItemMeta itemMeta = itemStack.getItemMeta();

        itemMeta.setDisplayName(ChatColor.GOLD + name());
        itemMeta.setLore(List.of(new String[] {ChatColor.DARK_GRAY + "Hold this and right click", ChatColor.DARK_GRAY + "to revive."}));
        itemMeta.addEnchant(Enchantment.DURABILITY, 10, true);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    @Override
    public void onRightClick(Player player) {
        GUIManager manager = ((GUIModule) DeathLife.moduleManager.getModule("gui_module")).manager;
        GUIBuilder gui = new GUIBuilder("Revival Key", player);

        for (Player onlinePlayer:
                Bukkit.getOnlinePlayers()) {
            if (new LastLifeAPI().getPlayerLives(onlinePlayer.getUniqueId()) < 1) {
                ItemStack item = new ItemStack(Material.PLAYER_HEAD);
                SkullMeta skullMeta = (SkullMeta) item.getItemMeta();

                skullMeta.setOwningPlayer(onlinePlayer);
                skullMeta.setDisplayName(ChatColor.GOLD + onlinePlayer.getDisplayName());

                skullMeta.setLore(List.of(new String[] {
                    ChatColor.RED + "Left-click here to revive ",
                        onlinePlayer.getDisplayName() + "!"
                }));

                item.setItemMeta(skullMeta);

                gui.addButton(new InventoryButton(item, callbackPlayer -> {
                    callbackPlayer.closeInventory();
                    new LastLifeAPI().setLife(onlinePlayer, 1);
                    onlinePlayer.teleport(onlinePlayer.getWorld().getSpawnLocation());
                    onlinePlayer.setGameMode(GameMode.SURVIVAL);
                    onlinePlayer.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 20 * 30, 255));
                    onlinePlayer.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 20 * 30, 255));
                    super.onRightClick(player);
                }));
            }
        }

        manager.addGUI(gui);
        player.openInventory(gui.inventory);
    }
}
