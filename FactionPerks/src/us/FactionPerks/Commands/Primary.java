package us.FactionPerks.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.massivecraft.factions.Board;
import com.massivecraft.factions.FLocation;
import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.FPlayers;
import com.massivecraft.factions.Faction;
import com.massivecraft.factions.Factions;

import net.milkbowl.vault.economy.Economy;
import us.FactionPerks.CoreblockMeta;
import us.FactionPerks.FPerks;
import us.FactionPerks.Settings.FactionCoreSettings;
import us.FactionPerks.Utilities.utils;

public class Primary implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		
		
		
		if (cmd.getName().equalsIgnoreCase("fCore")) {
			
			Faction faction = null;
			
			
			
			
			faction = Factions.getInstance().getByTag(sender.getName());

			Player p = (Player) sender;
		    FPlayer fPlayer = FPlayers.getInstance().getByPlayer(p);
	           
			
			

		    
			if (args.length == 0) {
				p.sendMessage(utils.translate("&7/fcore &egive&8, &7/fcore &eclearAll"));
	
				return false;
			}

			switch (args[0]) {

			case "give":
         
            p.getPlayer().getInventory().addItem(CoreblockMeta.getCore());
            
     
            
            FLocation fLoc = new FLocation(p.getLocation());
            faction = Board.getInstance().getFactionAt(fLoc);
            
            

            FLocation loc = new FLocation(p.getLocation());
          
            
        
            
				break;

			case "clearAll":

				break;

				default: p.sendMessage("Invalid arguments");
				
			}

		}
		return false;
	}
	
	
	

}
