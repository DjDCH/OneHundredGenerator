package com.djdch.bukkit.onehundredgenerator.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.craftbukkit.CraftWorld;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;

import com.djdch.bukkit.onehundredgenerator.configuration.WorldConfiguration;
import com.djdch.bukkit.onehundredgenerator.mc100.BiomeBase;
import com.djdch.bukkit.onehundredgenerator.mc100.NoiseGeneratorOctaves;
import com.djdch.bukkit.onehundredgenerator.mc100.WorldChunkManager;
import com.djdch.bukkit.onehundredgenerator.mc100.WorldGenLakes;

import net.minecraft.server.Block;
import net.minecraft.server.BlockSand;
import net.minecraft.server.Chunk;
import net.minecraft.server.ChunkCoordIntPair;
import net.minecraft.server.ChunkPosition;
import net.minecraft.server.EnumCreatureType;
import net.minecraft.server.IChunkProvider;
import net.minecraft.server.IProgressUpdate;
import net.minecraft.server.MathHelper;
import net.minecraft.server.SpawnerCreature;
import net.minecraft.server.World;

//UNCOMMENT BELOW WHEN REFACTORING THE CODE. OTHERWISE, KEEP COMMENTED
//import net.minecraft.server.WorldGenBase;
//import net.minecraft.server.WorldGenCanyon;
//import net.minecraft.server.WorldGenCaves;
//import net.minecraft.server.WorldGenDungeons;
//import net.minecraft.server.WorldGenMineshaft;
//import net.minecraft.server.WorldGenStronghold;
//import net.minecraft.server.WorldGenVillage;
//UNCOMMENT ABOVE WHEN REFACTORING THE CODE. OTHERWISE, KEEP COMMENTED

/**
 * 
 * @author DjDCH
 */
public class ChunkProviderGenerate extends ChunkGenerator implements IChunkProvider {
    /**
     * 
     */
    private Random k;

    /**
     * 
     */
    private NoiseGeneratorOctaves l;

    /**
     * 
     */
    private NoiseGeneratorOctaves m;

    /**
     * 
     */
    private NoiseGeneratorOctaves n;

    /**
     * 
     */
    private NoiseGeneratorOctaves o;

    /**
     * 
     */
    public NoiseGeneratorOctaves a;

    /**
     * 
     */
    public NoiseGeneratorOctaves b;

    /**
     * 
     */
    public NoiseGeneratorOctaves c;

    /**
     * 
     */
    private World p;

    /**
     * 
     */
    @SuppressWarnings("unused")
    private boolean q;

    /**
     * 
     */
    private double[] r;

    /**
     * 
     */
    private double[] s = new double[256];

//  UNCOMMENT BELOW WHEN REFACTORING THE CODE. OTHERWISE, KEEP COMMENTED
//    private WorldGenBase t = new WorldGenCaves();
//    public WorldGenStronghold u = new WorldGenStronghold();
//    public WorldGenVillage v = new WorldGenVillage(0);
//    public WorldGenMineshaft w = new WorldGenMineshaft();
//    private WorldGenBase x = new WorldGenCanyon();
//  UNCOMMENT ABOVE WHEN REFACTORING THE CODE. OTHERWISE, KEEP COMMENTED

    /**
     * 
     */
    private BiomeBase[] y;

    /**
     * 
     */
    double[] d;

    /**
     * 
     */
    double[] e;

    /**
     * 
     */
    double[] f;

    /**
     * 
     */
    double[] g;

    /**
     * 
     */
    double[] h;

    /**
     * 
     */
    float[] i;

    /**
     * 
     */
    int[][] j = new int[32][32];

    /**
     * 
     */
    protected WorldConfiguration worldSettings;

    /**
     * 
     */
    protected WorldChunkManager worldChunkManager;

    /**
     * 
     */
    protected ArrayList<BlockPopulator> populatorList;

