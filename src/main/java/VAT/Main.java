package VAT;

import Shape.ShapeActions;
import Shape.Shapes;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private Shapes shapes;

    @Override
    public void init() throws IOException {
        this.shapes = new ShapeActions();
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("VAT Calculator");

        InputView inputView = new InputView(shapes);
        ShapeView shapeView = new ShapeView(shapes);

        TabPane layout = new TabPane();

        Tab addShape = new Tab("Add Shape:", inputView.getView());
        Tab shapeList = new Tab("Shapes:", shapeView.getView());

        layout.getTabs().add(addShape);
        layout.getTabs().add(shapeList);

        Scene view = new Scene(layout, 400, 500);
        stage.setScene(view);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}