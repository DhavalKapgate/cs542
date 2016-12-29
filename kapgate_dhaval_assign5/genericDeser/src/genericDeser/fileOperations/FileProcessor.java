package genericDeser.fileOperations;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;


public class FileProcessor {
	FileInputStream fis=null;
	BufferedReader br=null;
	
	
	public FileProcessor(String input) {
		try{
		
			fis=new FileInputStream(input);
			br=new BufferedReader(new InputStreamReader(fis));
		}
		catch(FileNotFoundException e)
		{
			System.err.println("File not found");
			System.exit(0);
		}
		catch(Exception e)
		{
			System.exit(0);
		}
		finally
		{
		}
	}
	public String read()
	{
		try{
			return br.readLine();
		}
		catch(IOException e){
			System.err.println("IOEXCEPTION");
			System.exit(0);
		}
		catch(Exception e)
		{
			System.err.println("ERROR WHILE READING FILE");
			System.exit(0);
		}
		return null;
	}
}
