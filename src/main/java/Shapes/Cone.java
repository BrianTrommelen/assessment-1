package Shapes;

import Shape.Shape;
import Shape.Calculate;

public class Cone extends Shape implements Calculate {
    private double radius;
    private double height;

    public Cone(int id, String name, double radius, double height) {
        super(id,name);
        this.shapeNum = 3;
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
        double volume = ((double)1/3)* (Math.pow(radius, 2)*Math.PI)*height;
        return volume;
    }

    @Override
    public String toString() {
        return "Cone{" +
                "radius=" + radius +
                ", height=" + height +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
