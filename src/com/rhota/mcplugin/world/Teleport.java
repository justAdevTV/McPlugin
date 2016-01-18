package com.rhota.mcplugin.world;

import com.rhota.mcplugin.config.GameWorldHandlerConfig;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class Teleport {
    private GameWorldHandlerConfig gameWorldHandlerConfig;

    public Teleport(GameWorldHandlerConfig gameWorldHandlerConfig) {
        this.gameWorldHandlerConfig = gameWorldHandlerConfig;
    }

    public void tp(World w, Player p) {
        World previousWorld = p.getWorld();
        p.teleport(gameWorldHandlerConfig.locationFromWorld(w));

        // Auto close the world
        GameWorldHandler gw = GameWorldHandler.getFromWorld(previousWorld);
        if (gw != null) {
            if (gw.w.getPlayers().size() == 0) {
                gw.inUse = false;
            }
        }
    }
}
