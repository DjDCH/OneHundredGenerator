package com.djdch.bukkit.onehundredgenerator.mc100;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.server.Block;
import net.minecraft.server.EntityChicken;
import net.minecraft.server.EntityCow;
import net.minecraft.server.EntityCreeper;
import net.minecraft.server.EntityEnderman;
import net.minecraft.server.EntityPig;
import net.minecraft.server.EntitySheep;
import net.minecraft.server.EntitySkeleton;
import net.minecraft.server.EntitySlime;
import net.minecraft.server.EntitySpider;
import net.minecraft.server.EntitySquid;
import net.minecraft.server.EntityZombie;
import net.minecraft.server.EnumCreatureType;
import net.minecraft.server.World;

public class BiomeBase extends net.minecraft.server.BiomeBase {
    public static final BiomeBase[] a = new BiomeBase[256];

    public static final BiomeBase OCEAN = new BiomeOcean(0).b(112).a("Ocean").b(-1.0F, 0.4F);
    public static final BiomeBase PLAINS = new BiomePlains(1).b(9286496).a("Plains").a(0.8F, 0.4F);
    public static final BiomeBase DESERT = new BiomeDesert(2).b(16421912).a("Desert").a(2.0F, 0.0F).b(0.1F, 0.2F);
//    public static final BiomeBase DESERT = new BiomeDesert(2).b(16421912).a("Desert").g().a(2.0F, 0.0F).b(0.1F, 0.2F);
    public static final BiomeBase EXTREME_HILLS = new BiomeBigHills(3).b(6316128).a("Extreme Hills").b(0.2F, 1.8F).a(0.2F, 0.3F);
    public static final BiomeBase FOREST = new BiomeForest(4).b(353825).a("Forest").a(5159473).a(0.7F, 0.8F);
    public static final BiomeBase TAIGA = new BiomeTaiga(5).b(747097).a("Taiga").a(5159473).a(0.3F, 0.8F).b(0.1F, 0.4F);
    public static final BiomeBase SWAMPLAND = new BiomeSwamp(6).b(522674).a("Swampland").a(9154376).b(-0.2F, 0.1F).a(0.8F, 0.9F);
    public static final BiomeBase RIVER = new BiomeRiver(7).b(255).a("River").b(-0.5F, 0.0F);
//    public static final BiomeBase HELL = new BiomeHell(8).b(16711680).a("Hell").g().a(2.0F, 0.0F);
//    public static final BiomeBase SKY = new BiomeTheEnd(9).b(8421631).a("Sky").g();
    public static final BiomeBase FROZEN_OCEAN = new BiomeOcean(10).b(9474208).a("FrozenOcean").b(-1.0F, 0.5F).a(0.0F, 0.5F);
    public static final BiomeBase FROZEN_RIVER = new BiomeRiver(11).b(10526975).a("FrozenRiver").b(-0.5F, 0.0F).a(0.0F, 0.5F);
    public static final BiomeBase ICE_PLAINS = new BiomeIcePlains(12).b(16777215).a("Ice Plains").a(0.0F, 0.5F);
    public static final BiomeBase ICE_MOUNTAINS = new BiomeIcePlains(13).b(10526880).a("Ice Mountains").b(0.2F, 1.8F).a(0.0F, 0.5F);
    public static final BiomeBase MUSHROOM_ISLAND = new BiomeMushrooms(14).b(16711935).a("MushroomIsland").a(0.9F, 1.0F).b(0.2F, 1.0F);
    public static final BiomeBase MUSHROOM_SHORE = new BiomeMushrooms(15).b(10486015).a("MushroomIslandShore").a(0.9F, 1.0F).b(-1.0F, 0.1F);

//    UNCOMMENT BELOW WHEN REFACTORING THE CODE. OTHERWISE, KEEP COMMENTED
//    public String w;
//    public int x;
//    public byte y = (byte) Block.GRASS.id;
//    public byte z = (byte) Block.DIRT.id;
//    public int A = 5169201;
//    public float B = 0.1F;
//    public float C = 0.3F;
//    public float D = 0.5F;
//    public float E = 0.5F;
//    public int F = 16777215;
//    UNCOMMENT ABOVE WHEN REFACTORING THE CODE. OTHERWISE, KEEP COMMENTED

    public BiomeDecorator G;
    @SuppressWarnings({ "unchecked", "rawtypes" })
    protected List<BiomeMeta> H = new ArrayList();
    @SuppressWarnings({ "unchecked", "rawtypes" })
    protected List<BiomeMeta> I = new ArrayList();
    @SuppressWarnings({ "unchecked", "rawtypes" })
    protected List<BiomeMeta> J = new ArrayList();

//    UNCOMMENT BELOW WHEN REFACTORING THE CODE. OTHERWISE, KEEP COMMENTED
//    private boolean P;
//    private boolean Q = true;
//    public final int K;
//    UNCOMMENT ABOVE WHEN REFACTORING THE CODE. OTHERWISE, KEEP COMMENTED

