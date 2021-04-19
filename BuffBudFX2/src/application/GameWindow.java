package application;

/**
 * Acts as the primary window for the BuffBud game.
 * Displays the pet, options to interact with the pet,
 * and messages about exercising.
 * 
 * UPDATED: 19 APR 2021
 */

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class GameWindow {
	boolean exerciseActive = false; // tells whether or not an exercise is ongoing
	boolean successfulExercise = false; // tells if an exercise was completed well
	long exerciseTime = 0; // placeholder for the time an exercise was started
	long timeOfFailure = 0; // placeholder for the time an exercise failed
	boolean toReset = false; // flags if the user has chosen to "Exit & Reset"
	long resetStart; // the time that a reset was originally flagged
	Stage stage;

	// For main overlay
	BorderPane mainPane = new BorderPane();
	Scene scene = new Scene(mainPane, 400, 600);

	Image backgroundImage = new Image(this.getClass().getResourceAsStream("/Images/bg2.png"));
	BackgroundImage bgImage = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT,
			BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
			new BackgroundSize(400, 600, false, false, false, false));

	// For top toolbar component
	Button exitButton = new Button("Save & Exit");
	Button saveButton = new Button("Save");
	Button resetButton = new Button("Exit & Reset");
	Label healthLabel = new Label("Health Level: " + Main.pet.getHealthLevel());

	// For center pet display
	Image petImage = Main.pet.getIdleAnimList().get(0);
	ImageView petView = new ImageView(petImage);

	// For bottom dialogue/text-entry
	TextArea dialogue = new TextArea("It's a great day to exercise! - " + Main.pet.getPetName());
	Button yesButton = new Button("Yes");
	Button noButton = new Button("No");
	HBox answerPane = new HBox(yesButton, noButton);
	BorderPane dialoguePane = new BorderPane();

	/**
	 * Creates the game window display
	 * 
	 */
	public GameWindow(Stage stage) {
		this.stage = stage;

		// Setting background of main GameWindow's main overlay
		mainPane.setBackground(new Background(bgImage));

		// Setting up top component of our main pane - action bar
		ToolBar toolBar = new ToolBar(saveButton, exitButton, resetButton, healthLabel);
		mainPane.setTop(toolBar);

		// Setting up center component of our main pane - pet display
		mainPane.setCenter(petView);
		mainPane.setMargin(petView, new Insets(250, 0, 0, 0));

		// Setting up bottom component of our main pane - dialogue box / text area
		yesButton.setMinWidth(200);
		noButton.setMinWidth(200);
		dialogue.setEditable(false);
		dialoguePane.setMaxHeight(80);
		dialoguePane.setCenter(dialogue);
		mainPane.setBottom(dialoguePane);

		// Getting window ready to display
		stage.setResizable(false);
		stage.setTitle("Buff Bud");
		stage.setScene(scene);
		stage.show();
		stage.getIcons().add(new Image(this.getClass().getResourceAsStream("/Images/BuffBudIcon.png")));

		// Setting up buttons in the action bar
		saveButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				Utility.save();
			}
		});
		exitButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				Utility.save();
				System.exit(0);
			}
		});
		resetButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				// Setting goodbye message
				dialogue.setText(String.format("Bye! - %s\nThe next time you launch, a new pet will await.",
						Main.pet.getPetName()));

				// Clearing out clickable buttons to prevent misclicks
				dialoguePane.setBottom(null);
				mainPane.setTop(null);

				// Reforming pet location relative to the overlay
				mainPane.setMargin(petView, new Insets(285, 0, 0, 0));

				// Flagging so that GameLoop can reset following time to display the goodbye
				// message
				toReset = true;
				resetStart = System.nanoTime();
			}
		});

		// Setting up yes/no buttons
		yesButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				// What happens if the exercise has started and the user is completing it
				if (exerciseActive) {
					Main.pet.exerciseSuccess();
					exerciseActive = false;

					// Setting thank-you message
					dialogue.setText("Great job! " + Main.pet.getPetName() + " appreciates this.");
					dialoguePane.setBottom(null);

					// Flagging for celebratory animation
					if (!Main.pet.isSleeping()) {
						Main.loop.nextAnim = "celeb";
					}
					successfulExercise = true;

					// Updating exerciseTime
					exerciseTime = System.nanoTime();
				}
				// What happens if the exercise is being started by the user
				else {
					exerciseTime = System.nanoTime();
					exerciseActive = true;

					// Flagging for walking animation
					if (!Main.pet.isSleeping()) {
						Main.loop.nextAnim = "walk";
					}

					// Setting good luck message and removing buttons
					dialogue.setText("Good luck!");
					dialoguePane.setBottom(null);
				}
			}
		});
		noButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				Main.pet.exerciseFailure();
				exerciseActive = false;

				// Flagging for sad animation
				Main.loop.nextAnim = "sad";

				timeOfFailure = System.nanoTime();

				// Setting out failure message
				dialogue.setText("That's too bad..." + Main.pet.getPetName() + " is disappointed.");
				dialoguePane.setBottom(null);

				exerciseTime = System.nanoTime();
				Main.loop.exerciseFound = false;
			}
		});
	}

}
