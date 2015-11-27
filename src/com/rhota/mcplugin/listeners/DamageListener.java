package com.rhota.mcplugin.listeners;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class DamageListener implements Listener{

	//TODO Make better
	@EventHandler
	public void onDamageEvent(EntityDamageEvent e){
		if (e.getEntityType() == EntityType.PLAYER){
			e.setCancelled(true);
		}
	}
}
