package Repository;

import Shape.Shape;

import java.util.List;

public interface DatabaseInterface {
    void save(Shape shape);

    void update(int id, Shape shape);

    Shape getById(int id);
    Shape getByName(String name);

    void deleteFromName(String name);

    void deleteFromId(int id);

    void deleteAll();

    List<Shape> getAll();

    List<String> getUsableShapes();
}
