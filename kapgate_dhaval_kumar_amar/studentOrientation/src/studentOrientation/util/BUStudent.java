package studentOrientation.util;

import studentOrientation.activities.Buying_books;
import studentOrientation.activities.Campus_tour;
import studentOrientation.activities.Registration;
import studentOrientation.activities.Select_dorm;
import studentOrientation.enums.Buying_Books_Enum;
import studentOrientation.enums.Campus_tour_Enum;
import studentOrientation.enums.Registration_Enum;
import studentOrientation.enums.Selecting_Dorm_Enum;

public abstract class BUStudent implements Buying_books,Campus_tour,Registration,Select_dorm{
/**
 * this method set the student choices for the implementation 
 * @param books the (enum) bookstore choice the student enters
 * @param tour the (enum) campus tour choice that student enters
 * @param reg the (enum) course Registration method student enters 
 * @param dorm the (enum) dorm selection method student enters
 */
	public abstract void setDescription(Buying_Books_Enum books,Campus_tour_Enum tour,Registration_Enum reg,Selecting_Dorm_Enum dorm);
}
