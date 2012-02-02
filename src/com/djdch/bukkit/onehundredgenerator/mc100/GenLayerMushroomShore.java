package com.djdch.bukkit.onehundredgenerator.mc100;

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
                if (k == BiomeBase.MUSHROOM_ISLAND.K) {
                    int m = arrayOfInt1[(j + 1 + (i + 1 - 1) * (paramInt3 + 2))];
                    int n = arrayOfInt1[(j + 1 + 1 + (i + 1) * (paramInt3 + 2))];
                    int i1 = arrayOfInt1[(j + 1 - 1 + (i + 1) * (paramInt3 + 2))];
                    int i2 = arrayOfInt1[(j + 1 + (i + 1 + 1) * (paramInt3 + 2))];
                    if ((m == BiomeBase.OCEAN.K) || (n == BiomeBase.OCEAN.K) || (i1 == BiomeBase.OCEAN.K) || (i2 == BiomeBase.OCEAN.K))
                        arrayOfInt2[(j + i * paramInt3)] = BiomeBase.MUSHROOM_SHORE.K;
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
