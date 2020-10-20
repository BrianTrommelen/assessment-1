package Shapes;

import Shape.Shape;
import Shape.Calculate;

public class Cylinder extends Shape implements Calculate {
    private double radius;
    private double height;

    public Cylinder(int id, String name, double radius, double height) {
        super(id, name);
        this.shapeNum = 2;
        this.radius = radius;
        this.height = height;
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
    public double getHeight() {
        return height;
    }

    @Override
    public double calculateVolume() {
        double volume = (radius*radius*Math.PI)*height;
        return volume;
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "radius=" + radius +
                ", height=" + height +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
