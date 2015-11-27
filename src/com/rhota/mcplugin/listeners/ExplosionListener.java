package com.rhota.mcplugin.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreeperPowerEvent;
import org.bukkit.event.entity.ExplosionPrimeEvent;

public class ExplosionListener implements Listener {

	@EventHandler
	public void onTntPrime(ExplosionPrimeEvent e) {
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onCreeperPrime(CreeperPowerEvent e){
		e.setCancelled(true);
	}
}
