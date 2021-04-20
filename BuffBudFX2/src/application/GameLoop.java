package application;

import javafx.animation.*;

/**
 * Acts as the primary loop for the animations and general updates for the
 * BuffBud application. Extends AnimationTimer.
 */
public class GameLoop extends AnimationTimer {
	/**
	 * The amount of time in-between exercises.
	 */
	public final long EXERCISE_TIME = (long) (9 * Math.pow(10, 9 /* 11 */));

	/**
	 * The GameWindow that the loop operates on.
	 */
	protected GameWindow gw;

	/**
	 * The time that the last frame appeared.
	 */
	protected long lastFrameTime;

	/**
	 * The index used to loop through lists of animation. Should always be between 0
	 * and the length of the current animation's list - 1.
	 */
	protected int animationNumber;

	/**
	 * An array that lists different exercises that the pet can request its owner to
	 * do.
	 */
	private String[] exerciseList = { "go on a walk", "do jumping jacks", "jog in place", "do squats",
			"do some pushups", "do lunges", "do some crunches", "pretend to jump rope" };

	/**
	 * A string holding the last exercise offered. This eliminates duplicate
	 * exercises back-to-back.
	 */
	private String lastExercise = "";

	/**
	 * Flags whether or not an exercise has been found to display for the user.
	 */
	protected boolean exerciseFound = false;

	/**
	 * Records the current animation ongoing.
	 */
	protected String nextAnim = "idle";

	/**
	 * Records the next animation to be executed after the current one is done.
	 */
	protected String currAnim = "idle";

	/**
	 * Initializes the GameLoop.
	 * 
	 * @param gw - The GameWindow the loop is running on.
	 */
	public GameLoop(GameWindow gw) {
		this.gw = gw;
		lastFrameTime = System.nanoTime();
		animationNumber = 0;
	}

	/**
	 * Handles the GameLoop, overriding the handle method from AnimationTimer.
	 * 
	 * @param now - The current time in nanoseconds.
	 */
	@Override
	public void handle(long now) {
		// Loops after EXERCISE_TIME nanoseconds since exercise
		if (now - Main.pet.getTimeOfLastExercise() >= EXERCISE_TIME && (now - gw.exerciseTime >= EXERCISE_TIME)
				&& !gw.toReset) {
			if (!gw.exerciseActive && !exerciseFound) {
				// Finding an exercise to display then displaying it
				String currentExercise = randomExercise();
				gw.dialogue.setText("It's time to " + currentExercise + "!\nAre you ready to exercise?");
				gw.dialoguePane.setBottom(gw.answerPane);
			}
		}

		// Loop to check when an exercise should have been completed
		if (now - gw.exerciseTime >= EXERCISE_TIME && gw.exerciseActive && !gw.toReset) {
			gw.dialogue.setText("Whew! 5 seconds is up. Did you complete the exercise?");
			gw.dialoguePane.setBottom(gw.answerPane);
			exerciseFound = false;
			if (!Main.pet.isSleeping()) {
				nextAnim = "idle";
			}
		}

		// Limiting celebratory animation
		if (now - gw.exerciseTime >= (long) (EXERCISE_TIME / 3) && (currAnim.equals("celeb"))
				&& !Main.pet.isSleeping()) {
			nextAnim = "idle";
		}

		// Limiting sad reaction animation
		if (now - gw.timeOfFailure >= (long) (EXERCISE_TIME / 1.5) && (currAnim.equals("sad"))
				&& !Main.pet.isSleeping()) {
			nextAnim = "idle";
		}

		// Sending out reset message if a reset is intiated in GameWindow
		if (now - gw.resetStart >= (long) (5 * Math.pow(10, 9)) && gw.toReset) {
			Utility.clear();
			gw.stage.close();
		}

		// Setting animation patterns for a ghost pet
		if (Main.pet.getHealthLevel() <= 15) {
			Main.pet.setSleeping(true);
			if (!currAnim.equals("death") && !currAnim.equals("ghost")) {
				nextAnim = "death";
			}
		}

		// Setting condition to bring a ghost pet back to life
		if (Main.pet.isSleeping() && Main.pet.getHealthLevel() > 15) {
			Main.pet.setSleeping(false);
			nextAnim = "revive";
		}

		// Looping for animation
		if (now - lastFrameTime >= (long) (1.5 * Math.pow(10, 8))) {
			runAnimation(now);
		}

		// Ensuring the most up-to-date health level is displayed
		gw.healthLabel.setText("Health Level: " + Main.pet.getHealthLevel());
	}

