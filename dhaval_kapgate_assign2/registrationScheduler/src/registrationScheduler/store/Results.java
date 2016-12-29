package registrationScheduler.store;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import registrationScheduler.util.FileProcessor;
import registrationScheduler.util.Logger;
import registrationScheduler.util.Logger.DebugLevel;

public class Results implements StdoutDisplayInterface, FileDisplayInterface{

	public int alloted_pref[][]=new int[80][7];
	//fixed data
	public int preference[]=new int[7];	//stores preferences of each cource
	public String student[]=new String[80];
	public int pref_scores[]=new int[80];
	//variable data	
	public float pref_score=0;
	
	String output;
	
	public Results(String output) {
		this.output=output;
		Logger.writeMessage("In Parameterized Constructor of Results.\n", DebugLevel.DEBUG4);
	}
	@Override
	
	public synchronized void writeSchedulesToScreen(FileProcessor fp,Results result) {
		// TODO Auto-generated method stub
		for(int i=0;i<80;i++)
		{
			Logger.writeMessage(student[i]+" ", DebugLevel.DEBUG1);
			pref_score+=result.pref_scores[i];
			
			for(int j=0;j<7;j++)
			{
				if(result.alloted_pref[i][j]!=0)
				{
					char course='A';
					for(int k=0;k<result.alloted_pref[i][j]-1;k++)
						course++;
					Logger.writeMessage(course+" ", DebugLevel.DEBUG1);
				}
			}
			String pref_String=pref_scores[i]+"";
			Logger.writeMessage(pref_String+"\n", DebugLevel.DEBUG1);
		}
		pref_score/=80;
		Logger.writeMessage("Average preference_score is: "+pref_score+"\n", DebugLevel.DEBUG1);
		Logger.writeMessage("Capacity/Availabilty of cources: \n", DebugLevel.DEBUG1);
		Logger.writeMessage("A\tB\tC\tD\tE\tF\tG\n", DebugLevel.DEBUG1);
		{
			int avail[]=ObjectPool.Borrow();
			for(int i=0;i<7;i++)
				Logger.writeMessage(avail[i]+"\t", DebugLevel.DEBUG1);
			Logger.writeMessage("\n", DebugLevel.DEBUG1);
		}
		Logger.writeMessage("Average preference_score is: "+pref_score+"\n", DebugLevel.DEBUG0);
	}
	
	@Override
	public synchronized void writeSchedulesToFile(FileProcessor fp,Results result) {
		File out=new File(output);
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter(out));
			for(int i=0;i<80;i++)
			{
				bw.write(student[i]+" ");
				pref_score+=result.pref_scores[i];
				
				for(int j=0;j<7;j++)
				{
					if(result.alloted_pref[i][j]!=0)
					{
						bw.write('A'+result.alloted_pref[i][j]-1);
						bw.write(' ');
					}
				}
				String pref_String=pref_scores[i]+"";
				bw.write(pref_String);
				bw.newLine();
			}
			pref_score/=80;
			bw.write("Average preference_score is: "+pref_score);
			bw.close();
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.exit(0);
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			System.exit(0);
		}
		finally {
			
		}
	}
}
