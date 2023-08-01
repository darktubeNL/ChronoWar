package dtnl.chronowar.Events.Gui;

import dtnl.chronowar.Data.items;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;

import java.util.UUID;

public class Formations implements Listener {

    Inventory inv = Bukkit.createInventory(null, 54, " ");

    public void openInventory(UUID uuid) {
        Player p = Bukkit.getPlayer(uuid);
        if(p != null) {
            inv.setItem(1, items.gideon());
            p.openInventory(inv);
        }
    }

    @EventHandler
    public void onInventoryClick(final InventoryClickEvent e) {
        if (e.getInventory().equals(inv)) {
            e.setCancelled(true);
        }
    }


    @EventHandler
    public void onInventoryClick(final InventoryDragEvent e) {
        if (e.getInventory().equals(inv)) {
            e.setCancelled(true);
        }
    }
}
