package com.mudryk.simplejooq.businesslayer.businesscomponents.convertors;

/**
 * @author Volodymyr
 *         Date: 18.11.2016.
 */
public final class Boolean2ByteConverter {

    public static boolean byte2bool(byte byteRepresentation) {
        return byteRepresentation == 1;
    }

    public static byte bool2byte(boolean booleanRepresentation) {
        return (byte) (booleanRepresentation ? 1 : 0);
    }
}
