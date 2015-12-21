package com.rhota.mcplugin.ranks;

public class Prefix {
	public String prefix;
	
	public String append(String message) {
		return new StringBuilder()
				.append(prefix)
				.append(message)
				.toString();
	}
	
	public Prefix(String prefix) {
		this.prefix = prefix;
	}
}
