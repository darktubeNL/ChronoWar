package dtnl.chronowar.commands;

import dtnl.chronowar.DataManagers.PlayerData;
import dtnl.chronowar.Toolbox;
import dtnl.chronowar.gui.Formations;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.patheloper.api.pathing.Pathfinder;
import org.patheloper.api.pathing.result.PathfinderResult;
import org.patheloper.api.pathing.rules.PathingRuleSet;
import org.patheloper.api.pathing.strategy.strategies.DirectPathfinderStrategy;
import org.patheloper.api.pathing.strategy.strategies.WalkablePathfinderStrategy;
import org.patheloper.api.wrapper.PathPosition;
import org.patheloper.mapping.PatheticMapper;
import org.patheloper.mapping.bukkit.BukkitMapper;
import org.simpleyaml.configuration.file.YamlFile;

import java.util.UUID;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.atomic.AtomicReference;

public class testCMD implements CommandExecutor {

    private Pathfinder pathfinder;

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if ((sender instanceof Player)) {
            if(args.length > 0){
                if(args[0].equals("hans")) {
                    Player p = (Player) sender;
                    UUID uuid = p.getUniqueId();
                    YamlFile data = PlayerData.getloadedfile(uuid);
                    Bukkit.broadcastMessage("food: " + data.get("general.food"));
                }
                if(args[0].equals("sendformation")){
                    Player p = (Player) sender;
                    CompletionStage<PathfinderResult> pathfindingResult;

                    Location target = p.getTargetBlockExact(10).getLocation();
                    target.add(0,1,0);
                    Location start = new Location(Bukkit.getWorld("world"), 0, 65, 0);
                    Bukkit.broadcastMessage("target: " + target);
                    UUID uuid = p.getUniqueId();

                    for(Location loc : Toolbox.getpath(start, target, p)){
                        Bukkit.getWorld("world").getBlockAt(loc).setType(Material.RED_STAINED_GLASS);
                    }
                }
            }else {
                Player p = (Player) sender;
                Formations.openInventory(p.getUniqueId());
            }
        }
        return true;
    }
}
