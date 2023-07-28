package dtnl.chronowar.Events;

import dtnl.chronowar.ChronoWar;
import dtnl.chronowar.DataManagers.PlayerData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.simpleyaml.configuration.file.YamlFile;

import java.util.UUID;

public class JoinEvent implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        UUID uuid = p.getUniqueId();
        //new player
        if(!PlayerData.IsPlayer(e.getPlayer().getUniqueId())){
            PlayerData.CreatePlayer(uuid);
        }
        //no data loaded yet
        if(!ChronoWar.playerdata.containsKey(uuid)){
            YamlFile data = (YamlFile) PlayerData.getfile(uuid);

            ChronoWar.playerdata.put(uuid, data);
        }
    }
}
