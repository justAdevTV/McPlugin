package com.rhota.mcplugin.listeners;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

public class RegisterListener{
	
	public RegisterListener(Plugin p) {
		PluginManager pluginManager = p.getServer().getPluginManager();
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
