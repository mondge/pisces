package com.pisces._20160716_20160729.socket;

/**
 * Created by jun.xu on 16/7/27.
 */
public class Transfer {

    private static byte byteVal = 101;

    private static short shortVal = 10001;

    private static int intVal = 100000001;

    private static long longVal = 100000000000l;

    private final static int BSIZE = Byte.SIZE;

    private final static int SSIZE = Short.SIZE;

    private final static int ISIZE = Integer.SIZE;

    private final static int LSIZE = Long.SIZE;

    private final static int BYTEMASK = 0xFF;

    public static String byteToBit(byte b) {
        return "" + (byte) ((b >> 7) & 0x1) +
                (byte) ((b >> 6) & 0x1) +
                (byte) ((b >> 5) & 0x1) +
                (byte) ((b >> 4) & 0x1) +
                (byte) ((b >> 3) & 0x1) +
                (byte) ((b >> 2) & 0x1) +
                (byte) ((b >> 1) & 0x1) +
                (byte) ((b >> 0) & 0x1);
    }

    public static String longToBit(long b) {
        StringBuilder result = new StringBuilder();
        for (int i = 63; i >= 0; i--) {
            result.append((byte) ((b >> i) & 0x1));
        }
        return result.toString();
    }

    public static String byteArrayToDecimalString(byte[] bArray) {
        StringBuilder rtn = new StringBuilder();
        for (byte b : bArray) {
            rtn.append(byteToBit(b)).append(" ");
        }
        return rtn.toString();
    }

    public static int encodeIntBigEdian(byte[] dst, long val, int offset, int size) {
        for (int i = 0; i < size; i++) {
            int move = (size - i - 1) * Byte.SIZE;
            byte moveByte = (byte) (val >> move);
            System.out.println(longToBit(val) + "|" + move + "|" + byteToBit(moveByte));
            dst[offset++] = moveByte;
            System.out.println(byteArrayToDecimalString(dst));
        }
        return offset;
    }

    public static long decodeIntBigEdian(byte[] val, int offset, int size) {
        long rtn = 0;
        for (int i = 0; i < size; i++) {
            rtn = (rtn << Byte.SIZE) | ((long) val[offset + i] & BYTEMASK);
        }
        return rtn;
    }

    public static void main(String[] args) {
        byte[] message = new byte[BSIZE + SSIZE + ISIZE + LSIZE];
        System.out.println(byteToBit(byteVal));
        int offset = encodeIntBigEdian(message, byteVal, 0, BSIZE);
//        offset=encodeIntBigEdian(message,shortVal,offset,SSIZE);
//        offset=encodeIntBigEdian(message,intVal,offset,ISIZE);
//        encodeIntBigEdian(message,longVal,offset,LSIZE);
//
//        long value=decodeIntBigEdian(message,BSIZE,SSIZE);
//        value=decodeIntBigEdian(message,BSIZE+SSIZE+ISIZE,LSIZE);


    }


}
