package me.adairh.GuiManager.Examples;

import me.adairh.GuiManager.GuiManager;
import me.adairh.GuiManager.IS;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MainGui extends GuiManager {

    public MainGui() {
        super(
                "Example Inventory", //Inventory Title
                new int[][]{ //Inventory Map, per number stand for an item that will be initialize below, require 9 indexes per row, min is 1 row and max is 6 rows ( same to normal Inventory )
                        {0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 1, 1, 1, 2, 1, 1, 1, 0},
                        {0, 1, 3, 1, 4, 1, 5, 1, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0}
                },
                new HashMap<Integer, ItemStack>(){ //Initialize Item map, Key is a number and Value is an ItemStack ( Use oneline code supported by IS.java class )
                    {
                        put(0 , IS.IS(Material.BLACK_STAINED_GLASS_PANE, 1, new ArrayList<>()," "));
                        put(1, IS.IS(Material.LIGHT_GRAY_STAINED_GLASS_PANE, 1,  new ArrayList<>()," "));
                        put(2, IS.IS(Material.BOOK, 1, new ArrayList<>(),"&a&lOne", Enchantment.DURABILITY, 1, ItemFlag.HIDE_ENCHANTS));
                        put(3, IS.IS(Material.TNT, 1, new ArrayList<>(),"&c&lTwo", Enchantment.DURABILITY, 1, ItemFlag.HIDE_ENCHANTS));
                        put(4, IS.IS(Material.CHEST, 1, new ArrayList<>(),"&6&lThree", Enchantment.DURABILITY, 1, ItemFlag.HIDE_ENCHANTS));
                        put(5, IS.IS(Material.DIAMOND, 1, new ArrayList<>(),"&b&lFour", Enchantment.DURABILITY, 1, ItemFlag.HIDE_ENCHANTS));
                    }
                }
        );
    }

  
    //The part below is fired when player interact with THIS inventory, remember to check if it's top inventory.
  
    @Override
    public boolean onClick(InventoryClickEvent e) {
        if (Objects.equals(e.getClickedInventory(), e.getView().getTopInventory())) {
            e.setCancelled(true);
            int i = e.getSlot();
            switch (i) {
                case 13:
                    Bukkit.broadcastMessage("Clicked One");break;
                case 20:
                    Bukkit.broadcastMessage("Clicked Two");break;
                case 22:
                    Bukkit.broadcastMessage("Clicked Three");break;
                case 24:
                    Bukkit.broadcastMessage("Clicked Four");break;
            }
        }
        return false;
    }

    
    //Default item in case the Inventory Map above get error in some cases that cant load the item from code.
  
    @Override
    public ItemStack defaultItem() {
        return IS.IS(Material.LIGHT_GRAY_STAINED_GLASS_PANE, 1,
                new ArrayList<>()," ");
    }
}
