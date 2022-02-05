package me.adairh.GuiManager;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.annotation.Nonnull;
import java.util.List;

public class IS {
    @Nonnull
    public static ItemStack IS(Material m, int i, List<String> l, String name, Enchantment en, int enlv) {
        try {
            ItemStack is = new ItemStack(m,i);
            ItemMeta im = is.getItemMeta();
            im.setLore(l);
            im.setDisplayName(Color(name));
            im.addEnchant(en, enlv, true);
            is.setItemMeta(im);
            return is;
        }
        catch (Exception e) {
            return new ItemStack(Material.AIR);
        }
    }
    @Nonnull
    public static ItemStack IS(Material m, int i, List<String> l,String name) {
        try {
            ItemStack is = new ItemStack(m,i);
            ItemMeta im = is.getItemMeta();
            im.setLore(l);
            im.setDisplayName(Color(name));
            is.setItemMeta(im);
            return is;
        }
        catch (Exception e) {
            return new ItemStack(Material.AIR);
        }
    }

    @Nonnull
    public static ItemStack IS(Material m, int i, List<String> l,String name,Enchantment en,int enlv,ItemFlag ifs) {
        try {
            ItemStack is = new ItemStack(m,i);
            ItemMeta im = is.getItemMeta();
            im.setLore(l);
            im.setDisplayName(Color(name));
            im.addEnchant(en, enlv, true);
            im.addItemFlags(ifs);
            is.setItemMeta(im);
            return is;
        }
        catch (Exception e) {
            return new ItemStack(Material.AIR);
        }
    }
    @Nonnull
    public static ItemStack IS(Material m, int i, List<String> l,String name,Enchantment en,int enlv,List<ItemFlag> ifs) {
        try {
            ItemStack is = new ItemStack(m,i);
            ItemMeta im = is.getItemMeta();
            im.setLore(l);
            im.setDisplayName(Color(name));
            im.addEnchant(en, enlv, true);
            for (ItemFlag itfs:ifs) {
                im.addItemFlags(itfs);
            }
            is.setItemMeta(im);
            return is;
        }
        catch (Exception e) {
            return new ItemStack(Material.AIR);
        }
    }
    public static String Color(String str) {
        try {
            return ChatColor.translateAlternateColorCodes('&', str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
