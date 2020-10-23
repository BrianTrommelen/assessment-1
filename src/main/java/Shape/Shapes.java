package Shape;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

public interface Shapes {
    void saveShape(Shape shape);
    Shape searchShape(int id);
    void updateShape(int id, Shape shape);
    void deleteShape(int id);
    void deleteAll();
    Collection<Shape> getAllShapes();
    List<String> getUsableShapes();
    void exportShapes() throws IOException;
    void importShapes() throws FileNotFoundException;
}
