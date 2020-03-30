package us.FactionPerks.Settings;

import org.bukkit.entity.Player;

public class Perks {

	boolean Speedperk;
	boolean hasAtleastOnePerk;
	boolean Jumpboostperk;
	boolean Jellylegsperk;
	
	private static Perks instance;
	
	public static Perks getPerks() {
		return instance;
	}
	
	public static void addPurchasedPerks(Player fp) {
		
		
		
	}

	public boolean isSpeedperk() {
		return Speedperk;
	}

	public void setSpeedperk(boolean speedperk) {
		Speedperk = speedperk;
		
		if(Speedperk == true) {
			hasAtleastOnePerk = true;
		}
	}

	public boolean isJumpboostperk() {
		return Jumpboostperk;
	}

	public void setJumpboostperk(boolean jumpboostperk) {
		Jumpboostperk = jumpboostperk;
		
		
		if(Jumpboostperk == true) {
			hasAtleastOnePerk = true;
		}
		
	}

	public boolean isJellylegsperk() {
		return Jellylegsperk;
	}

	public void setJellylegsperk(boolean jellylegsperk) {
		Jellylegsperk = jellylegsperk;
		
		if(Jellylegsperk == true) {
			hasAtleastOnePerk = true;
		}
	}

	public boolean isHasAtleastOnePerk() {
		return hasAtleastOnePerk;
	}

	public void setHasAtleastOnePerk(boolean hasAtleastOnePerk) {
		this.hasAtleastOnePerk = hasAtleastOnePerk;
	}
	
	
	
}
