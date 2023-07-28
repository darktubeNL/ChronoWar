package dtnl.chronowar;

import dtnl.chronowar.Data.PlayerDataset;
import org.bukkit.plugin.java.JavaPlugin;
import org.simpleyaml.configuration.file.YamlFile;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class ChronoWar extends JavaPlugin {

    public static Map<UUID, YamlFile> playerdata = new HashMap<>();
    @Override
    public void onEnable() {
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