    protected WorldGenTrees L = new WorldGenTrees(false);
    protected WorldGenBigTree M = new WorldGenBigTree(false);
    protected WorldGenForest N = new WorldGenForest(false);
    protected WorldGenSwampTree O = new WorldGenSwampTree();

    protected BiomeBase(int paramInt) {
        super(paramInt);

//      this.K = paramInt;
        a[paramInt] = this;
        this.G = createBiomeDecorator();

        // Override values
        this.y = (byte) Block.GRASS.id;
        this.z = (byte) Block.DIRT.id;
        this.A = 5169201;
        this.B = 0.1F;
        this.C = 0.3F;
        this.D = 0.5F;
        this.E = 0.5F;
        this.F = 16777215;

        this.I.add(new BiomeMeta(EntitySheep.class, 12, 4, 4));
        this.I.add(new BiomeMeta(EntityPig.class, 10, 4, 4));
        this.I.add(new BiomeMeta(EntityChicken.class, 10, 4, 4));
        this.I.add(new BiomeMeta(EntityCow.class, 8, 4, 4));

        this.H.add(new BiomeMeta(EntitySpider.class, 10, 4, 4));
        this.H.add(new BiomeMeta(EntityZombie.class, 10, 4, 4));
        this.H.add(new BiomeMeta(EntitySkeleton.class, 10, 4, 4));
        this.H.add(new BiomeMeta(EntityCreeper.class, 10, 4, 4));
        this.H.add(new BiomeMeta(EntitySlime.class, 10, 4, 4));
        this.H.add(new BiomeMeta(EntityEnderman.class, 1, 1, 4));

        this.J.add(new BiomeMeta(EntitySquid.class, 10, 4, 4));
    }

    protected BiomeDecorator createBiomeDecorator() {
        return new BiomeDecorator(this);
    }

    private BiomeBase a(float paramFloat1, float paramFloat2) {
        if ((paramFloat1 > 0.1F) && (paramFloat1 < 0.2F))
            throw new IllegalArgumentException("Please avoid temperatures in the range 0.1 - 0.2 because of snow");

        this.D = paramFloat1;
        this.E = paramFloat2;
        return this;
    }

    private BiomeBase b(float paramFloat1, float paramFloat2) {
        this.B = paramFloat1;
        this.C = paramFloat2;
        return this;
    }

//  UNCOMMENT BELOW WHEN REFACTORING THE CODE. OTHERWISE, KEEP COMMENTED
//    private BiomeBase g() {
//        this.Q = false;
//        return this;
//    }
//  UNCOMMENT ABOVE WHEN REFACTORING THE CODE. OTHERWISE, KEEP COMMENTED

//    @Override
//    public WorldGenerator a(Random paramRandom) {
    public WorldGenerator aa(Random paramRandom) {
        if (paramRandom.nextInt(10) == 0) {
            return this.M;
        }
        return this.L;
    }

    protected BiomeBase a(String paramString) {
        this.w = paramString;
        return this;
    }

    protected BiomeBase a(int paramInt) {
        this.A = paramInt;
        return this;
    }

    protected BiomeBase b(int paramInt) {
        this.x = paramInt;
        return this;
    }

    @Override
    public List<BiomeMeta> getMobs(EnumCreatureType paramEnumCreatureType) {
        if (paramEnumCreatureType == EnumCreatureType.MONSTER)
            return this.H;
        if (paramEnumCreatureType == EnumCreatureType.CREATURE)
            return this.I;
        if (paramEnumCreatureType == EnumCreatureType.WATER_CREATURE)
            return this.J;
        return null;
    }

//  UNCOMMENT BELOW WHEN REFACTORING THE CODE. OTHERWISE, KEEP COMMENTED
//    public boolean b() {
//        return this.P;
//    }
//  UNCOMMENT ABOVE WHEN REFACTORING THE CODE. OTHERWISE, KEEP COMMENTED

//  UNCOMMENT BELOW WHEN REFACTORING THE CODE. OTHERWISE, KEEP COMMENTED
//    public boolean c() {
//        if (this.P)
//            return false;
//        return this.Q;
//    }
//  UNCOMMENT ABOVE WHEN REFACTORING THE CODE. OTHERWISE, KEEP COMMENTED

    @Override
    public float d() {
        return 0.1F;
    }

//  UNCOMMENT BELOW WHEN REFACTORING THE CODE. OTHERWISE, KEEP COMMENTED
//    public final int e() {
//        return (int) (this.E * 65536.0F);
//    }
//  UNCOMMENT ABOVE WHEN REFACTORING THE CODE. OTHERWISE, KEEP COMMENTED

//  UNCOMMENT BELOW WHEN REFACTORING THE CODE. OTHERWISE, KEEP COMMENTED
//    public final int f() {
//        return (int) (this.D * 65536.0F);
//    }
//  UNCOMMENT ABOVE WHEN REFACTORING THE CODE. OTHERWISE, KEEP COMMENTED

    @Override
    public void a(World paramWorld, Random paramRandom, int paramInt1, int paramInt2) {
        this.G.a(paramWorld, paramRandom, paramInt1, paramInt2);
    }
}
