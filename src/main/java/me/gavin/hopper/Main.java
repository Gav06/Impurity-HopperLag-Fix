package me.gavin.hopper;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.InventoryPickupItemEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.saveDefaultConfig();
        this.getServer().getPluginManager().registerEvents(this, this);
    }

    double tps = getConfig().getDouble("tps");

    @EventHandler
    public void onMove(InventoryMoveItemEvent event) {

        if (event.getDestination().getType() == InventoryType.HOPPER && getServer().getTPS()[0] < tps)
            event.setCancelled(true);
    }

    @EventHandler
    public void onPickup(InventoryPickupItemEvent event) {
        if (event.getInventory().getType() == InventoryType.HOPPER && getServer().getTPS()[0] < tps) {
            event.setCancelled(true);
        }
    }
}
