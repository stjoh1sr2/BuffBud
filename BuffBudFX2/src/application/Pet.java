package application;

/**
 * Class to represent a pet.
 * 
 * UPDATED:	16 APR 2021
 */

import java.util.List;

import javafx.scene.image.*;

public abstract class Pet {
	private final int REWARD_AMOUNT = 15;
	private final int PUNISHMENT_AMOUNT = 15;

	private int healthLevel; // Between 0 and 100
	private boolean isSleeping; // Sleeping if health level between 0 and PUNISHMENT_AMOUNT
	private String petName;
	private long timeOfLastExercise;

	/**
	 * Constructor initializing with just a pet name
	 * 
	 * @param petName
	 */
	public Pet(String petName) {
		this.healthLevel = 50;
		this.isSleeping = false;
		this.petName = petName;
		this.timeOfLastExercise = System.nanoTime();
	}

	/**
	 * Constructor initializing with custom information
	 * 
	 * @param petName
	 * @param healthLevel
	 * @param timeOfLastExercise
	 * @param isSleeping
	 */
	public Pet(String petName, int healthLevel, long timeOfLastExercise, boolean isSleeping) {
		this.petName = petName;
		this.healthLevel = healthLevel;
		this.timeOfLastExercise = timeOfLastExercise;
		this.isSleeping = isSleeping;
	}

	/**
	 * Gets health level
	 * 
	 * @return health level of the pet
	 */
	public int getHealthLevel() {
		return healthLevel;
	}

	/**
	 * Sets health level of pet
	 * 
	 * @param healthLevel to set the pet health level to
	 */
	public void setHealthLevel(int healthLevel) {
		this.healthLevel = healthLevel;
	}

	/**
	 * Checks if the pet is sleeping
	 * 
	 * @return true if sleeping, false if not
	 */
	public boolean isSleeping() {
		return isSleeping;
	}

	/**
	 * Sets the pet as sleeping or not sleeping
	 * 
	 * @param isSleeping - true if want the pet to sleep, false if not
	 */
	public void setSleeping(boolean isSleeping) {
		this.isSleeping = isSleeping;
	}

	/**
	 * Retrieves the pet's name
	 * 
	 * @return the pet's name as a String
	 */
	public String getPetName() {
		return petName;
	}

	/**
	 * Sets the pet's name
	 * 
	 * @param petName - the name of the pet to be set
	 */
	public void setPetName(String petName) {
		this.petName = petName;
	}

	/**
	 * Retrieves the last time the pet exercised
	 * 
	 * @return the last time the pet exercised
	 */
	public long getTimeOfLastExercise() {
		return timeOfLastExercise;
	}

	/**
	 * Sets the last time the pet exercised
	 * 
	 * @param timeOfLastExercise - the last time the pet exercised
	 */
	public void setTimeOfLastExercise(long timeOfLastExercise) {
		this.timeOfLastExercise = timeOfLastExercise;
	}

	/**
	 * Modifies the pet's stats when a successful exercise occurs
	 */
	public void exerciseSuccess() {
		timeOfLastExercise = System.nanoTime();

		if (healthLevel >= 100 - REWARD_AMOUNT) {
			// Set to 100 in order to avoid numbers above 100
			healthLevel = 100;
		} else if (healthLevel != 0) {
			healthLevel += REWARD_AMOUNT;
		} else {
			healthLevel = PUNISHMENT_AMOUNT;
			isSleeping = false;
		}
	}

	/**
	 * Modifies the pet's stats when a failed exercise occurs
	 */
	public void exerciseFailure() {
		if (healthLevel <= PUNISHMENT_AMOUNT) {
			// Set to 0 in order to avoid negative health numbers
			healthLevel = 0;
			isSleeping = true;
		} else {
			healthLevel -= PUNISHMENT_AMOUNT;
		}
	}

	// Gets the species/breed of the current pet
	protected abstract String getPetType();

	// For initializing the order of sprites for animation
	protected abstract void initIdleAnimList();

	protected abstract void initWalkAnimList();

	protected abstract void initCelebAnimList();

	protected abstract void initSadAnimList();

	protected abstract void initDeathAnimList();

	protected abstract void initGhostAnimList();

	// For retrieving the sprites for animation
	protected abstract List<Image> getIdleAnimList();

	protected abstract List<Image> getWalkAnimList();

	protected abstract List<Image> getCelebAnimList();

	protected abstract List<Image> getSadAnimList();

	protected abstract List<Image> getDeathAnimList();

	protected abstract List<Image> getGhostAnimList();

}
