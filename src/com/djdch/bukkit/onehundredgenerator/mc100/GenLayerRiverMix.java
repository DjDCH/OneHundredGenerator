package com.djdch.bukkit.onehundredgenerator.mc100;

public class GenLayerRiverMix extends GenLayer {
    private GenLayer b;
    private GenLayer c;

    public GenLayerRiverMix(long paramLong, GenLayer paramGenLayer1, GenLayer paramGenLayer2) {
        super(paramLong);
        this.b = paramGenLayer1;
        this.c = paramGenLayer2;
    }

    public void b(long paramLong) {
        this.b.b(paramLong);
        this.c.b(paramLong);
        super.b(paramLong);
    }

    @Override
    public int[] a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        int[] arrayOfInt1 = this.b.a(paramInt1, paramInt2, paramInt3, paramInt4);
        int[] arrayOfInt2 = this.c.a(paramInt1, paramInt2, paramInt3, paramInt4);

        int[] arrayOfInt3 = IntCache.a(paramInt3 * paramInt4);
        for (int i = 0; i < paramInt3 * paramInt4; i++) {
            if (arrayOfInt1[i] == BiomeBase.OCEAN.K) {
                arrayOfInt3[i] = arrayOfInt1[i];
            } else if (arrayOfInt2[i] >= 0) {
                if (arrayOfInt1[i] == BiomeBase.ICE_PLAINS.K)
                    arrayOfInt3[i] = BiomeBase.FROZEN_RIVER.K;
                else if ((arrayOfInt1[i] == BiomeBase.MUSHROOM_ISLAND.K) || (arrayOfInt1[i] == BiomeBase.MUSHROOM_SHORE.K))
                    arrayOfInt3[i] = BiomeBase.MUSHROOM_SHORE.K;
                else
                    arrayOfInt3[i] = arrayOfInt2[i];
            } else
                arrayOfInt3[i] = arrayOfInt1[i];

        }

        return arrayOfInt3;
    }
}
