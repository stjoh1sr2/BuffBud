package application;

import java.io.*;
import java.util.*;

import javafx.stage.Stage;

/**
 * Contains useful saving and loading mechanisms.
 */
public class Utility {
	/**
	 * The directory the pet save file will be saved in.
	 */
	protected static String dirURL = System.getProperty("user.home") + "\\BuffBud\\Data";

	/**
	 * The full address of the Pet.txt file that contains save data.
	 */
	protected static String fileURL = dirURL + "\\Pet.txt";

	/**
	 * Creates the directory for the save file.
	 */
	protected static boolean fileCreate = new File(dirURL).mkdirs();

	/**
	 * Creates the save file Pet.txt to store pet save data.
	 */
	protected static File file = new File(fileURL);

	/**
	 * Reads the file and determines if pet data is existing in Pet.txt.
	 * 
	 * @return True if the save file has data, false if the save file does not have
	 *         pet data.
	 */
	public static boolean readFile() {
		// Reads in file.
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scanner sc = null;

		// Flags if the file is reachable.
		boolean fileReachable = false;

		/*
		 * If the file is empty then it will open the intro screen so the user can
		 * create a pet! if the file has something in it that means the user has created
		 * a pet and will open the application
		 */
		try {
			sc = new Scanner(file);
			fileReachable = true;
			if (sc.hasNextLine() == true) {
				return true;
			} else {
				return false;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (fileReachable) {
				sc.close();
			}
		}
		return false;

	}

	/**
	 * Saves the current pet data into the Pet.txt file.
	 */
	public static void save() {
		// Writes in file
		PrintWriter writer = null;

		try {

			writer = new PrintWriter(fileURL);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// Writes in file to save information about the pet
		writer.println(
				Main.pet.getPetName() + "," + Main.pet.getHealthLevel() + "," + Main.pet.getTimeOfLastExercise());
		writer.close();

	}

	/**
	 * Submits the Pet to the Main class for display from the IntroWindow.
	 * 
	 * @param stage - The stage to display the pet on.
	 */
	public static void submission(Stage stage) {
		// Saves and sets variables
		save();

		// Opens up main application after creating new pet
		GameWindow instance;
		instance = new GameWindow(stage);
		Main.loop = new GameLoop(instance);
		Main.loop.start();

	}

	/**
	 * Loads the pet to the main class based off of the pet data in the Pet.txt
	 * file.
	 * 
	 * @return the Pet to load into the main class.
	 */
	public static Pet loadPet() {
		Scanner scnr = null;

		// Flags if the file is readable
		boolean readable = false;

		try {
			scnr = new Scanner(file);
			readable = true;
			String[] petString = scnr.next().split(",");
			Corgi petToPass = new Corgi(petString[0], Integer.parseInt(petString[1]), Long.parseLong(petString[2]),
					false);
			scnr.close();
			return petToPass;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (readable) {
				scnr.close();
			}
		}

		return null;

	}
	
	/**
	 * Erases all pet data in the Pet.txt file.
	 */
	public static void clear() {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(fileURL);
		} catch (FileNotFoundException e) {
			System.err.println("An error has occurred - no Pet file found.");
		}
		writer.print("");
		writer.close();
	}

}
