package me.mineapi.deathlife.Module.CustomItems;

import me.mineapi.deathlife.DeathLife;
import me.mineapi.deathlife.Item.ItemManager;
import me.mineapi.deathlife.Module.Module;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

import java.util.ArrayList;

public class CustomItemsModule extends Module {
    ArrayList<NamespacedKey> recipeKeys;

    public CustomItemsModule() {
        super(true);
    }

    @Override
    public void preLoad() {
        recipeKeys = new ArrayList<>();
    }

    @Override
    public void onLoad() {
        Bukkit.getPluginManager().registerEvents(new ItemManager(), DeathLife.plugin);
        loadRecipes();
    }

    @Override
    public void onDisable() {
        unloadRecipes();
    }

    public void loadRecipes() {
        NamespacedKey keyKey = new NamespacedKey(DeathLife.plugin, "revive_key");
        ShapedRecipe keyRecipe = new ShapedRecipe(keyKey, ItemManager.getItem("Revival Key").itemStack());

        recipeKeys.add(keyKey);

        keyRecipe.shape(
                " NG",
                "STS",
                "GN ");

        keyRecipe.setIngredient('N', Material.NETHERITE_INGOT);
        keyRecipe.setIngredient('G', Material.ENCHANTED_GOLDEN_APPLE);
        keyRecipe.setIngredient('T', new RecipeChoice.ExactChoice(ItemManager.getItem("Life").itemStack()));
        keyRecipe.setIngredient('S', Material.NETHER_STAR);

        Bukkit.addRecipe(keyRecipe);
    }

    public void unloadRecipes() {
        Bukkit.getConsoleSender().sendMessage("a");
        for (NamespacedKey key:
             recipeKeys) {
            Bukkit.removeRecipe(key);
            Bukkit.getConsoleSender().sendMessage("Removed recipe " + key.getKey() + "!");
        }
    }
}
