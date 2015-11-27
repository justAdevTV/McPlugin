package com.rhota.mcplugin;

import org.bukkit.plugin.java.JavaPlugin;

import com.rhota.mcplugin.listeners.RegisterListener;

/**
 * Created by justAdevTV on 11/26/2015.
 */

public class Core extends JavaPlugin {	
	
	RegisterListener registerListeners;
	
	public void onEnable() {
		registerListeners = new RegisterListener();
	}

	public void onDisable() {

	}
	
}
