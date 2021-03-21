package application;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	

	@Override
	public void start(Stage stage) throws Exception {
		GameWindow instance = new GameWindow(stage);
		GameLoop loop = new GameLoop(instance);
		loop.start();
	}
	
	public static void main(String[] args) {
		launch();
	}
}
