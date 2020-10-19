package Shape;

import java.util.Objects;

public class Shape {
    private int id;
    private String name;
    private double radius;

    public Shape(int id, String name) {
        this.id = id;
        this.name = name;
        this.radius = 0;
    }

    public Shape(int id, String name, double radius) {
        this.id = id;
        this.name = name;
        this.radius = radius;
    }

    public String getName() {
        return name;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Shape: " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shape shape = (Shape) o;
        return Objects.equals(name, shape.name);
    }


}