package us.FactionPerks.Utilities;

import java.util.Set;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.massivecraft.factions.FLocation;
import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.FPlayers;

public class utils {

	public static String translate(String args) {
		return ChatColor.translateAlternateColorCodes('&', args);
	}
	


	public static void sendMSG(Player p, String msg) {

		p.sendMessage(translate(msg));

	}

	public static void createHologram(Location l, String name) {
		ArmorStand am = (ArmorStand) l.getWorld().spawnEntity(l, EntityType.ARMOR_STAND);

		am.setArms(false);
		am.setGravity(false);
		am.setVisible(false);
		am.setCustomName(name);
		am.setCustomNameVisible(true);
	}

	public static void removeArmorStand(World world, String name) {
		for (Entity entity : world.getEntities()) {
				world.getEntitiesByClass(ArmorStand.class).forEach(Entity::remove);
			
		}
	}
	
	public static void addEffect(Player player) {
		
		 ((LivingEntity) player).addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 200, 15));
		
	}
	
	public static void FactionEffects(Player p) {
		

		
		
		
		
	}
	


}
