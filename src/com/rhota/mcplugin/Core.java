package com.rhota.mcplugin;

import com.rhota.mcplugin.utility.DebugUtility;
import org.bukkit.plugin.java.JavaPlugin;

import com.rhota.mcplugin.listeners.RegisterListener;

import java.io.File;
import java.nio.file.Paths;

/**
 * Created by justAdevTV on 11/26/2015.
 */

public class Core extends JavaPlugin {	
	
	RegisterListener registerListeners;
	
	public void onEnable() {
		registerListeners = new RegisterListener(this);

		File f = this.getDataFolder();
		if (!f.exists()) {
			f.mkdir();
		}

		DebugUtility.toConsole(this.getDataFolder());
	}

	public void onDisable() {

	}
}