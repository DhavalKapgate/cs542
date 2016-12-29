package wordCount.util;

public class Logger {


    public static enum DebugLevel { DEBUG0,DEBUG1,DEBUG2,DEBUG3
                                   };

    private static DebugLevel debugLevel;


    public static void setDebugValue (int levelIn) {
		switch (levelIn) {
		  case 3: debugLevel = DebugLevel.DEBUG3; break;	//display backup avl
		  case 2: debugLevel = DebugLevel.DEBUG2; break;	//display avl
		  case 1: debugLevel = DebugLevel.DEBUG1; break;	//display constructors
		  case 0: debugLevel = DebugLevel.DEBUG0; break; 	//default
		}
    }

    public static void setDebugValue (DebugLevel levelIn) {
	debugLevel = levelIn;
    }

    // @return None
    public static void writeMessage (String message ,DebugLevel levelIn ) {
	if (levelIn == debugLevel)
	    System.out.print(message);	
    }

    public String toString() {
	return "Debug Level is " + debugLevel;
    }
}