    /**
     * 
     * @param paramWorld
     * @param paramWorldChunkManager
     * @param paramLong
     * @param paramBoolean
     */
    public void Init(World paramWorld, WorldChunkManager paramWorldChunkManager, long paramLong, boolean paramBoolean) {
        this.p = paramWorld;
        this.q = paramBoolean;
        this.worldChunkManager = paramWorldChunkManager;

        this.k = new Random(paramLong);
        this.l = new NoiseGeneratorOctaves(this.k, 16);
        this.m = new NoiseGeneratorOctaves(this.k, 16);
        this.n = new NoiseGeneratorOctaves(this.k, 8);
        this.o = new NoiseGeneratorOctaves(this.k, 4);

        this.a = new NoiseGeneratorOctaves(this.k, 10);
        this.b = new NoiseGeneratorOctaves(this.k, 16);

        this.c = new NoiseGeneratorOctaves(this.k, 8);
    }

    /**
     * 
     * @param worldSettings
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public ChunkProviderGenerate(WorldConfiguration worldSettings) {
        this.worldSettings = worldSettings;
        this.worldSettings.setChunkProvider(this);
        this.populatorList = new ArrayList();
        this.populatorList.add(new ObjectSpawner(this));
    }

//  UNCOMMENT BELOW WHEN REFACTORING THE CODE. OTHERWISE, KEEP COMMENTED
//    public ChunkProviderGenerate(World paramWorld, long paramLong, boolean paramBoolean) {
//        this.p = paramWorld;
//        this.q = paramBoolean;
//
//        this.k = new Random(paramLong);
//        this.l = new NoiseGeneratorOctaves(this.k, 16);
//        this.m = new NoiseGeneratorOctaves(this.k, 16);
//        this.n = new NoiseGeneratorOctaves(this.k, 8);
//        this.o = new NoiseGeneratorOctaves(this.k, 4);
//
//        this.a = new NoiseGeneratorOctaves(this.k, 10);
//        this.b = new NoiseGeneratorOctaves(this.k, 16);
//
//        this.c = new NoiseGeneratorOctaves(this.k, 8);
//    }
//  UNCOMMENT ABOVE WHEN REFACTORING THE CODE. OTHERWISE, KEEP COMMENTED

    /**
     * 
     * @param paramInt1
     * @param paramInt2
     * @param paramArrayOfByte
     */
    public void generateTerrain(int paramInt1, int paramInt2, byte paramArrayOfByte[]) {
        byte b1 = 4;
        int i2 = this.p.height / 8;
        int i3 = this.p.seaLevel;

        int i4 = b1 + 1;
        int i5 = this.p.height / 8 + 1;
        int i6 = b1 + 1;

        this.y = (BiomeBase[]) this.worldChunkManager.getBiomes(this.y, paramInt1 * 4 - 2, paramInt2 * 4 - 2, i4 + 5, i6 + 5);
        this.r = a(this.r, paramInt1 * b1, 0, paramInt2 * b1, i4, i5, i6);

        for (int i7 = 0; i7 < b1; i7++) {
            for (int i8 = 0; i8 < b1; i8++) {
                for (int i9 = 0; i9 < i2; i9++) {
                    double d = 0.125D;

                    double d1 = this.r[((i7 + 0) * i6 + (i8 + 0)) * i5 + (i9 + 0)];
                    double d2 = this.r[((i7 + 0) * i6 + (i8 + 1)) * i5 + (i9 + 0)];
                    double d3 = this.r[((i7 + 1) * i6 + (i8 + 0)) * i5 + (i9 + 0)];
                    double d4 = this.r[((i7 + 1) * i6 + (i8 + 1)) * i5 + (i9 + 0)];

                    double d5 = (this.r[((i7 + 0) * i6 + (i8 + 0)) * i5 + (i9 + 1)] - d1) * d;
                    double d6 = (this.r[((i7 + 0) * i6 + (i8 + 1)) * i5 + (i9 + 1)] - d2) * d;
                    double d7 = (this.r[((i7 + 1) * i6 + (i8 + 0)) * i5 + (i9 + 1)] - d3) * d;
                    double d8 = (this.r[((i7 + 1) * i6 + (i8 + 1)) * i5 + (i9 + 1)] - d4) * d;

                    for (int i10 = 0; i10 < 8; i10++) {
                        double d9 = 0.25D;

                        double d10 = d1;
                        double d11 = d2;
                        double d12 = (d3 - d1) * d9;
                        double d13 = (d4 - d2) * d9;

                        for (int i11 = 0; i11 < 4; i11++) {
                            int i12 = i11 + i7 * 4 << this.p.heightBitsPlusFour | 0 + i8 * 4 << this.p.heightBits | i9 * 8 + i10;
                            int i13 = 1 << this.p.heightBits;

                            i12 -= i13;
                            double d14 = 0.25D;
                            double d15 = d10;
                            double d16 = (d11 - d10) * d14;
                            d15 -= d16;

                            for (int i14 = 0; i14 < 4; i14++) {
                                if ((d15 += d16) > 0.0D) {
                                    paramArrayOfByte[i12 += i13] = (byte) Block.STONE.id;
                                    continue;
                                }
                                if (i9 * 8 + i10 < i3) {
                                    paramArrayOfByte[i12 += i13] = (byte) Block.STATIONARY_WATER.id;
                                } else {
                                    paramArrayOfByte[i12 += i13] = 0;
                                }
                            }

                            d10 += d12;
                            d11 += d13;
                        }

                        d1 += d5;
                        d2 += d6;
                        d3 += d7;
                        d4 += d8;
                    }
                }
            }
        }
    }

