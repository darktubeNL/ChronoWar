package dtnl.chronowar.Data.comanders;

import dtnl.chronowar.Toolbox;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class gideon {

    public static ItemStack small(){
        ItemStack item = new ItemStack(Material.PAPER, 1);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setCustomModelData(1);
        item.setItemMeta(setlores(meta, 2));
        return item;
    }
    public static ItemStack big(){
        ItemStack item = new ItemStack(Material.PAPER, 1);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setCustomModelData(2);
        item.setItemMeta(setlores(meta, 2));
        return item;
    }

    public static int getboost(int level){
        switch (level){
            case 1:
                return 5;
            case 2:
                return 10;
            default:
                return 0;
        }
    }

    public static ItemMeta setlores(ItemMeta meta, int level) {
        List<String> lores = new ArrayList<>();
        meta.setDisplayName(Toolbox.redtop( "Gideon"));
        lores.add(Toolbox.redmid("我 有"));
        lores.add(Toolbox.redmid("&c\uD83D\uDDE1 Attack &f" + getboost(level)));
        lores.add(Toolbox.redunder("dit was het!"));
        meta.setLore(lores);
        return meta;
    }
}
