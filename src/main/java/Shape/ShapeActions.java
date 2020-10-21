package Shape;

import Service.ShapeService;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ShapeActions implements Shapes {
    private List<Shape> shapeList;
    private ShapeService shapeService = new ShapeService();

    @Override
    public void saveShape(Shape shape) {
        System.out.println("Saved shape\n" + shape);
        shapeService.create(shape);
    }

    @Override
    public Shape searchShape(String name) {
        Optional<Shape> found = shapeList.stream()
                .filter(p -> p.getName().equals(name)).findFirst();
        Shape result = found.isEmpty() ? null : found.get();

        System.out.println(result == null ? "No shape found" : "found: " + result);

        return result;
    }

    @Override
    public Collection<Shape> getAllShapes() {
        return shapeList = shapeService.getAll();
    }

    @Override
    public Shape getShapeById(int shapeId) {
        return shapeService.getSingle(shapeId);
    }

    @Override
    public int latestShape() { shapeService.getLatestId();
        return 0;
    }

    @Override
    public void deleteShape(Shape shape) {
        shapeList = shapeList.stream()
                .filter(p -> !p.getName().equals(shape))
                .collect(Collectors.toList());
        System.out.println("Deleted shape: " + shape);
    }
}
