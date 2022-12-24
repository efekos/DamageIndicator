package me.efekos.damageindicator;

import me.efekos.damageindicator.events.EntityDamaged;
import org.bukkit.plugin.java.JavaPlugin;

public final class DamageIndicator extends JavaPlugin {
    public static DamageIndicator plugin;

    static public DamageIndicator getPlugin(){
        return plugin;
    }

    @Override
    public void onEnable() {
        // Plugin startup login
        getServer().getPluginManager().registerEvents(new EntityDamaged(),this);
        plugin = this;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
