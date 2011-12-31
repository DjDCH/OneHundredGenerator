package com.djdch.bukkit.onehundredgenerator.mc100;

import java.util.Random;

import net.minecraft.server.MathHelper;

public class NoiseGeneratorOctaves extends NoiseGenerator {
    private NoiseGeneratorPerlin[] a;
    private int b;

    public NoiseGeneratorOctaves(Random paramRandom, int paramInt) {
        this.b = paramInt;
        this.a = new NoiseGeneratorPerlin[paramInt];
        for (int i = 0; i < paramInt; i++)
            this.a[i] = new NoiseGeneratorPerlin(paramRandom);
    }

    public double[] a(double[] paramArrayOfDouble, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, double paramDouble1, double paramDouble2, double paramDouble3) {
        if (paramArrayOfDouble == null)
            paramArrayOfDouble = new double[paramInt4 * paramInt5 * paramInt6];
        else {
            for (int i = 0; i < paramArrayOfDouble.length; i++)
                paramArrayOfDouble[i] = 0.0D;
        }
        double d1 = 1.0D;

        for (int j = 0; j < this.b; j++) {
            double d2 = paramInt1 * d1 * paramDouble1;
            double d3 = paramInt2 * d1 * paramDouble2;
            double d4 = paramInt3 * d1 * paramDouble3;
            long l1 = MathHelper.c(d2);
            long l2 = MathHelper.c(d4);
            d2 -= l1;
            d4 -= l2;
            l1 %= 16777216L;
            l2 %= 16777216L;
            d2 += l1;
            d4 += l2;
            this.a[j].a(paramArrayOfDouble, d2, d3, d4, paramInt4, paramInt5, paramInt6, paramDouble1 * d1, paramDouble2 * d1, paramDouble3 * d1, d1);
            d1 /= 2.0D;
        }

        return paramArrayOfDouble;
    }

    public double[] a(double[] paramArrayOfDouble, int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble1, double paramDouble2, double paramDouble3) {
        return a(paramArrayOfDouble, paramInt1, 10, paramInt2, paramInt3, 1, paramInt4, paramDouble1, 1.0D, paramDouble2);
    }
}
