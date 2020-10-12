package VAT;

import java.util.ArrayList;
import java.util.List;

public class Shapes {
    private List<Shape> shapes;

    public Shapes() {
        this.shapes = new ArrayList<>();
    }

    public void addShape(Shape shape) {
        if (!shapes.contains(shape)) {
            this.shapes.add(shape);
        }
    }

    public void removeShapes(Shape shape) {
        this.shapes.remove(shape);
    }

    public void printShapes() {
        for (int i = 0; i < this.shapes.size(); i++) {
            System.out.println(this.shapes.get(i));
        }
    }
}