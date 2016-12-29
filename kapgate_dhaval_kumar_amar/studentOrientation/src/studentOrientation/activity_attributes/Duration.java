package studentOrientation.activity_attributes;

import studentOrientation.enums.Buying_Books_Enum;
import studentOrientation.enums.Campus_tour_Enum;
import studentOrientation.enums.Registration_Enum;
import studentOrientation.enums.Selecting_Dorm_Enum;

public interface Duration {
	/**
	 * this method returns duration of buying books activity
	 * @param books the bookstore choice 
	 * @return duration of the activity
	 */
	public int getDurValue_books(Buying_Books_Enum books);
	/**
	 * this method returns duration of campus tour activity
	 * @param tour choice 
	 * @return duration of the activity
	 */
	public int getDurValue_tour(Campus_tour_Enum tour);
	/**
	  * this method returns duration of Course registration activity
	  * @param registration choice 
	  * @return duration of the activity
	  */
	public int getDurValue_reg(Registration_Enum reg);
	/**
	 * this method returns duration of selecting dorm activity
	 * @param dorm selection choice 
	 * @return duration of the activity
	 */
	public int getDurValue_dorm(Selecting_Dorm_Enum dorm);
}
