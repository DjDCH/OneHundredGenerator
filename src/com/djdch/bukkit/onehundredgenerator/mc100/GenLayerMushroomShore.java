package com.djdch.bukkit.onehundredgenerator.mc100;

import net.minecraft.server.BiomeBase;

public class GenLayerMushroomShore extends GenLayer {
    public GenLayerMushroomShore(long paramLong, GenLayer paramGenLayer) {
        super(paramLong);
        this.a = paramGenLayer;
    }

    @Override
    public int[] a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        int[] arrayOfInt1 = this.a.a(paramInt1 - 1, paramInt2 - 1, paramInt3 + 2, paramInt4 + 2);

        int[] arrayOfInt2 = IntCache.a(paramInt3 * paramInt4);
        for (int i = 0; i < paramInt4; i++) {
            for (int j = 0; j < paramInt3; j++) {
                a(j + paramInt1, i + paramInt2);
                int k = arrayOfInt1[(j + 1 + (i + 1) * (paramInt3 + 2))];
                if (k == BiomeBase.MUSHROOM_ISLAND.F) {
                    int m = arrayOfInt1[(j + 1 + (i + 1 - 1) * (paramInt3 + 2))];
                    int n = arrayOfInt1[(j + 1 + 1 + (i + 1) * (paramInt3 + 2))];
                    int i1 = arrayOfInt1[(j + 1 - 1 + (i + 1) * (paramInt3 + 2))];
                    int i2 = arrayOfInt1[(j + 1 + (i + 1 + 1) * (paramInt3 + 2))];
                    if ((m == BiomeBase.OCEAN.F) || (n == BiomeBase.OCEAN.F) || (i1 == BiomeBase.OCEAN.F) || (i2 == BiomeBase.OCEAN.F))
                        arrayOfInt2[(j + i * paramInt3)] = BiomeBase.MUSHROOM_SHORE.F;
                    else
                        arrayOfInt2[(j + i * paramInt3)] = k;
                } else {
                    arrayOfInt2[(j + i * paramInt3)] = k;
                }
            }
        }

        return arrayOfInt2;
    }
}
