package studentOrientation.activity_attributes;

import studentOrientation.enums.ActivityBaseCO2;
import studentOrientation.enums.ActivityBaseCost;
import studentOrientation.enums.ActivityBaseDuration;
import studentOrientation.enums.ActivityBaseEffort;
import studentOrientation.enums.Buying_Books_Enum;
import studentOrientation.enums.Campus_tour_Enum;
import studentOrientation.enums.Registration_Enum;
import studentOrientation.enums.Selecting_Dorm_Enum;
import studentOrientation.util.Logger;
import studentOrientation.util.Logger.DebugLevel;

public class Attributes implements Carbon_footprint,Cost,Effort,Duration {

	@Override
	
	public int getDurValue_books(Buying_Books_Enum books) {
		Logger.writeMessage("In getDurValue_books() (class:Attributes).\n", DebugLevel.DEBUG1);
		if(Buying_Books_Enum.UNIVERSITY==books)
			return ActivityBaseDuration.UNIVERSITY.getBaseDuration();
		else
			return ActivityBaseDuration.MANDO.getBaseDuration();
	}
	@Override
	public int getDurValue_tour(Campus_tour_Enum tour) {
		Logger.writeMessage("In getDurValue_tour() (class:Attributes).\n", DebugLevel.DEBUG1);
		if(Campus_tour_Enum.BUS==tour)
			return ActivityBaseDuration.BUS.getBaseDuration();
		else
			return ActivityBaseDuration.ON_FOOT.getBaseDuration();
	}
	@Override
	public int getDurValue_reg(Registration_Enum reg) {
		Logger.writeMessage("In getDurValue_reg() (class:Attributes).\n", DebugLevel.DEBUG1);
		if(Registration_Enum.REG==reg)
			return ActivityBaseDuration.REG.getBaseDuration();
		else
			return ActivityBaseDuration.FORM.getBaseDuration();
	}
	@Override
	public int getDurValue_dorm(Selecting_Dorm_Enum dorm) {
		Logger.writeMessage("In getDurValue_dorm() (class:Attributes).\n", DebugLevel.DEBUG1);
		if(Selecting_Dorm_Enum.GAMING_CONTEST==dorm)
			return ActivityBaseDuration.GAMING_CONTEST.getBaseDuration();
		else
			return ActivityBaseDuration.STAND_QUEUE.getBaseDuration();
	}
	@Override
	public int getEffortValue_books(Buying_Books_Enum books) {
		Logger.writeMessage("In getDurEffort_books() (class:Attributes).\n", DebugLevel.DEBUG1);
		if(Buying_Books_Enum.UNIVERSITY==books)
			return ActivityBaseEffort.UNIVERSITY.getBaseEffort();
		else
			return ActivityBaseEffort.MANDO.getBaseEffort();
	}
	@Override
	public int getEffortValue_tour(Campus_tour_Enum tour) {
		Logger.writeMessage("In getDurEffort_tour() (class:Attributes).\n", DebugLevel.DEBUG1);
		if(Campus_tour_Enum.BUS==tour)
			return ActivityBaseEffort.BUS.getBaseEffort();
		else
			return ActivityBaseEffort.ON_FOOT.getBaseEffort();
	}
	@Override
	public int getEffortValue_reg(Registration_Enum reg) {
		Logger.writeMessage("In getDurEffort_reg() (class:Attributes).\n", DebugLevel.DEBUG1);
		if(Registration_Enum.FORM==reg)
			return ActivityBaseEffort.FORM.getBaseEffort();
		else
			return ActivityBaseEffort.REG.getBaseEffort();
	}
	@Override
	public int getEffortValue_dorm(Selecting_Dorm_Enum dorm) {
		Logger.writeMessage("In getDurEffort_dorm() (class:Attributes).\n", DebugLevel.DEBUG1);
		if(Selecting_Dorm_Enum.STAND_QUEUE==dorm)
			return ActivityBaseEffort.STAND_QUEUE.getBaseEffort();
		else
			return ActivityBaseEffort.GAMING_CONTEST.getBaseEffort();
	}
	public double getCost(Buying_Books_Enum book) {
		Logger.writeMessage("In getCost(Buying_Books_Enum book) (class:Attributes).\n", DebugLevel.DEBUG1);
		if(book==Buying_Books_Enum.UNIVERSITY)
			return ActivityBaseCost.UNIVERSITY.getBaseCost();
		else 
			return ActivityBaseCost.UNIVERSITY.getBaseCost()*1.05;
	}
	public double getCost(Campus_tour_Enum tour) {
		Logger.writeMessage("In getCost(Campus_tour_Enum tour) (class:Attributes).\n", DebugLevel.DEBUG1);
		if(tour==Campus_tour_Enum.BUS)
			return ActivityBaseCost.BUS.getBaseCost();
		else 
			return ActivityBaseCost.ON_FOOT.getBaseCost();
	}
	public double getCost(Registration_Enum reg) {
		Logger.writeMessage("In getCost(Registration_Enum reg) (class:Attributes).\n", DebugLevel.DEBUG1);
		if(Registration_Enum.REG==reg)
			return ActivityBaseCost.REG.getBaseCost();
		else 
			return ActivityBaseCost.REG.getBaseCost()*0.97;
	}
	public double getCost(Selecting_Dorm_Enum dorm) {
		Logger.writeMessage("In getCost(Selecting_Dorm_Enum dorm) (class:Attributes).\n", DebugLevel.DEBUG1);
		if(Selecting_Dorm_Enum.STAND_QUEUE==dorm)
			return ActivityBaseCost.STAND_QUEUE.getBaseCost();
		else 
			return ActivityBaseCost.STAND_QUEUE.getBaseCost()*1.02;
	}
	@Override
	public double getC02Value_books(Buying_Books_Enum books) {
		Logger.writeMessage("In getC02Value_books() (class:Attributes).\n", DebugLevel.DEBUG1);
		if(Buying_Books_Enum.UNIVERSITY==books)
			return ActivityBaseCO2.UNIVERSITY.getBaseCO2();
		else
			return ActivityBaseCO2.UNIVERSITY.getBaseCO2();
	}
	@Override
	public double getC02Value_tour(Campus_tour_Enum tour) {
		Logger.writeMessage("In getC02Value_tour() (class:Attributes).\n", DebugLevel.DEBUG1);
		if(Campus_tour_Enum.BUS==tour)
			return ActivityBaseCO2.BUS.getBaseCO2();
		else
			return ActivityBaseCO2.ON_FOOT.getBaseCO2();
	}
	@Override
	public double getC02Value_reg(Registration_Enum reg) {
		Logger.writeMessage("In getC02Value_reg() (class:Attributes).\n", DebugLevel.DEBUG1);
		if(Registration_Enum.FORM==reg)
			return ActivityBaseCO2.FORM.getBaseCO2();
		else
			return ActivityBaseCO2.ON_FOOT.getBaseCO2();
	}
	@Override
	public double getC02Value_dorm(Selecting_Dorm_Enum dorm) {
		Logger.writeMessage("In getC02Value_dorm() (class:Attributes).\n", DebugLevel.DEBUG1);
		if(Selecting_Dorm_Enum.STAND_QUEUE==dorm)
			return ActivityBaseCO2.STAND_QUEUE.getBaseCO2();
		else
			return ActivityBaseCO2.GAMING_CONTEST.getBaseCO2();
	}
}
