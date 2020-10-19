package VAT;

import Shape.Shape;
import Shape.Shapes;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class InputView {
    private Shapes shapes;

    public InputView(Shapes shapes) { this.shapes = shapes; }

    public Parent getView() {
        // Create components
        GridPane components = new GridPane();

        // Shapes that can be chosen
        ComboBox comboBox = new ComboBox();
        comboBox.getItems().addAll("Sphere", "Cylinder", "Cone", "Pyramid", "Cube");
        comboBox.setValue("Choose your shape here");

        // Set components
        Label nameText = new Label("name:");
        TextField nameField = new TextField();

        Label radiusText = new Label("Radius:");
        TextField radiusField = new TextField();

        Label heightText = new Label("Height:");
        TextField heightField = new TextField();

        Label widthText = new Label("Width:");
        TextField widthField = new TextField();

        // Add save button
        Button addButton = new Button("Add shape!");

        // Display the current shape
        Label chosenShape = new Label();

        // Write a event that tracks the chosen shape
        comboBox.setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent event) {
                chosenShape.setText("Chosen shape: " + comboBox.getValue());

                if (comboBox.getValue() == "Sphere") {
                    System.out.println("Sphere");
                    heightField.setEditable(false);
                    widthField.setEditable(false);
                } else {
                    heightField.setEditable(true);
                    widthField.setEditable(true);
                }

                if (comboBox.getValue() == "Cylinder") {
                    System.out.println("Cylinder");
                    radiusField.setEditable(false);
                } else {
                    radiusField.setEditable(true);
                }

                if (comboBox.getValue() == "Cone") {
                    System.out.println("Cone");
                    widthField.setEditable(false);
                } else {
                    widthField.setEditable(true);
                }

                if (comboBox.getValue() == "Pyramid") {
                    System.out.println("Pyramid");
                    radiusField.setEditable(false);
                } else {
                    radiusField.setEditable(true);
                }

                if (comboBox.getValue() == "Cube") {
                    System.out.println("Cube");
                    radiusField.setEditable(false);
                } else {
                    radiusField.setEditable(true);
                }
            }
        });

        // Event for the save button
        addButton.setOnAction((e) -> {
            String name = nameField.getText();
            shapes.saveShape(new Shape(name));
            nameField.clear();
        });

        // Set default components in the right position
        components.add(comboBox, 0, 0);
        components.add(chosenShape, 0, 2);

        components.add(nameText, 0, 3);
        components.add(nameField, 1, 3);

        components.add(radiusText, 0, 4);
        components.add(radiusField, 1, 4);

        components.add(heightText, 0, 5);
        components.add(heightField, 1, 5);

        components.add(widthText, 0, 6);
        components.add(widthField, 1, 6);

        components.add(addButton, 0, 7);

        components.setHgap(10);
        components.setVgap(10);
        components.setPadding(new Insets(10, 10, 10, 10));

        return components;
    }
}
