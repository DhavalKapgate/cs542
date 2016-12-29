package registrationScheduler.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

import registrationScheduler.util.Logger.DebugLevel;

public class FileProcessor {
	
	FileReader fr=null;
	LineNumberReader lnr=null;
	public FileProcessor(String input){
		try {
			fr=new FileReader(input);
			lnr=new LineNumberReader(fr);
			Logger.writeMessage("In Parameterized Constructor of FileProcessor.\n", DebugLevel.DEBUG4);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("Input File Missing");
			System.exit(0);
		}
		finally {
			
		}
	}
	/**
	 * This method return a line read from the file
	 * @return the line containing information about course preference along with student number 
	 * under consideration.
	 */
	public synchronized String readFile(){
		try {
			String line=lnr.readLine();
			if(line!=null)
				return (line+"/"+(lnr.getLineNumber()-1));
			else 
				return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.exit(0);
		}
		finally{
			
		}
		return null;
	}
}
