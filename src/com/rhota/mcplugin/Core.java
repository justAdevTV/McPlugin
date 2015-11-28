package com.rhota.mcplugin;

import org.bukkit.plugin.java.JavaPlugin;

import com.rhota.mcplugin.listeners.RegisterListener;

/**
 * Created by justAdevTV on 11/26/2015.
 */

public class Core extends JavaPlugin {	
	
	RegisterListener registerListeners;
	
	public void onEnable() {
		registerListeners = new RegisterListener(this);
		//registerListenrs();
	}

	public void onDisable() {

	}

	/*
	public void registerListenrs(){
		PluginManager pluginManager = getServer().getPluginManager();
		// TODO Add toggle
		pluginManager.registerEvents(new BlockListeners(), this);
		pluginManager.registerEvents(new DamageListener(), this);
		pluginManager.registerEvents(new ExplosionListener(), this);
		pluginManager.registerEvents(new FoodListener(), this);
		pluginManager.registerEvents(new ItemListeners(), this);
		pluginManager.registerEvents(new WeatherListener(), this);
		pluginManager.registerEvents(new AchievementListener(), this);
	}*/
	
}