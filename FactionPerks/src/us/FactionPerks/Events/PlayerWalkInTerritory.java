package us.FactionPerks.Events;

import java.util.Set;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import com.massivecraft.factions.Board;
import com.massivecraft.factions.FLocation;
import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.FPlayers;
import com.massivecraft.factions.Faction;
import com.massivecraft.factions.iface.RelationParticipator;
import com.massivecraft.factions.struct.Relation;
import com.massivecraft.factions.struct.Role;

import us.FactionPerks.FPerks;
import us.FactionPerks.Settings.Perks;
import us.FactionPerks.Utilities.utils;

public class PlayerWalkInTerritory implements Listener {

	public void onWalk(PlayerMoveEvent e) {

		Player p = (Player) e.getPlayer();

		Faction faction = null;


		
	}

}
