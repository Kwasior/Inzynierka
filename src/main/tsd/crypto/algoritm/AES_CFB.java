package main.tsd.crypto.algoritm;
import com.sun.deploy.util.ArrayUtil;

import java.util.Arrays;

public class AES_CFB {


	private static byte[] xor_func(byte[] a, byte[] b) {
		byte[] out = new byte[a.length];
		for (int i = 0; i < a.length; i++) {
			out[i] = (byte) (a[i] ^ b[i]);
		}
		return out;

	}

	public static byte[] encrypt(byte[] in, byte[] key, byte[] ive){

		byte[] iveIN = ive;

		StringBuilder sbb = new StringBuilder();
		for (byte b : iveIN) {
			sbb.append(String.format("%02X ", b));
		}
		System.out.println("\nive w CFB : "+sbb.toString());

		int i;
		byte[] tmp = new byte[in.length];
		byte[] bloc = new byte[16];
		byte[] bloc2 = new byte[16];
		int counter = 0;
		int counter2 = 0;
		byte[][] iveTmp = new byte [((key.length / 4) + 6) * 16][((key.length / 4) + 6) * 16];

		for (i = 0; i < in.length + 1 ; i++) {
			if (i > 0 && i % 16 == 0) {
				counter = 0;
				iveIN = bloc;
				bloc = xor_func(bloc,bloc2);
				iveTmp=AES.encrypt(bloc,key);
				for (int j = 0; j < 16; j++ )
				{
					iveIN[j] = iveTmp[4][j+144];
				}
				System.arraycopy(bloc, 0, tmp, i - 16, bloc.length);
				counter2++;
			}
			if (i < in.length) {
				bloc[i % 16] = in[i];
				bloc2[i % 16] = iveIN[i % 16];

				counter++;
			}
			else{
				bloc = xor_func(bloc,bloc2);

				System.arraycopy(bloc, 0, tmp, counter2*16, counter);
			}
		}
		return tmp;
	}

	public static byte[] decrypt(byte[] in,byte[] key, byte[] ive,int length){

		//int lenght=0;
		//byte[] filler = new byte[1];
		int i;
		/*if (in.length % 16 == 0)
		{
			lenght = 0;
		}else{
			lenght = 16 - in.length % 16;
		}
		filler = new byte[lenght];
		//filler[0] = (byte) 0x80;
		System.out.println("Dlugosc fillera : " + lenght);

		for (i = 0 ; i < lenght; i++)

			filler[i] = 0;*/

		byte[] tmp = new byte[in.length];
		byte[] bloc = new byte[16];
		byte[] bloc2 = new byte[16];
		int counter = 0;
		int counter2 = 0;

		for (i = 0; i < in.length+1 ; i++) {
			if (i > 0 && i % 16 == 0) {
				counter = 0;
				bloc = xor_func(bloc,bloc2);
				//bloc = encryptBloc(bloc);
				ive = bloc;

			//	ive=AES.encrypt(ive,key);
				System.arraycopy(bloc, 0, tmp, i - 16, bloc.length);
				counter2++;
			}
			if (i < in.length) {
				bloc[i % 16] = in[i];
				bloc2[i % 16] = ive[i % 16];
				counter++;
			}
			else{
				bloc = xor_func(bloc,bloc2);
				System.arraycopy(bloc, 0, tmp, counter2*16, counter);
			}
		}

			/*for (int k = 0 ; k < bloc.length ; k++) {
					bloc[k] = (byte)(bloc2[k] ^ bloc[k]);

				}*/
		/*if(bloc.length == 16){

			bloc = xor_func(bloc,bloc2);
			//bloc = encryptBloc(bloc);
			for (int j = 0; j < 16;j++)
			{
				ive[j] = bloc[j];
			}
			ive=AES.encrypt(ive,key);
			System.arraycopy(bloc, 0, tmp, counter2*16, counter);
		}*/
		return tmp;
	}

	private static byte[] deletePadding(byte[] input) {
		int count = 0;

		int i = input.length - 2;
		while (input[i] == 0) {
			count++;
			i--;
		}

		byte[] tmp = new byte[input.length - count - 1];
		System.arraycopy(input, 0, tmp, 0, tmp.length);
		return tmp;
	}



}

/*for (int k = 0 ; k < bloc.length ; k++) {
					bloc[k] = (byte)(bloc2[k] ^ bloc[k]);

				}*/