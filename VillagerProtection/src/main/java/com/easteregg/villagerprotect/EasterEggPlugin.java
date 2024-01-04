package com.easteregg.villagerprotect;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class EasterEggPlugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onVillagerDamage(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Villager && event.getDamager() instanceof Player) {
            Villager villager = (Villager) event.getEntity();
            Player player = (Player) event.getDamager();

            if (villager.getRecipeCount() > 0) {
                event.setCancelled(true);
                player.sendMessage(ChatColor.RED + "You can't kill this villager.");
            }
        }
    }
}