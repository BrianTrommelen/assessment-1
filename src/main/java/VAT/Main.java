package VAT;

import Shape.ShapeActions;
import Shape.Shapes;
import javafx.application.Application;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class Main extends Application {

    private Shapes shapes;

    @Override
    public void init() {
        this.shapes = new ShapeActions();
        System.out.println(shapes.getAllShapes());
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("VAT Calculator");

        InputView shapesView = new InputView(shapes);

        TabPane layout = new TabPane();
        layout.setSide(Side.TOP);

        Tab addShape = new Tab("Add Shape:", shapesView.getView());
        layout.getTabs().add(addShape);

        layout.getSelectionModel().select(addShape);

        Scene view = new Scene(layout, 400, 400);
        stage.setScene(view);
        stage.show();
    }

    public static void main(String[] args) { launch(args); }
}