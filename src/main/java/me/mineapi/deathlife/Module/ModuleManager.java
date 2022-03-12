package me.mineapi.deathlife.Module;
import me.mineapi.deathlife.GUI.GUIModule;
import me.mineapi.deathlife.Module.CustomItems.CustomItemsModule;
import org.bukkit.Bukkit;

import java.util.HashMap;

public class ModuleManager {
    private static final HashMap<String, Module> modules = new HashMap<>();

    public ModuleManager() {
        for (Module module:
             modules.values()) {
            if (module.enableOnStart) {
                module.initialize();
            }
        }
    }

    /**
     *
     * @param module An instance of the module.
     * @param state Whether the module is enabled or disabled.
     */
    public void addModule(String moduleName, Module module, Boolean state) {
        modules.put(moduleName, module);

        if (state && module.state != Module.ModuleState.ENABLING || module.state != Module.ModuleState.ENABLED)
            module.initialize();
    }

    /**
     *
     * @param moduleName The name the module was added with.
     */
    public void enableModule(String moduleName) {
        try {
            modules.get(moduleName).initialize();
        } catch (Exception ex) {
            Bukkit.getConsoleSender().sendMessage(ex.getMessage());
        }
    }

    /**
     *
     * @param moduleName The name the module was added with.
     */
    public void disableModule(String moduleName) {
        try {
            modules.get(moduleName).cleanup();
        } catch (Exception ex) {
            Bukkit.getConsoleSender().sendMessage(ex.getMessage());
        }
    }

    public void disableModules() {
        for (Module module:
             modules.values()) {
            module.onDisable();
        }
    }

    /**
     *
     * @param moduleName The name the module was added with.
     * @return The called module.
     */
    public Module getModule(String moduleName) {
        return modules.get(moduleName);
    }

    static {
        modules.put("custom_items", new CustomItemsModule());
        modules.put("gui_module", new GUIModule(true ));
    }
}
