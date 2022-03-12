package me.mineapi.deathlife.Module;

public abstract class Module {
    public boolean enableOnStart = false;

    public enum ModuleState {
        ENABLING,
        ENABLED,
        DISABLING,
        DISABLED
    }

    public ModuleState state;

    public Module(boolean enableOnStart) {
        this.enableOnStart = enableOnStart;
    }

    public void initialize() {
        this.state = ModuleState.ENABLING;
        preLoad();
        this.state = ModuleState.ENABLED;
        onLoad();
    }

    public abstract void preLoad();
    public abstract void onLoad();

    public void cleanup() {
        this.state = ModuleState.DISABLING;
        onDisable();
        this.state = ModuleState.DISABLED;
    }

    public abstract void onDisable();
}
