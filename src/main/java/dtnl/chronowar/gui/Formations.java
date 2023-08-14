package dtnl.chronowar.gui;

import dtnl.chronowar.Data.comanders.gideon;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;

import java.util.UUID;

public class Formations implements Listener {

    static Inventory inv = Bukkit.createInventory(null, 54, ChatColor.WHITE + "\uF808的");

    public static void openInventory(UUID uuid) {
        Player p = Bukkit.getPlayer(uuid);
        if(p != null) {
            inv.clear();
            inv.setItem(0, gideon.small());
            inv.setItem(18, gideon.small());
            inv.setItem(36, gideon.small());
            p.openInventory(inv);
        }
    }

    @EventHandler
    public void onInventoryClick(final InventoryClickEvent e) {
        if(!e.getInventory().equals(inv)) return;
        if(e.getCurrentItem() == null || e.getCurrentItem().getType().isAir()) return;

        Player p = (Player) e.getWhoClicked();
        e.setCancelled(true);
        if(e.getSlot() == 1){
        }
    }


    @EventHandler
    public void onInventoryClick(final InventoryDragEvent e) {
        if (e.getInventory().equals(inv)) {
            e.setCancelled(true);
        }
    }
}
