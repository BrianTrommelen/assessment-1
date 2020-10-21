package VAT;

import Shape.Shapes;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    private final Shapes shapes;
    private final ComboBox<Object> usableShapes = new ComboBox<>();
    private final List<TextField> textFields = new ArrayList<>();

    public InputView(Shapes shapes) { this.shapes = shapes; }

    public Parent getView() {
        // Create components
        GridPane components = new GridPane();

        // Shapes that can be chosen
        usableShapes.getItems().addAll(this.shapes.getAllShapes());
        usableShapes.setValue("Choose shape");

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

        textFields.add(nameField);
        textFields.add(radiusField);
        textFields.add(heightField);
        textFields.add(widthField);
        textFields.add(lengthField);

        // Set by default everything on false
        setEditableForAllFieldsOnFalse();

        // Add save button
        Button addButton = new Button("Add shape!");

        // Write a event that tracks the chosen shape
        usableShapes.setOnAction(event -> showFields(nameField, radiusField,
                heightField, widthField, lengthField));

        // Event for the save button
        addButton.setOnAction((e) -> {
        });

        // Set default components in the right position
        components.add(usableShapes, 0, 0);

        components.add(nameText, 0, 1);
        components.add(nameField, 1, 1);

        components.add(radiusText, 0, 2);
        components.add(radiusField, 1, 2);

        components.add(heightText, 0, 3);
        components.add(heightField, 1, 3);

        components.add(widthText, 0, 4);
        components.add(widthField, 1, 4);

        components.add(lengthText, 0, 5);
        components.add(lengthField, 1, 5);

        components.add(addButton, 0, 6);

        components.setHgap(10);
        components.setVgap(10);
        components.setPadding(new Insets(10, 10, 10, 10));

        return components;
    }

    private void showFields(TextField nameField, TextField radiusField,
                            TextField heightField, TextField widthField, TextField lengthField) {

        System.out.println(usableShapes.getValue());

        // Name changeable on every shape
        showHideField(nameField, true);

        if (usableShapes.getSelectionModel().getSelectedItem().equals(this.shapes.getShapeById(1))) {
            showHideField(radiusField, true);
            showHideField(heightField, false);
            showHideField(widthField, false);
            showHideField(lengthField, false);
        } else if (usableShapes.getSelectionModel().getSelectedItem().equals(this.shapes.getShapeById(2))) {
            showHideField(radiusField, true);
            showHideField(heightField, true);
            showHideField(widthField, false);
            showHideField(lengthField, false);
        } else if (usableShapes.getSelectionModel().getSelectedItem().equals(this.shapes.getShapeById(3))) {
            showHideField(radiusField, true);
            showHideField(heightField, true);
            showHideField(widthField, false);
            showHideField(lengthField, false);
        } else if (usableShapes.getSelectionModel().getSelectedItem().equals(this.shapes.getShapeById(4))) {
            showHideField(radiusField, false);
            showHideField(heightField, true);
            showHideField(widthField, true);
            showHideField(lengthField, false);
        } else if (usableShapes.getSelectionModel().getSelectedItem().equals(this.shapes.getShapeById(5))) {
            showHideField(radiusField, false);
            showHideField(heightField, true);
            showHideField(widthField, true);
            showHideField(lengthField, true);
        }
    }

    public void showHideField(TextField textField, boolean showOrHide) {
        textField.setEditable(showOrHide);

        if (!showOrHide) {
            textField.setStyle("-fx-background-color: #e4e4e4;");
        } else {
            textField.setStyle("-fx-background-color: #fff;");
        }
    }

    public void setEditableForAllFieldsOnFalse() {
        for (TextField textfield : textFields) {
            textfield.setEditable(false);
            textfield.setStyle("-fx-background-color: #e4e4e4;");
        }
    }
}
