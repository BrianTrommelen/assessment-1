package VAT;

import Shape.Shape;
import Shape.Shapes;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class listView {
    private Shapes shapes;
    private int row = 1;

    public listView(Shapes shapes) { this.shapes = shapes; }

    public Node getView() {
        ListView<Shape> shapeListView = new ListView<>();

        // Create components
        GridPane components = new GridPane();

        Label nameTitle = new Label("Name");
        Label radiusTitle = new Label("Radius");
        Label widthTitle = new Label("Width");
        Label heightTitle = new Label("Height");
        Label lengthTitle = new Label("Length");

        components.add(nameTitle, 0, row);
        components.add(widthTitle, 1, row);
        components.add(heightTitle, 2, row);
        components.add(radiusTitle, 3, row);
        components.add(lengthTitle, 4, row);

        setComponents(components);

        components.setPadding(new Insets(15, 15, 15, 15));
        components.setHgap(15);
        components.setVgap(15);
        return components;
    }

    public void setComponents(GridPane gridPane) {
        for (Shape allShape : shapes.getAllShapes()) {
            row++;
            Label name = new Label(allShape.getName());
            Label radius = new Label(String.valueOf(allShape.getRadius()));
            Label width = new Label(String.valueOf(allShape.getWidth()));
            Label height = new Label(String.valueOf(allShape.getHeight()));
            Label length = new Label(String.valueOf(allShape.getLength()));

            gridPane.add(name, 0, row);
            gridPane.add(width, 1, row);
            gridPane.add(height, 2, row);
            gridPane.add(radius, 3, row);
            gridPane.add(length, 4, row);
        }
    }
}