	/**
	 * Finds a random exercise to display.
	 * 
	 * @return A random exercise as a String.
	 */
	private String randomExercise() {
		exerciseFound = false;
		int i = (int) (Math.random() * exerciseList.length);

		while (!exerciseFound) {
			if (!exerciseList[i].equals(lastExercise)) {
				exerciseFound = true;
				return exerciseList[i];
			} else {
				i = (int) (Math.random() * exerciseList.length);
			}
		}

		return null;
	}

	/**
	 * Runs the animation mechanisms for the pet.
	 * 
	 * @param now - The current System time in nanoseconds.
	 */
	private void runAnimation(long now) {
		/*
		 * Useful statement for testing animation patterns:
		 * 
		 * System.out.println(currAnim + " -> " + nextAnim + ": " + animationNumber +
		 * ", " + Thread.currentThread());
		 */

		// Running animation if walking
		if (currAnim.equals("walk")) {
			gw.petImage = Main.pet.getWalkAnimList().get(animationNumber);
			gw.petView.setImage(gw.petImage);

			animationNumber++;
			lastFrameTime = now;

			if (animationNumber >= Main.pet.getWalkAnimList().size()) {
				animationNumber = 0;

				if (!nextAnim.equals("walk")) {
					currAnim = nextAnim;
				}
			}
		}
		// Running animation if idle
		else if (currAnim.equals("idle")) {
			gw.petImage = Main.pet.getIdleAnimList().get(animationNumber);
			gw.petView.setImage(gw.petImage);

			animationNumber++;
			lastFrameTime = now;

			if (animationNumber == 8 || animationNumber == 17) {
				if (!nextAnim.equals("idle")) {
					animationNumber = 0;
					currAnim = nextAnim;
				}
			} else if (animationNumber >= Main.pet.getIdleAnimList().size()) {
				animationNumber = 0;

				if (!nextAnim.equals("idle")) {
					currAnim = nextAnim;
				}
			}
		}
		// Running animation if celebrating
		else if (currAnim.equals("celeb")) {
			gw.petImage = Main.pet.getCelebAnimList().get(animationNumber);
			gw.petView.setImage(gw.petImage);

			animationNumber++;
			lastFrameTime = now;

			if (animationNumber >= Main.pet.getCelebAnimList().size()) {
				animationNumber = 0;

				if (!nextAnim.equals("celeb")) {
					currAnim = nextAnim;
				}
			}
		}
		// Running animation if sad
		else if (currAnim.equals("sad")) {
			gw.petImage = Main.pet.getSadAnimList().get(animationNumber);
			gw.petView.setImage(gw.petImage);

			animationNumber++;
			lastFrameTime = now;

			if (animationNumber >= Main.pet.getSadAnimList().size()) {
				animationNumber = 0;

				if (!nextAnim.equals("sad")) {
					currAnim = nextAnim;
				}
			}
		}
		// Running animation if "going to sleep"/dying
		else if (currAnim.equals("death")) {
			gw.petImage = Main.pet.getDeathAnimList().get(animationNumber);
			gw.petView.setImage(gw.petImage);
			nextAnim = "ghost";

			animationNumber++;
			lastFrameTime = now;

			if (animationNumber >= Main.pet.getDeathAnimList().size()) {
				animationNumber = 0;

				currAnim = nextAnim;
			}
		}
		// Running animation if "sleeping"/ghost
		else if (currAnim.equals("ghost")) {
			gw.petImage = Main.pet.getGhostAnimList().get(animationNumber);
			gw.petView.setImage(gw.petImage);

			animationNumber++;
			lastFrameTime = now;

			if (animationNumber >= Main.pet.getGhostAnimList().size()) {
				animationNumber = 0;

				if (nextAnim.equals("revive")) {
					currAnim = "revive";
				} else {
					nextAnim = "ghost";
				}
			}
		}
		// Running animation if pet is to be revived
		else if (currAnim.equals("revive")) {
			int reverseIndex = Main.pet.getDeathAnimList().size() - 1;
			gw.petImage = Main.pet.getDeathAnimList().get(reverseIndex - animationNumber);
			gw.petView.setImage(gw.petImage);
			nextAnim = "idle";

			animationNumber++;
			lastFrameTime = now;

			if (animationNumber >= Main.pet.getGhostAnimList().size()) {
				animationNumber = 0;

				currAnim = nextAnim;
			}
		}
	}
}
