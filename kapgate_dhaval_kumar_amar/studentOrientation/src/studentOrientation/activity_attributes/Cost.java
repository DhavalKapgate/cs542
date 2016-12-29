package studentOrientation.activity_attributes;

import studentOrientation.enums.Buying_Books_Enum;
import studentOrientation.enums.Campus_tour_Enum;
import studentOrientation.enums.Registration_Enum;
import studentOrientation.enums.Selecting_Dorm_Enum;

public interface Cost {
	/**
	 * this method returns cost of buying books activity
	 * @param books the bookstore choice 
	 * @return cost of the activity
	 */
	public double getCost(Buying_Books_Enum books);
	/**
	 * this method returns cost of tour activity
	 * @param tour choice 
	 * @return cost of the activity
	 */
	public double getCost(Campus_tour_Enum tour);
	/**
	 * this method returns cost of Course registration activity
	 * @param registration choice 
	 * @return cost of the activity
	 */
	public double getCost(Registration_Enum reg);
	/**
	 * this method returns cost of dorm selection activity
	 * @param dorm choice 
	 * @return cost of the activity
	 */
	public double getCost(Selecting_Dorm_Enum dorm);
}
