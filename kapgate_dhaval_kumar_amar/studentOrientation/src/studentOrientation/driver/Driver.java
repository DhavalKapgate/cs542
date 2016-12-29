package studentOrientation.driver;


import studentOrientation.enums.Buying_Books_Enum;
import studentOrientation.enums.Campus_tour_Enum;
import studentOrientation.enums.Registration_Enum;
import studentOrientation.enums.Selecting_Dorm_Enum;
import studentOrientation.util.BU2016OrientationWorkshop;
import studentOrientation.util.BU2016Student;
import studentOrientation.util.BUStudent;
import studentOrientation.util.Logger;
import studentOrientation.util.Logger.DebugLevel;
import studentOrientation.util.StudentOrientationWorkshop;

public class Driver {

	public static void main(String[] args) {
		Logger.setDebugValue(Integer.parseInt(args[0]));
		Logger.writeMessage("In Driver.\n", DebugLevel.DEBUG1);
		BUStudent student=new BU2016Student(Buying_Books_Enum.UNIVERSITY,Campus_tour_Enum.BUS,Registration_Enum.FORM,Selecting_Dorm_Enum.STAND_QUEUE);
		StudentOrientationWorkshop shop=new BU2016OrientationWorkshop();
		shop.construct(student);
		System.out.println(student);
	}
}
