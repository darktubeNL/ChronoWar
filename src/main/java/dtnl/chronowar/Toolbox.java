package dtnl.chronowar;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.patheloper.api.pathing.Pathfinder;
import org.patheloper.api.pathing.result.PathfinderResult;
import org.patheloper.api.pathing.rules.PathingRuleSet;
import org.patheloper.api.pathing.strategy.strategies.WalkablePathfinderStrategy;
import org.patheloper.api.wrapper.PathPosition;
import org.patheloper.mapping.PatheticMapper;
import org.patheloper.mapping.bukkit.BukkitMapper;

import java.util.ArrayList;
import java.util.concurrent.CompletionStage;

public class Toolbox {

    public static int GetResource(String list, String type){
        String[] values = list.split("\\.");
        switch (type){
            case "food":
                return Integer.parseInt(values[0]);
            case "wood":
                return Integer.parseInt(values[1]);
            case "metal":
                return Integer.parseInt(values[2]);
            case "gold":
                return Integer.parseInt(values[3]);
        }
        return 0;
    }
    public static String redtop(String text){
        return ChatColor.translateAlternateColorCodes ('&',"&f\uF808 뀀 \uF808\uF80B\uF80A\uF80A\uF809\uF802\uF801&f"+text+"\uF80E\uF80E");
    }
    public static String redmid(String text){
        return ChatColor.translateAlternateColorCodes ('&',"&f\uF808 뀁 \uF808\uF80B\uF80A\uF80A\uF809\uF802\uF801" + text);
    }
    public static String redunder(String text){
        return ChatColor.translateAlternateColorCodes ('&',"&f\uF808 뀂 \uF808\uF80B\uF80A\uF80A\uF809\uF802\uF801" + text);
    }

    public static ArrayList<Location> getpath(Location start, Location target, Player p){
        final Iterable<PathPosition>[] list = new Iterable[]{null};
        Pathfinder reusablePathfinder = PatheticMapper.newPathfinder(PathingRuleSet.createRuleSet()
                .withStrategy(WalkablePathfinderStrategy.class)
                .withAllowingDiagonal(true)
                .withAllowingFailFast(true)
                .withAllowingAlternateTarget(true)
                .withMaxIterations(30000)
                .withAllowingFallback(true)
                .withLoadingChunks(true), PatheticMapper.PathfinderType.ASTAR);

        CompletionStage<PathfinderResult> pathfindingResult = reusablePathfinder.findPath(BukkitMapper.toPathPosition(start), BukkitMapper.toPathPosition(target));
        pathfindingResult.thenAccept(result -> {
            p.sendMessage("State: " + result.getPathState().name());
            p.sendMessage("Path length: " + result.getPath().length());
            if (result.successful()) {
                list[0] = result.getPath().getPositions();
            } else {
                p.sendMessage("Path not found!");
            }
        });
        ArrayList<Location> locations = new ArrayList<Location>();
        for(PathPosition loc : list[0]){
            locations.add(BukkitMapper.toLocation(loc));
        }
        return locations;
    }

}
