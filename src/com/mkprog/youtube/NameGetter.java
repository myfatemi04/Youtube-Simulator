package com.mkprog.youtube;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

public class NameGetter {
	public static String getName() {
		byte[] filebytes = new byte[1];
		Random r = new Random();
		try {
			File namefile = new File("namelist.txt");
			FileInputStream in = new FileInputStream(namefile);
			filebytes = new byte[(int)namefile.length()];
			in.read(filebytes, 0, (int)namefile.length());
			in.close();
		} catch (IOException e) {
			
		}
		String filestr = new String(filebytes);
		String[] lines = filestr.split("\n");
		
		int randname = r.nextInt(lines.length);
		return lines[randname].split(" ")[0].toLowerCase();
	}
}
