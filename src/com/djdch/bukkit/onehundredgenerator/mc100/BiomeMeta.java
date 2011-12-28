package com.djdch.bukkit.onehundredgenerator.mc100;

import net.minecraft.server.WeightedRandomChoice;

public class BiomeMeta extends WeightedRandomChoice {
    @SuppressWarnings("rawtypes")
    public Class a;
    public int b;
    public int c;

    @SuppressWarnings("rawtypes")
    public BiomeMeta(Class paramClass, int paramInt1, int paramInt2, int paramInt3) {
        super(paramInt1);
        this.a = paramClass;
        this.b = paramInt2;
        this.c = paramInt3;
    }
}
