package com.djdch.bukkit.onehundredgenerator.mc100;

import java.util.Random;

import net.minecraft.server.EntityWolf;

public class BiomeTaiga extends BiomeBase {
    public BiomeTaiga(int paramInt) {
        super(paramInt);

        this.D.add(new BiomeMeta(EntityWolf.class, 8, 4, 4));

        this.B.z = 10;
        this.B.B = 1;
    }

    public WorldGenerator aa(Random paramRandom) {
        if (paramRandom.nextInt(3) == 0) {
            return new WorldGenTaiga1();
        }
        return new WorldGenTaiga2(false);
    }
}
