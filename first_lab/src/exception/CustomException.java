package exception;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
 * Extend the previous program (10 min) (SCRITTO SOTTO)
 * Define a new exception type WrongPropertySyntaxException that subclasses IllegalArgumentException
 * When the property file is not in the expected format, raise a WrongPropertySyntaxException 
 * with a message that describes the problem.
 * Catch these exception in the main method and present the message to the user.
 * 
 * 
 * PREVIOUS:
 * 
 * Create a program that reads a property file. (15 min) 
 * Put the code that reads the file into a separate method.
 * Each line of the property file should be in the format of key : 
 * textual value.
 * Remove whitespace from both before the key, before and after the colon, 
 * and after the textual value.
 * Return a Map that associates the keys with the values.
 * In the main method write out the elements of the map.
 */

public class CustomException{

	public static HashMap read_file(String filename) throws WrongPropertySyntaxException{
		HashMap mp = new HashMap();
		File f = new File(System.getProperty("user.dir")+"\\"+filename);
		if(f.exists()) {
			BufferedReader br = null;
			FileReader fr = null;
	
			try {
	
				//br = new BufferedReader(new FileReader(FILENAME));
				fr = new FileReader(System.getProperty("user.dir")+"\\"+filename);
				br = new BufferedReader(fr);
	
				String sCurrentLine;
	
				while ((sCurrentLine = br.readLine()) != null) {

					if(sCurrentLine.indexOf(":")>=0){
						String key = sCurrentLine.substring(0, sCurrentLine.indexOf(":"));
						String value = sCurrentLine.substring(sCurrentLine.indexOf(":")+1);
						mp.put(key, value);
					} else {
						throw new WrongPropertySyntaxException("This is My error Message");						
					}
					

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
		return mp;
	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map mp = new HashMap();
		try {
			mp = read_file(args[0]);
		    Iterator it = mp.entrySet().iterator();
		    while (it.hasNext()) {
		        Map.Entry pair = (Map.Entry)it.next();
		        System.out.println(pair.getKey() + ":" + pair.getValue());
		        it.remove();
		    }
		} catch(WrongPropertySyntaxException e){
			System.out.println("e"+e) ;
		}

	}

}
