package dtnl.chronowar.loops;

import dtnl.chronowar.ChronoWar;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.simpleyaml.configuration.file.YamlFile;
import org.yaml.snakeyaml.Yaml;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.UUID;

public class bossbar {

    static NumberFormat fmt = NumberFormat.getCompactNumberInstance(new Locale("EN", "US"), NumberFormat.Style.SHORT);
    static NumberFormat fmt3 = NumberFormat.getNumberInstance(new Locale("EN", "US"));




    public static void startdloop(){

        fmt.setMaximumFractionDigits(2);
        fmt.setMinimumFractionDigits(2);
        Bukkit.getServer().getScheduler().runTaskTimer(ChronoWar.pl, () -> {
            for(Player player : Bukkit.getOnlinePlayers()){
                UUID uuid = player.getUniqueId();
                BossBar topbars = ChronoWar.topbars.get(uuid);
                BossBar botombars = ChronoWar.botombars.get(uuid);
                if(topbars != null && botombars != null) {
                    YamlFile Yaml = ChronoWar.playerdata.get(uuid);
                    double food = (double) Yaml.get("general.food");
                    double wood = (double) Yaml.get("general.wood");
                    double metal = (double) Yaml.get("general.metal");
                    double gold = (double) Yaml.get("general.gold");

                    topbars.setTitle(ChatColor.BOLD+"是 " + fmt.format(food) + "  不 " + fmt.format(wood) + "  了 " + fmt.format(metal) + "  人 " + fmt.format(gold));
                    botombars.setTitle("Power: 900k");
                }
            }
        }, 0, 20);
    }
}
