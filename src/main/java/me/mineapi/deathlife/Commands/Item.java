package me.mineapi.deathlife.Commands;

import me.mineapi.deathlife.Item.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;

public class Item extends MinecraftCommand{
    @Override
    public String name() {
        return "item";
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (sender instanceof Player player) {
            if (args.length > 0) {
                if (!Objects.isNull(ItemManager.getItem(args[0]))) {
                    player.getInventory().addItem(ItemManager.getItem(args[0]).itemStack());
                }
            }
        } else
            Bukkit.getConsoleSender().sendMessage("This command can only be run by a player!");
    }
}
