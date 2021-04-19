package application;

import java.io.*;
import java.util.*;

import javafx.stage.Stage;

public class Utility {
	static String dirURL = System.getProperty("user.home") + "\\BuffBud\\Data";
	static String fileURL = dirURL + "\\Pet.txt";
	static boolean fileCreate = new File(dirURL).mkdirs();
	static File file = new File(fileURL);

	public static boolean readFile() {
		// Reads in file
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scanner sc = null;
		boolean fileReachable = false;

		/**
		 * If the file is empty then it will open the intro screen so the user can
		 * create a pet! if the file has something in it that means the user has created
		 * a pet and will open the application
		 **/

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

	public static void save() {
		// Writes in file
		/**
		 * Does not work because of protected image variable in pet class
		 * ObjectOutputStream out = new ObjectOutputStream(new
		 * FileOutputStream("Pet.txt")); out.writeObject(pet);
		 **/

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
	
	// Submission of pet name
		public static void submission(Stage stage) {
			save(); // Saves and sets variables

			// Opens up main application after creating new pet
			GameWindow instance;
			instance = new GameWindow(stage);
			Main.loop = new GameLoop(instance);
			Main.loop.start();

		}

	public static Pet loadPet() {
		Scanner scnr = null;
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
