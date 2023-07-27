package dtnl.chronowar.DataManagers;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.simpleyaml.configuration.file.YamlFile;

public class PlayerData {

    public static YamlFile getfile(String uuid){
        return new YamlFile(Bukkit.getServer().getPluginManager().getPlugin("chronowar").getDataFolder() +"/players/"+uuid+".yml");
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

        yml.set("research.wood_chopping", 0);
        yml.set("research.food_gathering", 0);
    }
}
