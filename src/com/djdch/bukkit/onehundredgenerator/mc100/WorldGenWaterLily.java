package com.djdch.bukkit.onehundredgenerator.mc100;

import java.util.Random;

import net.minecraft.server.Block;
import net.minecraft.server.World;

public class WorldGenWaterLily extends WorldGenerator {
    @Override
    public boolean a(World paramWorld, Random paramRandom, int paramInt1, int paramInt2, int paramInt3) {
        for (int i = 0; i < 10; i++) {
            int j = paramInt1 + paramRandom.nextInt(8) - paramRandom.nextInt(8);
            int k = paramInt2 + paramRandom.nextInt(4) - paramRandom.nextInt(4);
            int m = paramInt3 + paramRandom.nextInt(8) - paramRandom.nextInt(8);
            if ((!paramWorld.isEmpty(j, k, m)) || (!Block.WATER_LILY.canPlace(paramWorld, j, k, m)))
                continue;
            paramWorld.setRawTypeId(j, k, m, Block.WATER_LILY.id);
        }

        return true;
    }
}
