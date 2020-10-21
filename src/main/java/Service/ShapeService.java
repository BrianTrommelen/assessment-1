package Service;

import Shape.Shape;
import Repository.ShapeDatabase;

import java.util.List;

public class ShapeService {
    private final ShapeDatabase database = new ShapeDatabase();

    public List<Shape> getAll() {
        return database.getAll();
    }

    public void create(Shape shape) {
        database.save(shape);
    }

    public Shape getSingle(int id) {
        return database.getById(id);
    }

    public void update(int id, Shape shape) {
        database.update(id, shape);
    }

    public void deleteSingle(int id) {
        database.delete(id);
    }

    public void deleteAll() {
        database.deleteAll();
    }

    public List<String> getUsableShapes() { return database.getUsableShapes(); }
}
