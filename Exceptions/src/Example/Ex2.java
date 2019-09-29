package Example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ex2 {

	public static void main(String[] args) throws IOException {
		try {
			File f = new File("F:/test.txt");
			FileReader fr = new FileReader(f);
			
			BufferedReader br = new BufferedReader(fr);
			String line;
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
			
			fr.close();
			br.close();
		} catch (Exception ex) {
			System.out.println("--Loi doc file: " + ex);
		}
	}

}
