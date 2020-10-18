package VAT.service;

import VAT.Shape;
import VAT.Shapes;
import VAT.repository.ShapeDatabase;

import java.util.List;

public class ShapeService {
    private final ShapeDatabase database;


    public ShapeService(ShapeDatabase database) {
        this.database = database;
    }

    public void getAll() {
        List<Shapes> all = database.getAll();

        for (Shapes shape : all) {
            System.out.println(shape.toString());
        }
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
}
