package application;

import java.util.List;

import javafx.scene.Node;
import javafx.scene.image.*;

public abstract class Pet {
	private final int REWARD_AMOUNT = 15;
	private final int PUNISHMENT_AMOUNT = 15;
	
	private int healthLevel; // Between 0 and 100
	private boolean isSleeping; // Sleeping if health level at 0
	private String petName;
	private long timeOfLastExercise;

	public Pet(String petName) {
		this.healthLevel = 50;
		this.isSleeping = false;
		this.petName = petName;
		this.timeOfLastExercise = System.nanoTime();
	}
	
	public Pet(String petName, int healthLevel, long timeOfLastExercise, boolean isSleeping) {
		this.petName = petName;
		this.healthLevel = healthLevel;
		this.timeOfLastExercise = timeOfLastExercise;
		this.isSleeping = isSleeping;
	}

	public int getHealthLevel() {
		return healthLevel;
	}

	public void setHealthLevel(int healthLevel) {
		this.healthLevel = healthLevel;
	}

	public boolean isSleeping() {
		return isSleeping;
	}

	public void setSleeping(boolean isSleeping) {
		this.isSleeping = isSleeping;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}
	
	public long getTimeOfLastExercise() {
		return timeOfLastExercise;
	}

	public void setTimeOfLastExercise(long timeOfLastExercise) {
		this.timeOfLastExercise = timeOfLastExercise;
	}

	public void exerciseSuccess() {
		timeOfLastExercise = System.nanoTime();
		
		if (healthLevel >= 100 - REWARD_AMOUNT) {
			healthLevel = 100;
		}
		else if (healthLevel != 0) {
			healthLevel += REWARD_AMOUNT;
		}
		else {
			healthLevel = PUNISHMENT_AMOUNT;
			isSleeping = false;
		}
	}
	
	public void exerciseFailure() {
		if (healthLevel <= PUNISHMENT_AMOUNT) {
			healthLevel = 0;
			isSleeping = true;
		}
		else {
			healthLevel -= PUNISHMENT_AMOUNT;
		}
	}
	
	protected abstract String getPetType();
	protected abstract void initIdleAnimList();
	protected abstract void initWalkAnimList();
	protected abstract void initCelebAnimList();
	protected abstract void initSadAnimList();
	protected abstract void initDeathAnimList(); // TODO: REMOVE?
	protected abstract void initGhostAnimList(); // TODO: REMOVE?
	protected abstract List<Image> getIdleAnimList();
	protected abstract List<Image> getWalkAnimList();
	protected abstract List<Image> getCelebAnimList();
	protected abstract List<Image> getSadAnimList();
	protected abstract List<Image> getDeathAnimList(); // TODO: REMOVE?
	protected abstract List<Image> getGhostAnimList();
	
}
