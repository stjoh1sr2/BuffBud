package application;

import java.util.List;

import javafx.scene.image.*;

/**
 * Class to represent a pet.
 */
public abstract class Pet {
	/**
	 * The health damage to a pet when an exercise fails.
	 */
	private final int REWARD_AMOUNT = 15;

	/**
	 * The health benefit to a pet when an exercise fails.
	 */
	private final int PUNISHMENT_AMOUNT = 15;

	/**
	 * The health level of the pet. Should always be between 0 and 100.
	 */
	private int healthLevel;

	/**
	 * Flags if the pet is "sleeping" (in ghost state). Should be "sleeping" if its
	 * health level is between 0 and PUNISHMENT_AMOUNT.
	 */
	private boolean isSleeping;

	/**
	 * The name of the pet.
	 */
	private String petName;

	/**
	 * The time that the pet was last exercised.
	 */
	private long timeOfLastExercise;

	/**
	 * Constructor initializing with just a pet name.
	 * 
	 * @param petName - The name of the pet.
	 */
	public Pet(String petName) {
		this.healthLevel = 50;
		this.isSleeping = false;
		this.petName = petName;
		this.timeOfLastExercise = System.nanoTime();
	}

	/**
	 * Constructor initializing with custom information.
	 * 
	 * @param petName            - The name of the pet.
	 * @param healthLevel        - The health level of the pet.
	 * @param timeOfLastExercise - The time that the pet last exercised.
	 * @param isSleeping         - Whether or not the pet is "sleeping"/in ghost
	 *                           state.
	 */
	public Pet(String petName, int healthLevel, long timeOfLastExercise, boolean isSleeping) {
		this.petName = petName;
		this.healthLevel = healthLevel;
		this.timeOfLastExercise = timeOfLastExercise;
		this.isSleeping = isSleeping;
	}

	/**
	 * Gets health level.
	 * 
	 * @return The health level of the pet.
	 */
	public int getHealthLevel() {
		return healthLevel;
	}

	/**
	 * Sets health level of pet.
	 * 
	 * @param healthLevel - The level to set the pet health level to.
	 */
	public void setHealthLevel(int healthLevel) {
		this.healthLevel = healthLevel;
	}

	/**
	 * Checks if the pet is sleeping.
	 * 
	 * @return True if sleeping, false if not.
	 */
	public boolean isSleeping() {
		return isSleeping;
	}

	/**
	 * Sets the pet as sleeping or not sleeping.
	 * 
	 * @param isSleeping - True if want the pet to sleep, false if not.
	 */
	public void setSleeping(boolean isSleeping) {
		this.isSleeping = isSleeping;
	}

	/**
	 * Retrieves the pet's name.
	 * 
	 * @return The pet's name as a String.
	 */
	public String getPetName() {
		return petName;
	}

	/**
	 * Sets the pet's name.
	 * 
	 * @param petName - The name of the pet to be set.
	 */
	public void setPetName(String petName) {
		this.petName = petName;
	}

	/**
	 * Retrieves the last time the pet exercised.
	 * 
	 * @return The last time the pet exercised.
	 */
	public long getTimeOfLastExercise() {
		return timeOfLastExercise;
	}

	/**
	 * Sets the last time the pet exercised.
	 * 
	 * @param timeOfLastExercise - The last time the pet exercised.
	 */
	public void setTimeOfLastExercise(long timeOfLastExercise) {
		this.timeOfLastExercise = timeOfLastExercise;
	}

	/**
	 * Modifies the pet's stats when a successful exercise occurs.
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

	/**
	 * Retrieves species or breed of pet.
	 * 
	 * @return The species/breed of the selected pet.
	 */
	protected abstract String getPetType();

	/**
	 * Initializes the animation list for idling.
	 */
	protected abstract void initIdleAnimList();

	/**
	 * Initializes the animation list for walking.
	 */
	protected abstract void initWalkAnimList();

	/**
	 * Initializes the animation list for celebrating.
	 */
	protected abstract void initCelebAnimList();

	/**
	 * Initializes the animation list for being sad.
	 */
	protected abstract void initSadAnimList();

	/**
	 * Initializes the animation list for dying/reviving.
	 */
	protected abstract void initDeathAnimList();

	/**
	 * Initializes the animation list for being a ghost.
	 */
	protected abstract void initGhostAnimList();

	/**
	 * Retrieves the animations for idling.
	 * 
	 * @return The list of animations for idling.
	 */
	protected abstract List<Image> getIdleAnimList();

	/**
	 * Retrieves the animations for walking.
	 * 
	 * @return The list of animations for walking.
	 */
	protected abstract List<Image> getWalkAnimList();

	/**
	 * Retrieves the animations for celebrating.
	 * 
	 * @return The list of animations for celebrating.
	 */
	protected abstract List<Image> getCelebAnimList();

	/**
	 * Retrieves the animations for being sad.
	 * 
	 * @return The list of animations for being sad.
	 */
	protected abstract List<Image> getSadAnimList();

	/**
	 * Retrieves the animations for dying/reviving.
	 * 
	 * @return The list of animations for dying/reviving.
	 */
	protected abstract List<Image> getDeathAnimList();

	/**
	 * Retrieves the animations for being a ghost.
	 * 
	 * @return The list of animations for being a ghost.
	 */
	protected abstract List<Image> getGhostAnimList();

}
