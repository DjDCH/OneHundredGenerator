package com.djdch.bukkit.onehundredgenerator.mc100;

import java.util.Random;

import net.minecraft.server.EntityWolf;

public class BiomeForest extends BiomeBase {
    public BiomeForest(int paramInt) {
        super(paramInt);
        this.I.add(new BiomeMeta(EntityWolf.class, 5, 4, 4));
        this.G.z = 10;
        this.G.B = 2;
    }

    public WorldGenerator aa(Random paramRandom) {
        if (paramRandom.nextInt(5) == 0) {
            return this.N;
        }
        if (paramRandom.nextInt(10) == 0) {
            return this.M;
        }
        return this.L;
    }
}
