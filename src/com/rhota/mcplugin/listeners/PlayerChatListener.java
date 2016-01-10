package com.rhota.mcplugin.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.Plugin;

import com.rhota.mcplugin.ranks.RankHandler;

public class PlayerChatListener implements Listener{
	final private RankHandler handle;
	
	@EventHandler
	public void onAsyncPlayerChat(AsyncPlayerChatEvent e) {
		e.setCancelled(true);
		e.getRecipients().stream().forEach((Player p) ->
				p.sendMessage(new StringBuilder()
                .append(handle.getPrefix(e.getPlayer()))
                .append(e.getMessage())
                .toString()));
	}
	
	public PlayerChatListener(Plugin plugin) {
		this.handle = new RankHandler(plugin);
	}
}
