package Models;

public class CarsModel {

    private int id;
    private String model;
    private int year;
    private String type;
    private String gas;
    private int price;
    private String city;

    public CarsModel(int id, String model, int year, String type, String gas, int price, String city) {
        this.id = id;
        this.model = model;
        this.year = year;
        this.type = type;
        this.gas = gas;
        this.price = price;
        this.city = city;
    }

    public CarsModel() {
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", type='" + type + '\'' +
                ", gas='" + gas + '\'' +
                ", price='" + price + '\'' +
                ", city='" + city + '\'';

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGas() {
        return gas;
    }

    public void setGas(String gas) {
        this.gas = gas;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
