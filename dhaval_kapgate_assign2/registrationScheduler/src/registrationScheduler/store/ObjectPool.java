package registrationScheduler.store;

import java.util.Arrays;

import registrationScheduler.util.Logger;
import registrationScheduler.util.Logger.DebugLevel;

public class ObjectPool {
	private static int capacity[]=new int[7];
	/**
	 * @return the capacity/availability of courses
	 */
	public static int[] Borrow() {
		return capacity;
	}
	/**
	 * This method updates the availability of courses 
	 * @param capacity the availability of each course
	 */
	public static void Return(int[] capacity) {
		ObjectPool.capacity = capacity;
	}
	private void setFactory(int capacity[])
	{
		Arrays.fill(capacity, 60);
	}
	
	public ObjectPool()
	{
		setFactory(capacity);
		Logger.writeMessage("In Constructor of ObjectPool.\n", DebugLevel.DEBUG4);
	}
	
}
