package us.FactionPerks.Events;

import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.FPlayers;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle.EnumTitleAction;
import us.FactionPerks.FPerks;
import us.FactionPerks.Files.BoughtPerks;
import us.FactionPerks.GUI.FPerksGUI;
import us.FactionPerks.GUI.upgradeGUI;
import us.FactionPerks.Utilities.utils;

public class PerksEvent implements Listener {

	@EventHandler
	public void onClick(InventoryClickEvent e) {

		ItemStack clicked = e.getCurrentItem();

		if (e.getInventory().getTitle().equalsIgnoreCase(utils.translate("&f&lFactionCore"))) {

			if ((clicked.getType() == Material.AIR)) {
				
				
				e.setCancelled(true);
				return;
			}

			

			
			
			
			
			Player p = (Player) e.getWhoClicked();
			if (clicked.getItemMeta().getDisplayName().equalsIgnoreCase(utils.translate("&6&lPG 2"))) {

				p.closeInventory();
				p.openInventory(upgradeGUI.inv);
				e.setCancelled(true);

			}

			FPlayer fPlayer = FPlayers.getInstance().getByPlayer(p);

			if (clicked.getItemMeta().getDisplayName()
					.equalsIgnoreCase(utils.translate(FPerksGUI.getSpeedinfactionland()))) {

				if (FPerks.econ.getBalance(p.getPlayer()) >= 15000000) {
					if (fPlayer.hasFaction() == true) {

						if (BoughtPerks.boughtperks
								.getBoolean("Factions." + fPlayer.getFaction().getTag() + ".Perks.SpeedBUFF") == true) {

							p.sendMessage(utils.translate(FPerks.prefix + "&cYou already own this perk!"));
							e.setCancelled(true);

							return;

						}

						if (BoughtPerks.boughtperks.getBoolean(
								"Factions." + fPlayer.getFaction().getTag() + ".Perks.SpeedBUFF") == false) {


							p.sendMessage(utils.translate(FPerks.prefix + "&cYou have purchased the speed perk!"));

							
							double balance = FPerks.econ.getBalance(p.getPlayer());

							IChatBaseComponent chatTitle = ChatSerializer
									.a("{\"text\":\"" + utils.translate(FPerks.prefix + "&4- &c15,000,000") + "\"}");

							PacketPlayOutTitle title = new PacketPlayOutTitle(EnumTitleAction.TITLE, chatTitle);
							PacketPlayOutTitle length = new PacketPlayOutTitle(5, 50, 5);

							((CraftPlayer) p).getHandle().playerConnection.sendPacket(title);
							((CraftPlayer) p).getHandle().playerConnection.sendPacket(length);

							FPerks.econ.withdrawPlayer(p.getPlayer(), 15000000);

							BoughtPerks.boughtperks
									.set("Factions." + fPlayer.getFaction().getTag() + ".Perks.SpeedBUFF", true);
							BoughtPerks.saveBoughtPerks();
							p.closeInventory();
							e.setCancelled(true);

						}
					} else {

						return;
					}

				} else {
					if (FPerks.econ.getBalance(p.getPlayer()) < 15000000) {
						p.sendMessage(utils.translate(FPerks.prefix + "&cNot enough funds for this perk!"));
						e.setCancelled(true);
						return;

					}

				}
			}

		
			
		}

	}

