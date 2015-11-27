package com.rhota.mcplugin.listeners;

import org.bukkit.plugin.PluginManager;

import com.rhota.mcplugin.Core;

public class RegisterListener extends Core{
	
	Core p;
	
	public RegisterListener() {
		PluginManager pluginManager = getServer().getPluginManager();
		// TODO Add toggle
		pluginManager.registerEvents(new BlockListeners(), p);
		pluginManager.registerEvents(new DamageListener(), p);
		pluginManager.registerEvents(new ExplosionListener(), p);
		pluginManager.registerEvents(new FoodListener(), p);
		pluginManager.registerEvents(new ItemListeners(), p);
		pluginManager.registerEvents(new WeatherListener(), p);
		pluginManager.registerEvents(new AchievementListener(), p);
	}
	
}
