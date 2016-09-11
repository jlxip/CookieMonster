package net.jlxip.cookiemonster;

import java.io.File;
import java.io.FileWriter;
import java.util.Random;

public class CorruptFile {
	public static byte[] getRandomByte() {
		byte[] b = new byte[1];
		new Random().nextBytes(b);
		
		return b;
	}
	
	public static void run(File f) {
		long length = f.length();
		
		try {
			FileWriter fw = new FileWriter(f, false);
			for(long i=0;i<length;i++) {
				fw.write(new String(getRandomByte()));
			}
			fw.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
