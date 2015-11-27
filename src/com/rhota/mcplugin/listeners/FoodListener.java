package com.rhota.mcplugin.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class FoodListener implements Listener{

	@EventHandler
	public void onHungerChange(FoodLevelChangeEvent e){
		e.setCancelled(true);
	}
	
}
