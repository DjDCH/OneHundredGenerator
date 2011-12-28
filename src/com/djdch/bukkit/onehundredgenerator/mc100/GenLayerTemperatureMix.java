package com.djdch.bukkit.onehundredgenerator.mc100;

public class GenLayerTemperatureMix extends GenLayer {
    private GenLayer b;
    private int c;

    public GenLayerTemperatureMix(GenLayer paramGenLayer1, GenLayer paramGenLayer2, int paramInt) {
        super(0L);
        this.a = paramGenLayer2;
        this.b = paramGenLayer1;
        this.c = paramInt;
    }

    @Override
    public int[] a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        int[] arrayOfInt1 = this.a.a(paramInt1, paramInt2, paramInt3, paramInt4);
        int[] arrayOfInt2 = this.b.a(paramInt1, paramInt2, paramInt3, paramInt4);

        int[] arrayOfInt3 = IntCache.a(paramInt3 * paramInt4);
        for (int i = 0; i < paramInt3 * paramInt4; i++) {
            arrayOfInt2[i] += (BiomeBase.a[arrayOfInt1[i]].f() - arrayOfInt2[i]) / (this.c * 2 + 1);
        }

        return arrayOfInt3;
    }
}
