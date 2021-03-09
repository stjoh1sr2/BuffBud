
public abstract class Pet {
	private final int REWARD_AMOUNT = 15;
	private final int PUNISHMENT_AMOUNT = 15;
	
	private int healthLevel; // Between 0 and 100
	private boolean isSleeping; // Sleeping if health level at 0
	private String petName;
	private long timeOfLastExcersize;

	public Pet(String petName) {
		this.healthLevel = 50;
		this.isSleeping = false;
		this.petName = petName;
		this.timeOfLastExcersize = System.currentTimeMillis();
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
	
	public void excersizeSuccess() {
		timeOfLastExcersize = System.currentTimeMillis();
		
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
	
	public void excersizeFailure() {
		if (healthLevel <= PUNISHMENT_AMOUNT) {
			healthLevel = 0;
			isSleeping = true;
		}
		else {
			healthLevel -= PUNISHMENT_AMOUNT;
		}
	}
}
