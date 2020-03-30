package us.FactionPerks;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import us.FactionPerks.Utilities.ItemBuilder;
import us.FactionPerks.Utilities.utils;

public class CoreblockMeta {
	
	public static ItemStack getCore() { 
		
		
		ItemStack Core = new ItemBuilder(Material.BEACON).addUnsafeEnchantment(Enchantment.DURABILITY, 10).setName(utils.translate("&e&lFactionsCore")).toItemStack();
		
		
		return Core;		
	
	}

}
