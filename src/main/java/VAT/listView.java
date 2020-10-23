package VAT;

import Shape.Shape;
import Shape.Shapes;
import Shapes.*;
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
            Label volume = new Label(String.format("%.2f", allShape.getVolume()));

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

                                Label nameText = new Label("Name:");
                                Label radiusText = new Label("Radius:");
                                Label heightText = new Label("Height:");
                                Label widthText = new Label("Width:");
                                Label lengthText = new Label("Length:");

                                TextField updateName = new TextField(allShape.getName());
                                TextField updateRadius = new TextField(Double.toString(allShape.getRadius()));
                                TextField updateHeight = new TextField(Double.toString(allShape.getHeight()));
                                TextField updateWidth = new TextField(Double.toString(allShape.getWidth()));
                                TextField updateLength = new TextField(Double.toString(allShape.getLength()));

                                Button updateButton = new Button("Update");
                                updateButton.setOnAction((e) -> {
                                    try {
                                        String name = updateName.getText();
                                        double radius = updateRadius.getText().isEmpty() ? 0 :
                                                Double.parseDouble(updateRadius.getText());
                                        double width = updateWidth.getText().isEmpty() ? 0 :
                                                Double.parseDouble(updateWidth.getText());
                                        double height = updateHeight.getText().isEmpty() ? 0 :
                                                Double.parseDouble(updateHeight.getText());
                                        double length = updateLength.getText().isEmpty() ? 0 :
                                                Double.parseDouble(updateLength.getText());

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
                                        stage.close();
                                    } catch (Exception error) {
                                        System.out.println("Error in updating shape\n" + error);
                                    }
                                });

                                Button deleteButton = new Button("Delete");
                                deleteButton.setOnAction(event -> {
                                    try {
                                        shapes.deleteShape(allShape.getId());
                                        stage.close();
                                    } catch (Exception error) {
                                        System.out.println("Error in deleting shape\n" + error);
                                    }
                                });

                                pane.add(nameText, 0, 0);
                                pane.add(updateName, 1, 0);

                                pane.add(radiusText, 0, 1);
                                pane.add(updateRadius, 1, 1);

                                pane.add(heightText, 0, 2);
                                pane.add(updateHeight, 1, 2);

                                pane.add(widthText, 0, 3);
                                pane.add(updateWidth, 1, 3);

                                pane.add(lengthText, 0, 4);
                                pane.add(updateLength, 1, 4);

                                pane.add(updateButton, 0, 5);
                                pane.add(deleteButton, 1, 5);

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
            gridPane.add(volume, 5, row);
        }
    }

}
