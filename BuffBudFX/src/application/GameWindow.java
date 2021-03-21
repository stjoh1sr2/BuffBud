package application;

import java.io.FileNotFoundException;

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
	Pet pet = new Corgi("Steven");
	
	// For main overlay
	BorderPane mainPane = new BorderPane();
	Scene scene = new Scene(mainPane, 400, 600);
	
	Image backgroundImage = new Image("file:Images/bg2.png");
	BackgroundImage bgImage = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
			BackgroundPosition.CENTER, new BackgroundSize(400, 600, false, false, false, false));

	// For top toolbar component
	Button exitButton = new Button("Save & Exit");
	Button saveButton = new Button("Save");
	Label healthLabel = new Label("Health Level: ");

	// For center pet display
	Image petImage = pet.getIdleAnimList().get(0);
	ImageView petView = new ImageView(petImage);

	// For bottom dialogue/text-entry
	TextArea dialogue = new TextArea("It's a great day to exercise! - " + pet.getPetName());
	StackPane dialoguePane = new StackPane();
	

	/**
	 * Creates the game window display
	 * @throws FileNotFoundException 
	 * @throws InterruptedException 
	 */
	public GameWindow(Stage stage) throws FileNotFoundException, InterruptedException {
		mainPane.setBackground(new Background(bgImage));
		
		// Setting up top component of our main pane - action bar
		ToolBar toolBar = new ToolBar(exitButton, saveButton, healthLabel);
		mainPane.setTop(toolBar);

		// Setting up center component of our main pane - pet display
		mainPane.setCenter(petView);
		mainPane.setMargin(petView, new Insets(280, 0, 0, 0));

		// Setting up bottom component of our main pane - dialogue box / text area
		dialogue.setEditable(false);
		dialoguePane.setMaxHeight(80);
		dialoguePane.getChildren().setAll(dialogue);
		mainPane.setBottom(dialoguePane);

		// Getting window ready to display
		stage.setResizable(false);
		stage.setTitle("Buff Bud");
		stage.setScene(scene);
		stage.show();
	}
	
	// TODO: Implement Save Feature
	public static void save() {
		
	}
}
