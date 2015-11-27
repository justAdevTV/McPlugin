package com.rhota.mcplugin.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class WeatherListener implements Listener{

	@EventHandler
	public void disableWeather(WeatherChangeEvent e){
		e.setCancelled(true);
	}
	
}
