package us.FactionPerks.Files;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import us.FactionPerks.FPerks;
import us.FactionPerks.Utilities.utils;

public class FactionCoreHP {

	public static FPerks plugin;

	
	public static File FactionCoreHPfile;
	public static FileConfiguration FactionCoreHP;

	public static void init() {
		

		if (!(FactionCoreHPfile.exists())) {
			Bukkit.getConsoleSender().sendMessage(utils.translate(FPerks.prefix + " &4&lCREATED FactionCoreHP.yml"));
			saveFactionCoreHP();
		}

		setStrings();

	}

	private static void setStrings() {

	}

	public static void saveFactionCoreHP() {

		try {

			FactionCoreHP.save(FactionCoreHPfile);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
