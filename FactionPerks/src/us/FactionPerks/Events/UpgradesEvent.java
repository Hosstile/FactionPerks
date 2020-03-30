package us.FactionPerks.Events;

import java.util.ArrayList;

import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.FPlayers;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle.EnumTitleAction;
import us.FactionPerks.FPerks;
import us.FactionPerks.Files.BoughtPerks;
import us.FactionPerks.Files.BoughtUpgrades;
import us.FactionPerks.GUI.upgradeGUI;
import us.FactionPerks.MoneyPrinter.MoneyPrinter;
import us.FactionPerks.Settings.FactionCoreSettings;
import us.FactionPerks.Utilities.utils;

public class UpgradesEvent implements Listener{
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		
		if(e.getInventory().getTitle().equalsIgnoreCase(utils.translate("&f&lCore Upgrades"))) {
			
			ItemStack clicked = e.getCurrentItem();
			Player p = (Player) e.getWhoClicked();
			FPlayer fPlayer = FPlayers.getInstance().getByPlayer(p);

			if (clicked.getItemMeta().getDisplayName()
					.equalsIgnoreCase(utils.translate("&e&lMoney Printer"))) {

				if (FPerks.econ.getBalance(p.getPlayer()) >= 13000000) {
					if (fPlayer.hasFaction() == true) {

						if (BoughtUpgrades.upgrades
								.getBoolean("Factions." + fPlayer.getFaction().getTag() + ".Upgrades.MoneyPrinter") == true) {

							p.sendMessage(utils.translate(FPerks.prefix + "&cYou already own this upgrade!"));
							e.setCancelled(true);

							return;

						}

						if (BoughtUpgrades.upgrades.getBoolean(
								"Factions." + fPlayer.getFaction().getTag() + ".Upgrades.MoneyPrinter") == false) {
                              

							p.sendMessage(utils.translate(FPerks.prefix + "&cYou have purchased the MoneyPrinter Upgrade!"));
                             

							double balance = FPerks.econ.getBalance(p.getPlayer());

							IChatBaseComponent chatTitle = ChatSerializer
									.a("{\"text\":\"" + utils.translate(FPerks.prefix + "&4- &c13,000,000") + "\"}");

							PacketPlayOutTitle title = new PacketPlayOutTitle(EnumTitleAction.TITLE, chatTitle);
							PacketPlayOutTitle length = new PacketPlayOutTitle(5, 50, 5);

							((CraftPlayer) p).getHandle().playerConnection.sendPacket(title);
							((CraftPlayer) p).getHandle().playerConnection.sendPacket(length);

							FPerks.econ.withdrawPlayer(p.getPlayer(), 13000000);

							BoughtUpgrades.upgrades.set("Factions." + fPlayer.getFaction().getTag() + ".Upgrades.MoneyPrinter", true);
							BoughtUpgrades.saveupgrades();
							FPerks.getInstance().startCash(p);
							
							p.closeInventory();
							e.setCancelled(true);

						}
					} else {

						return;
					}

				} else {
					if (FPerks.econ.getBalance(p.getPlayer()) < 13000000) {
						p.sendMessage(utils.translate(FPerks.prefix + "&cNot enough funds for this Upgrade!"));
						e.setCancelled(true);
						return;

					}

				}
			}
			if(e.getInventory().getTitle().equalsIgnoreCase(utils.translate("&f&lCore Upgrades"))) {
				

				if (clicked.getItemMeta().getDisplayName()
						.equalsIgnoreCase(utils.translate("&4&lHealth"))) {

					if (FPerks.econ.getBalance(p.getPlayer()) >= 5000000) {
						if (fPlayer.hasFaction() == true) {

							if (BoughtUpgrades.upgrades
									.getBoolean("Factions." + fPlayer.getFaction().getTag() + ".Upgrades.Health") == true) {

								p.sendMessage(utils.translate(FPerks.prefix + "&cYou already own this upgrade!"));
								e.setCancelled(true);

								return;

							}

							if (BoughtUpgrades.upgrades.getBoolean(
									"Factions." + fPlayer.getFaction().getTag() + ".Upgrades.Health") == false) {


								p.sendMessage(utils.translate(FPerks.prefix + "&cYou have purchased the Health Upgrade!"));

								ArrayList<String> lores = new ArrayList<String>();
								
	

						
								
								
								double balance = FPerks.econ.getBalance(p.getPlayer());

								IChatBaseComponent chatTitle = ChatSerializer
										.a("{\"text\":\"" + utils.translate(FPerks.prefix + "&4- &c5,000,000") + "\"}");

								PacketPlayOutTitle title = new PacketPlayOutTitle(EnumTitleAction.TITLE, chatTitle);
								PacketPlayOutTitle length = new PacketPlayOutTitle(5, 50, 5);

								((CraftPlayer) p).getHandle().playerConnection.sendPacket(title);
								((CraftPlayer) p).getHandle().playerConnection.sendPacket(length);

								FPerks.econ.withdrawPlayer(p.getPlayer(), 5000000);

								
								BoughtUpgrades.upgrades.set("Factions." + fPlayer.getFaction().getTag() + ".Upgrades.Health", true);
								BoughtUpgrades.saveupgrades();
								p.closeInventory();
								
								FactionCoreSettings.addRandomHP(fPlayer.getFaction(), p);
								
								e.setCancelled(true);

							}
						} else {

							return;
						}

					} else {
						if (FPerks.econ.getBalance(p.getPlayer()) < 5000000) {
							p.sendMessage(utils.translate(FPerks.prefix + "&cNot enough funds for this Upgrade!"));
							e.setCancelled(true);
							return;

						}

					}
				}
			}
		}
				
		
	}

}
