package com.rhota.mcplugin.world;

import org.bukkit.World;
import org.bukkit.entity.Player;

public class Teleport {
	public static void tp(World w, Player p) {
		p.teleport(w.getSpawnLocation());
	}
}
