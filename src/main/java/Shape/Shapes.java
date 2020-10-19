package Shape;

import java.util.Collection;

public interface Shapes {
    void saveShape(Shape shape);
    Shape searchShape(String name);
    void deleteShape(Shape shape);
    Collection<Shape> getAllShapes();
}
