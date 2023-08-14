package dtnl.chronowar.Events;

import dtnl.chronowar.ChronoWar;
import dtnl.chronowar.DataManagers.PlayerData;
import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.simpleyaml.configuration.file.YamlFile;

import java.util.UUID;

public class JoinEvent implements Listener {

    BossBar ui = Bukkit.createBossBar("一", BarColor.GREEN, BarStyle.SEGMENTED_6);
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        UUID uuid = p.getUniqueId();

        ui.addPlayer(p);
        if (ChronoWar.topbars.containsKey(uuid)) {
            ChronoWar.topbars.get(uuid).removePlayer(p);
            ChronoWar.topbars.remove(uuid);
        }
        BossBar topbars = Bukkit.createBossBar(" ", BarColor.GREEN, BarStyle.SEGMENTED_6);
        topbars.addPlayer(p);
        ChronoWar.topbars.put(uuid, topbars);

        if (ChronoWar.botombars.containsKey(uuid)) {
            ChronoWar.botombars.get(uuid).removePlayer(p);
            ChronoWar.botombars.remove(uuid);
        }
        BossBar botombars = Bukkit.createBossBar(" ", BarColor.GREEN, BarStyle.SEGMENTED_6);
        botombars.addPlayer(p);
        ChronoWar.botombars.put(uuid, botombars);

        //new player
        if(!PlayerData.IsPlayer(e.getPlayer().getUniqueId())){
            PlayerData.CreatePlayer(uuid);
        }
        //no data loaded yet
        if(!ChronoWar.playerdata.containsKey(uuid)){
            YamlFile data = (YamlFile) PlayerData.getloadedfile(uuid);
            ChronoWar.playerdata.put(uuid, data);
        }

    }
}
