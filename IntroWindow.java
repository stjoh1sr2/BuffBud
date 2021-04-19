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

public class IntroWindow {
	private int count = 0;
	public static Pet pet = new Corgi(null);

	// Introductory screen
	BorderPane intro = new BorderPane();
	Scene introScene = new Scene(intro, 400, 600);

	// Intro Components - Text including fonts and textfields
	TextField nameTF = new TextField();
	Text text = new Text(30.0, 30.0, "This is your new workout buddy!");
	Text nameText = new Text("Pet Name: ");
	Font textFont = Font.font("Times New Roman", FontWeight.BOLD, 50);
	Font petFont = Font.font("Times New Roman", FontWeight.BOLD, 25);

	// Intro Components - Images
	Image puppy = new Image("file:resources/Images/Corgi/corgiIdle0.png", 200, 200, true, false);
	Image bg = new Image("file:resources/Images/IntroScreen.png");
	ImageView puppyView = new ImageView(puppy);

	// Intro Components - Controls
	Button nextButton = new Button("Next");
	Button submitButton = new Button("Submit");
	ToolBar tb = new ToolBar(nameText, nameTF, submitButton);

	// Intro Components - Background
	BackgroundImage introBgImage = new BackgroundImage(bg, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
			BackgroundPosition.CENTER, new BackgroundSize(400, 600, false, false, false, false));

	public IntroWindow(Stage stage) {

		// Setting up Interface
		intro.setBackground(new Background(introBgImage));
		intro.setBottom(nextButton);
		intro.setCenter(puppyView);
		intro.setTop(text);
		BorderPane.setMargin(puppyView, new Insets(100, 0, 0, 0));
		BorderPane.setAlignment(nextButton, Pos.BOTTOM_RIGHT);

		// Setting up fonts
		text.setFont(textFont);
		text.setTextAlignment(TextAlignment.CENTER);
		text.setWrappingWidth(400);
		nameText.setFont(petFont);

		// Setting up next button
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

		// Keyboard for pet name
		nameTF.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent ke) {
				if (ke.getCode().equals(KeyCode.ENTER)) {
					Main.pet.setPetName(nameTF.getText());
					Utility.submission(stage);
				}
			}
		});

		// Setting up submit button
		submitButton.setOnAction(e -> {
			Main.pet.setPetName(nameTF.getText());
			Utility.submission(stage);
		});

		// Display settings
		stage.setResizable(false);
		stage.setTitle("Buff Bud");
		stage.setScene(introScene);
		stage.show();

	}

}
