package VAT;

import Shape.Shape;
import Shape.Shapes;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class listView {
    private Shapes shapes;
    private int row = 0;

    public listView(Shapes shapes) {
        this.shapes = shapes;
    }

    public Node getView() {
        ListView<Shape> shapeListView = new ListView<>();

        // Create components
        GridPane components = new GridPane();
        ScrollPane scrollPane = new ScrollPane();

        setComponents(components);

        scrollPane.setContent(components);
        scrollPane.setFitToWidth(true);

        components.setPadding(new Insets(0, 15, 0, 15));
        components.setHgap(15);
        components.setVgap(15);
        return scrollPane;
    }

    public void setComponents(GridPane gridPane) {
        for (Shape allShape : shapes.getAllShapes()) {
            row++;
            Label name = new Label(allShape.getName());

            name.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                        if (mouseEvent.getClickCount() == 2) {

                            if (name != null) {
                                GridPane pane = new GridPane();
                                Scene scene = new Scene(pane, 400, 400);
                                Stage stage = new Stage();
                                stage.setScene(scene);

                                TextField updateName = new TextField(allShape.getName());
                                TextField updateRadius = new TextField(Double.toString(allShape.getRadius()));
                                TextField updateHeight = new TextField(Double.toString(allShape.getHeight()));
                                TextField updateWidth = new TextField(Double.toString(allShape.getWidth()));
                                TextField updateLength = new TextField(Double.toString(allShape.getLength()));

                                Button updateButton = new Button("Update");
                                updateEvent(updateButton);

                                pane.add(updateName, 1, 0);
                                pane.add(updateRadius, 1, 1);
                                pane.add(updateHeight, 1, 2);
                                pane.add(updateWidth, 1, 3);
                                pane.add(updateLength, 1, 4);
                                pane.add(updateButton, 1, 5);

                                pane.setPadding(new Insets(15, 15, 15, 15));
                                pane.setHgap(10);
                                pane.setVgap(10);
                                stage.show();
                            }

                        }
                    }
                }
            });

            gridPane.add(name, 0, row);
        }
    }

    public void updateEvent(Button addButton) {
        addButton.setOnAction((e) -> {
            if (this.shapes.getUsableShapes().get(0) == "Sphere") {
                shapes.searchShape(0);
            }

            if (this.shapes.getUsableShapes().get(1) == "Cylinder") {
                shapes.searchShape(0);
            }

            if (this.shapes.getUsableShapes().get(2) == "Cone") {
                shapes.searchShape(0);
            }

            if (this.shapes.getUsableShapes().get(3) == "Pyramid") {
                shapes.searchShape(0);
            }

            if (this.shapes.getUsableShapes().get(4) == "Cube") {
                shapes.searchShape(0);
            }

        });
    }
}
