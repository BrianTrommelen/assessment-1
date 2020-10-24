package test;

import Service.ShapeService;
import Shape.Shape;
import Shapes.Cylinder;
import Shapes.Sphere;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CrudTest {

    @Test
    public void testRead() {
        // Arrange
        ShapeService shapeService = new ShapeService();

        // Act

        Sphere actual = new Sphere("testSphere", 21.6);
        shapeService.create(actual);


        // Assert

        assertNotNull(shapeService.getSingleByName("testSphere"));
        System.out.println("found: " + shapeService.getSingleByName("testSphere"));
    }

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
        System.out.println("Get shape returns:" + shapeService.getSingleByName(create.getName()));
    }

    @Test
    public void testCreate() {
        // Arrange

        Sphere expected = new Sphere("testSphere", 22.6);
        ShapeService shapeService = new ShapeService();

        // Act

        shapeService.create(expected);
        Shape actual = shapeService.getSingleByName(expected.getName());


        // Assert

        assertEquals(expected, actual);
        System.out.println(expected + "\n Equals: \n" + actual);
        shapeService.deleteSingleFromName(actual.getName());
    }

    @Test
    public void testUpdate() {
        // Arrange

        double DELTA = 1e-15;
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
        Shape actual = shapeService.getSingleByName("testCylinder");

        // Assert

        assertEquals(expected.getVolume(), actual.getVolume(), DELTA);
        System.out.println("Old volume before update: " + create.getName()+ " with volume: " + create.getVolume()
                + "\n" + expected.getName() + " with volume: " + expected.getVolume()
                + "\n Equals: \n" + actual.getName() + " with volume: " + actual.getVolume());
        shapeService.deleteSingleFromName(actual.getName());
    }
}
