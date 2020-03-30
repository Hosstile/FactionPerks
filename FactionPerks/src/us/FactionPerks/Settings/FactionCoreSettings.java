package us.FactionPerks.Settings;

import java.util.HashMap;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.Faction;

import us.FactionPerks.FPerks;
import us.FactionPerks.Files.BoughtPerks;
import us.FactionPerks.Files.BoughtUpgrades;
import us.FactionPerks.Files.FactionCoreHP;
import us.FactionPerks.Utilities.utils;

public class FactionCoreSettings {
	
	public static HashMap<String, Integer> hm = new HashMap<String, Integer>();
	
	public static int getCoreHP(Faction f) {
		

		

		return CoreHP;
		
	}
	public static int maxCOREHP = 850;
	public static int CoreHP = 500;
	
	
	public static void saveHashMap(HashMap<String, Integer> hm){
		
		for(String key : hm.keySet()) {
			
			BoughtUpgrades.upgrades.set("Hashmap."+key,  hm.get(key));
			BoughtUpgrades.saveupgrades();
			
			
		}
		

		
	}
	
	public  static HashMap<String, Integer> loadHashMap(){
		
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		
		for(String key : BoughtPerks.boughtperks.getConfigurationSection("HashMap").getKeys(false)) {
			hm.put(key, (Integer) BoughtPerks.boughtperks.get("HashMap."+key));
		}
		
		
		return hm;
		
	}

	public static int getCurrentHP(Faction faction) {
		
	
		
		
		return FactionCoreHP.FactionCoreHP.getInt("Factions." + faction.getTag() + ".HP");
		
		
	}
	
	public static void setCurrentHP(Faction faction, Integer hp) {
		
		int current = getCoreHP(faction);
		
		CoreHP = hp;
		
	}
	
	public static void addRandomHP(Faction faction, Player p) {
		
		
		Random r = new Random();
		
		int chance = r.nextInt(100);
		
		if(chance <= 5) {
			
			for(FPlayer f : faction.getFPlayers()) {
				
				f.sendMessage(utils.translate(FPerks.prefix + "&d&lRARE &7FactionCore's health has been boosted by &e+250&7."));
				setCurrentHP(faction, getCurrentHP(faction) + 250);
				FactionCoreHP.saveFactionCoreHP();
				
				return;
				
			}
			
			
		}
		
		if(chance <= 95) {
			
	for(FPlayer f : faction.getFPlayers()) {
			
		if(f.hasFaction() == true) {
		
				f.sendMessage(utils.translate(FPerks.prefix + "&d&l&7FactionCore's health has been boosted by &e+150&7."));
				setCurrentHP(faction, getCurrentHP(faction) + 150);
				
				FactionCoreHP.saveFactionCoreHP();
				
				utils.removeArmorStand(p.getWorld(),
						"&4&l❤  &c" + getCoreHP(faction) + "&7/&c" + FactionCoreSettings.maxCOREHP);
				
				double x;
				double y;
				double z;

				
				
				x  = FactionCoreHP.FactionCoreHP.getDouble("Factions."+faction.getTag()+".x");
				y  = FactionCoreHP.FactionCoreHP.getDouble("Factions."+faction.getTag()+".y");
				z  = FactionCoreHP.FactionCoreHP.getDouble("Factions."+faction.getTag()+".z");
				

				
				Location loc = new Location (p.getWorld(), x,y,z);
				
				utils.createHologram(loc, "&4&l❤  &c" + FactionCoreSettings.getCoreHP(f.getFaction()) + "&7/&c" + FactionCoreSettings.maxCOREHP);
				p.sendMessage(loc.toString());
		
		
				
				
				return;
		}		
			}
			
		}
		
		
		
	}
	
	
	
}
