package com.rhota.mcplugin.listeners;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class DamageListener implements Listener{

	//TODO Make better
	@EventHandler
	public void onDamageEvent(EntityDamageByEntityEvent e){
		if (e.getEntityType() == EntityType.PLAYER){
			e.setCancelled(true);
		}
	}
	
}
