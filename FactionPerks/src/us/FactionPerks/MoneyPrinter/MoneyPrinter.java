package us.FactionPerks.MoneyPrinter;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitScheduler;

import us.FactionPerks.FPerks;
import us.FactionPerks.Utilities.utils;

public class MoneyPrinter {
	
	public static MoneyPrinter money;
	public static MoneyPrinter getmoney() {
		return money;
	}

	public FPerks plugin;
	
	public MoneyPrinter(FPerks plugin) {
		this.plugin = plugin;
	}
	
	public static int startingCash = 250000;

	public static void startCash(Player p) {
		
		
		BukkitScheduler scheduler = Bukkit.getScheduler();
		
		scheduler.scheduleSyncDelayedTask(MoneyPrinter.getmoney().plugin, new Runnable() {
			
		
		
		public void run() {
			
			p.sendMessage(utils.translate(FPerks.prefix + "&cYour hourly income has arrived! &e&l+250k"));
			
		}
		
		}, 100);
	}

}
