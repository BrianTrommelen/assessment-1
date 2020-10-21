package Service;

import Shape.Shape;
import Shape.ShapeActions;
import repository.ShapeDatabase;

import java.util.List;

public class ShapeService {
    private final ShapeDatabase database = new ShapeDatabase();


    public ShapeService() {

    }

    public List<Shape> getAll() {
        return database.getAll();
    }

    public void create(Shape shape) {
        database.save(shape);
    }

    public Shape getSingle(int id) {
        return database.getById(id);
    }

    public void getLatestId() { database.getLatestId(); }

    public void update(int id, Shape shape) {
        database.update(id, shape);
    }

    public void deleteSingle(int id) {
        database.delete(id);
    }

    public void deleteAll() {
        database.deleteAll();
    }
}
