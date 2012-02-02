package com.djdch.bukkit.onehundredgenerator.mc100;

import net.minecraft.server.Block;

public class BiomeDesert extends BiomeBase {
    public BiomeDesert(int paramInt) {
        super(paramInt);

        this.I.clear();
        this.y = (byte) Block.SAND.id;
        this.z = (byte) Block.SAND.id;

        this.G.z = -999;
        this.G.C = 2;
        this.G.E = 50;
        this.G.F = 10;
    }
}
