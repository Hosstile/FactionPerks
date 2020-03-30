package us.FactionPerks.Events;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.massivecraft.factions.FLocation;
import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.FPlayers;
import com.massivecraft.factions.Faction;
import com.massivecraft.factions.cmd.FCommand;
import com.massivecraft.factions.struct.Role;

import us.FactionPerks.FPerks;
import us.FactionPerks.Files.BoughtPerks;
import us.FactionPerks.Files.FactionCoreHP;
import us.FactionPerks.Settings.FactionCoreSettings;
import us.FactionPerks.Utilities.utils;

public class CorePlaceEvent implements Listener {

	private static FPerks plugin;

	public CorePlaceEvent(FPerks plugin) {
		this.plugin = plugin;
	}

	private final Map<UUID, Collection<PotionEffect>> playerActivePotionEffects = new HashMap<>();
	private HashMap<UUID, Player> tm = new HashMap<UUID, Player>();
	private HashMap<UUID, Player> inLand = new HashMap<UUID, Player>();

	@EventHandler

	public void onPlace(BlockPlaceEvent e) {

		Player p = (Player) e.getPlayer();

		FPlayer fPlayer = FPlayers.getInstance().getByPlayer(p);
		Role role = fPlayer.getRole();

		Faction faction = null;

		faction = fPlayer.getFaction();

		String factionID = faction.getId();

		if (e.getBlockPlaced().getType().equals(Material.BEACON)) {

			for (FPlayer fp : faction.getFPlayers()) {

				if (!fPlayer.isInOwnTerritory() == true) {

					fPlayer.getPlayer()
							.sendMessage(utils.translate(FPerks.prefix + "&cYou must be in your faction land!"));

					e.setCancelled(true);

					return;

				}

			}

			if (!(fPlayer.hasFaction() == true)) {
				return;
			}

			e.getPlayer().sendMessage(utils.translate(FPerks.prefix + "&7You have placed a &e&lFaction Core&7."));
			
			FactionCoreHP.FactionCoreHP.set("Factions." + faction.getTag() + ".HP", 250);

			FactionCoreHP.FactionCoreHP.set("Factions." + faction.getTag() + ".x", e.getBlock().getX());
			FactionCoreHP.FactionCoreHP.set("Factions." + faction.getTag() + ".y", e.getBlock().getY());
			FactionCoreHP.FactionCoreHP.set("Factions." + faction.getTag() + ".z", e.getBlock().getZ());

			
			FactionCoreHP.saveFactionCoreHP();

			utils.createHologram(e.getBlockPlaced().getLocation().add(0.5, -0.8, 0.5),
					utils.translate("&e&lFactionsCore"));
			utils.createHologram(e.getBlockPlaced().getLocation().add(0.5, -0.3, 0.5), utils
					.translate("&4&l❤  &c" + FactionCoreSettings.getCoreHP(faction) + "&7/&c" + FactionCoreSettings.maxCOREHP));

			return;

		}

	}

	private static boolean notified = false;

	@EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
	public void onMove(PlayerMoveEvent e) {

		Player p = (Player) e.getPlayer();

		FPlayer fPlayer = FPlayers.getInstance().getByPlayer(p);
		Role role = fPlayer.getRole();

		Faction faction = null;

		faction = fPlayer.getFaction();

		String factionID = faction.getId();

		if (fPlayer.isInOwnTerritory() && !inLand.containsKey(p.getUniqueId())) {

			p.sendMessage(utils.translate(FPerks.prefix + "&aYour Faction perks have been &f&lAPPLIED&a."));

			inLand.put(p.getUniqueId(), p.getPlayer());

			if (BoughtPerks.boughtperks
					.getBoolean("Factions." + fPlayer.getFaction().getTag() + ".Perks.JumpboostBUFF") == true) {

				p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, Integer.MAX_VALUE, 1));

			}

			if (BoughtPerks.boughtperks
					.getBoolean("Factions." + fPlayer.getFaction().getTag() + ".Perks.SpeedBUFF") == true) {

				p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1));

			}

		} else {

			if (!(fPlayer.isInOwnTerritory()) && inLand.containsKey(p.getUniqueId())) {

				p.sendMessage(utils.translate(FPerks.prefix + "&aYour Faction perks have been &f&lUN-APPLIED&a."));

				inLand.remove(p.getUniqueId());

				if (BoughtPerks.boughtperks
						.getBoolean("Factions." + fPlayer.getFaction().getTag() + ".Perks.JumpboostBUFF") == true) {

					p.removePotionEffect(PotionEffectType.JUMP);

				}

				if (BoughtPerks.boughtperks
						.getBoolean("Factions." + fPlayer.getFaction().getTag() + ".Perks.SpeedBUFF") == true) {

					p.removePotionEffect(PotionEffectType.SPEED);

				}

			}
		}

	}

}
