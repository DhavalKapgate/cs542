package studentOrientation.activity_attributes;

import studentOrientation.enums.Buying_Books_Enum;
import studentOrientation.enums.Campus_tour_Enum;
import studentOrientation.enums.Registration_Enum;
import studentOrientation.enums.Selecting_Dorm_Enum;

public interface Carbon_footprint {
	/**
	 * this method returns carbon footprint of buying books activity
	 * @param books the bookstore choice 
	 * @return carbon footprint of the activity
	 */
	public double getC02Value_books(Buying_Books_Enum books);
	/**
	 * this method returns carbon footprint of campus tour activity
	 * @param tour choice 
	 * @return carbon footprint of the activity
	 */
	public double getC02Value_tour(Campus_tour_Enum tour);
	 /**
	  * this method returns carbon footprint of Course registration activity
	  * @param registration choice 
	  * @return carbon footprint of the activity
	  */
	public double getC02Value_reg(Registration_Enum reg);
	/**
	 * this method returns carbon footprint of selecting dorm activity
	 * @param dorm selection choice 
	 * @return carbon footprint of the activity
	 */
	public double getC02Value_dorm(Selecting_Dorm_Enum dorm);
}
