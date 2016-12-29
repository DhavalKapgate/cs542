package studentOrientation.util;

import studentOrientation.activity_attributes.Attributes;
import studentOrientation.activity_attributes.Carbon_footprint;
import studentOrientation.activity_attributes.Cost;
import studentOrientation.activity_attributes.Duration;
import studentOrientation.activity_attributes.Effort;
import studentOrientation.enums.Buying_Books_Enum;
import studentOrientation.enums.Campus_tour_Enum;
import studentOrientation.enums.Registration_Enum;
import studentOrientation.enums.Selecting_Dorm_Enum;
import studentOrientation.util.Logger.DebugLevel;

public class BU2016Student extends BUStudent{

	private int total_duration,total_effort;
	private double total_cost,total_carbon_print;
	private Buying_Books_Enum buying_books_enum;
	private Campus_tour_Enum campus_tour_enum;
	private Registration_Enum registration_enum;
	private Selecting_Dorm_Enum selecting_dorm_enum;
	
	private Carbon_footprint att_CO2=new Attributes();
	private Cost att_cost=new Attributes();
	private Duration att_duration=new Attributes();
	private Effort att_effort=new Attributes();
	
	public BU2016Student(Buying_Books_Enum buying_books, Campus_tour_Enum campus_tour, Registration_Enum registration, Selecting_Dorm_Enum selecting_dorm) {
		
		setDescription(buying_books, campus_tour, registration, selecting_dorm);
	}

	@Override
	public void buy_books() {
		Logger.writeMessage("In buy_books() (class:BU2016Student).\n", DebugLevel.DEBUG1);
		total_duration=total_duration+att_duration.getDurValue_books(buying_books_enum);
		total_effort=total_effort+att_effort.getEffortValue_books(buying_books_enum);
		total_cost=total_cost+att_cost.getCost(buying_books_enum);
		total_carbon_print=total_carbon_print+att_CO2.getC02Value_books(buying_books_enum);
	}

	@Override
	public void take_tour() {
		Logger.writeMessage("In take_tour() (class:BU2016Student).\n", DebugLevel.DEBUG1);
		total_duration=total_duration+att_duration.getDurValue_tour(campus_tour_enum);
		total_effort=total_effort+att_effort.getEffortValue_tour(campus_tour_enum);
		total_cost=total_cost+att_cost.getCost(campus_tour_enum);
		total_carbon_print=total_carbon_print+att_CO2.getC02Value_tour(campus_tour_enum);			
	}

	@Override
	public void register_courses() {
		Logger.writeMessage("In register_courses() (class:BU2016Student).\n", DebugLevel.DEBUG1);
		total_duration=total_duration+att_duration.getDurValue_reg(registration_enum);
		total_effort=total_effort+att_effort.getEffortValue_reg(registration_enum);
		total_cost=total_cost+att_cost.getCost(registration_enum);
		total_carbon_print=total_carbon_print+att_CO2.getC02Value_reg(registration_enum);
	}

	@Override
	public void selecting_a_dorm() {
		Logger.writeMessage("In selecting_a_dorm() (class:BU2016Student).\n", DebugLevel.DEBUG1);	
		total_duration=total_duration+att_duration.getDurValue_dorm(selecting_dorm_enum);
		total_effort=total_effort+att_effort.getEffortValue_dorm(selecting_dorm_enum);
		total_cost=total_cost+att_cost.getCost(selecting_dorm_enum);
		total_carbon_print=total_carbon_print+att_CO2.getC02Value_dorm(selecting_dorm_enum);
	}

	@Override
	public String toString() {
		String tostring="Your choices:";
		if(campus_tour_enum==Campus_tour_Enum.BUS)
			tostring=tostring+"\nCAMPUS TOUR: BUS-RIDE";
		else
			tostring=tostring+"\nCAMPUS TOUR: ON-FOOT";
		tostring=tostring+"\nBUYING BOOKS: "+buying_books_enum+" BOOKSTORE";
		if(selecting_dorm_enum==Selecting_Dorm_Enum.STAND_QUEUE)
			tostring=tostring+"\nSELECTING DORM: STANDING IN LONG QUEUE OUTSIDE ADMINISTRARORS OFFICE";
		else
			tostring=tostring+"\nSELECTING DORM: ONLINE GAMING CONTEST";
		if(registration_enum==Registration_Enum.FORM)
			tostring=tostring+"\nREGISTERING COURSES: SUBMITTING FORM TO REGISTRARS OFFICE";
		else
			tostring=tostring+"\nREGISTERING COURSES: ACCESSING THE REGISTRATION SYSTEM";
		tostring=tostring+"\n\nTOTAL:";
		tostring=tostring+"\nDURATION: "+total_duration+" minutes";
		tostring=tostring+"\nCARBON FOOTPRINT: "+total_carbon_print+" tonnes of CO2";
		tostring=tostring+"\nCOST: $"+total_cost;
		tostring=tostring+"\nEFFORT: "+total_effort+" calories";

		return tostring;	
	}

	@Override
	public void setDescription(Buying_Books_Enum books, Campus_tour_Enum tour, Registration_Enum reg,Selecting_Dorm_Enum dorm) {
		Logger.writeMessage("In setDescription() (class:BU2016Student).\n", DebugLevel.DEBUG1);
		buying_books_enum=books;
		campus_tour_enum=tour;
		registration_enum=reg;
		selecting_dorm_enum=dorm;
	}
}
	