package com.djdch.bukkit.onehundredgenerator.mc100;

import java.util.Random;

import net.minecraft.server.Block;
import net.minecraft.server.World;

public class WorldGenCactus extends WorldGenerator {
    @Override
    public boolean a(World paramWorld, Random paramRandom, int paramInt1, int paramInt2, int paramInt3) {
        for (int i = 0; i < 10; i++) {
            int j = paramInt1 + paramRandom.nextInt(8) - paramRandom.nextInt(8);
            int k = paramInt2 + paramRandom.nextInt(4) - paramRandom.nextInt(4);
            int m = paramInt3 + paramRandom.nextInt(8) - paramRandom.nextInt(8);
            if (paramWorld.isEmpty(j, k, m)) {
                int n = 1 + paramRandom.nextInt(paramRandom.nextInt(3) + 1);
                for (int i1 = 0; i1 < n; i1++) {
                    if (Block.CACTUS.f(paramWorld, j, k + i1, m)) {
                        paramWorld.setRawTypeId(j, k + i1, m, Block.CACTUS.id);
                    }
                }
            }
        }

        return true;
    }
}
