package Shape;

import java.util.Objects;

public abstract class Shape implements Calculate  {
    protected String name;
    protected int shapeNum;
    protected double volume;

    public Shape(int shapeId, String name) {
        shapeNum = shapeId;
        this.name = name;
    }

    public Shape(String name) {
        this.name = name;
    }

    public abstract double getVolume();

    public int getShapeNum() {
        return shapeNum;
    }

    public String getName() {
        return name;
    }

    public double getRadius() {
        return 0;
    }

    public double getWidth() {
        return 0;
    }

    public double getLength() {
        return 0;
    }

    public double getHeight() {
        return 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shape shape = (Shape) o;
        return Objects.equals(name, shape.name);
    }
}