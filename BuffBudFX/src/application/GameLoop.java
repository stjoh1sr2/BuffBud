package application;

import javafx.animation.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;

public class GameLoop extends AnimationTimer {
	final long EXERCISE_TIME = 0l;
	GameWindow gw;
	long lastFrameTime;
	int animationNumber;
	String[] exerciseList = { "go on a walk", "do jumping jacks", "jog in place" };
	String lastExercise = "";
	static boolean exerciseFound = false;
	boolean animationDone = false;

	public GameLoop(GameWindow gw) {
		this.gw = gw;
		lastFrameTime = System.nanoTime();
		animationNumber = 0;
	}

	@Override
	public void handle(long now) {
		// Loops after 15 minutes since exercise (if 4.5*10^11)
		if (now - Main.pet.getTimeOfLastExercise() >= (long) (9 * Math.pow(10, 9 /* 11 */))
				&& (now - gw.exerciseTime >= (long) (9 * Math.pow(10, 9 /* 11 */)))) {
			if (!gw.exerciseActive && !exerciseFound) {
				// TODO: Send out push notification
				String currentExercise = randomExercise();
				gw.dialogue.setText("It's time to " + currentExercise + "!\nAre you ready to exercise?");
				gw.dialoguePane.setBottom(gw.answerPane);
			}
		}

		// Loop for when an exercise is going on (15 minutes if 4.5*10 ^ 11)
		if (now - gw.exerciseTime >= (long) (9 * Math.pow(10, 9 /* 11 */)) && gw.exerciseActive) {
			gw.dialogue.setText("Whew! 15 minutes is up. Did you complete the exercise?");
			gw.dialoguePane.setBottom(gw.answerPane);
			// TODO Reset to defaults?
			animationDone = true;
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
		if (gw.exerciseActive && animationDone) {
			gw.petImage = Main.pet.getWalkAnimList().get(animationNumber);
			gw.petView.setImage(gw.petImage);
			
			animationNumber++;
			lastFrameTime = now;
			
			// Reseting animation list if end of list is reached
			if (animationNumber >= Main.pet.getWalkAnimList().size()) {
				animationNumber = 0;
			}
		} else {
			gw.petImage = Main.pet.getIdleAnimList().get(animationNumber);
			gw.petView.setImage(gw.petImage);

			animationNumber++;
			lastFrameTime = now;

			// Reseting animation list if end of list is reached
			if (animationNumber >= Main.pet.getIdleAnimList().size()) {
				animationNumber = 0;
				
				if (gw.exerciseActive) {
					animationDone = true;
				}
			}
		}
	}

}
