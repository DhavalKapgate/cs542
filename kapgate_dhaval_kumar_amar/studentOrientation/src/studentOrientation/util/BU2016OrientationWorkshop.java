package studentOrientation.util;

import studentOrientation.util.Logger.DebugLevel;

public class BU2016OrientationWorkshop implements StudentOrientationWorkshop{
		public void construct(BUStudent bustudent) { 
			Logger.writeMessage("In construct() (class:BU2016OrientationWorkshop).\n", DebugLevel.DEBUG1);

			try{
				bustudent.buy_books();
				bustudent.register_courses();
				bustudent.selecting_a_dorm();
				bustudent.take_tour();
			}
			catch(IllegalArgumentException e)
			{
				System.err.println("INVALID ARGUMENTS.");
				System.exit(0);
			}
			catch(Exception e)
			{
				System.out.println("PROGRAM FAILURE");
				System.exit(0);
			}
			finally {
				
			}
	     }
} 
