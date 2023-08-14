package dtnl.chronowar.loops;

import dtnl.chronowar.ChronoWar;
import fr.mrmicky.fastboard.FastBoard;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Scoreboard implements Listener {
    public static void startscoreboardloop(){
        Bukkit.getServer().getScheduler().runTaskTimer(ChronoWar.pl, () -> {
            for (FastBoard board : ChronoWar.boards.values()) {
                updateBoard(board);
            }
        }, 0, 20);
    }
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        FastBoard board = new FastBoard(player);
        board.updateTitle("\uF809" + ChatColor.RED + "title");
        ChronoWar.boards.put(player.getUniqueId(), board);
    }
    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        FastBoard board = ChronoWar.boards.remove(player.getUniqueId());
        if (board != null) {
            board.delete();
        }
    }
    private static void updateBoard(FastBoard board) {
        board.updateLines(
                "1",
                "Players: " + Bukkit.getOnlinePlayers().size(),
                "3",
                "Kills: " + board.getPlayer().getStatistic(Statistic.PLAYER_KILLS),
                "4",
                "5",
                "6",
                "7",
                "8",
                "9",
                "\uF802\uF806从",
                "11",
                "12",
                "13",
                "14",
                "15",
                "16",
                "17"
        );

    }
}
