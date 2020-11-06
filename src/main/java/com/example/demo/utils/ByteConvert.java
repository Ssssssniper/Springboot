package com.example.demo.utils;

public class ByteConvert {
    public static byte[] intToBytes(int n) {
        byte[] b = new byte[4];
        b[0] = (byte) (n & 0xff);
        b[1] = (byte) (n >> 8 & 0xff);
        b[2] = (byte) (n >> 16 & 0xff);
        b[3] = (byte) (n >> 24 & 0xff);
        return b;
    }
    public static void intToBytes(int n, byte[] array, int offset) {
        array[0 + offset] = (byte) (n & 0xff);
        array[1 + offset] = (byte) (n >> 8 & 0xff);
        array[2 + offset] = (byte) (n >> 16 & 0xff);
        array[3 +offset] = (byte) (n >> 24 & 0xff);
    }
    public static int bytesToInt(byte b[]) {
        return b[0] & 0xff | (b[1] & 0xff) << 8 | (b[2] & 0xff) << 16
                | (b[3] & 0xff) << 24;
    }
    public static int bytesToInt(byte b[], int offset) {
        return b[offset + 0] & 0xff | (b[offset + 1] & 0xff) << 8
                | (b[offset + 2] & 0xff) << 16 | (b[offset + 3] & 0xff) << 24;
    }

    public static byte[] longToBytes(long n) {
        byte[] b = new byte[8];
        b[0] = (byte) (n & 0xff);
        b[1] = (byte) (n >> 8 & 0xff);
        b[2] = (byte) (n >> 16 & 0xff);
        b[3] = (byte) (n >> 24 & 0xff);
        b[4] = (byte) (n >> 32 & 0xff);
        b[5] = (byte) (n >> 40 & 0xff);
        b[6] = (byte) (n >> 48 & 0xff);
        b[7] = (byte) (n >> 56 & 0xff);
        return b;
    }
    public static void longToBytes(long n, byte[] array, int offset) {
        array[0 + offset] = (byte) (n & 0xff);
        array[1 + offset] = (byte) (n >> 8 & 0xff);
        array[2 + offset] = (byte) (n >> 16 & 0xff);
        array[3 + offset] = (byte) (n >> 24 & 0xff);
        array[4 + offset] = (byte) (n >> 32 & 0xff);
        array[5 + offset] = (byte) (n >> 40 & 0xff);
        array[6 + offset] = (byte) (n >> 48 & 0xff);
        array[7 + offset] = (byte) (n >> 56 & 0xff);
    }
    public static long bytesToLong(byte[] array) {
        return ((((long) array[7] & 0xff) << 56)
                | (((long) array[6] & 0xff) << 48)
                | (((long) array[5] & 0xff) << 40)
                | (((long) array[4] & 0xff) << 32)
                | (((long) array[3] & 0xff) << 24)
                | (((long) array[2] & 0xff) << 16)
                | (((long) array[1] & 0xff) << 8) | (((long) array[0] & 0xff) << 0));
    }
    public static long bytesToLong(byte[] array, int offset) {
        return ((((long) array[offset + 7] & 0xff) << 56)
                | (((long) array[offset + 6] & 0xff) << 48)
                | (((long) array[offset + 5] & 0xff) << 40)
                | (((long) array[offset + 4] & 0xff) << 32)
                | (((long) array[offset + 3] & 0xff) << 24)
                | (((long) array[offset + 2] & 0xff) << 16)
                | (((long) array[offset + 1] & 0xff) << 8) | (((long) array[offset + 0] & 0xff) << 0));
    }

    public static byte[] floatToBytes(float x) {
        byte[] b = new byte[4];
        int l = Float.floatToIntBits(x);
        for (int i = 0; i < 4; i++) {
            b[i] = new Integer(l).byteValue();
            l = l >> 8;
        }
        return b;
    }
    /**
     * 通过byte数组取得float
     *
     * @param b
     * @param index
     * @return
     */
    public static float bytesToFloat(byte[] b, int index) {
        int l;
        l = b[index + 0];
        l &= 0xff;
        l |= ((long) b[index + 1] << 8);
        l &= 0xffff;
        l |= ((long) b[index + 2] << 16);
        l &= 0xffffff;
        l |= ((long) b[index + 3] << 24);
        return Float.intBitsToFloat(l);
    }
}
