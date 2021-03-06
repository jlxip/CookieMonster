package net.jlxip.cookiemonster;

import java.io.File;

public class Main {
	public static void main(String[] args) {
		if(args.length < 1) {
			System.out.println("Cookie Monster");
			System.out.println("Usage: cookiemonster file_to_corrupt.ext...  OR  cookiemonster /directory/...");
			return;
		}
		
		for(int i=0;i<args.length;i++) {
			System.out.println("Corrupting file "+(i+1)+"/"+(args.length));	// i+1 (instead of i) and args.length (instead of args.length-1) because of human readability.
			File f = new File(args[i]);
			if(!f.exists()) {
				System.out.println("File doesn't exist.");
				return;
			}
			if(f.isDirectory()) {
				CorruptDir.run(f);
			} else {
				CorruptFile.run(f);
			}
		}
	}
}
