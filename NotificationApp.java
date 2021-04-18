package application;

import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.animation.*;
import javafx.application.Application;
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

public class NotificationApp extends Application {

	//create buttons
	private Button windowButton, ignoreButton;
	
	//background
	Image notificationBackground = new Image("file:///Users/lisaliang/CPS240/MyNewBuffBud/src/application/BackgroundNotification.png");
	BackgroundImage notificationBI = new BackgroundImage(notificationBackground, BackgroundRepeat.NO_REPEAT,
			BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
			new BackgroundSize(450, 250, false, false, false, false));
	
	//image 
	Image corgiImage = new Image("file:///Users/lisaliang/CPS240/MyNewBuffBud/src/application/testCorgi.png");
	ImageView corgiIcon = new ImageView(corgiImage);
	
	//time in between notification
	long minutes;
	long seconds;
	long milliseconds;

  @Override
  public void start(Stage primaryStage) throws Exception {
	  
	  //ask user to input the amount of minutes (testing purposes)
	  //try to access one set up in IntroWindow
	  Scanner inputTime = new Scanner(System.in);
	  System.out.print("Enter minutes between workout: ");
	  minutes = inputTime.nextLong();
	  
	  //converting minutes to milliseconds
		if(minutes > 0)
			milliseconds = minutes*60000;
		else
			System.out.println("Error: Invalid Input");
	  
	  //button options for notification window
	  windowButton = new Button("Go to App");
	  ignoreButton = new Button("Ignore");
	  
	  //setting the style of buttons
	  windowButton.setStyle("-fx-background-color: #44a62b; -fx-text-fill: #ffffff; -fx-border-color: #000000; -fx-border-width: 2px;");
	  ignoreButton.setStyle("-fx-background-color: #b32b0c; -fx-text-fill: #ffffff; -fx-border-color: #000000; -fx-border-width: 2px;");
	  //setting button sizes
	  windowButton.setPrefSize(225, 20);
	  ignoreButton.setPrefSize(225, 20);
	  
	  //open the application
	  windowButton.setOnAction(e -> {
		  //temporary 
		  IntroWindow intro = new IntroWindow(primaryStage); });

	  //closes the application
	  //how to make it so the pet will lose health if you press this button?
	  ignoreButton.setOnAction(e -> {
		  primaryStage.close(); });
	  
	  //layout
	  GridPane notificationButtons = new GridPane();
	  VBox notificationBox = new VBox();
	  
	  //set size of corgIcon in the center
	  corgiIcon.setFitHeight(150);
	  corgiIcon.setFitWidth(150);
	    
	  //adding buttons to notificationPane to be on one row
	  notificationButtons.addRow(0, windowButton, ignoreButton);
	  
	  //create scene to show the application window
	  Scene scene = new Scene(notificationBox, 450, 250);
	 
	  //setting background of window
	  notificationBox.setBackground(new Background(notificationBI));
	  
	  //creating a Text object
	  Text exerciseText = new Text("Time to Exercise!");
	  
	  //setting the font to the text
	  exerciseText.setFont(Font.font("impact", FontWeight.BOLD, FontPosture.REGULAR, 40));
	  //setting the color
	  exerciseText.setFill(Color.SKYBLUE);
	  //setting the stroke (border)
	  exerciseText.setStrokeWidth(2);
	  //setting the stroke color
	  exerciseText.setStroke(Color.NAVY);
	  
	  //calling helper createBlink to have new message pop up
	  Timeline blinker = createBlink(exerciseText);
	  
	  //call the name from IntroWindow
	  blinker.setOnFinished(exerciseEvent -> exerciseText.setText("Your bud is waiting for you!"));
	  //text will show, then blinker will make it disappear into new message
	  SequentialTransition blinkNewMessage = new SequentialTransition(exerciseText, blinker);
	  
	  //adding components to notificationBox window
	  notificationBox.getChildren().add(corgiIcon);
	  notificationBox.getChildren().add(exerciseText);
	  notificationBox.setAlignment(Pos.CENTER);
	  notificationBox.setPadding(new Insets(0, 0, 0, 0));
	  notificationBox.getChildren().add(notificationButtons);
	  notificationBox.setAlignment(Pos.BOTTOM_CENTER);

	  primaryStage.setScene(scene);
	  primaryStage.setTitle("Buff Bud Notification");
	  primaryStage.setResizable(false);
	  primaryStage.setAlwaysOnTop(true);
	    
	    //message will blink to new one
	    blinkNewMessage.play();
	    
	    //simulating notification
	    //notificaiton window will pop up after entered minutes
    Timeline notificationTime = new Timeline(new KeyFrame(Duration.millis(milliseconds), event -> {
	    primaryStage.show(); }));
    
    //Timeline will activated
    notificationTime.play();
  }
  
  //helper
  //method to have the text show then disappear after a few seconds to a new message
  private Timeline createBlink(Node node) {
     seconds = minutes * 60;
	 Timeline blink = new Timeline(new KeyFrame(Duration.seconds(seconds + 2),
                      			new KeyValue(node.opacityProperty(), 1, Interpolator.DISCRETE)
              ),
              new KeyFrame(Duration.seconds(2), new KeyValue(node.opacityProperty(), 0, Interpolator.DISCRETE)
              ),
              new KeyFrame(Duration.seconds(3), new KeyValue(node.opacityProperty(), 1, Interpolator.DISCRETE) ) 
              );
      blink.setCycleCount(1);
      return blink;
  }
  
  public static void main(String[] args) {
	    launch(args);
	  }
}