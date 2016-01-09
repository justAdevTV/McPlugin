package com.rhota.mcplugin.world;

import java.io.File;
import java.io.IOException;

import org.bukkit.Location;

import com.rhota.mcplugin.utility.DebugUtility;
import com.sk89q.worldedit.CuboidClipboard;
import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.MaxChangedBlocksException;
import com.sk89q.worldedit.bukkit.BukkitUtil;
import com.sk89q.worldedit.bukkit.BukkitWorld;
import com.sk89q.worldedit.data.DataException;
import com.sk89q.worldedit.schematic.SchematicFormat;
import org.bukkit.World;

@SuppressWarnings("deprecation")
public class LoadWorld {
	/**
	 * The Great Deprecation
	 */

	public static void loadInCurrentWorld(File file, Location l) {
		try {
			EditSession e = new EditSession(new BukkitWorld(l.getWorld()), Integer.MAX_VALUE);
			e.enableQueue();
			SchematicFormat s = SchematicFormat.getFormat(file);
			CuboidClipboard c;
			c = s.load(file);
			c.paste(e, BukkitUtil.toVector(l), false);
			e.flushQueue();
		} catch (DataException | IOException | MaxChangedBlocksException temp) {
			DebugUtility.toConsole(temp.getMessage());
		}
	}

	/**
	 * Note: You should never use this.
	 * @param idOfWorld
	 * @param file
     * @param l
     */
	@Deprecated
	public static World loadInCompletelyBlankWorld(String idOfWorld, File file, Location l) {
		GameWorldHandler w = new GameWorldHandler();

		World q = w.createBlankWorld();
		//TODO: Find optimal y
		loadInCurrentWorld(file, new Location(q, 0, 64, 0));
		return q;
	}
}
