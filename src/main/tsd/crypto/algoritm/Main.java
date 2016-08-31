
package main.tsd.crypto.algoritm;


import java.io.UTFDataFormatException;
import java.nio.charset.Charset;


public class Main {

    private static final Charset UTF8_CHARSET = Charset.forName("UTF-8");


    public static void main(String[] args) {
// kryptografia stosowana Menezes 
// kryptografia teoria i praktyka zabezpieczenia systemow komputerowych - Kuty�owski
// bez ograniczen długosc DONE
// TODO wygląd
// deterministyczne uzupelnienie CHYBA DONE
// musimy wiedziec gdzie zayczna sie wypelnienie DONE
// jak równo to wypelnienie DONE
// pozostale tryby
// warianty AES DOJE
// HAMAC
// TODO DOROB WYSWIETLANIE HMACA !
        try {
            String text = "11111111111111111";
            final String iv = "1111111111111111";
            String iv2 = "0000000000000000";
            //AES
            String k = "1111111111111111";
            int ivInt = 1;
            String counter = "0";
            //klucz jest 16-19 to dziala chuj wi dlaczego ;/
            // bo AES wymaga klucza 128/192/256 bitow baranie
            System.out.println("Tekst do zaszyfrowania: " + text);
            System.out.println();

//			byte[] enc = HMAC.generate(text.getBytes(), k.getBytes());


            byte[][] encTmp = AES.encrypt(iv.getBytes(), k.getBytes());
            //byte[][] subKeys = AES.generateSubkeys(k.getBytes());
            int length = 0;
            int i = 0;

            if (text.length() % 16 == 0) {
                i = (text.length() / 16) * 16;
            } else i = ((text.length() / 16) + 1) * 16;


            byte[] enc = new byte[i];
            //	for (int j = 0; j < i; j++ )
            //	{
            //		enc[j] = encTmp[4][j+144];
            //	}
            //	System.out.println("ive normalne :" + enc[1]);
            /*for (int j = 0; j < subKeys.length; j++ )
            {
				System.arraycopy(subKeys[j], 0, enc, j * 4, 4);
			}*/
            System.out.println("iv przed CBC :" + iv);
            byte[] enc2 = AES_CBC.encrypt(text.getBytes(), k.getBytes(), iv.getBytes());
            System.out.println("ive po CBC :" + enc[1]);

            byte[][] iveTmp = AES.encrypt(iv.getBytes(), k.getBytes());


            byte[] ive = new byte[16];
            //String ive = "1111111111111111";
            for (int m = 0; m < 16; m++) {
                ive[m] = iveTmp[4][m + 144];
            }
            //System.out.println();


            //System.out.println("Ive przed CFB :" + ive[1]);
            byte[] enc3 = AES_CFB.encrypt(text.getBytes(), k.getBytes(), ive);
            //System.out.println("Ive po CFB :" + ive[1]);
            //byte[] enc4 = AES_OFB.encrypt(text.getBytes(), k.getBytes(),ive);
            //System.out.println("Ive po OFB :" + ive[1]);

            //byte[] enc5 = AES_CTR.encrypt(text.getBytes(), k.getBytes(),ivInt);
            //System.out.println("Ive po CTR :" + ive[1]);
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            StringBuilder sb3 = new StringBuilder();
            StringBuilder sb4 = new StringBuilder();
            StringBuilder sb5 = new StringBuilder();


            //for (byte b : ive) {
            //	sb.append(String.format("%02X ", b));
            //	}
            //	System.out.println("\nTekst zaszyfrowany: "+sb.toString());

            for (byte b : enc2) {
                sb2.append(String.format("%02X ", b));
            }

            System.out.println("\nTekst zaszyfrowany CBC : " + sb2.toString());

            for (byte b : enc3) {
                sb3.append(String.format("%02X ", b));
            }

            System.out.println("\nTekst zaszyfrowany CFB : " + sb3.toString());

            //	for (byte b : enc4) {
            //		sb4.append(String.format("%02X ", b));
            //	}

            System.out.println("\nTekst zaszyfrowany OFB : " + sb4.toString());

            //for (byte b : enc5) {
            //		sb5.append(String.format("%02X ", b));
            //	}

            System.out.println("\nTekst zaszyfrowany CTR : " + sb5.toString());

//
//			byte[]  dec = AES.decrypt(enc, k.getBytes());
//			byte[] dec2 = AES_CBC.decrypt(enc2, k.getBytes(), iv.getBytes(),text.length());
//			byte[] dec3 = AES_CFB.decrypt(enc3, k.getBytes(), ive, text.length());
//			byte[] dec4 = AES_OFB.decrypt(enc4, k.getBytes(), ive, text.length());
//			byte[] dec5 = AES_CTR.decrypt(enc5, k.getBytes(), ivInt);
//			System.out.println("Tekst odszyfrowany: "+new String(dec));
//			System.out.println("Tekst odszyfrowany CBC: "+new String(dec2));
//			System.out.println("Tekst odszyfrowany CFB: "+new String(dec3));
//			System.out.println("Tekst odszyfrowany OFB: "+new String(dec4));
//			System.out.println("Tekst odszyfrowany CTR: "+new String(dec5));
//			System.out.println("Dlugosc odszyfrowanego normalnego: "+dec.length);
//			System.out.println("Dlugosc odszyfrowanego CBC: "+dec2.length);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
