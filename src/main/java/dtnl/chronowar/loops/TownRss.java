package dtnl.chronowar.loops;

import dtnl.chronowar.ChronoWar;
import dtnl.chronowar.Data.buildings.foodfarm;
import dtnl.chronowar.Data.research.development.food_gathering;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.simpleyaml.configuration.file.YamlFile;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.UUID;

public class TownRss {

    static NumberFormat fmt = NumberFormat.getCompactNumberInstance(new Locale("EN", "US"), NumberFormat.Style.SHORT);
    public static void startdloop(){
        Bukkit.getServer().getScheduler().runTaskTimer(ChronoWar.pl, () -> {
            for(Player player : Bukkit.getOnlinePlayers()){
                UUID uuid = player.getUniqueId();
                YamlFile data = ChronoWar.playerdata.get(uuid);

                int foodadd = foodfarm.boost(data.getInt("buildings.foodfarm"));
                int foodresearch = food_gathering.boost(data.getInt("research.development.food_gathering"));
                int woodadd = foodfarm.boost(data.getInt("buildings.woodfarm"));
                int woodresearch = food_gathering.boost(data.getInt("research.development.wood_chopping"));
                int metaladd = foodfarm.boost(data.getInt("buildings.metalmine"));
                int metalresearch = food_gathering.boost(data.getInt("research.development.metal_mining"));
                int goldadd = foodfarm.boost(data.getInt("buildings.goldmine"));
                int goldresearch = food_gathering.boost(data.getInt("research.development.gold_mining"));

                double foodtotal = foodadd + ((foodadd / 100f) * foodresearch);
                double woodtotal = woodadd + ((woodadd / 100f) * woodresearch);
                double metaltotal = metaladd + ((metaladd / 100f) * metalresearch);
                double goldtotal = goldadd + ((goldadd / 100f) * goldresearch);

                data.set("general.food", (double) data.get("general.food") + foodtotal);
                data.set("general.wood", (double) data.get("general.wood") + woodtotal);
                data.set("general.metal", (double) data.get("general.metal") + metaltotal);
                data.set("general.gold", (double) data.get("general.gold") + goldtotal);
                ChronoWar.playerdata.put(uuid, data);
            }
        }, 0, 20);
    }
}
