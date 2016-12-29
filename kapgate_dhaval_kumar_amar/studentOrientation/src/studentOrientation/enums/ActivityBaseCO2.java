package studentOrientation.enums;

public enum ActivityBaseCO2 {
	UNIVERSITY(0.03),
	MANDO(0.02),
	BUS(0.07),
	ON_FOOT(0.0),
	FORM(0.05),
	REG(0.0),
	STAND_QUEUE(0.0),
	GAMING_CONTEST(0.0);
	private double baseCO2;
	private ActivityBaseCO2(double co2)
	{
		baseCO2=co2;
	}
	/**
	 * getter method of base values of CO2 print
	 * @return base carbon footprint of the activity
	 */
	public double getBaseCO2() {
		return baseCO2;
	}
	
}
