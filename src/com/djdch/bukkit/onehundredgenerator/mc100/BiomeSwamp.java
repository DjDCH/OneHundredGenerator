package com.djdch.bukkit.onehundredgenerator.mc100;

import java.util.Random;

public class BiomeSwamp extends BiomeBase {
    protected BiomeSwamp(int paramInt) {
        super(paramInt);
        this.G.z = 2;
        this.G.A = -999;
        this.G.C = 1;
        this.G.D = 8;
        this.G.E = 10;
        this.G.I = 1;
        this.G.y = 4;

        this.F = 14745456;
    }

    public WorldGenerator aa(Random paramRandom) {
        return this.O;
    }
}
