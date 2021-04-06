package application;

import java.util.*;
import java.io.*;

public class SaveUtility {
	static FileOutputStream saveFile;
	static PrintWriter pw;
	static Scanner scnr;

	public SaveUtility() {
		try {
			saveFile = new FileOutputStream("save.txt", true);
			pw = new PrintWriter(saveFile);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void save(GameWindow gw) {
		pw.append(String.format("%s,%s,%d,%d,%b\n", Main.pet.getPetType(), Main.pet.getPetName(), Main.pet.getHealthLevel(),
				Main.pet.getTimeOfLastExercise(), Main.pet.isSleeping()));
		pw.close();
	}

	// TODO
	public static Pet load() {
		Pet petToReturn;
		
		try {
			scnr = new Scanner(new File("save.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		while (scnr.hasNextLine()) {
			continue;
		}

		scnr.close();
		pw.close();

		String[] petParts = scnr.nextLine().split(",");

		if (petParts[0].equals("Corgi")) {
			petToReturn = new Corgi(petParts[1], Integer.parseInt(petParts[2]), Long.parseLong(petParts[3]),
					Boolean.parseBoolean(petParts[4]));
		} else {
			return null;
		}
		
		return petToReturn;
	}

	// TODO
	public static GameWindow newFile() {
		return null;
	}
}
