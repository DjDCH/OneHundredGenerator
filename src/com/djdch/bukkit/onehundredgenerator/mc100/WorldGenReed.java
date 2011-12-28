package com.djdch.bukkit.onehundredgenerator.mc100;

import java.util.Random;

import net.minecraft.server.Block;
import net.minecraft.server.Material;
import net.minecraft.server.World;

public class WorldGenReed extends WorldGenerator {
    @Override
    public boolean a(World paramWorld, Random paramRandom, int paramInt1, int paramInt2, int paramInt3) {
        for (int i = 0; i < 20; i++) {
            int j = paramInt1 + paramRandom.nextInt(4) - paramRandom.nextInt(4);
            int k = paramInt2;
            int m = paramInt3 + paramRandom.nextInt(4) - paramRandom.nextInt(4);
            if ((!paramWorld.isEmpty(j, k, m)) || ((paramWorld.getMaterial(j - 1, k - 1, m) != Material.WATER) && (paramWorld.getMaterial(j + 1, k - 1, m) != Material.WATER) && (paramWorld.getMaterial(j, k - 1, m - 1) != Material.WATER) && (paramWorld.getMaterial(j, k - 1, m + 1) != Material.WATER))) {
                continue;
            }

            int n = 2 + paramRandom.nextInt(paramRandom.nextInt(3) + 1);
            for (int i1 = 0; i1 < n; i1++) {
                if (Block.SUGAR_CANE_BLOCK.f(paramWorld, j, k + i1, m)) {
                    paramWorld.setRawTypeId(j, k + i1, m, Block.SUGAR_CANE_BLOCK.id);
                }

            }

        }

        return true;
    }
}
