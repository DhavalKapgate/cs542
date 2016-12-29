package registrationScheduler.store;

import registrationScheduler.util.FileProcessor;

public interface FileDisplayInterface {
	/**
	 * This method prints allotment of courses and their preference scores to the file
	 */
	public void writeSchedulesToFile(FileProcessor fp,Results result);
}
