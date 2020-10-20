package VAT;


import Repository.ShapeDatabase;
import Service.ShapeService;

import Shapes.Cone;
import Shapes.Cylinder;
import Shapes.Cube;
import Shapes.Sphere;
import Shapes.Pyramid;


import Shape.Shape;
import Shape.ShapeActions;
import Shape.Shapes;
import javafx.application.Application;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

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

    public static void main(String[] args) {
//        launch(args);

// Create mew shapeService
        ShapeService shapeService = new ShapeService();


// DATABASE COMMANDS:

//      Create
//        Cube cube = new Cube( 0,"Naam" ,30, 20, 20);
//
//
//        System.out.println("Created: " + cube);
//        shapeService.create(cube);

//      Get all
//        System.out.println(shapeService.getAll());


//      Get by id
//        System.out.println(shapeService.getSingle(1).calculateVolume());
//        System.out.println("Get from database: " + shapeService.getSingle(1));

//      Update by id
//        shapeService.getAll();
//
//        Pyramid pr = new Pyramid(0,"Pyramid", 21, 42);
//        Sphere sphere = new Sphere(0,"Sphere", 21);

//        // Send new shape with info to replace shape of id.
//        shapeService.update(2, pr);
//        System.out.println("--------------------");
//        shapeService.getAll();


//      Delete by id
        // Delete shape with id
//        shapeService.deleteSingle(4);


//      Delete all from shape table
//        shapeService.deleteAll();
    }
}