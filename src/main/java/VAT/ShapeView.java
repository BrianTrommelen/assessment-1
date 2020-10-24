package VAT;

import Shape.Shape;
import Shape.Shapes;
import Shapes.*;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShapeView {
    private Shapes shapes;
    private final GridPane layout = new GridPane();
    private final List<TextField> textFields = new ArrayList<>();

    public ShapeView(Shapes shapes) {
        this.shapes = shapes;
    }

    public Parent getView() {
        VBox scrollContent = new VBox();
        ScrollPane scrollPane = new ScrollPane();
        scrollContent.setStyle("-fx-background-color: #e4e4e4; -fx-border-color: #e4e4e4;");
        scrollPane.setMaxHeight(250);

        // Set components
        Label nameText = new Label("Name:");
        TextField nameField = new TextField();

        Label radiusText = new Label("Radius:");
        TextField radiusField = new TextField();

        Label heightText = new Label("Height:");
        TextField heightField = new TextField();

        Label widthText = new Label("Width:");
        TextField widthField = new TextField();

        Label lengthText = new Label("Length:");
        TextField lengthField = new TextField();

        Button updateButton = new Button("Update");
        Button deleteButton = new Button("Delete");
        Button importButton = new Button("Import");
        Button exportButton = new Button("Export");

        textFields.add(nameField);
        textFields.add(radiusField);
        textFields.add(heightField);
        textFields.add(widthField);
        textFields.add(lengthField);

        for (int i = 0; i < textFields.size(); i++) {
            textFields.get(i).setEditable(false);
        }

        for (Shape allShape : shapes.getAllShapes()) {
            TextField name = new TextField(allShape.getName());
            name.setStyle("-fx-background-color: #e4e4e4; -fx-max-width: 340px; -fx-min-width: 340px;");
            name.setEditable(false);
            scrollContent.getChildren().add(name);
            scrollPane.setContent(scrollContent);

            name.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                        if (mouseEvent.getClickCount() == 2) {
                            for (int i = 0; i < textFields.size(); i++) {
                                textFields.get(i).setEditable(true);
                            }

                            nameField.setText(allShape.getName());
                            radiusField.setText(Double.toString(allShape.getRadius()));
                            heightField.setText(Double.toString(allShape.getHeight()));
                            widthField.setText(Double.toString(allShape.getWidth()));
                            lengthField.setText(Double.toString(allShape.getLength()));

                            TextField volume = new TextField(String.format("%.2f", allShape.getVolume()));
                            volume.setEditable(false);
                            volume.setStyle("-fx-background-color: #e4e4e4;");
                            layout.add(volume, 1, 5);

                            update(nameField, radiusField, heightField,
                                    widthField, lengthField, updateButton);

                            delete(allShape.getId(), deleteButton);
                        }
                    }
                }
            });
        }

        importButton.setOnAction(event -> {
            try {
                shapes.importShapes();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });

        exportButton.setOnAction(event -> {
            try {
                shapes.exportShapes();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        layout.add(nameText, 0, 0);
        layout.add(nameField, 1, 0);

        layout.add(radiusText, 0, 1);
        layout.add(radiusField, 1, 1);

        layout.add(heightText, 0, 2);
        layout.add(heightField, 1, 2);

        layout.add(widthText, 0, 3);
        layout.add(widthField, 1, 3);

        layout.add(lengthText, 0, 4);
        layout.add(lengthField, 1, 4);

        Label volumeText = new Label("Volume:");
        layout.add(volumeText, 0, 5, 1, 1);

        Label allVolumesText = new Label("Volume:");
        layout.add(allVolumesText, 0, 6, 1, 1);
        TextField allVolumes = new TextField(String.format("%.2f", shapes.calculateAllVolumes()));
        layout.add(allVolumes, 1, 6, 1, 1);
        allVolumes.setEditable(false);
        allVolumes.setStyle("-fx-background-color: #e4e4e4;");

        layout.add(updateButton, 3, 0, 1, 1);
        layout.add(deleteButton, 4, 0, 1, 1);
        layout.add(importButton, 3, 1, 1, 1);
        layout.add(exportButton, 4, 1, 1, 1);

        layout.add(scrollPane, 0, 8, 5, 1);

        layout.setPadding(new Insets(15, 15, 15, 15));
        layout.setHgap(10);
        layout.setVgap(10);
        return layout;
    }

    public void update(TextField nameField, TextField radiusField, TextField heightField,
                       TextField widthField, TextField lengthField, Button updateButton) {
        for (Shape allShape : shapes.getAllShapes()) {
            updateButton.setOnAction((e) -> {
                try {
                    String name = nameField.getText();
                    double radius = radiusField.getText().isEmpty() ? 0 :
                            Double.parseDouble(radiusField.getText());
                    double width = widthField.getText().isEmpty() ? 0 :
                            Double.parseDouble(widthField.getText());
                    double height = heightField.getText().isEmpty() ? 0 :
                            Double.parseDouble(heightField.getText());
                    double length = lengthField.getText().isEmpty() ? 0 :
                            Double.parseDouble(lengthField.getText());

                    if (allShape.getShapeNum() == 1) {
                        shapes.updateShape(allShape.getId(), new Sphere(name, radius));
                    }
                    if (allShape.getShapeNum() == 2) {
                        shapes.updateShape(allShape.getId(), new Cylinder(name, radius, height));
                    }
                    if (allShape.getShapeNum() == 3) {
                        shapes.updateShape(allShape.getId(), new Cone(name, radius, height));
                    }
                    if (allShape.getShapeNum() == 4) {
                        shapes.updateShape(allShape.getId(), new Pyramid(name, width, height));
                    }
                    if (allShape.getShapeNum() == 5) {
                        shapes.updateShape(allShape.getId(), new Cube(name, width, length, height));
                    }
                } catch (Exception error) {
                    System.out.println("Error in updating shape\n" + error);
                }
            });
        }
    }

    public void delete(int id, Button deleteButton) {
        deleteButton.setOnAction(event -> {
            try {
                shapes.deleteShape(id);
            } catch (Exception error) {
                System.out.println("Error in deleting shape\n" + error);
            }
        });
    }
}
