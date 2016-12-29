package studentOrientation.enums;

public enum ActivityBaseCost {
	UNIVERSITY(200.0),
	BUS(2.0),
	ON_FOOT(0.5),
	REG(3000.0),
	STAND_QUEUE(10.0);
	private double baseCost;
	private ActivityBaseCost(double cost)
	{
		baseCost=cost;
	}

	/**
	 * getter method of base values of Cost
	 * @return base Cost of the activity
	 */
	public double getBaseCost() {
		return baseCost;
	}
}
