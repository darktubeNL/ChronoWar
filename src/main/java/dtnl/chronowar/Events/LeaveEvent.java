package dtnl.chronowar.Events;

import dtnl.chronowar.ChronoWar;
import dtnl.chronowar.DataManagers.PlayerData;
import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.UUID;

public class LeaveEvent implements Listener {

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e) {
        UUID uuid = e.getPlayer().getUniqueId();
        PlayerData.updatefile(uuid, ChronoWar.playerdata.get(uuid));
    }
}
