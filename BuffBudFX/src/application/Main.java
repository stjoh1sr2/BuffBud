package application;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	static Pet pet = new Corgi("Steven");

	@Override
	public void start(Stage stage) throws Exception {
		SaveUtility su = new SaveUtility();
		GameWindow instance = new GameWindow(stage);
		GameLoop loop = new GameLoop(instance);
		loop.start();
	}
	
	public static void main(String[] args) {
		launch();
	}
}
