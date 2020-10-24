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

    public Shape getSingleById(int id) {
        return database.getById(id);
    }

    public Shape getSingleByName(String name) {
        return database.getByName(name);
    }

    public void update(int id, Shape shape) {
        database.update(id, shape);
    }

    public void deleteSingleFromId(int id) {
        database.deleteFromId(id);
    }

    public void deleteSingleFromName(String name) {
        database.deleteFromName(name);
    }

    public void deleteAll() {
        database.deleteAll();
    }

    public List<String> getUsableShapes() { return database.getUsableShapes(); }
}
