package Shapes;

import Shape.Shape;
import Shape.Calculate;

public class Cube extends Shape implements Calculate {
    private double width;
    private double length;
    private double height;

    public Cube(int id, String name, double width, double length, double height) {
        super(id, name);
        this.shapeNum = 5;
        this.width = width;
        this.length = length;
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
    public double getWidth() {
        return width;
    }

    @Override
    public double getLength() {
        return length;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double calculateVolume() {
        double volume = Math.round (width*length*height);
        return (double)Math.round(volume * 100d) / 100d;
    }

    @Override
    public String toString() {
        return "Cube{" +
                "width=" + width +
                ", length=" + length +
                ", height=" + height +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", shapeNum=" + shapeNum +
                ", volume=" + volume +
                '}';
    }
}
