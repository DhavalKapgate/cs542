package registrationScheduler.store;

import registrationScheduler.util.FileProcessor;

public interface StdoutDisplayInterface {
	/**
	 * This method prints allotment of courses and their preference scores to the stdout/Screen
	 */
	public void writeSchedulesToScreen(FileProcessor fp,Results result);
}
