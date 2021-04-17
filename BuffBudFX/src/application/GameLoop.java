package application;

import javafx.animation.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;

public class GameLoop extends AnimationTimer {
	final long EXERCISE_TIME = (long) (9 * Math.pow(10, 9 /* 11 */));
	GameWindow gw;
	long lastFrameTime;
	int animationNumber;
	String[] exerciseList = { "go on a walk", "do jumping jacks", "jog in place" };
	String lastExercise = "";
	boolean exerciseFound = false;
	boolean animationDone = false;
	protected String nextAnim = "idle";
	protected String currAnim = "idle";

	public GameLoop(GameWindow gw) {
		this.gw = gw;
		lastFrameTime = System.nanoTime();
		animationNumber = 0;
	}

	@Override
	public void handle(long now) {
		// Loops after EXERCISE_TIME nanoseconds since exercise
		if (now - Main.pet.getTimeOfLastExercise() >= EXERCISE_TIME && (now - gw.exerciseTime >= EXERCISE_TIME)
				&& !gw.toReset) {
			if (!gw.exerciseActive && !exerciseFound) {
				// TODO: Send out push notification
				String currentExercise = randomExercise();
				gw.dialogue.setText("It's time to " + currentExercise + "!\nAre you ready to exercise?");
				gw.dialoguePane.setBottom(gw.answerPane);
			}
		}

		// Loop for when an exercise is going on
		if (now - gw.exerciseTime >= EXERCISE_TIME && gw.exerciseActive && !gw.toReset) {
			gw.dialogue.setText("Whew! 5 seconds is up. Did you complete the exercise?"); // TODO
			gw.dialoguePane.setBottom(gw.answerPane);
			// TODO Reset to defaults?
			animationDone = true;
			exerciseFound = false;
			if (!Main.pet.isSleeping()) {
				nextAnim = "idle";
			} else {
				// TODO: nextAnim = "revive";
			}
		}

		// Limiting celeb animation
		if (now - gw.exerciseTime >= (long) (EXERCISE_TIME / 3) && (currAnim.equals("celeb")) && !Main.pet.isSleeping()) {
			nextAnim = "idle";
		}

		// Limiting sad animation
		if (now - gw.timeOfFailure >= (long) (EXERCISE_TIME / 1.5) && (currAnim.equals("sad")) && !Main.pet.isSleeping()) {
			nextAnim = "idle";
		}

		// Sending out reset message
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

		// Setting condition to bring ghost pet back to life
		if (Main.pet.isSleeping() && Main.pet.getHealthLevel() > 15) {
			Main.pet.setSleeping(false);
			nextAnim = "revive";
		}

		// Loops about 60 times per second (animation)
		if (now - lastFrameTime >= (long) (1.5 * Math.pow(10, 8))) {
			runAnimation(now);
		}

		gw.healthLabel.setText("Health Level: " + Main.pet.getHealthLevel());
	}

	private String randomExercise() {
		exerciseFound = false;
		int i = (int) (Math.random() * 3);

		while (!exerciseFound) {
			if (!exerciseList[i].equals(lastExercise)) {
				exerciseFound = true;
				return exerciseList[i];
			} else {
				i = (int) (Math.random() * 3);
			}
		}

		return null;
	}

	private void runAnimation(long now) {
		//System.out.println(currAnim + " -> " + nextAnim + ": " +
		//		animationNumber + ", " + Thread.currentThread()); // TODO: REMOVE
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
		} else if (currAnim.equals("idle")) {
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
		} else if (currAnim.equals("celeb")) {
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
		} else if (currAnim.equals("sad")) {
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
		} else if (currAnim.equals("death")) { // TODO: REMOVE????
			gw.petImage = Main.pet.getDeathAnimList().get(animationNumber);
			gw.petView.setImage(gw.petImage);
			nextAnim = "ghost";

			animationNumber++;
			lastFrameTime = now;

			if (animationNumber >= Main.pet.getDeathAnimList().size()) {
				animationNumber = 0;

				currAnim = nextAnim;
			}
		} else if (currAnim.equals("ghost")) { // TODO: REMOVE????
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
		} else if (currAnim.equals("revive")) { // TODO: REMOVE????
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
