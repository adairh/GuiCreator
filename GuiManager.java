package me.adairh.GuiManager;

import org.bukkit.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class GuiManager {

    private static List<GuiManager> guiManager = new ArrayList<GuiManager>();

    private String title;
    private int[][] guiMap;
    private HashMap<Integer, ItemStack> itemMap;
    private Inventory inventory;
    private boolean realClose;

    public GuiManager(String title, int[][] guiMap, HashMap<Integer, ItemStack> itemMap){
        this.title      = title.replace('&', ChatColor.COLOR_CHAR);
        this.guiMap     = guiMap;
        this.itemMap    = itemMap;
        this.inventory  = generate();
        this.realClose  = true;
        guiManager.add(this);
    }

    public Inventory generate(){
        int length = getGuiMap().length*9;
        Inventory inv = Bukkit.createInventory(null, length, getTitle());
        for (int y = 0; y < (length/9); y++){
            for (int x = 0; x < 9; x++){
                int value = getGuiMap()[y][x];
                int slot = y*9+x;
                inv.setItem(slot, getItemMap().get(value)!=null ? getItemMap().get(value) : defaultItem());
            }
        }
        return inv;
    }

    public String getTitle() {
        return title;
    }

    public int[][] getGuiMap() {
        return guiMap;
    }

    public HashMap<Integer, ItemStack> getItemMap() {
        return itemMap;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public boolean isRealClose() {
        return realClose;
    }

    public void setRealClose(boolean realClose) {
        this.realClose = realClose;
    }

    public ItemStack getItemInDefaultMap(int slot){
        int row = (int)slot/9;
        int col = slot - row*9;

        int value = getGuiMap()[row][col];

        try {
            return getItemMap().get(value);
        } catch (Exception e) {
            return null;
        }
    }

    public void removeGui(){
        guiManager.removeIf(gui -> gui.equals(this));
    }

    //===========
    public abstract boolean onClick(InventoryClickEvent e);

    public abstract ItemStack defaultItem();

    //===========

    public static List<GuiManager> getGuiManager() {
        return guiManager;
    }

    public static boolean checkGui(String invTitle){
        for (GuiManager manager : guiManager){
            if (manager.getTitle().equalsIgnoreCase(invTitle)){
                return true;
            }
        }
        return false;
    }

    public static GuiManager getGui(String invTitle){
        for (GuiManager manager : guiManager){
            if (manager.getTitle().equalsIgnoreCase(invTitle)){
                return manager;
            }
        }
        return null;
    }

}
