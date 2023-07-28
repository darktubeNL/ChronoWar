package dtnl.chronowar.DataManagers;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.simpleyaml.configuration.file.YamlFile;

public class PlayerData {

    public static YamlFile getfile(String uuid){
        return new YamlFile(Bukkit.getServer().getPluginManager().getPlugin("chronowar").getDataFolder() +"/players/"+uuid+".yml");
    }

    public static Boolean IsPlayer(UUID uuid){
        YamlFile yml = getfile(uuid.toString());
        return yml.exists();
    }

    public static Object getfile(UUID uuid){
        YamlFile yml = getfile(uuid.toString());
        try {
            if (!yml.exists()) {
                return false;
            } else {
                return yml;
            }
        } catch (Exception ignored) {}
        return false;
    }
    public static int Getvalue(UUID uuid, String value){
        YamlFile yml = getfile(uuid.toString());
        try {
            if (!yml.exists()) {
                return 0;
            } else {
                yml.load();
                if(yml.isSet(value)) {
                    return (int) yml.get(value);
                }
            }
        } catch (Exception ignored) {}
        return 0;
    }

    public static void CreatePlayer(UUID uuid){
        String player = uuid.toString();
        YamlFile yml = getfile(player);
        try {
            if(!yml.exists()){
                yml.createNewFile();
            }
            yml.load();
        } catch (Exception ignored) {}
        yml.set("general.level", 1);
        yml.set("general.elitelevel", 1);
        yml.set("units.lvl1", 0);
        yml.set("units.lvl2", 0);
        yml.set("units.lvl3", 0);
        yml.set("units.lvl4", 0);
        yml.set("units.lvl5", 0);
        yml.set("units.lvl6", 0);

        yml.set("research.development.wood_chopping", 0);
        yml.set("research.development.food_gathering", 0);
        yml.set("research.development.metal_mining", 0);
        yml.set("research.development.gold_mining", 0);

        yml.set("research.basic_combat.fighter_promotion", 0);
        yml.set("research.basic_combat.attack_tactics", 0);
        yml.set("research.basic_combat.defence_tactics", 0);
        yml.set("research.basic_combat.health_tactics", 0);
        yml.set("research.basic_combat.attack_tactics_defending", 0);
        yml.set("research.basic_combat.defence_tactics_defending", 0);
        yml.set("research.basic_combat.health_tactics_defending", 0);
    }
}
