package com.rhota.mcplugin.config;

import com.rhota.mcplugin.utility.DebugUtility;
import com.rhota.mcplugin.utility.LocationUtility;
import com.rhota.mcplugin.world.BlankWorldGenerator;
import com.rhota.mcplugin.world.GameWorldHandler;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.configuration.MemorySection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by joeychor on 1/18/2016.
 */
public class GameWorldHandlerConfig {
    private final boolean NO_RECURSION = false;

    private YamlConfiguration q;
    private Plugin p;

    // Get world from Location
    public ArrayList<Location> worlds;

    public GameWorldHandlerConfig(Plugin p) {
        this.p = p;
        worlds = new ArrayList<>();
    }

    public void load() {
        q = YamlConfiguration.loadConfiguration(new File(p.getDataFolder(), "index.yml"));

        /**
         * worlds:
         *  [id]:
         *   x: 0
         *   y: 64
         *   z: 0
         *
         * worlds is the first iteration
         * [id] is the second iteration
         * x, y, z is the third iteration
         */
        // First iteration
        q.getValues(NO_RECURSION).entrySet().stream().forEach((x) -> {
            // Second iteration
            if (x.getValue() instanceof MemorySection) {
                MemorySection X = ((MemorySection) x.getValue());
                X.getValues(NO_RECURSION).entrySet().stream().forEach((y) -> {
                    // Third iteration
                    if (y.getValue() instanceof MemorySection) {
                        MemorySection Y = ((MemorySection) y.getValue());

                        WorldCreator w = new WorldCreator(y.getKey());
                        w.generator(new BlankWorldGenerator());
                        w.generateStructures(false);
                        World W = w.createWorld();

                        Location l = new Location(W, Y.getDouble("x"), Y.getDouble("y"), Y.getDouble("z"));
                        DebugUtility.toConsole(LocationUtility.printLocation(l));

                        worlds.add(l);
                    }
                    //DebugUtility.toConsole("!", y.getKey(), ":", y.getValue());
                });
            }/* else {
                DebugUtility.toConsole(x.getKey(), ":", x.getValue());
            }*/
        });
    }

    public void loadWorldsToWorldHandler() {
        for (Location l : worlds) {
            GameWorldHandler w = new GameWorldHandler(p, l.getWorld());
            w.inUse = false;
            GameWorldHandler.gw.add(w);
        }
    }

    public Location locationFromWorld(World w) {
        for (Location l : worlds)
            if (l.getWorld().getName() == w.getName())
                return l;
        return (w.getSpawnLocation().getY() == 0
                ? w.getSpawnLocation().add(0,64,0)
                : w.getSpawnLocation());
    }

    public void addWorldsFromWorldHandler() {
        for (GameWorldHandler w : GameWorldHandler.gw) {
            Location l = locationFromWorld(w.w);
            // I swear to use StringBuilder next time!
            q.set("worlds." + w.w.getName() + ".x", l.getX());
            q.set("worlds." + w.w.getName() + ".y", l.getY());
            q.set("worlds." + w.w.getName() + ".z", l.getZ());
        }
    }

    public void addWorldFromWorldHandler(World w) {
        Location l = locationFromWorld(w);
        // I swear to use StringBuilder next time!
        q.set("worlds." + w.getName() + ".x", l.getX());
        q.set("worlds." + w.getName() + ".y", l.getY());
        q.set("worlds." + w.getName() + ".z", l.getZ());
    }

    public void close() {
        try {
            q.save(new File(p.getDataFolder(), "index.yml"));
        } catch (IOException e) {
            DebugUtility.toConsole(e.getMessage());
        }
    }
}
