package com.rhota.mcplugin.utility;

import org.bukkit.Location;

public class LocationUtility {
	public static String printLocation(Location l) {
		return new StringBuilder()
				.append("(")
				.append(l.getBlockX())
				.append(", ")
				.append(l.getBlockY())
				.append(", ")
				.append(l.getBlockZ())
				.append(")")
				.toString();
	}
}
