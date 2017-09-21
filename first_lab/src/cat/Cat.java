package cat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*
 * Create a “cat” program.
 * This should receive a filename as a command line argument and
 * write out the contents of the file. (10 min) 
 * Check if the given file is missing, in that case don’t write 
 * out anything.
 */

public class Cat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File f = new File(System.getProperty("user.dir")+"\\"+args[0]);
		if(f.exists()) {
			BufferedReader br = null;
			FileReader fr = null;
	
			try {
	
				//br = new BufferedReader(new FileReader(FILENAME));
				fr = new FileReader(System.getProperty("user.dir")+"\\"+args[0]);
				br = new BufferedReader(fr);
	
				String sCurrentLine;
	
				while ((sCurrentLine = br.readLine()) != null) {
					System.out.println(sCurrentLine);
				}
	
			} catch (IOException e) {
	
				e.printStackTrace();
	
			} finally {
	
				try {
	
					if (br != null)
						br.close();
	
					if (fr != null)
						fr.close();
	
				} catch (IOException ex) {
	
					ex.printStackTrace();
	
				}
	
			}
		}

	}

}
