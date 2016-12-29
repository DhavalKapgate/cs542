package studentOrientation.util;

public class Logger{


    public static enum DebugLevel { DEBUG0,DEBUG1 
                                   };

    private static DebugLevel debugLevel;

    /**
     * debug mode 	1-print the flow of fuctions
     * 			  	0-normal execution
     * @param levelIn	debug level
     */
    public static void setDebugValue (int levelIn) {
		switch (levelIn) {
		  case 1: debugLevel = DebugLevel.DEBUG1; break;
		  case 0: debugLevel = DebugLevel.DEBUG0; break; 
		}
    }
    /**
     * set debug level
     * @param levelIn debug level
     */
    public static void setDebugValue (DebugLevel levelIn) {
	debugLevel = levelIn;
    }

    // @return None
    /**
     * print message
     * @param message string to be printed by the call
     * @param levelIn debug level
     */
    public static void writeMessage (String message ,DebugLevel levelIn ) {
	if (levelIn == debugLevel)
	    System.out.print(message);	
    }

    public String toString() {
	return "Debug Level is " + debugLevel;
    }
}
