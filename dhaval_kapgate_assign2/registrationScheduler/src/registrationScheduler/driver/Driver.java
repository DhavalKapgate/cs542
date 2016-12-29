package registrationScheduler.driver;



import registrationScheduler.store.ObjectPool;
import registrationScheduler.store.Results;
import registrationScheduler.threadMgmt.CreateWorkers;
import registrationScheduler.util.FileProcessor;
import registrationScheduler.util.Logger;

public class Driver {

	public static void main(String[] args) {
		try{
			if(args.length==4)
			{
				String input=args[0];
				String output=args[1];
				int NUM_THREADS=Integer.parseInt(args[2]);
				if(!(NUM_THREADS>=1 && NUM_THREADS<=3))
				{
					System.err.println("Invalid number of threads.");
					System.exit(0);
				}
				Logger.setDebugValue(Integer.parseInt(args[3]));
				int DEBUG_VALUE=Integer.parseInt(args[3]);
				if(!(DEBUG_VALUE>=0 && DEBUG_VALUE<=4))
				{
					System.err.println("Invalid value of DEBUG_VALUE.");
					System.exit(0);
				}
				FileProcessor fp=new FileProcessor(input);
				ObjectPool op=new ObjectPool();
				Results result=new Results(output);
				CreateWorkers cw=new CreateWorkers(fp,result);
				cw.startWorker(3);
				result.writeSchedulesToFile(fp,result);
				result.writeSchedulesToScreen(fp,result);
			}
			else
			{
				System.err.println("Wrong number of arguments");
				System.exit(0);
			}
		}
		catch (NumberFormatException e) {
			System.err.println("Enter a integer value needed for NUM_THREADS and DEBUG_VALUE");
			System.exit(0);
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.exit(0);
			
		}
		catch (Exception e) {
			System.err.println("ERROR!!");
			System.exit(0);
		}
		finally {
			
		}
	}
}
