package lesson3;

public class Tea {

    @Default("black")
    private String type;

    private String name;

    @Default("100")
    private double weight;

    @Default("102.12")
    private int price;

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Tea{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }

}
