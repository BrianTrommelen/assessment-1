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

        // get shapes from database to show in list.

//      Create
//        Shape shape = new Shape("Orb");
//        System.out.println("Created: " + shape);
//        shapeService.create(shape);

//      Get all
//        shapeService.getAll();

//      Get where id
//        System.out.println("Get from database: " + shapeService.getSingle(1));

//      Update by id
        shapeService.getAll();
        Shape old = shapeService.getSingle(7);
        Shape toUpdate = shapeService.getSingle(7);
        toUpdate.setName("nee");
        // Send new shape with info to replace shape of id.
        shapeService.update(7, toUpdate);
        System.out.println("--------------------");
        shapeService.getAll();

        System.out.println("Updated: " + old + " To: " + toUpdate);

    }
}