package com.djdch.bukkit.onehundredgenerator.mc100;

/* Working version of GenLayerZoom class. */
public class GenLayerZoom extends GenLayer {
    public GenLayerZoom(long paramLong, GenLayer paramGenLayer) {
        super(paramLong);
        this.a = paramGenLayer;
    }

    @Override
    public int[] a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        int i = paramInt1 >> 1;
        int j = paramInt2 >> 1;
        int k = (paramInt3 >> 1) + 3;
        int l = (paramInt4 >> 1) + 3;

        int[] arrayOfInt1 = this.a.a(i, j, k, l);
        int[] arrayOfInt2 = IntCache.a(k * 2 * (l * 2));

        int m = k << 1;

        for (int i1 = 0; i1 < l - 1; i1++) {
            int i2 = i1 << 1;
            int i3 = i2 * m;
            int i4 = arrayOfInt1[0 + (i1 + 0) * k];
            int i5 = arrayOfInt1[0 + (i1 + 1) * k];

            for (int i6 = 0; i6 < k - 1; i6++) {
                a(i6 + i << 1, i1 + j << 1);

                int i7 = arrayOfInt1[i6 + 1 + (i1 + 0) * k];
                int i8 = arrayOfInt1[i6 + 1 + (i1 + 1) * k];

                arrayOfInt2[i3] = i4;
                arrayOfInt2[i3++ + m] = b(i4, i5);
                arrayOfInt2[i3] = b(i4, i7);
                arrayOfInt2[i3++ + m] = c(i4, i7, i5, i8);

                i4 = i7;
                i5 = i8;
            }
        }

        int[] arrayOfInt3 = IntCache.a(paramInt3 * paramInt4);
        for (int l2 = 0; l2 < paramInt4; l2++) {
            System.arraycopy(arrayOfInt2, (l2 + (paramInt2 & 1)) * (k << 1) + (paramInt1 & 1), arrayOfInt3, l2 * paramInt3, paramInt3);
        }

        return arrayOfInt3;
    }

    protected int b(int paramInt1, int paramInt2) {
        return a(2) != 0 ? paramInt2 : paramInt1;
    }

    protected int c(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        if (paramInt2 == paramInt3 && paramInt3 == paramInt4) {
            return paramInt2;
        }
        if (paramInt1 == paramInt2 && paramInt1 == paramInt3) {
            return paramInt1;
        }
        if (paramInt1 == paramInt2 && paramInt1 == paramInt4) {
            return paramInt1;
        }
        if (paramInt1 == paramInt3 && paramInt1 == paramInt4) {
            return paramInt1;
        }

        if (paramInt1 == paramInt2 && paramInt3 != paramInt4) {
            return paramInt1;
        }
        if (paramInt1 == paramInt3 && paramInt2 != paramInt4) {
            return paramInt1;
        }
        if (paramInt1 == paramInt4 && paramInt2 != paramInt3) {
            return paramInt1;
        }

        if (paramInt2 == paramInt1 && paramInt3 != paramInt4) {
            return paramInt2;
        }
        if (paramInt2 == paramInt3 && paramInt1 != paramInt4) {
            return paramInt2;
        }
        if (paramInt2 == paramInt4 && paramInt1 != paramInt3) {
            return paramInt2;
        }

        if (paramInt3 == paramInt1 && paramInt2 != paramInt4) {
            return paramInt3;
        }
        if (paramInt3 == paramInt2 && paramInt1 != paramInt4) {
            return paramInt3;
        }
        if (paramInt3 == paramInt4 && paramInt1 != paramInt2) {
            return paramInt3;
        }

        if (paramInt4 == paramInt1 && paramInt2 != paramInt3) {
            return paramInt3;
        }
        if (paramInt4 == paramInt2 && paramInt1 != paramInt3) {
            return paramInt3;
        }
        if (paramInt4 == paramInt3 && paramInt1 != paramInt2) {
            return paramInt3;
        }

        int i = a(4);
        if (i == 0) {
            return paramInt1;
        }
        if (i == 1) {
            return paramInt2;
        }
        if (i == 2) {
            return paramInt3;
        } else {
            return paramInt4;
        }
    }

    public static GenLayer a(long paramLong, GenLayer paramGenLayer, int paramInt) {
        Object localObject = paramGenLayer;
        for (int i = 0; i < paramInt; i++) {
            localObject = new GenLayerZoom(paramLong + (long) i, ((GenLayer) (localObject)));
        }

        return ((GenLayer) (localObject));
    }
}
