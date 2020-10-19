package repository;

import Shape.Shape;
import Shape.Shapes;
import Shape.ShapeActions;

import java.util.List;

public interface DatabaseInterface {
    void save(Shape shape);

    void update(int id, Shape shape);

    Shape getById(int id);

    void delete(Shape person);

    void delete(int id);

    void deleteAll();

    List<Shapes> getAll();
}
