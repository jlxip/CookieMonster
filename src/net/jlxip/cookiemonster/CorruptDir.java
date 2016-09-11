package net.jlxip.cookiemonster;

import java.io.File;
import java.util.ArrayList;

public class CorruptDir {
	public static ArrayList<File> files;
	
	protected static void search(File file) {
		File[] children = file.listFiles();
		
		for(int i=0;i<children.length;i++) {
			if(children[i].isDirectory()) {
				search(children[i]);
			} else {
				files.add(children[i]);
			}
		}
	}
	
	public static void run(File f) {
		files = new ArrayList<File>();
		search(f);
		
		for(int i=0;i<files.size();i++) {
			CorruptFile.run(files.get(i));
		}
	}
}
