package Shape;

import Service.ShapeService;

import Shapes.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class ShapeActions implements Shapes {
    private List<Shape> shapeList;
    private ShapeService shapeService = new ShapeService();

    @Override
    public void saveShape(Shape shape) {
        shapeService.create(shape);
    }

    @Override
    public Shape searchShape(int id) {
        Shape result = shapeService.getSingleById(id);

        System.out.println(result == null ? "No shape found" : "found: " + result);

        return result;
    }

    @Override
    public void updateShape(int id, Shape shape) {
        shapeService.update(id, shape);
    }

    @Override
    public Collection<Shape> getAllShapes() {
        return shapeList = shapeService.getAll();
    }

    @Override
    public List<String> getUsableShapes() {
        return shapeService.getUsableShapes();
    }

    @Override
    public void exportShapes() throws IOException {
        String fileName = "exportedShapes.txt";
        String content = "";

        try {
            try {
                shapeList = shapeService.getAll();
                for (Shape shape : shapeList) {
                    content = content + shape + "\n";
                }

                System.out.println(content);
            } catch (Exception e) {
                e.printStackTrace();
            }

            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.write(content);
            fileWriter.close();

        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    public void importShapes() throws FileNotFoundException {
        try {
            Scanner input = new Scanner(new File("exportedShapes.txt"));
            input.useDelimiter("-|\n");

            deleteAll();

            while (input.hasNext()) {
                int id = input.nextInt();
                String name = input.next();
                int shapeId = input.nextInt();
                if (shapeId == 1) {
                    double radius = Double.valueOf(input.next());
                    double volume = Double.valueOf(input.next());

                    Sphere shape = new Sphere(id, name, radius, volume);
                    saveShape(shape);
                } else if (shapeId == 2) {
                    double radius = Double.valueOf(input.next());
                    double height = Double.valueOf(input.next());
                    double volume = Double.valueOf(input.next());

                    Cylinder shape = new Cylinder(id, name, radius, height, volume);
                    saveShape(shape);
                } else if (shapeId == 3) {
                    double radius = Double.valueOf(input.next());
                    double height = Double.valueOf(input.next());
                    double volume = Double.valueOf(input.next());

                    Cone shape = new Cone(id, name, radius, height, volume);
                    saveShape(shape);
                } else if (shapeId == 4) {
                    double width = Double.valueOf(input.next());
                    double height = Double.valueOf(input.next());
                    double volume = Double.valueOf(input.next());

                    Pyramid shape = new Pyramid(id, name, width, height, volume);
                    saveShape(shape);
                } else if (shapeId == 5) {
                    double width = Double.valueOf(input.next());
                    double length = Double.valueOf(input.next());
                    double height = Double.valueOf(input.next());
                    double volume = Double.valueOf(input.next());

                    Cube shape = new Cube(id, name, width, length, height, volume);
                    saveShape(shape);
                }
            }
        } catch (java.io.FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public double calculateAllVolumes() {
        double sum = 0;
        for (Shape shape : shapeService.getAll()) {
            sum = sum + shape.getVolume();
        }
        return sum;
    }

    @Override
    public void deleteShape(int id) {
        shapeService.deleteSingleFromId(id);
    }

    @Override
    public void deleteAll() {
        shapeService.deleteAll();
    }
}
