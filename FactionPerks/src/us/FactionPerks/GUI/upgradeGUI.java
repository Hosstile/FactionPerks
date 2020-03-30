package us.FactionPerks.GUI;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import us.FactionPerks.Utilities.ItemBuilder;
import us.FactionPerks.Utilities.utils;

public class upgradeGUI {
	
	public static ItemStack health = new ItemBuilder(Material.DIAMOND).setName(utils.translate("&4&lHealth")).addLoreLine("&8&l&m--------------------").addLoreLine("").addLoreLine("&7Current Upgrades: &e1&7/&e4").addLoreLine("&7Upgrade your faction cores health")
			.addLoreLine("").addLoreLine("&ePrice&8: &f5,000,000").addLoreLine("").addLoreLine("&8&l&m--------------------").toItemStack();
	
	public static ItemStack hopper = new ItemBuilder(Material.HOPPER).setName(utils.translate("&e&lMoney Printer")).addLoreLine("&8&l&m--------------------").addLoreLine("").addLoreLine("&7Current Upgrades: &e1&7/&e3").addLoreLine("&7You make &e250k &7per hour!")
			.addLoreLine("").addLoreLine("&ePrice&8: &f13,000,000").addLoreLine("").addLoreLine("&8&l&m--------------------").toItemStack();
	
	public static ItemStack toggleperks = new ItemBuilder(Material.EYE_OF_ENDER).setName(utils.translate("&e&lNotify Upgrade")).addLoreLine("&8&l&m--------------------").addLoreLine("").addLoreLine("&7Current Upgrades: &e1&7/&e1").addLoreLine(" &7Notify your factions member with a enemy player within &e380 &7blocks of your Faction land!")
			.addLoreLine("").addLoreLine("&ePrice&8: &f9,000,000").addLoreLine("").addLoreLine("&8&l&m--------------------").toItemStack();
	
public static Inventory inv = Bukkit.createInventory(null, 9, utils.translate("&f&lCore Upgrades"));

	public static Inventory getInv() {
		return inv;
	}

	public static void setItems(ItemStack item, Integer place) {
		
		inv.setItem(place -1, item);
		
	}
	
	public static void init() {
		inv.setItem(4, health);
		inv.setItem(2, hopper);
		inv.setItem(6, toggleperks);
	}
	
	

}
