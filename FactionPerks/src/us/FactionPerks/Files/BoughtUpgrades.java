package us.FactionPerks.Files;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import us.FactionPerks.FPerks;
import us.FactionPerks.Utilities.utils;

public class BoughtUpgrades {

	public static FPerks plugin;

	
	public static File upgradesFile;
	public static FileConfiguration upgrades;

	public static void init() {
		

		if (!(upgradesFile.exists())) {
			Bukkit.getConsoleSender().sendMessage(utils.translate(FPerks.prefix + " &4&lCREATED upgrades.yml"));
			saveupgrades();
		}

		setStrings();

	}

	private static void setStrings() {

	}

	public static void saveupgrades() {

		try {

			upgrades.save(upgradesFile);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
