package Shape;

import Service.ShapeService;

import java.util.Collection;
import java.util.List;
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
    public Shape searchShape(int id) {
        Shape result = shapeService.getSingle(id);

        System.out.println(result == null ? "No shape found" : "found: " + result);

        return result;
    }

    @Override
    public Collection<Shape> getAllShapes() {
        return shapeList = shapeService.getAll();
    }

    @Override
    public List<String> getUsableShapes() { return shapeService.getUsableShapes(); }

    @Override
    public void deleteShape(Shape shape) {
        shapeList = shapeList.stream()
                .filter(p -> !p.getName().equals(shape))
                .collect(Collectors.toList());
        System.out.println("Deleted shape: " + shape);
    }
}
