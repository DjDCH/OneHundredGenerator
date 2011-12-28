package com.djdch.bukkit.onehundredgenerator.mc100;

public class LayerIsland extends GenLayer {
    public LayerIsland(long paramLong) {
        super(paramLong);
    }

    @Override
    public int[] a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        int[] arrayOfInt = IntCache.a(paramInt3 * paramInt4);
        for (int i = 0; i < paramInt4; i++) {
            for (int j = 0; j < paramInt3; j++) {
                a(paramInt1 + j, paramInt2 + i);
                arrayOfInt[(j + i * paramInt3)] = (a(10) == 0 ? 1 : 0);
            }
        }

        if ((paramInt1 > -paramInt3) && (paramInt1 <= 0) && (paramInt2 > -paramInt4) && (paramInt2 <= 0)) {
            arrayOfInt[(-paramInt1 + -paramInt2 * paramInt3)] = 1;
        }
        return arrayOfInt;
    }
}
