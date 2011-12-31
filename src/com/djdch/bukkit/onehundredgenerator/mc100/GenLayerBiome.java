package com.djdch.bukkit.onehundredgenerator.mc100;

import net.minecraft.server.BiomeBase;

public class GenLayerBiome extends GenLayer {
    private BiomeBase[] b = { BiomeBase.DESERT, BiomeBase.FOREST, BiomeBase.EXTREME_HILLS, BiomeBase.SWAMPLAND, BiomeBase.PLAINS, BiomeBase.TAIGA };

    public GenLayerBiome(long paramLong, GenLayer paramGenLayer) {
        super(paramLong);
        this.a = paramGenLayer;
    }

    @Override
    public int[] a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        int[] arrayOfInt1 = this.a.a(paramInt1, paramInt2, paramInt3, paramInt4);

        int[] arrayOfInt2 = IntCache.a(paramInt3 * paramInt4);
        for (int i = 0; i < paramInt4; i++) {
            for (int j = 0; j < paramInt3; j++) {
                a(j + paramInt1, i + paramInt2);
                int k = arrayOfInt1[(j + i * paramInt3)];
                if (k == 0)
                    arrayOfInt2[(j + i * paramInt3)] = 0;
                else if (k == BiomeBase.MUSHROOM_ISLAND.F)
                    arrayOfInt2[(j + i * paramInt3)] = k;
                else if (k == 1)
                    arrayOfInt2[(j + i * paramInt3)] = this.b[a(this.b.length)].F;
                else {
                    arrayOfInt2[(j + i * paramInt3)] = BiomeBase.ICE_PLAINS.F;
                }
            }
        }

        return arrayOfInt2;
    }
}
