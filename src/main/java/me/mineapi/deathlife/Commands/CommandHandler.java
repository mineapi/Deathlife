package me.mineapi.deathlife.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;

public class CommandHandler implements CommandExecutor {
    public static ArrayList<MinecraftCommand> commands = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        for (MinecraftCommand queryCommand:
                commands) {
            if (queryCommand.name().equals(command.getName())) {
                queryCommand.execute(sender, args);
                return true;
            }
        }
        return false;
    }

    static {
        commands.add(new Withdraw());
    }
}
