package application;

import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class Main extends Application {
	static Pet pet = null;
	static GameLoop loop;

	@Override
	public void start(Stage stage) throws Exception {
		// If readFile returns false, set up new pet else open up already created pet
		if (Utility.readFile() == false) {
			IntroWindow intro = new IntroWindow(stage);
			this.pet = IntroWindow.pet;
		} else if (Utility.readFile() == true) {
			this.pet = Utility.loadPet();
			GameWindow instance = new GameWindow(stage);
			loop = new GameLoop(instance);
			loop.start();
		}
		
	}

	public static void main(String[] args) {
		launch();
	}
}
