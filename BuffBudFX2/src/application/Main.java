
package application;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Ties together the BuffBud application by instantiating windows and loops and
 * deciding whether to continue with a pre-existing pet or create a new one.
 */
public class Main extends Application {
	/**
	 * The current pet for use in the app.
	 */
	static protected Pet pet = null;

	/**
	 * The loop used for the current app.
	 */
	static protected GameLoop loop;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void start(Stage stage) {
		// If readFile returns false, set up new pet else open up already created pet.
		if (Utility.readFile() == false) {
			IntroWindow intro = new IntroWindow(stage);
			this.pet = IntroWindow.pet;
		} else if (Utility.readFile() == true) {
			this.pet = Utility.loadPet();
			GameWindow instance = new GameWindow(stage);
			loop = new GameLoop(instance);
			loop.start();
		}
		
		// Instantiating the notification window.
		NotificationApp na = new NotificationApp(stage);

	}
	
	/**
	 * Launches the main program.
	 * @param args - The program arguments.
	 */
	public static void main(String[] args) {
		launch();
	}
}
