package com.rhota.mcplugin.world;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.World.Environment;
import org.bukkit.WorldCreator;

public class GameWorldHandler {
	public World w;
	public boolean inUse = true;
	
	public void createBlankWorldWithID(String id) {
		WorldCreator c = new WorldCreator(id);
		c.generateStructures(false);
		c.environment(Environment.NORMAL);
		c.generator(new BlankWorldGenerator());
		w = c.createWorld();
	}
	
	public World createBlankWorld() {
		createBlankWorldWithID(UUID.randomUUID().toString());
		return w;
	}
	
	public void disable() {
		for (Chunk c : w.getLoadedChunks()) {
			w.unloadChunk(c);
		}
		inUse = false;
	}
	
	public void reuse() {
		createBlankWorldWithID(w.getName());
	}
	
	
	public static ArrayList<GameWorldHandler> gw = new ArrayList<>();
	
	public static GameWorldHandler tryRecycleWorld() {
		GameWorldHandler returnValue = null;
		for (GameWorldHandler g : gw) {
			if (!g.inUse) {
				g.reuse();
				returnValue = g;
				break;
			}
		}
		if (returnValue == null) {
			returnValue = new GameWorldHandler();
            returnValue.createBlankWorld();
            gw.add(returnValue);
		}
		return returnValue;
	}
}
