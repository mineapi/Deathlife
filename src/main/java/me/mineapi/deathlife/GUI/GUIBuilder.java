package me.mineapi.deathlife.GUI;

import org.bukkit.Bukkit;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.List;

public class GUIBuilder {
    public Inventory inventory;
    public Player player;

    private final List<InventoryButton> buttons;

    public GUIBuilder(String name, Player player) {
        this.player = player;
        inventory = Bukkit.createInventory(player, 9, name);
        buttons = new ArrayList<>();
    }

    public GUIBuilder addButton(InventoryButton button) {
        buttons.add(button);
        inventory.addItem(button.item);
        return this;
    }

    public GUIBuilder addButtons(InventoryButton... buttons) {
        this.buttons.addAll(List.of(buttons));
        for (InventoryButton button:
             buttons) {
            inventory.addItem(button.item);
        }
        return this;
    }

    public InventoryButton[] getButtons() {
        return buttons.toArray(InventoryButton[]::new);
    }

    public void show() {
        player.openInventory(inventory);
    }
}