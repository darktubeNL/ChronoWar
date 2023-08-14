package dtnl.chronowar.loops;

import dtnl.chronowar.ChronoWar;
import dtnl.chronowar.DataManagers.PlayerData;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.simpleyaml.configuration.file.YamlFile;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

public class PlayerDataLoop {

    public static void startdloop(){
        Bukkit.getServer().getScheduler().runTaskTimer(ChronoWar.pl, () -> {
            Bukkit.getConsoleSender().sendMessage("[ChronoWar] Saving....");
            LocalDateTime firtst = LocalDateTime.now();
            for(Player player : Bukkit.getOnlinePlayers()){
                UUID uuid = player.getUniqueId();
                PlayerData.updatefile(uuid,ChronoWar.playerdata.get(uuid));

            }
            long diff = ChronoUnit.MILLIS.between(firtst, LocalDateTime.now());
            Bukkit.getConsoleSender().sendMessage("[ChronoWar] done saving ("+diff+"ms)");
        }, 0, 20*60);
    }
}
