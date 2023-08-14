package dtnl.chronowar.gui;

import dtnl.chronowar.ChronoWar;
import dtnl.chronowar.Data.Items;
import dtnl.chronowar.Data.comanders.gideon;
import dtnl.chronowar.Toolbox;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;

import java.util.UUID;

public class MapInteraction implements Listener {

    static String name = ChatColor.WHITE + "map actions";
    public static void openInventory(UUID uuid) {
        Player p = Bukkit.getPlayer(uuid);
        Inventory inv = Bukkit.createInventory(null, 54, name);
        if(p != null) {
            inv.clear();
            inv.setItem(0, Items.paper());
            inv.setItem(18, Items.paper());
            inv.setItem(36, Items.paper());
            p.openInventory(inv);
        }
    }
    @EventHandler
    public void onInventoryClick(final InventoryClickEvent e) {
        if(!e.getView().getTitle().equals(name)) return;
        if(e.getCurrentItem() == null || e.getCurrentItem().getType().isAir()) return;

        Player p = (Player) e.getWhoClicked();
        e.setCancelled(true);
        if(e.getSlot() == 0){
            Location start = new Location(Bukkit.getWorld("world"), 0,65,0);
            Location target = ChronoWar.interactionlocation.get(p.getUniqueId());
            target.add(0,1,0);
            for(Location loc : Toolbox.getpath(start, target, p)){
                Bukkit.getWorld("world").getBlockAt(loc).setType(Material.RED_STAINED_GLASS);
            }
        }
    }


    @EventHandler
    public void onInventoryClick(final InventoryDragEvent e) {
        if (e.getView().getTitle().equals(name)) {
            e.setCancelled(true);
        }
    }
}
