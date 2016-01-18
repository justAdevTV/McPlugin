package com.rhota.mcplugin;

import com.rhota.mcplugin.config.GameWorldHandlerConfig;
import com.rhota.mcplugin.listeners.RegisterListener;
import com.rhota.mcplugin.utility.DebugUtility;
import com.rhota.mcplugin.world.GameWorldHandler;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

/**
 * Created by justAdevTV on 11/26/2015.
 */

public class Core extends JavaPlugin {

    public GameWorldHandlerConfig gameWorldHandlerConfig;

    public void onEnable() {
        gameWorldHandlerConfig = new GameWorldHandlerConfig(this);
        new RegisterListener(this, gameWorldHandlerConfig).register();

        File f = this.getDataFolder();
        if (!f.exists() && !f.mkdir()) {
            throw new RuntimeException("McPlugin cannot make its data directory.");
        }
        File F = new File(f, "index.yml");
        try {
            if (!F.exists())
                F.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("McPlugin cannot make its index.yml.");
        }
        //DebugUtility.toConsole(this.getDataFolder());

        gameWorldHandlerConfig.load();
        gameWorldHandlerConfig.loadWorldsToWorldHandler();
        GameWorldHandler.print();
    }

    public void onDisable() {
        for (GameWorldHandler gw : GameWorldHandler.gw) {
            gw.disable();
            DebugUtility.toConsole("Archiving ", gw.w.getName(), ", adding to recycle bin");
            gameWorldHandlerConfig.addWorldFromWorldHandler(gw.w);
        }
        gameWorldHandlerConfig.close();
    }
}