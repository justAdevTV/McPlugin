package com.rhota.mcplugin;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.rhota.mcplugin.listeners.BlockListeners;
import com.rhota.mcplugin.listeners.DamageListener;
import com.rhota.mcplugin.listeners.ExplosionListener;
import com.rhota.mcplugin.listeners.FoodListener;
import com.rhota.mcplugin.listeners.ItemListeners;
import com.rhota.mcplugin.listeners.WeatherListener;

/**
 * Created by justAdevTV on 11/26/2015.
 */

public class Core extends JavaPlugin{

	public void onEnable(){
		
	}
	
	public void onDisable(){
		
	}
	
	 public void registerListeners(){
		 PluginManager pluginManager = getServer().getPluginManager();
		 //TODO Add toggle
		 pluginManager.registerEvents(new BlockListeners(), this);
		 pluginManager.registerEvents(new DamageListener(), this);
		 pluginManager.registerEvents(new ExplosionListener(), this);
		 pluginManager.registerEvents(new FoodListener(), this);
		 pluginManager.registerEvents(new ItemListeners(), this);
		 pluginManager.registerEvents(new WeatherListener(), this);
	 }
	
}
