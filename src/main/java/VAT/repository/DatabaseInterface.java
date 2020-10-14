package VAT.repository;

import VAT.Shape;
import VAT.Shapes;

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