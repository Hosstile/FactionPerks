package us.FactionPerks.Files;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import us.FactionPerks.FPerks;
import us.FactionPerks.Utilities.utils;

public class BoughtPerks {

	public static FPerks plugin;

	
	public static File boughtperksfile;
	public static FileConfiguration boughtperks;

	public static void init() {
		

		if (!(boughtperksfile.exists())) {
			Bukkit.getConsoleSender().sendMessage(utils.translate(FPerks.prefix + " &4&lCREATED boughtperks.yml"));
			saveBoughtPerks();
		}

		setStrings();

	}

	private static void setStrings() {

	}

	public static void saveBoughtPerks() {

		try {

			boughtperks.save(boughtperksfile);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
