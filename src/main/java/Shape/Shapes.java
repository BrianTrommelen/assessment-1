package Shape;

import java.util.Collection;
import java.util.List;

public interface Shapes {
    void saveShape(Shape shape);
    Shape searchShape(int id);
    void deleteShape(Shape shape);
    Collection<Shape> getAllShapes();
    List<String> getUsableShapes();
}
