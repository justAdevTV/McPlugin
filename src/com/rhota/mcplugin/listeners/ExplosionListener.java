package com.rhota.mcplugin.listeners;

import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.CreeperPowerEvent;

public class ExplosionListener implements Listener {

	@EventHandler
	public void onTntPlace(BlockPlaceEvent e) {
		if (e.getPlayer().getUniqueId() != UUID.fromString("fdd6a6eca4c44c40b0efa5f64e2becc5")) {
			if (e.getBlockPlaced().getType() == Material.TNT) {
				e.getBlockPlaced().setType(Material.AIR);
			}
		}
	}
	
	@EventHandler
	public void disableTntExplosion(TNTPrimed e){
		e.remove();
	}
	
	@EventHandler
	public void creeperExplodeEvent(CreeperPowerEvent e){
		e.setCancelled(true);
	}
}
