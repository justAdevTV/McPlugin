package com.rhota.mcplugin.ranks;

import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;

public class AssignRank {
	private Plugin p;
	
	public AssignRank(Plugin p) {
		this.p = p;
	}
	
	public void setRank(Player p, Rank r) {
		p.getPlayer().setMetadata("Rank", new FixedMetadataValue(this.p, r));
	}
}
