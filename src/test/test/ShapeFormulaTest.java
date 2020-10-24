package test;

import Service.ShapeService;
import Shape.Shape;
import Shapes.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ShapeFormulaTest {

    @Test
    public void testVolumeCalculation() {
        // Arrange

        double DELTA = 1e-15;
        Cone cone = new Cone("testCone", 40.20, 12.69);

        // Act

        double expected = Math.round (((double)1/3)* (Math.pow(cone.getRadius(), 2)*Math.PI)*cone.getHeight());
        double actual = cone.calculateVolume();

        // Assert

        assertEquals(actual, expected, DELTA);
        System.out.println("Volume from expected: " + expected + "\n" + "Volume from actual: " + actual);
    }
}
