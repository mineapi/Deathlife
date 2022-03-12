package me.mineapi.deathlife.Commands;

import me.mineapi.deathlife.DeathLife;
import me.mineapi.deathlife.Item.Consumables.LifeTotem;
import me.xcalibur8.lastlife.LastLife;
import me.xcalibur8.lastlife.services.api.LastLifeAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.lang.reflect.Field;
import java.util.UUID;

public class Withdraw extends MinecraftCommand {

    @Override
    public String name() {
        return "withdraw";
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        LastLifeAPI api = LastLife.getApi();

        if (sender instanceof Player player) {
            int playerLives = api.getPlayerLives(player.getUniqueId());

            if (playerLives > 1) {
                player.sendMessage(ChatColor.RED + "A life has been removed from your player and you've been given a life totem. Use it wisely.");
                player.getInventory().addItem(new LifeTotem().itemStack());
                api.setLife(player, playerLives - 1);
            } else if (playerLives <= 0)
                player.sendMessage(ChatColor.RED + "You do not have any lives to withdraw.");
            else if (playerLives <= 1)
                player.sendMessage(ChatColor.RED + "You only have 1 life, withdrawing it will perma-kill you!");

        }
    }


}
