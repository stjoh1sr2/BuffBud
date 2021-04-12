package application;

import java.io.*;
import java.util.*;

import javafx.stage.Stage;

public class Utility {

	public static boolean readFile() {
		// Reads in file
		File file = new File("resources/Pet.txt");
		Scanner sc = null;

		/**
		 * If the file is empty then it will open the intro screen so the user can create a pet!
		 * if the file has something in it that means the user has created a pet and will open the application
		 **/
		
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

	public static void save() {
		// Writes in file
		/**
		 * Does not work because of protected image variable in pet class
		 * ObjectOutputStream out = new ObjectOutputStream(new
		 * FileOutputStream("Pet.txt")); out.writeObject(pet);
		 **/

		PrintWriter writer = null;

		try {

			writer = new PrintWriter("resources/Pet.txt");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// Writes in file to save information about the pet
		writer.println(Main.pet.getPetName() + "," + Main.pet.getHealthLevel() + "," + Main.pet.getTimeOfLastExercise());
		writer.close();

	}
	
	public static Pet loadPet() throws FileNotFoundException {
		Scanner scnr = new Scanner(new File("resources/Pet.txt"));
		String[] petString = scnr.next().split(",");
		Corgi petToPass = new Corgi(petString[0], Integer.parseInt(petString[1]), Long.parseLong(petString[2]), false /*TODO*/);
		
		return petToPass;
	}

}
