import java.io.*;

import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class GameWindow {

	public void createGame(Stage stage) throws FileNotFoundException {
		// Setting up main BorderPane display
		BorderPane bp = new BorderPane();
		Scene scene = new Scene(bp, 500, 600);
		stage.setResizable(false);

		// Setting up background image
		Image img = new Image(new FileInputStream("background_image.png"));
		BackgroundImage bgImage = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.DEFAULT, new BackgroundSize(2.3, 1.0, true, true, false, false));
		bp.setBackground(new Background(bgImage));

		// Setting up center panel (pet)
		Image corgiIdle = new Corgi("Placeholder").getCorgiIdle();
		ImageView imgview = new ImageView(corgiIdle);
		// Button petButton = new Button("Testing button.");
		bp.setCenter(imgview);
		// bp.setAlignment(imgview, Pos.BOTTOM_CENTER);
		bp.setMargin(imgview, new Insets(150, 0, 0, 0));

		/*
		 * bp.setTop(petButton); petButton.setOnAction(new EventHandler<ActionEvent>() {
		 * 
		 * @Override public void handle(ActionEvent event) { if
		 * (!(petButton.getText().equals("You clicked the pet button.")))
		 * petButton.setText("You clicked the pet button."); else
		 * petButton.setText("Testing button"); } });
		 */

		// ImageView imageView = new ImageView(img);
		// stage.getIcons().add(new Image("file:TestIcon.png")); TODO: Fix, doesn't work

		// Setting up bottom part - dialogue
		TextArea dialogue = new TextArea();
		dialogue.setEditable(false);
		dialogue.setText("This will be where the dialogue goes?");
		dialogue.shapeProperty();
		dialogue.setPrefHeight(20.);
		bp.setBottom(dialogue);

		// Setting up exit button
		Button exit = new Button("Exit");
		exit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.exit(0);
			}
		});
		
		// Setting up ToolBar
		Label healthTxt = new Label("Health: ");
		Image healthBar_img = new Image("file:concepthealth.png");
		ImageView healthBar = new ImageView(healthBar_img);
		healthBar.setFitWidth(100);
		healthBar.setFitHeight(20);
		ToolBar topbar = new ToolBar(exit, new Button("Save"), healthTxt, healthBar);
		bp.setTop(topbar);
		
		// Setting up icon
		stage.getIcons().add(new Image("file:barbell.png"));

		stage.setTitle("Buff Bud");
		stage.setScene(scene);
		stage.show();
	}
}
