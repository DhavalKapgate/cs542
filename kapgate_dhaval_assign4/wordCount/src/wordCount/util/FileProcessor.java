package wordCount.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import wordCount.util.Logger.DebugLevel;

public class FileProcessor {
	FileInputStream fis=null;
	FileOutputStream fos=null;
	BufferedReader br=null;
	BufferedWriter bw=null;
	File op;
	
	public FileProcessor(String output) {
		try{
			Logger.writeMessage("IN FILEPROCESSOR CONSTRUCTOR (ONLY OUTPUT)\n",DebugLevel.DEBUG1);
			op=new File(output);
			fos=new FileOutputStream(output);
			bw=new BufferedWriter(new OutputStreamWriter(fos));
		}
		catch(FileNotFoundException e)
		{
			System.err.println("Input file not found");
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
	public FileProcessor(String input,String output) {
		try{
			Logger.writeMessage("IN FILEPROCESSOR CONSTRUCTOR",DebugLevel.DEBUG1);
			
			fis=new FileInputStream(input);
			br=new BufferedReader(new InputStreamReader(fis));
			op=new File(output);
			fos=new FileOutputStream(output);
			bw=new BufferedWriter(new OutputStreamWriter(fos));
		}
		catch(FileNotFoundException e)
		{
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
			String line=br.readLine();
			return line;
		}
		catch(IOException e){
			System.exit(0);
		}
		catch(Exception e)
		{
			System.exit(0);
		}
		return null;
	}
	public void write(String data)
	{
		try {
			bw.write(data);
			bw.flush();
		} catch (IOException e) {
			System.exit(0);
		}
		catch (Exception e) {
			System.exit(0);
		}
	}
}
