package application;

import javafx.animation.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;

public class GameLoop extends AnimationTimer {
	GameWindow gw;
	long lastFrameTime;
	int animationNumber;
	String[] exerciseList = {"go on a walk", "do jumping jacks", "jog in place"};
	String lastExercise = "";

	public GameLoop(GameWindow gw) {
		this.gw = gw;
		lastFrameTime = System.nanoTime();
		animationNumber = 0;
	}

	@Override
	public void handle(long now) {
		// Loops after 15 minutes since exercise (if 4.5*10^11)
		if (now - gw.pet.getTimeOfLastExercise() >= (long)(9 * Math.pow(10, 9 /*11*/)) && (now - gw.exerciseTime >= (long)(9 * Math.pow(10, 9 /*11*/)))) {
			if (!gw.exerciseActive) {
				// TODO: Send out push notification
				String currentExcersize = randomExcersize();
				gw.dialogue.setText("It's time to " + currentExcersize + "!\nAre you ready to exercise?");
				gw.dialoguePane.setBottom(gw.answerPane);
			}
		}

		// Loop for when an exercise is going on (15 minutes if 4.5*10 ^ 11)
		if (now - gw.exerciseTime >= (long)(9 * Math.pow(10, 9 /*11*/)) && gw.exerciseActive) {
			gw.dialogue.setText("Whew! 15 minutes is up. Did you complete the exercise?");
			gw.dialoguePane.setBottom(gw.answerPane);
			// TODO Reset to defaults?
		}

		// Loops about 60 times per second (animation)
		if (now - lastFrameTime >= (long)(1.5 * Math.pow(10, 8))) {
			gw.petImage = gw.pet.getIdleAnimList().get(animationNumber);
			gw.petView.setImage(gw.petImage);

			animationNumber++;
			lastFrameTime = now;

			// Reseting animation list if end of list is reached
			if (animationNumber >= gw.pet.getIdleAnimList().size()) {
				animationNumber = 0;
			}
		}

		gw.healthLabel.setText("Health Level: " + gw.pet.getHealthLevel());
	}

	private String randomExcersize() {
		boolean exerciseFound = false;
		int i = (int) Math.random() * 3;

		while (!exerciseFound) {
			if (!exerciseList[i].equals(lastExercise)) {
				exerciseFound = true;
				return exerciseList[i];
			}
			else {
				i = (int) Math.random() * 3;
			}
		}

		return null;
	}

}
