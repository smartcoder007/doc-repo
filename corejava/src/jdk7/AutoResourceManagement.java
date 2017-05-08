package jdk7;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class AutoResourceManagement {
	public static void main(String args[]) {
		try (FileInputStream fin = new FileInputStream("info.xml");	BufferedReader br = new BufferedReader(new InputStreamReader(fin));) {
			if (br.ready()) {
				String line1 = br.readLine();
				System.out.println(line1);
			}
		} catch (FileNotFoundException ex) {
			System.out.println("Info.xml is not found");
		} catch (IOException ex) {
			System.out.println("Can't read the file");
		}

	}
}
