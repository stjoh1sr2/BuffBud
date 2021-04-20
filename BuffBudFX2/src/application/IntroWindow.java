package application;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.*;

/**
 * Creates the introduction window when creating a new pet for the BuffBud
 * application.
 */
public class IntroWindow {
	/**
	 * For setting the order of text in the introduction.
	 */
	private int count = 0;

	/**
	 * The new pet to be created.
	 */
	public static Pet pet = new Corgi(null);

	/**
	 * The layout for the introductory screen.
	 */
	BorderPane intro = new BorderPane();

	/**
	 * The scene for the introductory screen.
	 */
	Scene introScene = new Scene(intro, 400, 600);

	// Intro Components - Text including fonts and textfields
	/**
	 * The text field for user input.
	 */
	TextField nameTF = new TextField();

	/**
	 * The text displaying messages to the user.
	 */
	Text text = new Text(30.0, 30.0, "This is your new workout buddy!");

	/**
	 * The text display asking for the name of the pet.
	 */
	Text nameText = new Text("Pet Name: ");

	/**
	 * The font used on the upper part of the introduction window.
	 */
	Font textFont = Font.font("Times New Roman", FontWeight.BOLD, 50);

	/**
	 * The font used on the lower part of the introduction window.
	 */
	Font petFont = Font.font("Times New Roman", FontWeight.BOLD, 25);

	// Intro Components - Images
	/**
	 * Image of the puppy used in the intro window.
	 */
	Image puppy = new Image(this.getClass().getResourceAsStream("/Images/Corgi/corgiIdle0.png"), 200, 200, true, false);

	/**
	 * Background of the intro screen as an image.
	 */
	Image bg = new Image(this.getClass().getResourceAsStream("/Images/IntroScreen.png"));

	/**
	 * The view of the puppy image for the intro.
	 */
	ImageView puppyView = new ImageView(puppy);

	// Intro Components - Controls
	/**
	 * Button for moving to the next portion of the intro.
	 */
	Button nextButton = new Button("Next");

	/**
	 * Button for submitting the pet.
	 */
	Button submitButton = new Button("Submit");

	/**
	 * The toolbar holding name submission information.
	 */
	ToolBar tb = new ToolBar(nameText, nameTF, submitButton);

	// Intro Components - Background
	/**
	 * The view for the background image for the intro.
	 */
	BackgroundImage introBgImage = new BackgroundImage(bg, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
			BackgroundPosition.CENTER, new BackgroundSize(400, 600, false, false, false, false));

	/**
	 * A constructor displaying the introduction sequence for new pets.
	 * 
	 * @param stage - The main stage for displaying the intro window.
	 */
	public IntroWindow(Stage stage) {

		// Setting up Interface.
		intro.setBackground(new Background(introBgImage));
		intro.setBottom(nextButton);
		intro.setCenter(puppyView);
		intro.setTop(text);
		BorderPane.setMargin(puppyView, new Insets(100, 0, 0, 0));
		BorderPane.setAlignment(nextButton, Pos.BOTTOM_RIGHT);
		stage.getIcons().add(new Image(this.getClass().getResourceAsStream("/Images/BuffBudIcon.png")));

		// Setting up fonts.
		text.setFont(textFont);
		text.setTextAlignment(TextAlignment.CENTER);
		text.setWrappingWidth(400);
		nameText.setFont(petFont);

		// Setting up next button.
		nextButton.setOnAction(e -> {
			switch (count) {
			case 0:
				text.setText("They are going to help you work out everyday!");
				break;
			case 1:
				intro.setBottom(tb);
				text.setText("What would you like to name your new friend?");
				break;
			}
			count++;
		});

		// Keyboard for pet name.
		nameTF.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent ke) {
				if (ke.getCode().equals(KeyCode.ENTER)) {
					Main.pet.setPetName(nameTF.getText());
					Utility.submission(stage);
				}
			}
		});

		// Setting up submit button.
		submitButton.setOnAction(e -> {
			Main.pet.setPetName(nameTF.getText());
			Utility.submission(stage);
		});

		// Display settings.
		stage.setResizable(false);
		stage.setTitle("Buff Bud");
		stage.setScene(introScene);
		stage.show();

	}

}