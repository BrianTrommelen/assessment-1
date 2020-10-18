package VAT;

import VAT.repository.ShapeDatabase;
//import javafx.application.Application;
//import javafx.scene.Scene;
//import javafx.scene.layout.BorderPane;
//import javafx.stage.Stage;

import VAT.service.ShapeService;

import java.util.List;

public class Main {


//    @Override
//    public void start(Stage stage) {
//        stage.setTitle("Hello World");
//        BorderPane layout = new BorderPane();
//        Scene view = new Scene(layout, 300, 275);
//        stage.setScene(view);
//        stage.show();
//    }

    public static void main(String[] args) {
//        launch(args);
        ShapeDatabase shapeDatabase = new ShapeDatabase();

        ShapeService shapeService = new ShapeService(shapeDatabase);

// DATABASE COMMANDS:

//      Create
        Shape shape = new Shape("Orb");
        System.out.println("Created: " + shape);
        shapeService.create(shape);

//      Get all
        shapeService.getAll();

//      Get where id
//        System.out.println("Get from database: " + shapeService.getSingle(1));

//      Update by id
//        shapeService.getAll();
//        Shape old = shapeService.getSingle(8);
//        Shape toUpdate = shapeService.getSingle(8);
//        toUpdate.setName("Heart");
//        // Send new shape with info to replace shape of id.
//        shapeService.update(8, toUpdate);
//        System.out.println("--------------------");
//        shapeService.getAll();
//
//        System.out.println("Updated: " + old + " To: " + toUpdate);


//      Delete by id
//        shapeService.getAll();
//        // Delete shape with id
//        shapeService.deleteSingle(8);
//        System.out.println("--------------------");
//        shapeService.getAll();

//      Delete all from shape table
//        shapeService.deleteAll();
    }
}