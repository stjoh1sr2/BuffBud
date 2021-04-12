package application;

import java.io.FileNotFoundException;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GameWindow {
	SaveUtility su = new SaveUtility();
	boolean exerciseActive = false;
	boolean successfulExercise = false;
	long exerciseTime = 0;
	
	// For main overlay
	BorderPane mainPane = new BorderPane();
	Scene scene = new Scene(mainPane, 400, 600);
	
	Image backgroundImage = new Image("file:resources/Images/bg2.png");
	BackgroundImage bgImage = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
			BackgroundPosition.CENTER, new BackgroundSize(400, 600, false, false, false, false));

	// For top toolbar component
	Button exitButton = new Button("Save & Exit");
	Button saveButton = new Button("Save");
	Button resetButton = new Button("Reset Pet");
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
	 * @throws FileNotFoundException 
	 * @throws InterruptedException 
	 */
	public GameWindow(Stage stage) throws FileNotFoundException, InterruptedException {
		GameWindow saveWindow = this;
		
		mainPane.setBackground(new Background(bgImage));
		
		// Setting up top component of our main pane - action bar
		ToolBar toolBar = new ToolBar(exitButton, saveButton, resetButton, healthLabel);
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
		stage.getIcons().add(new Image("file:resources/Images/BuffBudIcon.png"));
		
		// Setting up buttons in the action bar
		saveButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				Utility.save();
				//dialogue.setText("Thanks for saving!");
				//dialoguePane.getChildren().setAll(dialogue);
			}
		});
		exitButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				Utility.save();
				dialogue.setText("Thanks for saving! See you soon!");
				dialoguePane.getChildren().setAll(dialogue);
				System.exit(0);
			}
		});
		resetButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				IntroWindow intro = new IntroWindow(stage);
				Main.pet = intro.pet;
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
					
					dialogue.setText("Great job! " + Main.pet.getPetName() + " appreciates this.");
					dialoguePane.setBottom(null);
					
					exerciseTime = System.nanoTime();
				} 
				// What happens if the exercise is being started by the user
				else {
					exerciseTime = System.nanoTime();
					exerciseActive = true;
					
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
					
					dialogue.setText("That's too bad..." + Main.pet.getPetName() + " is disappointed.");
					dialoguePane.setBottom(null);
					
					exerciseTime = System.nanoTime();
					GameLoop.exerciseFound = false;
			}
		});
	}
	
}
