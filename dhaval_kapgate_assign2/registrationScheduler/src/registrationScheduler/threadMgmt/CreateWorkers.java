package registrationScheduler.threadMgmt;

import registrationScheduler.store.ObjectPool;
import registrationScheduler.store.Results;
import registrationScheduler.util.FileProcessor;
import registrationScheduler.util.Logger;
import registrationScheduler.util.Logger.DebugLevel;

public class CreateWorkers {

	FileProcessor fp=null;
	Results result=null;
	public CreateWorkers(FileProcessor fp,Results result)
	{
		this.fp=fp;
		this.result=result;
		Logger.writeMessage("In Parameterized Constructor of CreateWorkers.\n", DebugLevel.DEBUG4);
	}
	/**
	 * this method creates NUM_THREADS that work on allotment of courses 
	 * @param no_of_threads NUM_THREADS/number of threads to be created and started
	 */
	public void startWorker(int no_of_threads)
	{
		Thread[] th = new Thread[no_of_threads];
	
		for(int i=0;i<no_of_threads;i++){
			th[i] = new Thread(new WorkerThread(fp,result));
			th[i].start();
		}
		for(int i=0;i<no_of_threads;i++){
			try {
				th[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block	
				System.exit(0);
			}
			finally {
				
			}
		}
	}
}
