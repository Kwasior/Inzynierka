package main.tsd.crypto.algoritm;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;


public class HMAC {

    public static byte[] o_key_pad = new byte[64];
    public static byte[] i_key_pad = new byte[64];
    public static byte[] result = new byte[20];
    public static final byte oneOpad = 0x5c;
    public static final byte oneIpad = 0x36;
    public static byte[] resultTmp = new byte[20];
    public static byte[] i_pad = new byte [64];
    public static byte[] o_pad = new byte [64];


    private static byte[] xor_func(byte[] a, byte[] b) throws Exception {
        byte[] out = new byte[a.length];
        for (int i = 0; i < a.length; i++) {
            out[i] = (byte) (a[i] ^ b[i]);
        }
        return out;

    }

    private static byte[] hash(byte[] in) {
        byte[] mdresult = new byte[20];
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            mdresult = md.digest(in);
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        return mdresult;
    }

    public static byte[] generate(byte[] in, byte[] key) {


        byte[] tmp = new byte[i_key_pad.length + in.length];
        byte[] tmp2 = new byte[o_key_pad.length + result.length];

        byte test = (byte) (6);
        System.out.println(String.valueOf(test));
        // key = hash(key);
        for (int i = 0; i < key.length; i++) {
            i_key_pad[i] = (byte) (key[i] ^ oneIpad);
        }
        for (int i = key.length; i < 64; i++) {
            i_key_pad[i] = oneIpad;
        }
        for (int i = 0; i < key.length; i++) {
            o_key_pad[i] = (byte) (key[i] ^ oneOpad);
        }
        for (int i = key.length; i < 64; i++) {
            o_key_pad[i] = oneOpad;
        }
        for (int i = 0; i < 64 ; i++){
            i_pad[i] = oneIpad;
            o_pad[i] = oneOpad;
        }

        System.arraycopy(i_key_pad, 0, tmp, 0, i_key_pad.length);
        System.arraycopy(in, 0, tmp, i_key_pad.length, in.length);
        resultTmp = hash(tmp);
        System.arraycopy(o_key_pad, 0, tmp2, 0, o_key_pad.length);
        System.arraycopy(resultTmp, 0, tmp2, o_key_pad.length, resultTmp.length);
        result = hash(tmp2);
        return result;
    }



}


