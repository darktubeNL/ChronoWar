package dtnl.chronowar;

import dtnl.chronowar.Events.JoinEvent;
import dtnl.chronowar.Events.LeaveEvent;
import dtnl.chronowar.Events.MapInteractionEvent;
import dtnl.chronowar.commands.testCMD;
import dtnl.chronowar.gui.Formations;
import dtnl.chronowar.gui.MapInteraction;
import dtnl.chronowar.loops.PlayerDataLoop;
import dtnl.chronowar.loops.Scoreboard;
import dtnl.chronowar.loops.TownRss;
import dtnl.chronowar.loops.bossbar;
import fr.mrmicky.fastboard.FastBoard;
import org.bukkit.Location;
import org.bukkit.boss.BossBar;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.patheloper.mapping.PatheticMapper;
import org.simpleyaml.configuration.file.YamlFile;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class ChronoWar extends JavaPlugin {

    public static Plugin pl;

    public static Map<UUID, YamlFile> playerdata = new HashMap<>();
    public static Map<UUID, Location> interactionlocation = new HashMap<>();
    public static Map<UUID, BossBar> topbars = new HashMap<>();
    public static Map<UUID, BossBar> botombars = new HashMap<>();
    public static Map<UUID, FastBoard> boards = new HashMap<>();
    @Override
    public void onEnable() {
        pl = (Plugin)this;

        PatheticMapper.initialize(this);

        startloops();
        registerevents();

        getCommand("test").setExecutor((CommandExecutor) new testCMD());

    }

    public void startloops(){
        bossbar.startdloop();
        Scoreboard.startscoreboardloop();
        PlayerDataLoop.startdloop();
        TownRss.startdloop();
    }
    public void registerevents(){
        getServer().getPluginManager().registerEvents( new Formations(), this);
        getServer().getPluginManager().registerEvents( new JoinEvent(), this);
        getServer().getPluginManager().registerEvents( new Scoreboard(), this);
        getServer().getPluginManager().registerEvents( new MapInteractionEvent(), this);
        getServer().getPluginManager().registerEvents( new MapInteraction(), this);
        getServer().getPluginManager().registerEvents( new LeaveEvent(), this);
    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
