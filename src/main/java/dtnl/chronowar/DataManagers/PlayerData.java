package dtnl.chronowar.DataManagers;

import java.io.IOException;
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

    public static YamlFile getloadedfile(UUID uuid){
        YamlFile yml = getfile(uuid.toString());
        try {
            if (!yml.exists()) {
                return null;
            } else {
                yml.load();
                return yml;
            }
        } catch (Exception ignored) {}
        return null;
    }
    public static void updatefile(UUID uuid, YamlFile data){
        String player = uuid.toString();
        YamlFile yml = getfile(player);
        try {
            if(!yml.exists()){
                yml.createNewFile();
            }
            yml.load();
        } catch (Exception ignored) {}
        yml = data;
        try { yml.save(); } catch (IOException ignored) {}
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
        yml.set("general.food", 0.0);
        yml.set("general.wood", 0.0);
        yml.set("general.metal", 0.0);
        yml.set("general.gold", 0.0);

        yml.set("units.lvl1", 0);
        yml.set("units.lvl2", 0);
        yml.set("units.lvl3", 0);
        yml.set("units.lvl4", 0);
        yml.set("units.lvl5", 0);
        yml.set("units.lvl6", 0);

        yml.set("buildings.radio_tower", 0);
        yml.set("buildings.Barracks", 0);
        yml.set("buildings.house", 0);
        yml.set("buildings.foodfarm", 0);
        yml.set("buildings.woodfarm", 0);
        yml.set("buildings.metalmine", 0);
        yml.set("buildings.goldmine", 0);

        yml.set("research.development.wood_chopping", 0);
        yml.set("research.development.food_gathering", 0);
        yml.set("research.development.metal_mining", 0);
        yml.set("research.development.gold_mining", 0);

        yml.set("research.basic_combat.fighter_promotion", 0);
        yml.set("research.basic_combat.attack_tactics", 0);
        yml.set("research.basic_combat.defence_tactics", 0);
        yml.set("research.basic_combat.health_tactics", 0);

        yml.set("comanders.gideon.level", 0);
        yml.set("comanders.gideon.xp", 0);
        yml.set("comanders.gideon.skill1", 0);
        yml.set("comanders.gideon.skill2", 0);
        yml.set("comanders.gideon.skill3", 0);

        try { yml.save(); } catch (IOException ignored) {}
    }
}
