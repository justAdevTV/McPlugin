package com.rhota.mcplugin.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class ExplosionListener implements Listener {

	@EventHandler
	public void onTntPrime(EntityExplodeEvent e) {
		e.setCancelled(true);
	}

}
