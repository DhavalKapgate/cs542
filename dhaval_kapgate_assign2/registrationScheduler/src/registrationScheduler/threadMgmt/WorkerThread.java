package registrationScheduler.threadMgmt;

import registrationScheduler.store.ObjectPool;
import registrationScheduler.store.Results;
import registrationScheduler.util.FileProcessor;
import registrationScheduler.util.Logger;
import registrationScheduler.util.Logger.DebugLevel;


public class WorkerThread implements Runnable{
	FileProcessor fp=null;
	Results result=null;
	public WorkerThread(FileProcessor fp,Results result) {
		super();
		this.fp = fp;
		this.result=result;
		Logger.writeMessage("In Parameterized Constructor of WorkerThread.\n", DebugLevel.DEBUG4);
	}

	public void run() {
		String entry;
		try {
			Logger.writeMessage("run() of "+Thread.currentThread().getName()+" called.\n", DebugLevel.DEBUG3);
			
			//part 1)get line from FileProcessor and store in data structure
			while((entry = fp.readFile()) != null)
			{
				subwork(entry);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.exit(0);
		}
		finally {
			
		}
	}
	/**
	 * This method performs operation on the string/line returned by FileProcessor, which includes
	 * splitting the line so fill the data about preference and current student_no. 
	 * @param entry	string returned by FIleProcessor 
	 */
	public void subwork(String entry)
	{
		synchronized (result) {
			int student_no=0;
			String[] line2=entry.split("/");
			student_no=Integer.parseInt(line2[1]);
			
			String[] line=line2[0].split("[ |\t]+");
			result.student[student_no]=line[0];
			
			for(int i=0;i<7;i++)
			{
				result.preference[i]=Integer.parseInt(line[i+1]);
			}
			Logger.writeMessage(Thread.currentThread().getName()+" taken details of "+result.student[student_no]+" and stored then in student[] and preference[].\n", DebugLevel.DEBUG2);
			
			Allotment allot=new Allotment();
			allot.allotment(result,student_no);
		}
	}
}
