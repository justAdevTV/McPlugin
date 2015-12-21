package com.rhota.mcplugin.ranks;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;

public class RankHandler {
	public Plugin p;
	
	public RankHandler(Plugin p) {
		this.p = p;
	}
	
	public void setPersonToRank(Player player, Rank r) {
		player.setMetadata("rank", new FixedMetadataValue(p, r.getRankName()));
	}
	
	public Rank getRankFromPerson(Player player) {
		return Rank.valueOf(player.getMetadata("rank").get(0).asString());
	}
	
	public String getPrefix(Player player) {
		StringBuilder result = new StringBuilder();
		
		switch (getRankFromPerson(player)) {
		case OWNER:
			result.append(ChatColor.BOLD);
		case ADMIN:
			result.append(ChatColor.RED);
			break;
			
		case MODERATOR:
			result.append(ChatColor.BOLD);
			result.append(ChatColor.BLUE);
			break;
		
		case BUILDER:
			result.append(ChatColor.ITALIC);
		case DEFAULT:
		default:
			result.append(ChatColor.BLUE);		
			break;
			
		case DONOR_ONE:
			result.append(ChatColor.BOLD);
		case DONOR_TWO:
		case DONOR_THREE:
			result.append(ChatColor.GOLD);
			break;		
		}
		
		return result.append("{")
				.append(getRankFromPerson(player).getRankName())
				.append("} [")
				.append(player.getName())
				.append("] ")
				.append(ChatColor.RESET)
				.append(ChatColor.BLACK)
				.toString();
	}
}