	@EventHandler
	public void onClick1(InventoryClickEvent e) {

		ItemStack clicked = e.getCurrentItem();
		Player p = (Player) e.getWhoClicked();

		if (e.getInventory().getTitle().equalsIgnoreCase(utils.translate("&f&lFactionCore"))) {

			FPlayer fPlayer = FPlayers.getInstance().getByPlayer(p);

			if (clicked.getItemMeta().getDisplayName()
					.equalsIgnoreCase(utils.translate(FPerksGUI.getJumpboostinfactionland()))) {

				if (FPerks.econ.getBalance(p.getPlayer()) >= 12500000) {
					if (fPlayer.hasFaction() == true) {

						if (BoughtPerks.boughtperks.getBoolean(
								"Factions." + fPlayer.getFaction().getTag() + ".Perks.JumpboostBUFF") == true) {

							p.sendMessage(utils.translate(FPerks.prefix + "&cYou already own this perk!"));
							e.setCancelled(true);

							return;

						}

						if (BoughtPerks.boughtperks.getBoolean(
								"Factions." + fPlayer.getFaction().getTag() + ".Perks.JumpboostBUFF") == false) {

							p.sendMessage(utils.translate(FPerks.prefix + "&cYou have purchased the Jumpboost perk!"));

							double balance = FPerks.econ.getBalance(p.getPlayer());

							IChatBaseComponent chatTitle = ChatSerializer
									.a("{\"text\":\"" + utils.translate(FPerks.prefix + "&4- &c12,500,000") + "\"}");

							PacketPlayOutTitle title = new PacketPlayOutTitle(EnumTitleAction.TITLE, chatTitle);
							PacketPlayOutTitle length = new PacketPlayOutTitle(5, 50, 5);

							((CraftPlayer) p).getHandle().playerConnection.sendPacket(title);
							((CraftPlayer) p).getHandle().playerConnection.sendPacket(length);

							FPerks.econ.withdrawPlayer(p.getPlayer(), 12500000);

							BoughtPerks.boughtperks
									.set("Factions." + fPlayer.getFaction().getTag() + ".Perks.JumpboostBUFF", true);
							BoughtPerks.saveBoughtPerks();
							
							p.closeInventory();
							e.setCancelled(true);

						}
					} else {

						return;
					}

				} else {
					if (FPerks.econ.getBalance(p.getPlayer()) < 12500000) {
						p.sendMessage(utils.translate(FPerks.prefix + "&cNot enough funds for this perk!"));
						e.setCancelled(true);
						return;

					}

				}
			}

		}
		
		if (e.getInventory().getTitle().equalsIgnoreCase(utils.translate("&f&lFactionCore"))) {

			FPlayer fPlayer = FPlayers.getInstance().getByPlayer(p);

			if (clicked.getItemMeta().getDisplayName()
					.equalsIgnoreCase(utils.translate(FPerksGUI.getNofalldamageinfactionland()))) {

				if (FPerks.econ.getBalance(p.getPlayer()) >= 10000000) {
					if (fPlayer.hasFaction() == true) {

						if (BoughtPerks.boughtperks.getBoolean(
								"Factions." + fPlayer.getFaction().getTag() + ".Perks.JellyLegsBUFF") == true) {

							p.sendMessage(utils.translate(FPerks.prefix + "&cYou already own this perk!"));
							e.setCancelled(true);

							return;

						}

						if (BoughtPerks.boughtperks.getBoolean(
								"Factions." + fPlayer.getFaction().getTag() + ".Perks.JellyLegsBUFF") == false) {

							p.sendMessage(utils.translate(FPerks.prefix + "&cYou have purchased the JellyLegs perk!"));

							double balance = FPerks.econ.getBalance(p.getPlayer());

							IChatBaseComponent chatTitle = ChatSerializer
									.a("{\"text\":\"" + utils.translate(FPerks.prefix + "&4- &c10,500,000") + "\"}");

							PacketPlayOutTitle title = new PacketPlayOutTitle(EnumTitleAction.TITLE, chatTitle);
							PacketPlayOutTitle length = new PacketPlayOutTitle(5, 50, 5);

							((CraftPlayer) p).getHandle().playerConnection.sendPacket(title);
							((CraftPlayer) p).getHandle().playerConnection.sendPacket(length);

							FPerks.econ.withdrawPlayer(p.getPlayer(), 10000000);

							BoughtPerks.boughtperks
									.set("Factions." + fPlayer.getFaction().getTag() + ".Perks.JellyLegsBUFF", true);
							BoughtPerks.saveBoughtPerks();
							
							p.closeInventory();
							e.setCancelled(true);

						}
					} else {

		
						return;
					}

				} else {
					if (FPerks.econ.getBalance(p.getPlayer()) < 10000000) {
						p.sendMessage(utils.translate(FPerks.prefix + "&cNot enough funds for this perk!"));
						e.setCancelled(true);
						return;

					}
		

				}
			}

		}

	}
	
	@EventHandler
	
	public void onClick2(InventoryClickEvent e) {
		
		Player p = (Player) e.getWhoClicked();
		ItemStack clicked = e.getCurrentItem();
		


		if (e.getInventory().getTitle().equalsIgnoreCase(utils.translate("&f&lFactionCore"))) {
			
			if (!clicked.getItemMeta().getDisplayName().equalsIgnoreCase(utils.translate(FPerksGUI.getSpeedinfactionland()))) {e.setCancelled(true); return;}
			if (!clicked.getItemMeta().getDisplayName().equalsIgnoreCase(utils.translate(FPerksGUI.getNofalldamageinfactionland()))) {e.setCancelled(true); return;}
			if (!clicked.getItemMeta().getDisplayName().equalsIgnoreCase(utils.translate(FPerksGUI.getJumpboostinfactionland()))) { e.setCancelled(true); return;}
			if (!clicked.getItemMeta().getDisplayName().equalsIgnoreCase(utils.translate(FPerksGUI.getNextPGString()))) {e.setCancelled(true); return;}
			if (clicked.getItemMeta().getDisplayName().equalsIgnoreCase(utils.translate(FPerksGUI.getPurchasedPerks()))) {e.setCancelled(true); return;}
			
			
			
		}
		
	}

}
