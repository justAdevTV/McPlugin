package com.rhota.mcplugin.world;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.ChunkGenerator;

@SuppressWarnings("deprecation")
public class BlankWorldGenerator extends ChunkGenerator {
	@Override
	public byte[] generate(World world, Random random, int x, int z) {
        byte[] r = new byte[32768];
        for (int i = 0; i < 32768; i++) {
            r[i] = (byte) Material.AIR.getId();
        }
        return r;
    }
}
