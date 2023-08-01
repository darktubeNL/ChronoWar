package dtnl.chronowar.Data;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class items {

    public static ItemStack gideon(){
        ItemStack item = new ItemStack(Material.PAPER, 1);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setCustomModelData(1);
        meta.setDisplayName(" ");
        item.setItemMeta(meta);
        return item;
    }
}
