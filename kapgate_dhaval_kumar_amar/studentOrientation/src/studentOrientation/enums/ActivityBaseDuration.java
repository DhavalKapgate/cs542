package studentOrientation.enums;

public enum ActivityBaseDuration {
	UNIVERSITY(45),
	MANDO(35),
	BUS(120),
	ON_FOOT(300),
	FORM(30),
	REG(10),
	STAND_QUEUE(100),
	GAMING_CONTEST(60);
	private int baseDuration;
	
	private ActivityBaseDuration(int duration) {
		baseDuration = duration;
	}
	/**
	 * getter method of base values of Duration
	 * @return base duration of the activity
	 */
	public int getBaseDuration() {
		return baseDuration;
	}
	
}
