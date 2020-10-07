package VAT;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Hello World");
        BorderPane layout = new BorderPane();
        Scene view = new Scene(layout, 300, 275);
        stage.setScene(view);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
