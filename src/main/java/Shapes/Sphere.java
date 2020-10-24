package Shapes;

import Shape.Shape;
import Shape.Calculate;

public class Sphere extends Shape implements Calculate {
    private double radius;

    public Sphere(int id, String name, double radius, double volume) {
        super(id, name);
        this.shapeNum = 1;
        this.radius = radius;
        this.volume = volume;
    }
    public Sphere(int id, String name, double radius) {
        super(id, name);
        this.shapeNum = 1;
        this.radius = radius;
        this.volume = this.calculateVolume();
    }

    public Sphere(String name, double radius) {
        super(name);
        this.shapeNum = 1;
        this.radius = radius;
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
    public double calculateVolume() {
        double volume = (((double)1/3) + 1)*Math.PI*Math.pow(radius, 3);
        return (double)Math.round(volume * 100d) / 100d;
    }

    @Override
    public String toString() {
        return id + "-" + name + "-" + shapeNum + "-" + radius + "-" + volume;
    }
}
