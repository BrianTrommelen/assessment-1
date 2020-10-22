package test;

import Service.ShapeService;
import Shape.Shape;
import Shapes.Sphere;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CrudTest {

    @Test
    public void testCreate() {
        // Arrange

        Sphere expected1 = new Sphere("testSphere", 21.6);
        ShapeService shapeService = new ShapeService();

        // Act
        shapeService.create(expected1);

        Shape actual1 = shapeService.getSingle(20);


        // Assert
        assertEquals(expected1, actual1);

        //TODO functie get shape by name
    }
}
