package com.djdch.bukkit.onehundredgenerator.mc100;

import net.minecraft.server.BiomeBase;

public class BiomeCacheBlock {
    public float[] a = new float[256];
    public float[] b = new float[256];
    public BiomeBase[] c = new BiomeBase[256];
    public int d;
    public int e;
    public long f;

    public BiomeCacheBlock(BiomeCache paramBiomeCache, int paramInt1, int paramInt2) {
        this.d = paramInt1;
        this.e = paramInt2;
        BiomeCache.a(paramBiomeCache).getTemperatures(this.a, paramInt1 << 4, paramInt2 << 4, 16, 16);
        BiomeCache.a(paramBiomeCache).getWetness(this.b, paramInt1 << 4, paramInt2 << 4, 16, 16);
        BiomeCache.a(paramBiomeCache).a(this.c, paramInt1 << 4, paramInt2 << 4, 16, 16, false);
    }

    public BiomeBase a(int paramInt1, int paramInt2) {
        return this.c[(paramInt1 & 0xF | (paramInt2 & 0xF) << 4)];
    }

    public float b(int paramInt1, int paramInt2) {
        return this.a[(paramInt1 & 0xF | (paramInt2 & 0xF) << 4)];
    }
}
