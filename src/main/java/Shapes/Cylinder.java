package Shapes;

import Shape.Shape;
import Shape.Calculate;

public class Cylinder extends Shape implements Calculate {
    private double radius;
    private double height;

    public Cylinder(int id, String name, double radius, double height, double volume) {
        super(id, name);
        this.shapeNum = 2;
        this.radius = radius;
        this.height = height;
        this.volume = volume;
    }

    public Cylinder(int id, String name, double radius, double height) {
        super(id, name);
        this.shapeNum = 2;
        this.radius = radius;
        this.height = height;
        this.volume = this.calculateVolume();
    }

    public Cylinder(String name, double radius, double height) {
        super(name);
        this.shapeNum = 2;
        this.radius = radius;
        this.height = height;
        this.volume = this.calculateVolume();
    }


    @Override
    public double getVolume() {
        return volume;
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
        double volume = Math.round ((radius*radius*Math.PI)*height);
        return (double)Math.round(volume * 100d) / 100d;
    }

    @Override
    public String toString() {
        return id + "-" + name + "-" + shapeNum + "-" + radius + "-" + height + "-" + volume;
    }
}
