package application;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;

import javafx.stage.Stage;

public class Utility {
	static boolean fileCreate = new File("C:\\BuffBud\\Data").mkdirs();
	static File file = new File("C:\\BuffBud\\Data\\Pet.txt");

	public static boolean readFile() throws IOException, URISyntaxException {
		// Reads in file
		file.createNewFile();
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
		} finally {
			if (fileReachable) {
				sc.close();
			}
		}
		
		
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

			writer = new PrintWriter("C:\\BuffBud\\Data\\Pet.txt");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// Writes in file to save information about the pet
		writer.println(
				Main.pet.getPetName() + "," + Main.pet.getHealthLevel() + "," + Main.pet.getTimeOfLastExercise());
		writer.close();

	}

	public static Pet loadPet() throws FileNotFoundException, URISyntaxException {
		Scanner scnr = new Scanner(file);
		String[] petString = scnr.next().split(",");
		Corgi petToPass = new Corgi(petString[0], Integer.parseInt(petString[1]), Long.parseLong(petString[2]),
				false);
		scnr.close();
		
		return petToPass;
	}

	public static void clear() throws URISyntaxException {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter("C:\\BuffBud\\Data\\Pet.txt");
		} catch (FileNotFoundException e) {
			System.err.println("An error has occurred - no Pet file found.");
		}
		writer.print("");
		writer.close();
	}

}
