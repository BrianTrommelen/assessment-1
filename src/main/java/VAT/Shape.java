package VAT;

public class Shape extends Shapes{
    private String name;
    private int id;

    public Shape(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Shape(String name) {
        this.id = 0;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
