package application;

import javafx.animation.*;
import javafx.geometry.*;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Creates an notification window when the user needs to be alerted that their
 * pet requires attention.
 */
public class NotificationApp {
	/**
	 * The main stage used by the GameWindow class.
	 */
	protected Stage gwStage;

	/**
	 * The clickable button that redirects the user to the main GameWindow.
	 */
	private Button windowButton;

	/**
	 * The clickable button that users choose to ignore their pet.
	 */
	private Button ignoreButton;

	/**
	 * The background image for the notification.
	 */
	private Image notificationBackground = new Image(
			this.getClass().getResourceAsStream("/Images/BackgroundNotification.png"));

	/**
	 * The background image applied to the notification via the BackgroundImage
	 * class.
	 */
	private BackgroundImage notificationBI = new BackgroundImage(notificationBackground, BackgroundRepeat.NO_REPEAT,
			BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
			new BackgroundSize(450, 250, false, false, false, false));

	/**
	 * The underlying image of a corgi for the notification window.
	 */
	private Image corgiImage = new Image(this.getClass().getResourceAsStream("/Images/testCorgi.png"));

	/**
	 * The view of the image of a corgi for display in the notification window.
	 */
	private ImageView corgiIcon = new ImageView(corgiImage);

	/**
	 * The time in-between notifications in minutes.
	 */
	protected double minutes;

	/**
	 * The time in-between notifications in seconds.
	 */
	protected long seconds;

	/**
	 * The time in-between notifications in milliseconds.
	 */
	protected long milliseconds;

	/**
	 * Initializes the Notification popup.
	 * 
	 * @param stage - The main stage from GameWindow.
	 */
	public NotificationApp(Stage stage) {
		// Setting the GameWindow stage as the main stage passed.
		this.gwStage = stage;
		Stage primaryStage = new Stage();

		// Putting in minutes between notifications.
		minutes = 0.2; // TODO

		// Converting minutes to milliseconds.
		if (minutes > 0)
			milliseconds = (long) (minutes * 60000);
		else
			System.out.println("Error: Invalid Input");

		// Creating button options for notification window.
		windowButton = new Button("Go to App");
		ignoreButton = new Button("Ignore");

		// Setting the style of buttons.
		windowButton.setStyle(
				"-fx-background-color: #44a62b; -fx-text-fill: #ffffff; -fx-border-color: #000000; -fx-border-width: 2px;");
		ignoreButton.setStyle(
				"-fx-background-color: #b32b0c; -fx-text-fill: #ffffff; -fx-border-color: #000000; -fx-border-width: 2px;");
		// Setting button sizes.
		windowButton.setPrefSize(225, 20);
		ignoreButton.setPrefSize(225, 20);

		// Opening the application if the user chooses to go to window.
		windowButton.setOnAction(e -> {
			gwStage.setIconified(false);
			gwStage.requestFocus();
			primaryStage.close();
		});

		// Closes the notification and hurts the pet if the user ignores them.
		ignoreButton.setOnAction(e -> {
			Main.pet.exerciseFailure();
			Main.loop.nextAnim = "sad";
			primaryStage.close();
		});

		// Creating panes to configure the GUI layout.
		GridPane notificationButtons = new GridPane();
		VBox notificationBox = new VBox();

		// Setting size of corgiIcon in the center.
		corgiIcon.setFitHeight(150);
		corgiIcon.setFitWidth(150);

		// Adding buttons to notificationPane to be on one row.
		notificationButtons.addRow(0, windowButton, ignoreButton);

		// Creating scene to show the application window.
		Scene scene = new Scene(notificationBox, 450, 250);

		// Setting background of the window.
		notificationBox.setBackground(new Background(notificationBI));

		// Creating a Text object displaying a message.
		Text exerciseText = new Text("Time to Exercise!");

		// Setting the font to the text.
		exerciseText.setFont(Font.font("impact", FontWeight.BOLD, FontPosture.REGULAR, 40));
		// Setting the color.
		exerciseText.setFill(Color.SKYBLUE);
		// Setting the stroke (border).
		exerciseText.setStrokeWidth(2);
		// Setting the stroke color.
		exerciseText.setStroke(Color.NAVY);

		// Calling helper createBlink to have new message pop up.
		Timeline blinker = createBlink(exerciseText);

		// Calling the name from IntroWindow.
		blinker.setOnFinished(exerciseEvent -> exerciseText.setText("Your bud is waiting for you!"));
		// Text will show, then blinker will make it disappear into new message.
		SequentialTransition blinkNewMessage = new SequentialTransition(exerciseText, blinker);

		// Adding components to notificationBox window.
		notificationBox.getChildren().add(corgiIcon);
		notificationBox.getChildren().add(exerciseText);
		notificationBox.setAlignment(Pos.CENTER);
		notificationBox.setPadding(new Insets(0, 0, 0, 0));
		notificationBox.getChildren().add(notificationButtons);
		notificationBox.setAlignment(Pos.BOTTOM_CENTER);

		// Configuring window settings for notification window.
		primaryStage.setScene(scene);
		primaryStage.setTitle("Buff Bud Notification");
		primaryStage.setResizable(false);
		primaryStage.setAlwaysOnTop(true);
		primaryStage.getIcons().add(new Image(this.getClass().getResourceAsStream("/Images/BuffBudIcon.png")));

		// Message will blink to new one.
		blinkNewMessage.play();

		// Simulating notification.
		// The notification window will pop up after set minutes.
		Timeline notificationTime = new Timeline(new KeyFrame(Duration.millis(milliseconds), event -> {
			if (!gwStage.isFocused() && !Main.loop.equals(null)) {
				primaryStage.show();
			}
		}));

		// Activating the timeline.
		notificationTime.setCycleCount(Animation.INDEFINITE);
		notificationTime.play();
	}

	/**
	 * Acts as a helper method creating a timeline.
	 * 
	 * @param node - The Text to display with the notification.
	 * @return The Timeline used for the notification
	 */
	private Timeline createBlink(Node node) {
		seconds = (long) (minutes * 60);
		Timeline blink = new Timeline(
				new KeyFrame(Duration.seconds(seconds + 2),
						new KeyValue(node.opacityProperty(), 1, Interpolator.DISCRETE)),
				new KeyFrame(Duration.seconds(2), new KeyValue(node.opacityProperty(), 0, Interpolator.DISCRETE)),
				new KeyFrame(Duration.seconds(3), new KeyValue(node.opacityProperty(), 1, Interpolator.DISCRETE)));
		blink.setCycleCount(1);
		return blink;
	}
}