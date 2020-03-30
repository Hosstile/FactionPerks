package us.FactionPerks;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import net.milkbowl.vault.economy.Economy;
import us.FactionPerks.Commands.Primary;
import us.FactionPerks.Events.CoreClickEvent;
import us.FactionPerks.Events.CorePlaceEvent;
import us.FactionPerks.Events.PerksEvent;
import us.FactionPerks.Events.PlayerWalkInTerritory;
import us.FactionPerks.Events.UpgradesEvent;
import us.FactionPerks.Files.BoughtPerks;
import us.FactionPerks.Files.BoughtUpgrades;
import us.FactionPerks.Files.FactionCoreHP;
import us.FactionPerks.GUI.FPerksGUI;
import us.FactionPerks.GUI.upgradeGUI;
import us.FactionPerks.Settings.FactionCoreSettings;
import us.FactionPerks.Utilities.utils;

public class FPerks extends JavaPlugin {

	public static String prefix = utils.translate("&e&lFactions Core &8» ");

	public static Economy econ = null;
	
	public static FPerks fperks;
	
	public static FPerks getInstance() {
		return fperks;
	}

	public  void startCash(Player p) {
		
		
		BukkitScheduler scheduler = Bukkit.getScheduler();
		
		scheduler.scheduleSyncDelayedTask(this, new Runnable() {
			
		
		
		public void run() {
			
			p.sendMessage(utils.translate(FPerks.prefix + "&cYour hourly income has arrived! &e&l+250k"));
			
		}
		
		}, 100);
	}
	
	
	private boolean setupEconomy() {

		if (getServer().getPluginManager().getPlugin("Vault") == null) {
			return false;
		}
		RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
		if (rsp == null) {
			return false;
		}
		econ = rsp.getProvider();
		return econ != null;
	}

	public void onEnable() {


		
		handler();
		setupEconomy();
		registerCFG();

		FactionCoreHP.init();
		BoughtPerks.init();
		BoughtUpgrades.init();
		

		BoughtUpgrades.saveupgrades();
		
	}

	public void onDisable() {


	}

	private void handler() {

		
		registerCommands();
		registerEvents();
		FPerksGUI.init();
		upgradeGUI.init();
	}

	private void registerCFG() {

		getConfig().options().copyDefaults(true);
		saveConfig();

		
		BoughtPerks.boughtperksfile = new File(getDataFolder(), "boughtperks.yml");
		BoughtPerks.boughtperks = YamlConfiguration.loadConfiguration(BoughtPerks.boughtperksfile);
		
	 BoughtUpgrades.upgradesFile = new File(getDataFolder(), "boughtupgrades.yml");
	 BoughtUpgrades.upgrades = YamlConfiguration.loadConfiguration(BoughtUpgrades.upgradesFile);
	 
	 FactionCoreHP.FactionCoreHPfile = new File(getDataFolder(), "FactionCoreHP.yml");
	 FactionCoreHP.FactionCoreHP = YamlConfiguration.loadConfiguration(FactionCoreHP.FactionCoreHPfile);

		
	}

	private void registerCommands() {
		getCommand("fCore").setExecutor(new Primary());

	}

	private void registerEvents() {
		PluginManager pm = Bukkit.getPluginManager();

		pm.registerEvents(new CoreClickEvent(), this);
		pm.registerEvents(new CorePlaceEvent(this), this);
		pm.registerEvents(new PlayerWalkInTerritory(), this);
		pm.registerEvents(new PerksEvent(), this);
		pm.registerEvents(new UpgradesEvent(), this);

	}

}
