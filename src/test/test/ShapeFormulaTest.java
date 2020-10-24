package test;

import Shapes.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShapeFormulaTest {

    @Test
    public void testVolumeCalculation() {
        // Arrange

        double DELTA = 1e-15;
        Cone cone = new Cone("testCone", 40.20, 12.69);

        // Act

        double expected = ((double)1/3)* (Math.pow(cone.getRadius(), 2)*Math.PI)*cone.getHeight();
        double actual = cone.calculateVolume();

        double formatted = Math.round(expected * 100d) / 100d;

        // Assert

        assertEquals(formatted, actual, DELTA);
        System.out.println("Volume from expected: " + formatted + "\n" + "Volume from actual: " + actual);
    }
}
