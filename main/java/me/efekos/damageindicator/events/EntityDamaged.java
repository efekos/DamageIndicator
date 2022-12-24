package me.efekos.damageindicator.events;

import me.efekos.damageindicator.DamageIndicator;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.Objects;

public class EntityDamaged implements Listener {
    @EventHandler
    public void onPlayerDamage(EntityDamageEvent e){
        ArmorStand hologram = (ArmorStand) Objects.requireNonNull(Bukkit.getServer().getWorld(e.getEntity().getWorld().getUID()))
                .spawnEntity(e.getEntity().getLocation().add(new Vector(0,2,0)), EntityType.ARMOR_STAND);
        hologram.setVisible(false);
        hologram.setCustomNameVisible(true);
        hologram.setCustomName(ChatColor.RED + (ChatColor.BOLD + (Math.round(e.getFinalDamage()) + " -❤")));
        hologram.setBasePlate(false);
        hologram.setMarker(true);
        hologram.setGravity(false);
        hologram.setSilent(true);
        new BukkitRunnable(){
            @Override
            public void run() {
                hologram.remove();
            }
        }.runTaskLater(DamageIndicator.getPlugin(),60);
    }
}
