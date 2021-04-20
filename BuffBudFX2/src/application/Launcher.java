package application;

/**
 * Launches the main class, but does not extend Application.
 */
public class Launcher {

	/**
	 * Calls the Main.main method to launch the program but in a class that does not
	 * extend javafx.Application.
	 * 
	 * @param args - The program arguments.
	 */
	public static void main(String[] args) {
		application.Main.main(args);
	}

}
