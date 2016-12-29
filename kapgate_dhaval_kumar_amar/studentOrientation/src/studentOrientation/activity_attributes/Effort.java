package studentOrientation.activity_attributes;

import studentOrientation.enums.Buying_Books_Enum;
import studentOrientation.enums.Campus_tour_Enum;
import studentOrientation.enums.Registration_Enum;
import studentOrientation.enums.Selecting_Dorm_Enum;

public interface Effort {
	/**
	 * this method returns effort of buying books activity
	 * @param books the bookstore choice 
	 * @return effort of the activity
	 */
	public int getEffortValue_books(Buying_Books_Enum books);
	/**
	 * this method returns effort of campus tour activity
	 * @param tour choice 
	 * @return effort of the activity
	 */
	public int getEffortValue_tour(Campus_tour_Enum tour);
	/**
	  * this method returns effort of Course registration activity
	  * @param registration choice 
	  * @return effort of the activity
	  */
	public int getEffortValue_reg(Registration_Enum reg);
	/**
	 * this method returns effort of selecting dorm activity
	 * @param dorm selection choice 
	 * @return effort of the activity
	 */
	public int getEffortValue_dorm(Selecting_Dorm_Enum dorm);
}
