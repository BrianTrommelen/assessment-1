package Shape;

import java.util.Objects;

public abstract class Shape implements Calculate  {
    protected int id;
    protected String name;
    protected int shapeNum;

    public Shape(int id,String name) {
        this.id = id;
        this.name = name;
    }

    public Shape(String name) {
        this.id = 0;
        this.name = name;
    }

    public int getShapeNum() {
        return 0;
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