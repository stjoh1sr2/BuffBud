import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Test extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		Label l = new Label("I am a pet."); // TODO: REMOVE? UNUSED

		// Setting up GUI Display
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
		Button petButton = new Button();
		bp.setCenter(imgview);
		//bp.setAlignment(imgview, Pos.BOTTOM_CENTER);
		bp.setMargin(imgview, new Insets(150, 0, 0, 0));
		
		/*
		bp.setCenter(petButton);
		petButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (!(petButton.getText().equals("You clicked the pet button.")))
					petButton.setText("You clicked the pet button.");
				else
					petButton.setText("Pet goes here?");
			}
		});
		*/

		// ImageView imageView = new ImageView(img);
		// stage.getIcons().add(new Image("file:TestIcon.png")); TODO: Fix, doesn't work
		
		// Setting up exit button
		Button exit = new Button("Exit");
		exit.setOnAction(new EventHandler<ActionEvent> () {
			@Override
			public void handle(ActionEvent event) {
				System.exit(0);
			}
		});
		
		// Setting up ToolBar
		ToolBar topbar = new ToolBar(exit, new Button("Save"));
		bp.setTop(topbar);

		stage.setTitle("Buff Bud");
		stage.setScene(scene);
		stage.show();

	}

	public static void main(String[] args) {
		launch();
	}

}
