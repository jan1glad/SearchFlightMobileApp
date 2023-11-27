package Models;

public class PassengersModel {
    private  int id;
    private String name;
    private String surname;
    private int phone;
    private String email;
    private String country;
    private String reservation;
    private String starting;
    private String landing;
    private int price;

    public PassengersModel(int id, String name, String surname, int phone, String email, String country, String reservation, String starting, String landing, int price) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.country = country;
        this.reservation = reservation;
        this.starting = starting;
        this.landing = landing;
        this.price = price;
    }

    public PassengersModel() {
    }

    @Override
    public String toString() {
        return "PassengersModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                ", country='" + country + '\'' +
                ", reservation='" + reservation + '\'' +
                ", starting='" + starting + '\'' +
                ", landing='" + landing + '\'' +
                ", price=" + price +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getReservation() {
        return reservation;
    }

    public void setReservation(String reservation) {
        this.reservation = reservation;
    }

    public String getStarting() {
        return starting;
    }

    public void setStarting(String starting) {
        this.starting = starting;
    }

    public String getLanding() {
        return landing;
    }

    public void setLanding(String landing) {
        this.landing = landing;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
