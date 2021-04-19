package application;

import java.io.*;
import java.util.*;

import javafx.stage.Stage;

public class Utility {
	private static File file = new File("resources/Pet.txt");

	// Reads in file
	public static boolean readFile() {
		/**
		 * If the file is empty then it will open the intro screen so the user can
		 * create a pet! if the file has something in it that means the user has created
		 * a pet and will open the application
		 **/

		Scanner sc = null;

		try {
			sc = new Scanner(file);
			if (sc.hasNextLine() == true) {
				return true;
			} else {
				return false;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}

		return false;

	}

	// Writes in file
	public static void save() {
		/**
		 * Does not work because of protected image variable in pet class
		 * ObjectOutputStream out = new ObjectOutputStream(new
		 * FileOutputStream("Pet.txt")); out.writeObject(pet);
		 **/

		PrintWriter writer = null;

		try {

			writer = new PrintWriter(file);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// Writes in file to save information about the pet
		writer.println(
				Main.pet.getPetName() + "," + Main.pet.getHealthLevel() + "," + Main.pet.getTimeOfLastExercise());
		writer.close();

	}

	// Submission of pet name
	public static void submission(Stage stage) {
		save(); // Saves and sets variables

		// Opens up main application after creating new pet
		GameWindow instance;
		try {
			instance = new GameWindow(stage);
			GameLoop loop = new GameLoop(instance);
			loop.start();
		} catch (FileNotFoundException | InterruptedException e1) {
			e1.printStackTrace();
		}

	}

	// Clears file
	public static void clearPet() {
		Scanner scnr = null;
		PrintWriter writer = null;

		try {
			scnr = new Scanner(file);
			writer = new PrintWriter(file);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		writer.print("");
		Main.pet.equals(null);
	}

	// Loads in pet to create pet object
	public static Pet loadPet() throws FileNotFoundException {
		Scanner scnr = new Scanner(new File("resources/Pet.txt"));
		String[] petString = scnr.next().split(",");
		Corgi petToPass = new Corgi(petString[0], Integer.parseInt(petString[1]), Long.parseLong(petString[2]),
				false /* TODO */);

		return petToPass;
	}

}
