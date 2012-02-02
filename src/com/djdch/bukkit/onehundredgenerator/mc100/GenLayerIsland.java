package com.djdch.bukkit.onehundredgenerator.mc100;

public class GenLayerIsland extends GenLayer {
    public GenLayerIsland(long paramLong, GenLayer paramGenLayer) {
        super(paramLong);
        this.a = paramGenLayer;
    }

    @Override
    public int[] a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        int i = paramInt1 - 1;
        int j = paramInt2 - 1;
        int k = paramInt3 + 2;
        int m = paramInt4 + 2;
        int[] arrayOfInt1 = this.a.a(i, j, k, m);

        int[] arrayOfInt2 = IntCache.a(paramInt3 * paramInt4);
        for (int n = 0; n < paramInt4; n++) {
            for (int i1 = 0; i1 < paramInt3; i1++) {
                int i2 = arrayOfInt1[(i1 + 0 + (n + 0) * k)];
                int i3 = arrayOfInt1[(i1 + 2 + (n + 0) * k)];
                int i4 = arrayOfInt1[(i1 + 0 + (n + 2) * k)];
                int i5 = arrayOfInt1[(i1 + 2 + (n + 2) * k)];
                int i6 = arrayOfInt1[(i1 + 1 + (n + 1) * k)];
                a(i1 + paramInt1, n + paramInt2);
                if ((i6 == 0) && ((i2 != 0) || (i3 != 0) || (i4 != 0) || (i5 != 0))) {
                    int i7 = 1;
                    int i8 = 1;
                    if ((i2 != 0) && (a(i7++) == 0))
                        i8 = i2;
                    if ((i3 != 0) && (a(i7++) == 0))
                        i8 = i3;
                    if ((i4 != 0) && (a(i7++) == 0))
                        i8 = i4;
                    if ((i5 != 0) && (a(i7++) == 0))
                        i8 = i5;
                    if (a(3) == 0) {
                        arrayOfInt2[(i1 + n * paramInt3)] = i8;
                    } else if (i8 == BiomeBase.ICE_PLAINS.K)
                        arrayOfInt2[(i1 + n * paramInt3)] = BiomeBase.FROZEN_OCEAN.K;
                    else
                        arrayOfInt2[(i1 + n * paramInt3)] = 0;
                } else if ((i6 > 0) && ((i2 == 0) || (i3 == 0) || (i4 == 0) || (i5 == 0))) {
                    if (a(5) == 0) {
                        if (i6 == BiomeBase.ICE_PLAINS.K)
                            arrayOfInt2[(i1 + n * paramInt3)] = BiomeBase.FROZEN_OCEAN.K;
                        else
                            arrayOfInt2[(i1 + n * paramInt3)] = 0;
                    } else
                        arrayOfInt2[(i1 + n * paramInt3)] = i6;
                } else {
                    arrayOfInt2[(i1 + n * paramInt3)] = i6;
                }
            }
        }
        return arrayOfInt2;
    }
}
