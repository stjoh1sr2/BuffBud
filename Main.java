package application;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		// If readFile returns false, set up new pet else open up already created pet
		if (Utility.readFile() == false) {
			IntroWindow intro = new IntroWindow(stage);
		} else if (Utility.readFile() == true) {
			GameWindow instance = new GameWindow(stage);
			GameLoop loop = new GameLoop(instance);
			loop.start();
		}
	}

	public static void main(String[] args) {
		launch();
	}
}