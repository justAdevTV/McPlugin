package com.rhota.mcplugin.ranks;

public enum Rank {
	OWNER		("Owner"),
	ADMIN		("Admin"),
	MODERATOR	("Mod"),
	BUILDER		("Builder"),
	DONOR_ONE	(ThemedRankNames.DONOR_ONE),
	DONOR_TWO	(ThemedRankNames.DONOR_TWO),
	DONOR_THREE	(ThemedRankNames.DONOR_THREE),
	DEFAULT		("Player");
	
	public final String rank;
	
	Rank(String rank) {
		this.rank = rank;
	}
	
	public String getRankName() {
		return rank;
	}
}
