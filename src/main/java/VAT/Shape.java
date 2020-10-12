package VAT;

public class Shape {
    private String name;
    private int id;

    public Shape(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Shape(String name) {
        this.id = 0;
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
