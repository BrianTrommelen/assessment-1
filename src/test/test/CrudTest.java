package test;

import Service.ShapeService;
import Shape.Shape;
import Shapes.Cylinder;
import Shapes.Sphere;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CrudTest {

    @Test
    public void testDelete() {
        // Arrange
        ShapeService shapeService = new ShapeService();

        Sphere create = new Sphere("testSphere", 21.6);
        Shape actual = null;

        // Act

        shapeService.create(create);
        shapeService.deleteSingleFromName(create.getName());

        // Assert

        assertEquals(shapeService.getSingleByName(create.getName()), actual);
    }

    @Test
    public void testCreate() {
        // Arrange

        Sphere expected = new Sphere("testSphere", 21.6);
        ShapeService shapeService = new ShapeService();

        // Act

        shapeService.create(expected);
        Shape actual = shapeService.getSingleByName(expected.getName());


        // Assert

        assertEquals(expected, actual);
        shapeService.deleteSingleFromName(actual.getName());
    }

    @Test
    public void testUpdate() {
        // Arrange

        Cylinder create = new Cylinder("testCylinder", 21.6, 10.5);
        ShapeService shapeService = new ShapeService();
        shapeService.create(create);

        // Act

        // Get created record from database
        Shape toUpdate = shapeService.getSingleByName(create.getName());
        // update/replace shape
        Cylinder update = new Cylinder(toUpdate.getName(), 22.1, 15.2);
        shapeService.update(toUpdate.getId(), update);

        // Create expected
        Cylinder expected = new Cylinder(toUpdate.getId(), "testCylinder",22.1, 15.2);

        // Get updated result from database
        Shape actual = shapeService.getSingleByName(create.getName());

        // Assert

        assertEquals(expected, actual);
        shapeService.deleteSingleFromName(actual.getName());
    }
}
