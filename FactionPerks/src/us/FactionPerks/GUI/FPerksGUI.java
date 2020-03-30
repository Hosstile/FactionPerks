package us.FactionPerks.GUI;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.massivecraft.factions.Faction;

import us.FactionPerks.FPerks;
import us.FactionPerks.Files.BoughtPerks;
import us.FactionPerks.PurchasedPerks.Purchased;
import us.FactionPerks.Utilities.ItemBuilder;
import us.FactionPerks.Utilities.utils;

public class FPerksGUI {
	
	private static String speedinfactionland = "&e&lSpeed Upgrade &8< &eI - II &8>";
	private static String jumpboostinfactionland = "&e&lJumpboost Upgrade";
	private static String nofalldamageinfactionland = "&e&lJellyLegs Upgrade";
	private static String nextPGString = "&6&lPG 2";
	private static String purchasedPerks = "&6&lPurchased Perks";
	
	
	
	private static  ItemStack SpeedInFactionLand = new ItemBuilder(Material.PAPER)
			.setName(utils.translate(speedinfactionland)).addLoreLine("&8&l&m--------------------").addLoreLine("&7Gain Speed &8(&eI - II&8) &7 in faction teritory")
			.addLoreLine("").addLoreLine("&ePrice&8: &f15,000,000").addLoreLine("&eXP needed&8: &f165 Levels").addLoreLine("").addLoreLine("&8&l&m--------------------").toItemStack();
	
	private static	ItemStack JumpboostInFactionLand = new ItemBuilder(Material.PAPER)
			.setName(utils.translate(jumpboostinfactionland)).addLoreLine("&8&l&m--------------------").addLoreLine("&7Enables Jumpboost &eI&7 in faction teritory")
			.addLoreLine("").addLoreLine("&ePrice&8: &f12,500,000").addLoreLine("&eXP needed&8: &f165 Levels").addLoreLine("").addLoreLine("&8&l&m--------------------").toItemStack();
	
	private static	ItemStack NoFallDamageInFactionLand = new ItemBuilder(Material.PAPER).setName(utils.translate(nofalldamageinfactionland))
			.addLoreLine("&8&l&m--------------------").addLoreLine("&7Take no fall damage in faction teritory")
			.addLoreLine("").addLoreLine("&ePrice&8: &f10,000,000").addLoreLine("&eXP needed&8: &f130 Levels").addLoreLine("").addLoreLine("&8&l&m--------------------").toItemStack();
	
  
	private static ItemStack nextPG = new ItemBuilder(Material.ANVIL).setName(utils.translate("&6&lPG 2")).toItemStack();
	
	public static String booleanToString(boolean b) {
	    return b ? "✔" : "✖";
	}
	


	
	public static void setPurchasedPerks(Faction fac) {
		

		
		ItemStack purchased = new ItemBuilder(Material.BLAZE_POWDER).setName(utils.translate(purchasedPerks))
				.addLoreLine("").addLoreLine("&a&lSpeed").addLoreLine(ChatColor.YELLOW +
						booleanToString(BoughtPerks.boughtperks.getBoolean("Factions." + fac.getTag() + ".Perks.SpeedBUFF")))
				
				.addLoreLine("").addLoreLine("&a&lJumpboost").addLoreLine(ChatColor.YELLOW +
						booleanToString(BoughtPerks.boughtperks.getBoolean("Factions." + fac.getTag() + ".Perks.JumpboostBUFF")))

				
				.addLoreLine("").addLoreLine("&a&lJellyLegs").addLoreLine(ChatColor.YELLOW +
						booleanToString(BoughtPerks.boughtperks.getBoolean("Factions." + fac.getTag() + ".Perks.JellyLegsBUFF"))).toItemStack();

		
		inv.setItem(1, purchased);
	}
	
	
	
	
	
	public static String getPurchasedPerks() {
		
		
		return purchasedPerks;
	}

	public static void setPurchasedPerks(String purchasedPerks) {
		FPerksGUI.purchasedPerks = purchasedPerks;
	}

	public static ItemStack getJumpboostInFactionLand() {
		return JumpboostInFactionLand;
	}

	public static void setJumpboostInFactionLand(ItemStack jumpboostInFactionLand) {
		JumpboostInFactionLand = jumpboostInFactionLand;
	}

	public static ItemStack getNoFallDamageInFactionLand() {
		return NoFallDamageInFactionLand;
	}

	public static void setNoFallDamageInFactionLand(ItemStack noFallDamageInFactionLand) {
		NoFallDamageInFactionLand = noFallDamageInFactionLand;
	}

	public static Inventory getInv() {
		return inv;
	}

	public static void setInv(Inventory inv) {
		FPerksGUI.inv = inv;
	}

	public static String getNextPGString() {
		return nextPGString;
	}

	public static void setNextPGString(String nextPGString) {
		FPerksGUI.nextPGString = nextPGString;
	}

	public static ItemStack getNextPG() {
		return nextPG;
	}

	public static void setNextPG(ItemStack nextPG) {
		FPerksGUI.nextPG = nextPG;
	}

	private static Inventory inv = Bukkit.createInventory(null, 9, utils.translate("&f&lFactionCore"));
	
	public static void openInventory(Player p) {
		p.openInventory(inv);
		p.sendMessage(utils.translate(FPerks.prefix + "&cOpening FactionsCore."));
	}
	
	public static Inventory getInventory() {
		return inv;
		
	}
	
	public static String getInventoryName() {
		return inv.getName();
	}

	public static void setItems(Integer place, ItemStack item) {
		
		inv.setItem(place - 1, item);
		
	}
	
	public static void init() {
		
		inv.setItem(3, NoFallDamageInFactionLand);
		inv.setItem(4, JumpboostInFactionLand);
		inv.setItem(5, SpeedInFactionLand);
		
		inv.setItem(8, nextPG);
		
	}

	public static String getSpeedinfactionland() {
		return speedinfactionland;
	}

	public static void setSpeedinfactionland(String speedinfactionland) {
		FPerksGUI.speedinfactionland = speedinfactionland;
	}

	public static String getJumpboostinfactionland() {
		return jumpboostinfactionland;
	}

	public static void setJumpboostinfactionland(String jumpboostinfactionland) {
		FPerksGUI.jumpboostinfactionland = jumpboostinfactionland;
	}

	public static String getNofalldamageinfactionland() {
		return nofalldamageinfactionland;
	}

	public static void setNofalldamageinfactionland(String nofalldamageinfactionland) {
		FPerksGUI.nofalldamageinfactionland = nofalldamageinfactionland;
	}

	public static ItemStack getSpeedInFactionLand() {
		return SpeedInFactionLand;
	}

	public static void setSpeedInFactionLand(ItemStack speedInFactionLand) {
		SpeedInFactionLand = speedInFactionLand;
	}


	
	
}
