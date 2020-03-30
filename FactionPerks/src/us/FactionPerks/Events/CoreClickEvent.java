package us.FactionPerks.Events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.FPlayers;
import com.massivecraft.factions.Faction;

import us.FactionPerks.FPerks;
import us.FactionPerks.GUI.FPerksGUI;
import us.FactionPerks.MoneyPrinter.MoneyPrinter;
import us.FactionPerks.Settings.FactionCoreSettings;
import us.FactionPerks.Utilities.utils;

public class CoreClickEvent implements Listener {

	@EventHandler

	public void onClick(PlayerInteractEvent e) {

		Player p = (Player) e.getPlayer();

		if (e.getAction().equals(Action.LEFT_CLICK_BLOCK)) {
			if (e.getClickedBlock().getType().equals(Material.BEACON)) {

				if (FactionCoreSettings.CoreHP == 0) {

					MoneyPrinter.startCash(p);
					
					FactionCoreSettings.CoreHP = FactionCoreSettings.maxCOREHP;
					e.getClickedBlock().breakNaturally();
					p.getWorld().createExplosion(e.getClickedBlock().getLocation(), 1);
					p.getWorld().strikeLightning(e.getClickedBlock().getLocation());
					p.sendMessage(utils.translate(FPerks.prefix + "&cYou broke the &e&lFactionCore&c!"));
					utils.removeArmorStand(e.getPlayer().getWorld(),
							"&4&l❤  &c" + FactionCoreSettings.CoreHP + "&7/&c" + FactionCoreSettings.maxCOREHP);

					e.setCancelled(true);
					return;

				}

				FactionCoreSettings.CoreHP = FactionCoreSettings.CoreHP - 2;

				
				
				utils.removeArmorStand(e.getPlayer().getWorld(),
						"&4&l❤  &c" + FactionCoreSettings.CoreHP + "&7/&c" + FactionCoreSettings.maxCOREHP);
				utils.createHologram(e.getClickedBlock().getLocation().add(0.5, -0.3, 0.5), utils
						.translate("&4&l❤  &c" + FactionCoreSettings.CoreHP + "&7/&c" + FactionCoreSettings.maxCOREHP));

				e.setCancelled(true);
				return;

			}

		}
		
		

		if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			
			FPlayer fPlayer = FPlayers.getInstance().getByPlayer(p);
			if (e.getClickedBlock().getType().equals(Material.BEACON)) {
				FPerksGUI.setPurchasedPerks(fPlayer.getFaction());
				FPerksGUI.openInventory(e.getPlayer());
				e.setCancelled(true);
				return;
			}
			
			
	

		}

	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void EntityExplodeEvent(EntityExplodeEvent e) {

		for (Block b : e.blockList()) {

			ItemStack beac = new ItemStack(Material.BEACON);

			if (b.getType() == beac.getType()) {

				
				e.blockList().clear();

				Bukkit.broadcastMessage(utils.translate(("" + FPerks.prefix
						+ "&8&l<&4&LCRITICAL HIT&8&l> &c &4&lTNT &chas taken &4&l&n-60HP&c off the FactionCore&7.")));
				FactionCoreSettings.CoreHP = FactionCoreSettings.CoreHP - 60;

				utils.removeArmorStand(b.getWorld(),
						"&4&l❤  &c" + FactionCoreSettings.CoreHP + "&7/&c" + FactionCoreSettings.maxCOREHP);
				utils.createHologram(b.getLocation().add(0.5, -0.3, 0.5), utils
						.translate("&4&l❤  &c" + FactionCoreSettings.CoreHP + "&7/&c" + FactionCoreSettings.maxCOREHP));
				
				if(FactionCoreSettings.CoreHP == 0) {
		
					b.breakNaturally();
					b.getWorld().createExplosion(b.getLocation(), 1);
					
					b.getWorld().strikeLightning(b.getLocation());
					
			          for(Entity en2 : b.getWorld().getEntities()) {
			        	  if(en2 instanceof Player) {
			        		  
			        		  
			        		  Player player = (Player) en2;
			        		  
			        		  double dist = player.getLocation().distance(b.getLocation());
			        		  
			        		  if(dist < 70) {
			        			  player.sendMessage(utils.translate(FPerks.prefix + "&cA &a&lNEARBY &c Faction Core have been broken."));
			        			  
			        			  player.playSound(player.getLocation(), Sound.ANVIL_BREAK, 0.0F, 0.0F);
			        			  
			        		  }
			        		  
			        	  }
			          }
					
					
				} else if(FactionCoreSettings.CoreHP < 0) {
					
					FactionCoreSettings.CoreHP = FactionCoreSettings.maxCOREHP;
					b.breakNaturally();
					b.getWorld().createExplosion(b.getLocation(), 1);
					b.getWorld().strikeLightning(b.getLocation());
					
				
					
					utils.removeArmorStand(b.getWorld(),
							"&4&l❤  &c" + FactionCoreSettings.CoreHP + "&7/&c" + FactionCoreSettings.maxCOREHP);
					
					
		          for(Entity en : b.getWorld().getEntities()) {
		        	  if(en instanceof Player) {
		        		  
		        		  
		        		  Player player = (Player) en;
		        		  
		        		  double dist = player.getLocation().distance(b.getLocation());
		        		  
		        		  if(dist < 70) {
		        			  player.sendMessage(utils.translate(FPerks.prefix + "&cA &a&lNEARBY &c Faction Core have been broken."));
		        			  player.playSound(player.getLocation(), Sound.ANVIL_BREAK, 0.0F, 0.0F);
		        		  }
		        		  
		        	  }
		          }
					

					e.setCancelled(true);
					return;
				}
			

				e.setCancelled(true);
				return;
			}

		}




	}

}
