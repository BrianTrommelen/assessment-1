package Shapes;

import Shape.Shape;
import Shape.Calculate;

public class Sphere extends Shape implements Calculate {
    private double radius;

    public Sphere(int id, String name, double radius) {
        super(id, name);
        this.shapeNum = 1;
        this.radius = radius;
    }

    @Override
    public int getShapeNum() {
        return shapeNum;
    }

    @Override
    public double getRadius() {
        return radius;
    }

    @Override
    public double calculateVolume() {
        double volume = (((double)1/3) + 1)*Math.PI*Math.pow(radius, 3);
        return volume;
    }

    @Override
    public String toString() {
        return "Sphere{" +
                "radius=" + radius +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
