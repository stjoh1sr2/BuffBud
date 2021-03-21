package application;
/*
 * Adapted from Homework 2/5
 */

public class StopWatch {
	private double startTime; // The starting time of the StopWatch
	private double endTime; // The ending time of the StopWatch

	// The default constructor with no arguments
	public StopWatch() {
		this.startTime = 0;
		this.endTime = 0;
	}

	// A two-argument constructor that sets startTime and endTime
	public StopWatch(double startTime, double endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}

	// A getter method for startTime
	public double getStartTime() {
		return startTime;
	}

	// A setter method for startTime
	public void setStartTime(double d) {
		this.startTime = d;
	}

	// A getter method for endTime
	public double getEndTime() {
		return endTime;
	}

	// A setter method for endTime
	public void setEndTime(double endTime) {
		this.endTime = endTime;
	}

	// A method that signals the start of the StopWatch
	public void start() {
		startTime = System.nanoTime() / (double) 1e9;
	}

	// A method that signals the end of the StopWatch
	public void stop() {
		endTime = System.nanoTime() / (double) 1e9;
	}

	/*
	 * A method that returns the length between the StopWatch's start and end
	 */
	public double getElapsedTime() {
		return (endTime - startTime);
	}
}
