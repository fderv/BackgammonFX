package Game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    private static final String APPLICATION_TITLE = "BACKGAMMON";
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("game.fxml"));

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle(APPLICATION_TITLE);
        primaryStage.show();
    }

    public static void main(String[] args) { launch(args); }

    //CONSTANTS
    public static final int POINT_HEIGHT = 200;
    public static final int POINT_WIDTH = 42;
    public static final int CHECKER_RADIUS = 20;
    public static final int BAR_X = 294;
    public static final int WHITEBAR_Y = 250;
    public static final int BROWNBAR_Y = 158;
    public static final int BAR_SIDE = 42;
}
