package Shapes;

import Shape.Shape;
import Shape.Calculate;

public class Pyramid extends Shape implements Calculate {
    private double width;
    private double height;

    public Pyramid(int id, String name, double width, double height, double volume) {
        super(id, name);
        this.shapeNum = 4;
        this.width = width;
        this.height = height;
        this.volume = volume;
    }

    public Pyramid(int id, String name, double width, double height) {
        super(id, name);
        this.shapeNum = 4;
        this.width = width;
        this.height = height;
        this.volume = this.calculateVolume();
    }

    public Pyramid(String name, double width, double height) {
        super( name);
        this.shapeNum = 4;
        this.width = width;
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
    public double getHeight() {
        return height;
    }

    @Override
    public double calculateVolume() {
        double volume = Math.round (((double) 1/3 )*Math.pow(width, 2)*height);
        return (double)Math.round(volume * 100d) / 100d;
    }

    @Override
    public String toString() {
         return id + "-" + name + "-" + shapeNum + "-" + width + "-" + height + "-" + volume;
    }
}
