package com.rhota.mcplugin;

import com.rhota.mcplugin.listeners.RegisterListener;
import com.rhota.mcplugin.utility.DebugUtility;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

/**
 * Created by justAdevTV on 11/26/2015.
 */

public class Core extends JavaPlugin {

    RegisterListener registerListeners;

    public void onEnable() {
        registerListeners = new RegisterListener(this);
        registerListeners.register();

        File f = this.getDataFolder();
        if (!f.exists()) {
            if (!f.mkdir()) {
                DebugUtility.toConsole("We can't make the dir?");
            }
        }

        DebugUtility.toConsole(this.getDataFolder());
    }

    public void onDisable() {

    }
}