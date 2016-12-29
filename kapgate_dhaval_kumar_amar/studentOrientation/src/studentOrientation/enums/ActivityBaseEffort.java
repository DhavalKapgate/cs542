package studentOrientation.enums;

public enum ActivityBaseEffort {
	UNIVERSITY(290),
	MANDO(200),
	BUS(150),
	ON_FOOT(380),
	FORM(152),
	REG(10),
	STAND_QUEUE(100),
	GAMING_CONTEST(10);
	private int baseEffort;

	private ActivityBaseEffort(int effort) {
		baseEffort = effort;
	}

	/**
	 * getter method of base values of Effort
	 * @return base effort of the activity
	 */
	public int getBaseEffort() {
		return baseEffort;
	}
}
