package com.djdch.bukkit.onehundredgenerator.mc100;

import java.util.Random;

import net.minecraft.server.Block;
import net.minecraft.server.MathHelper;
import net.minecraft.server.World;

public class WorldGenMinable extends WorldGenerator {
    private int a;
    private int b;

    public WorldGenMinable(int paramInt1, int paramInt2) {
        this.a = paramInt1;
        this.b = paramInt2;
    }

    @Override
    public boolean a(World paramWorld, Random paramRandom, int paramInt1, int paramInt2, int paramInt3) {
        float f = paramRandom.nextFloat() * 3.141593F;

        double d1 = paramInt1 + 8 + MathHelper.sin(f) * this.b / 8.0F;
        double d2 = paramInt1 + 8 - MathHelper.sin(f) * this.b / 8.0F;
        double d3 = paramInt3 + 8 + MathHelper.cos(f) * this.b / 8.0F;
        double d4 = paramInt3 + 8 - MathHelper.cos(f) * this.b / 8.0F;

        double d5 = paramInt2 + paramRandom.nextInt(3) - 2;
        double d6 = paramInt2 + paramRandom.nextInt(3) - 2;

        for (int i = 0; i <= this.b; i++) {
            double d7 = d1 + (d2 - d1) * i / this.b;
            double d8 = d5 + (d6 - d5) * i / this.b;
            double d9 = d3 + (d4 - d3) * i / this.b;

            double d10 = paramRandom.nextDouble() * this.b / 16.0D;
            double d11 = (MathHelper.sin(i * 3.141593F / this.b) + 1.0F) * d10 + 1.0D;
            double d12 = (MathHelper.sin(i * 3.141593F / this.b) + 1.0F) * d10 + 1.0D;

            int j = MathHelper.floor(d7 - d11 / 2.0D);
            int k = MathHelper.floor(d8 - d12 / 2.0D);
            int m = MathHelper.floor(d9 - d11 / 2.0D);

            int n = MathHelper.floor(d7 + d11 / 2.0D);
            int i1 = MathHelper.floor(d8 + d12 / 2.0D);
            int i2 = MathHelper.floor(d9 + d11 / 2.0D);

            for (int i3 = j; i3 <= n; i3++) {
                double d13 = (i3 + 0.5D - d7) / (d11 / 2.0D);
                if (d13 * d13 < 1.0D) {
                    for (int i4 = k; i4 <= i1; i4++) {
                        double d14 = (i4 + 0.5D - d8) / (d12 / 2.0D);
                        if (d13 * d13 + d14 * d14 < 1.0D) {
                            for (int i5 = m; i5 <= i2; i5++) {
                                double d15 = (i5 + 0.5D - d9) / (d11 / 2.0D);
                                if ((d13 * d13 + d14 * d14 + d15 * d15 < 1.0D) && (paramWorld.getTypeId(i3, i4, i5) == Block.STONE.id))
                                    paramWorld.setRawTypeId(i3, i4, i5, this.a);
                            }
                        }
                    }
                }

            }

        }

        return true;
    }
}
