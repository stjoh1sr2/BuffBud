package application;
	
import java.awt.Font;
import java.awt.Insets;
import java.awt.Label;
import java.awt.TextField;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class Main extends Application {
	
		@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane grid = new BorderPane();
			grid.setTop(grid);
			grid.setBottom(grid);
			grid.setLeft(grid);
			grid.setRight(grid);
			grid.setCenter(grid);
			
//			grid.getAlignment(grid);		
////			grid.getAlignment(Pos.CENTER);
//			grid.setTop(10);
////			grid.setHgap(10);
////			grid.setVgap(10);
//			grid.setPadding(new Insets(25, 25, 25, 25));

//			Scene scene = new Scene(grid, 300, 275);
//			primaryStage.setScene(scene);
//			
//			Text scenetitle = new Text("Welcome");
//			scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
//			grid.add(scenetitle, 0, 0, 2, 1);
//
//			Label userName = new Label("User Name:");
//			grid.add(userName, 0, 1);
//
//			TextField userTextField = new TextField();
//			grid.add(userTextField, 1, 1);
//
//			Label pw = new Label("Password:");
//			grid.add(pw, 0, 2);
//
//			PasswordField pwBox = new PasswordField();
//			grid.add(pwBox, 1, 2);
			
			Scene scene = new Scene(grid);
			
			primaryStage.setTitle("JavaFX Welcome");
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();	} }
	
	public static void main(String[] args) {
		launch(args);
	}
}
	
	//	@Override
//	public void start(Stage primaryStage) {
//		try {
//			BorderPane root = new BorderPane();
//			Scene scene = new Scene(root,400,400);
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//			primaryStage.setScene(scene);
//			primaryStage.show();
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public static void main(String[] args) {
//		launch(args);
//	}
//}