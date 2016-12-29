package genericDeser.driver;


import genericDeser.util.HashMapsObjectAndCountIn;
import genericDeser.util.Logger;
import genericDeser.util.Logger.DebugLevel;
import genericDeser.util.HashMapsObjectAndCount;
import genericDeser.util.PopulateObjects;
import genericDeser.util.PopulateObjectsIn;

public class Driver {

	public static void main(String[] args) {
			try {
				
				if(args.length!=3)
				{
					System.out.println("Invalid argument list");
					System.exit(0);
				}
				String inputFile=args[0];
				int NUM_ITERATIONS=Integer.parseInt(args[1]);
				int DBG_LVL=Integer.parseInt(args[2]);
				if(DBG_LVL>=0 && DBG_LVL<3)
					Logger.setDebugValue(DBG_LVL);
				else
				{
					System.err.println("Invalid Debug Level");
					System.exit(0);
				}
				HashMapsObjectAndCountIn hmoac=new HashMapsObjectAndCount();
				long startTime = System.currentTimeMillis(); 

				PopulateObjectsIn po=null;
				for(int i=0;i<NUM_ITERATIONS;i++)
				{
					po=new PopulateObjects(inputFile);
					po.deserObjects(hmoac);
				}
				if(DBG_LVL==1)
					po.showListObj();
				else if(DBG_LVL==2)
					po.showObjCount();
				
				int no_of_unique_first_obj=hmoac.uniqueFirstObjects(hmoac.getListObject());
				int no_of_unique_second_obj=hmoac.uniqueSecondObjects(hmoac.getListObject());
				int total_no_of_unique_first_obj=hmoac.totalFirstObjects(hmoac);
				int total_no_of_unique_second_obj=hmoac.totalSecondObjects(hmoac);
				
				long finishTime = System.currentTimeMillis();
				long total_time = (finishTime-startTime)/NUM_ITERATIONS;
				Logger.writeMessage("Number of unique First objects:"+no_of_unique_first_obj, DebugLevel.DEBUG0);
				Logger.writeMessage("\nTotal Number of First objects:"+total_no_of_unique_first_obj, DebugLevel.DEBUG0);
				Logger.writeMessage("\nNumber of unique Second objects:"+no_of_unique_second_obj, DebugLevel.DEBUG0);
				Logger.writeMessage("\nTotal Number of Second objects:"+total_no_of_unique_second_obj, DebugLevel.DEBUG0);
				Logger.writeMessage("\nTOTAL TIME: "+total_time+" millisecs", DebugLevel.DEBUG0);
				System.out.println("s");
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				System.err.println("NumberFormatException");
				System.exit(0);
			} 
			catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println("Error");
				System.exit(0);
			} 
	}
}
