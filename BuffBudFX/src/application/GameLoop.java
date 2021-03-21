package application;

import javafx.animation.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;

public class GameLoop extends AnimationTimer {
	GameWindow gw;
	long lastFrameTime;
	int animationNumber;
	
	public GameLoop(GameWindow gw) {
		this.gw = gw;
		lastFrameTime = System.nanoTime();
		animationNumber = 0;
	}
	
	@Override
	public void handle(long now) {
		if (now - gw.pet.getTimeOfLastExcersize() >= (long)(5 * Math.pow(10, 9))) {
			gw.dialogue.setText("It's been five seconds!");
			gw.dialoguePane.getChildren().setAll(gw.dialogue);
			// TODO: Send out push notification
		}
		
		// TODO: Animate
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
		
		// System.out.println(now - gw.pet.getTimeOfLastExcersize());
		
		// gw.healthLabel.setText("Health Level: " + gw.pet.getHealthLevel());
	}
	
	
}
