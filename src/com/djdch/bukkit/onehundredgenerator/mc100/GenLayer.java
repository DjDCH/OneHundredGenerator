package com.djdch.bukkit.onehundredgenerator.mc100;

public abstract class GenLayer extends net.minecraft.server.GenLayer {
    private long b;
    protected net.minecraft.server.GenLayer a;
    private long c;
    private long d;

    public static net.minecraft.server.GenLayer[] a(long paramLong) {
        Object localObject1 = new LayerIsland(1L);
        localObject1 = new GenLayerZoomFuzzy(2000L, (GenLayer) localObject1);
        localObject1 = new GenLayerIsland(1L, (GenLayer) localObject1);
        localObject1 = new GenLayerZoom2(2001L, (GenLayer) localObject1);
        localObject1 = new GenLayerIsland(2L, (GenLayer) localObject1);
        localObject1 = new GenLayerIcePlains(2L, (GenLayer) localObject1);
        localObject1 = new GenLayerZoom2(2002L, (GenLayer) localObject1);
        localObject1 = new GenLayerIsland(3L, (GenLayer) localObject1);
        localObject1 = new GenLayerZoom2(2003L, (GenLayer) localObject1);
        localObject1 = new GenLayerIsland(4L, (GenLayer) localObject1);
        localObject1 = new GenLayerMushroomIsland(5L, (GenLayer) localObject1);

        int i = 4;

        Object localObject2 = localObject1;
        localObject2 = GenLayerZoom2.a(1000L, (GenLayer) localObject2, 0);
        localObject2 = new GenLayerRiverInit(100L, (GenLayer) localObject2);
        localObject2 = GenLayerZoom2.a(1000L, (GenLayer) localObject2, i + 2);
        localObject2 = new GenLayerRiver(1L, (GenLayer) localObject2);
        localObject2 = new GenLayerSmooth(1000L, (GenLayer) localObject2);

        Object localObject3 = localObject1;
        localObject3 = GenLayerZoom2.a(1000L, (GenLayer) localObject3, 0);
        localObject3 = new GenLayerBiome(200L, (GenLayer) localObject3);
        localObject3 = GenLayerZoom2.a(1000L, (GenLayer) localObject3, 2);

        Object localObject4 = new GenLayerTemperature((GenLayer) localObject3);
        Object localObject5 = new GenLayerDownfall((GenLayer) localObject3);

        for (int j = 0; j < i; j++) {
            localObject3 = new GenLayerZoom2(1000 + j, (GenLayer) localObject3);
            if (j == 0)
                localObject3 = new GenLayerIsland(3L, (GenLayer) localObject3);

            if (j == 0) {
                localObject3 = new GenLayerMushroomShore(1000L, (GenLayer) localObject3);
            }
            localObject4 = new GenLayerSmoothZoom(1000 + j, (net.minecraft.server.GenLayer) localObject4);
            localObject4 = new GenLayerTemperatureMix2((GenLayer) localObject4, (GenLayer) localObject3, j);
            localObject5 = new GenLayerSmoothZoom(1000 + j, (net.minecraft.server.GenLayer) localObject5);
            localObject5 = new GenLayerDownfallMix((GenLayer) localObject5, (GenLayer) localObject3, j);
        }

        localObject3 = new GenLayerSmooth(1000L, (GenLayer) localObject3);

        localObject3 = new GenLayerRiverMix(100L, (GenLayer) localObject3, (GenLayer) localObject2);

        Object localObject6 = localObject3;

        localObject4 = GenLayerSmoothZoom.a(1000L, (net.minecraft.server.GenLayer) localObject4, 2);
        localObject5 = GenLayerSmoothZoom.a(1000L, (net.minecraft.server.GenLayer) localObject5, 2);

        GenLayerZoomVoronoi localGenLayerZoomVoronoi = new GenLayerZoomVoronoi(10L, (net.minecraft.server.GenLayer) localObject3);

        ((net.minecraft.server.GenLayer) localObject3).b(paramLong);
        ((net.minecraft.server.GenLayer) localObject4).b(paramLong);
        ((net.minecraft.server.GenLayer) localObject5).b(paramLong);

        localGenLayerZoomVoronoi.b(paramLong);

        return (new net.minecraft.server.GenLayer[] { (net.minecraft.server.GenLayer) localObject3, localGenLayerZoomVoronoi, (net.minecraft.server.GenLayer) localObject4, (net.minecraft.server.GenLayer) localObject5, (net.minecraft.server.GenLayer) localObject6 });
    }

    public GenLayer(long paramLong) {
        super(paramLong);

        this.d = paramLong;
        this.d *= (this.d * 6364136223846793005L + 1442695040888963407L);
        this.d += paramLong;
        this.d *= (this.d * 6364136223846793005L + 1442695040888963407L);
        this.d += paramLong;
        this.d *= (this.d * 6364136223846793005L + 1442695040888963407L);
        this.d += paramLong;
    }

    public void b(long paramLong) {
        this.b = paramLong;
        if (this.a != null)
            this.a.b(paramLong);
        this.b *= (this.b * 6364136223846793005L + 1442695040888963407L);
        this.b += this.d;
        this.b *= (this.b * 6364136223846793005L + 1442695040888963407L);
        this.b += this.d;
        this.b *= (this.b * 6364136223846793005L + 1442695040888963407L);
        this.b += this.d;
    }

    public void a(long paramLong1, long paramLong2) {
        this.c = this.b;
        this.c *= (this.c * 6364136223846793005L + 1442695040888963407L);
        this.c += paramLong1;
        this.c *= (this.c * 6364136223846793005L + 1442695040888963407L);
        this.c += paramLong2;
        this.c *= (this.c * 6364136223846793005L + 1442695040888963407L);
        this.c += paramLong1;
        this.c *= (this.c * 6364136223846793005L + 1442695040888963407L);
        this.c += paramLong2;
    }

    protected int a(int paramInt) {
        int i = (int) ((this.c >> 24) % paramInt);
        if (i < 0)
            i += paramInt;
        this.c *= (this.c * 6364136223846793005L + 1442695040888963407L);
        this.c += this.b;
        return i;
    }
}
