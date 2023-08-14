package dtnl.chronowar.Events;

import dtnl.chronowar.ChronoWar;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class MapInteractionEvent implements Listener {
    @EventHandler
    public void onPlayerInteractMap(PlayerInteractEvent e) {
        if(e.getClickedBlock() == null){
            return;
        }
        if(e.getClickedBlock().getType().equals(Material.WHITE_TERRACOTTA)){
            ChronoWar.interactionlocation.put(e.getPlayer().getUniqueId(), e.getClickedBlock().getLocation());
            dtnl.chronowar.gui.MapInteraction.openInventory(e.getPlayer().getUniqueId());
        }
    }
}
