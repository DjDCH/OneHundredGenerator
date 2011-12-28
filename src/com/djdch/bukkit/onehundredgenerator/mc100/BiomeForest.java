package com.djdch.bukkit.onehundredgenerator.mc100;

import java.util.Random;

import net.minecraft.server.EntityWolf;

public class BiomeForest extends BiomeBase {
    public BiomeForest(int paramInt) {
        super(paramInt);
        this.D.add(new BiomeMeta(EntityWolf.class, 5, 4, 4));
        this.B.z = 10;
        this.B.B = 2;
    }

    public WorldGenerator aa(Random paramRandom) {
        if (paramRandom.nextInt(5) == 0) {
            return this.I;
        }
        if (paramRandom.nextInt(10) == 0) {
            return this.H;
        }
        return this.G;
    }
}
