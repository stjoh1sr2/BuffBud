import javafx.application.Application;
import javafx.stage.Stage;

public class Test extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		GameWindow instance = new GameWindow();
		instance.createGame(stage);

	}

	public static void main(String[] args) {
		launch();
	}

}
