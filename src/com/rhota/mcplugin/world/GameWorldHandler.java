package com.rhota.mcplugin.world;

import com.rhota.mcplugin.utility.DebugUtility;
import com.rhota.mcplugin.utility.FileUtility;
import org.bukkit.World;
import org.bukkit.World.Environment;
import org.bukkit.WorldCreator;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

public class GameWorldHandler {
    public final Plugin p;

    public GameWorldHandler(Plugin p) {
        this.p = p;
    }

    public GameWorldHandler(Plugin p, World w) {
        this.p = p;
        this.w = w;
    }

    public World w;
    public boolean inUse = true;

    private void createBlankWorldWithID(String id) {
        WorldCreator c = new WorldCreator(id);
        c.generateStructures(false);
        c.environment(Environment.NORMAL);
        c.generator(new BlankWorldGenerator());
        w = c.createWorld();
//        DebugUtility.toConsole(w.getName());
    }

    public World createBlankWorld() {
        createBlankWorldWithID(UUID.randomUUID().toString());
        return w;
    }

    public void disable() {
        Arrays.stream(w.getLoadedChunks()).forEach((x) -> {
            w.unloadChunk(x);
        });
        p.getServer().unloadWorld(w, false);
        inUse = false;
    }

    public void reuse() {
//        DebugUtility.toConsole(w.getName());
        createBlankWorldWithID(w.getName());
    }

    public boolean delete() {
        disable();
        return FileUtility.recursive_delete(w.getWorldFolder());
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof GameWorldHandler) {
            return ((GameWorldHandler) o).w.getName() == w.getName();
        } else if (o instanceof World) {
            return ((World) o).getName() == w.getName();
        } else {
            return false;
        }
    }


    public static ArrayList<GameWorldHandler> gw = new ArrayList<>();

    public static void print() {
        for (GameWorldHandler g : gw) {
            DebugUtility.toConsole(g.w.getName() + " % " + g.inUse + " % " + g.w.getPlayers().size());
            for (Player player : g.w.getPlayers()) {
                DebugUtility.toConsole(" " + player.getName());
            }
        }
    }

    public static GameWorldHandler tryRecycleWorld(Plugin p) {
        for (GameWorldHandler g : gw) {
            if (!g.inUse) {
                g.reuse();
                g.inUse = true;
                return g;
            }
        }
        GameWorldHandler g = new GameWorldHandler(p);
        g.createBlankWorld();
        g.inUse = true;
        gw.add(g);
        return g;
    }

    public static GameWorldHandler getFromWorld(World w) {
        for (GameWorldHandler g : gw) {
            if (w.getName() == g.w.getName()) {
                return g;
            }
        }
        return null;
    }

    public static void replaceGameWorldHandler(GameWorldHandler w) {
        for (GameWorldHandler g : gw) {
            if (g == w) {
                gw.remove(g);
                gw.add(w);
                break;
            }
        }
    }
}