    /**
     * 
     * @param paramInt1
     * @param paramInt2
     * @param paramArrayOfByte
     * @param paramArrayOfBiomeBase
     */
    public void a(int paramInt1, int paramInt2, byte[] paramArrayOfByte, BiomeBase[] paramArrayOfBiomeBase) {
        int i1 = this.p.seaLevel;

        double d1 = 0.03125D;
        this.s = this.o.a(this.s, paramInt1 * 16, paramInt2 * 16, 0, 16, 16, 1, d1 * 2.0D, d1 * 2.0D, d1 * 2.0D);

        float[] arrayOfFloat = this.worldChunkManager.a(paramInt1 * 16, paramInt2 * 16, 16, 16);

        for (int i2 = 0; i2 < 16; i2++) {
            for (int i3 = 0; i3 < 16; i3++) {
                float f1 = arrayOfFloat[(i3 + i2 * 16)];

                BiomeBase localBiomeBase = paramArrayOfBiomeBase[(i3 + i2 * 16)];
                int i4 = (int) (this.s[(i2 + i3 * 16)] / 3.0D + 3.0D + this.k.nextDouble() * 0.25D);

                int i5 = -1;

                int i6 = localBiomeBase.y;
                int i7 = localBiomeBase.z;

                for (int i8 = this.p.heightMinusOne; i8 >= 0; i8--) {
                    int i9 = (i3 * 16 + i2) * this.p.height + i8;

                    if (i8 <= 0 + this.k.nextInt(5)) {
                        paramArrayOfByte[i9] = (byte) Block.BEDROCK.id;
                    } else {
                        int i10 = paramArrayOfByte[i9];

                        if (i10 == 0) {
                            i5 = -1;
                        } else if (i10 == Block.STONE.id) {
                            if (i5 == -1) {
                                if (i4 <= 0) {
                                    i6 = 0;
                                    i7 = (byte) Block.STONE.id;
                                } else if ((i8 >= i1 - 4) && (i8 <= i1 + 1)) {
                                    i6 = localBiomeBase.y;
                                    i7 = localBiomeBase.z;
                                }

                                if ((i8 < i1) && (i6 == 0)) {
                                    if (f1 < 0.15F)
                                        i6 = (byte) Block.ICE.id;
                                    else {
                                        i6 = (byte) Block.STATIONARY_WATER.id;
                                    }

                                }

                                i5 = i4;
                                if (i8 >= i1 - 1)
                                    paramArrayOfByte[i9] = (byte) i6;
                                else
                                    paramArrayOfByte[i9] = (byte) i7;
                            } else if (i5 > 0) {
                                i5--;
                                paramArrayOfByte[i9] = (byte) i7;

                                if ((i5 == 0) && (i7 == Block.SAND.id)) {
                                    i5 = this.k.nextInt(4);
                                    i7 = (byte) Block.SANDSTONE.id;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * 
     * @param paramArrayOfDouble
     * @param paramInt1
     * @param paramInt2
     * @param paramInt3
     * @param paramInt4
     * @param paramInt5
     * @param paramInt6
     * @return
     */
    private double[] a(double[] paramArrayOfDouble, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
        if (paramArrayOfDouble == null) {
            paramArrayOfDouble = new double[paramInt4 * paramInt5 * paramInt6];
        }
        if (this.i == null) {
            this.i = new float[25];
            for (int i1 = -2; i1 <= 2; i1++) {
                for (int i2 = -2; i2 <= 2; i2++) {
                    float f1 = 10.0F / MathHelper.c(i1 * i1 + i2 * i2 + 0.2F);
                    this.i[(i1 + 2 + (i2 + 2) * 5)] = f1;
                }
            }
        }

        double d1 = 684.41200000000003D;
        double d2 = 684.41200000000003D;

        this.g = this.a.a(this.g, paramInt1, paramInt3, paramInt4, paramInt6, 1.121D, 1.121D, 0.5D);
        this.h = this.b.a(this.h, paramInt1, paramInt3, paramInt4, paramInt6, 200.0D, 200.0D, 0.5D);

        this.d = this.n.a(this.d, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, d1 / 80.0D, d2 / 160.0D, d1 / 80.0D);
        this.e = this.l.a(this.e, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, d1, d2, d1);
        this.f = this.m.a(this.f, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, d1, d2, d1);
        paramInt1 = paramInt3 = 0;

        int i3 = 0;
        int i4 = 0;

        for (int i5 = 0; i5 < paramInt4; i5++) {
            for (int i6 = 0; i6 < paramInt6; i6++) {
                float f2 = 0.0F;
                float f3 = 0.0F;
                float f4 = 0.0F;

                int i7 = 2;

                BiomeBase localBiomeBase1 = this.y[(i5 + 2 + (i6 + 2) * (paramInt4 + 5))];
                for (int i8 = -i7; i8 <= i7; i8++) {
                    for (int i9 = -i7; i9 <= i7; i9++) {
                        BiomeBase localBiomeBase2 = this.y[(i5 + i8 + 2 + (i6 + i9 + 2) * (paramInt4 + 5))];
                        float f5 = this.i[(i8 + 2 + (i9 + 2) * 5)] / (localBiomeBase2.B + 2.0F);
                        if (localBiomeBase2.B > localBiomeBase1.B) {
                            f5 /= 2.0F;
                        }
                        f2 += localBiomeBase2.C * f5;
                        f3 += localBiomeBase2.B * f5;
                        f4 += f5;
                    }
                }
                f2 /= f4;
                f3 /= f4;

                f2 = f2 * 0.9F + 0.1F;
                f3 = (f3 * 4.0F - 1.0F) / 8.0F;

                double d3 = this.h[i4] / 8000.0D;
                if (d3 < 0.0D)
                    d3 = -d3 * 0.3D;
                d3 = d3 * 3.0D - 2.0D;

                if (d3 < 0.0D) {
                    d3 /= 2.0D;
                    if (d3 < -1.0D)
                        d3 = -1.0D;
                    d3 /= 1.4D;
                    d3 /= 2.0D;
                } else {
                    if (d3 > 1.0D)
                        d3 = 1.0D;
                    d3 /= 8.0D;
                }

                i4++;

                for (int i10 = 0; i10 < paramInt5; i10++) {
                    double d4 = f3;
                    double d5 = f2;

                    d4 += d3 * 0.2D;
                    d4 = d4 * paramInt5 / 16.0D;

                    double d6 = paramInt5 / 2.0D + d4 * 4.0D;

                    double d7 = 0.0D;

                    double d8 = (i10 - d6) * 12.0D * 128.0D / this.p.height / d5;

                    if (d8 < 0.0D)
                        d8 *= 4.0D;

                    double d9 = this.e[i3] / 512.0D;
                    double d10 = this.f[i3] / 512.0D;

                    double d11 = (this.d[i3] / 10.0D + 1.0D) / 2.0D;
                    if (d11 < 0.0D)
                        d7 = d9;
                    else if (d11 > 1.0D)
                        d7 = d10;
                    else
                        d7 = d9 + (d10 - d9) * d11;
                    d7 -= d8;

                    if (i10 > paramInt5 - 4) {
                        double d12 = (i10 - (paramInt5 - 4)) / 3.0F;
                        d7 = d7 * (1.0D - d12) + -10.0D * d12;
                    }

                    paramArrayOfDouble[i3] = d7;
                    i3++;
                }
            }
        }

        return paramArrayOfDouble;
    }

    /**
     * 
     * @param paramInt1
     * @param paramInt2
     * @return
     */
    @Override
    public boolean isChunkLoaded(int paramInt1, int paramInt2) {
        return true;
    }

    /**
     * 
     * @param paramInt1
     * @param paramInt2
     * @return
     */
    @Override
    public Chunk getOrCreateChunk(int paramInt1, int paramInt2) {
        this.k.setSeed(paramInt1 * 341873128712L + paramInt2 * 132897987541L);

        byte[] arrayOfByte = new byte[16 * this.p.height * 16];
        Chunk localChunk = new Chunk(this.p, arrayOfByte, paramInt1, paramInt2);

        generateTerrain(paramInt1, paramInt2, arrayOfByte);
        this.y = (BiomeBase[]) this.worldChunkManager.getBiomeBlock(this.y, paramInt1 * 16, paramInt2 * 16, 16, 16);
        a(paramInt1, paramInt2, arrayOfByte, this.y);

//      UNCOMMENT BELOW WHEN REFACTORING THE CODE. OTHERWISE, KEEP COMMENTED
//        this.t.a(this, this.p, paramInt1, paramInt2, arrayOfByte);
//        this.x.a(this, this.p, paramInt1, paramInt2, arrayOfByte);
//        if (this.q) {
//            this.w.a(this, this.p, paramInt1, paramInt2, arrayOfByte);
//            this.v.a(this, this.p, paramInt1, paramInt2, arrayOfByte);
//            this.u.a(this, this.p, paramInt1, paramInt2, arrayOfByte);
//        }
//      UNCOMMENT ABOVE WHEN REFACTORING THE CODE. OTHERWISE, KEEP COMMENTED

        localChunk.initLighting();

        return localChunk;
    }

    /**
     * 
     * @param paramInt1
     * @param paramInt2
     * @return
     */
    @Override
    public Chunk getChunkAt(int paramInt1, int paramInt2) {
        return getOrCreateChunk(paramInt1, paramInt2);
    }

    /**
     * 
     * @param paramIChunkProvider
     * @param paramInt1
     * @param paramInt2
     * @return
     */
    @Override
    public void getChunkAt(IChunkProvider paramIChunkProvider, int paramInt1, int paramInt2) {
        BlockSand.instaFall = true;
        int i1 = paramInt1 * 16;
        int i2 = paramInt2 * 16;

        BiomeBase localBiomeBase = (BiomeBase) this.worldChunkManager.getBiome(i1 + 16, i2 + 16);

        this.k.setSeed(this.p.getSeed());
        long l1 = this.k.nextLong() / 2L * 2L + 1L;
        long l2 = this.k.nextLong() / 2L * 2L + 1L;
        this.k.setSeed(paramInt1 * l1 + paramInt2 * l2 ^ this.p.getSeed());

        boolean bool = false;

//      UNCOMMENT BELOW WHEN REFACTORING THE CODE. OTHERWISE, KEEP COMMENTED
//        if (this.q) {
//            this.w.a(this.p, this.k, paramInt1, paramInt2);
//            bool = this.v.a(this.p, this.k, paramInt1, paramInt2);
//            this.u.a(this.p, this.k, paramInt1, paramInt2);
//        }
//      UNCOMMENT ABOVE WHEN REFACTORING THE CODE. OTHERWISE, KEEP COMMENTED
        int i4;
        int i5;
        int i3;
        if ((!bool) && (this.k.nextInt(4) == 0)) {
            i3 = i1 + this.k.nextInt(16) + 8;
            i4 = this.k.nextInt(this.p.height);
            i5 = i2 + this.k.nextInt(16) + 8;
            new WorldGenLakes(Block.STATIONARY_WATER.id, this.worldChunkManager).a(this.p, this.k, i3, i4, i5);
        }

        if ((!bool) && (this.k.nextInt(8) == 0)) {
            i3 = i1 + this.k.nextInt(16) + 8;
            i4 = this.k.nextInt(this.k.nextInt(this.p.height - 8) + 8);
            i5 = i2 + this.k.nextInt(16) + 8;
            if ((i4 < this.p.seaLevel) || (this.k.nextInt(10) == 0))
                new WorldGenLakes(Block.STATIONARY_LAVA.id, this.worldChunkManager).a(this.p, this.k, i3, i4, i5);
        }

//      UNCOMMENT BELOW WHEN REFACTORING THE CODE. OTHERWISE, KEEP COMMENTED
//        for (i3 = 0; i3 < 8; i3++) {
//            i4 = i1 + this.k.nextInt(16) + 8;
//            i5 = this.k.nextInt(this.p.height);
//            int i6 = i2 + this.k.nextInt(16) + 8;
//            if (!new WorldGenDungeons().a(this.p, this.k, i4, i5, i6)) {
//                continue;
//            }
//        }
//      UNCOMMENT ABOVE WHEN REFACTORING THE CODE. OTHERWISE, KEEP COMMENTED
        localBiomeBase.a(this.p, this.k, i1, i2);

        SpawnerCreature.a(this.p, localBiomeBase, i1 + 8, i2 + 8, 16, 16, this.k);

        i1 += 8;
        i2 += 8;
        for (i3 = 0; i3 < 16; i3++) {
            for (i4 = 0; i4 < 16; i4++) {
                i5 = this.p.e(i1 + i3, i2 + i4);

                if (this.p.p(i3 + i1, i5 - 1, i4 + i2)) {
                    this.p.setTypeId(i3 + i1, i5 - 1, i4 + i2, Block.ICE.id);
                }
                if (this.p.r(i3 + i1, i5, i4 + i2)) {
                    this.p.setTypeId(i3 + i1, i5, i4 + i2, Block.SNOW.id);
                }
            }

        }

        BlockSand.instaFall = false;
    }

    /**
     * 
     * @param paramBoolean
     * @param paramIProgressUpdate
     * @return
     */
    @Override
    public boolean saveChunks(boolean paramBoolean, IProgressUpdate paramIProgressUpdate) {
        return true;
    }

    /**
     * 
     * @return
     */
    @Override
    public boolean unloadChunks() {
        return false;
    }

    /**
     * 
     * @return
     */
    @Override
    public boolean canSave() {
        return true;
    }

    /**
     * 
     * @param
     * @param
     * @param
     * @param
     * @return
     */
    @Override
    @SuppressWarnings("rawtypes")
    public List getMobsFor(EnumCreatureType paramEnumCreatureType, int paramInt1, int paramInt2, int paramInt3) {
        WorldChunkManager localWorldChunkManager = (WorldChunkManager) this.worldChunkManager;
        if (localWorldChunkManager == null) {
            return null;
        }

        BiomeBase localBiomeBase = localWorldChunkManager.getBiome(new ChunkCoordIntPair(paramInt1 >> 4, paramInt3 >> 4));
        if (localBiomeBase == null) {
            return null;
        }

        return localBiomeBase.getMobs(paramEnumCreatureType);
    }

    /**
     * 
     * @param
     * @param
     * @param
     * @param
     * @param
     * @return
     */
    @Override
    public ChunkPosition findNearestMapFeature(World paramWorld, String paramString, int paramInt1, int paramInt2, int paramInt3) {
//      UNCOMMENT BELOW WHEN REFACTORING THE CODE. OTHERWISE, KEEP COMMENTED
//        if (("Stronghold".equals(paramString)) && (this.u != null)) {
//            return this.u.getNearestGeneratedFeature(paramWorld, paramInt1, paramInt2, paramInt3);
//        }
//      UNCOMMENT ABOVE WHEN REFACTORING THE CODE. OTHERWISE, KEEP COMMENTED
        return null;
    }

    /**
     * 
     * @param
     * @param
     * @param
     * @param
     * @return
     */
    @Override
    public byte[] generate(org.bukkit.World paramWorld, Random paramRandom, int paramInt1, int paramInt2) {
        return getOrCreateChunk(paramInt1, paramInt2).b;
    }

    /**
     * 
     * @param
     * @param
     * @param
     * @return
     */
    @Override
    public boolean canSpawn(org.bukkit.World world, int x, int z) {
        this.worldSettings.getPlugin().WorldInit(world);

        int i = ((CraftWorld) world).getHandle().a(x, z);
        return (i != 0) && (Block.byId[i].material.isSolid());
    }

    /**
     * 
     * @param
     * @return
     */
    @Override
    public List<BlockPopulator> getDefaultPopulators(org.bukkit.World world) {
        return this.populatorList;
    }
}
