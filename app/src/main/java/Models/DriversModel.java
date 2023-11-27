package Models;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class DriversModel {
    public static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private int id;
    private String name;
    private String surname;
    private int phone;
    private String email;
    private String countryOfBorn;
    private Calendar dateOfBorn;
    private String typeOfDriver;
    private String reservationID;
    private String city;
    private String model;
    private Calendar start;
    private Calendar end;
    private int price;

    public String getDateOfBornAsString() {
        return dateFormatter.format(dateOfBorn.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
    }

    public String getStartDateAsString() {
        return dateFormatter.format(start.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
    }

    public String getEndDateAsString() {
        return dateFormatter.format(end.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
    }


    @Override
    public String toString() {
        return "DriversModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                ", countryOfBorn='" + countryOfBorn + '\'' +
                ", dateOfBorn=" + dateOfBorn +
                ", typeOfDriver='" + typeOfDriver + '\'' +
                ", reservationID='" + reservationID + '\'' +
                ", city='" + city + '\'' +
                ", model='" + model + '\'' +
                ", start=" + start +
                ", end=" + end +
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
    public String getReservationID() {
        return reservationID;
    }
    public String getCountryOfBorn() {
        return countryOfBorn;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setReservationID(String reservationID) {
        this.reservationID = reservationID;
    }
    public void setCountryOfBorn(String country) {
        this.countryOfBorn = countryOfBorn;
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

    public Calendar getDateOfBorn() {
        return dateOfBorn;
    }

    public void setDateOfBorn(Calendar dateOfBorn) {
        this.dateOfBorn = dateOfBorn;
    }

    public String getTypeOfDriver() {
        return typeOfDriver;
    }

    public void setTypeOfDriver(String typeOfDriver) {
        this.typeOfDriver = typeOfDriver;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Calendar getStart() {
        return start;
    }

    public void setStart(Calendar start) {
        this.start = start;
    }

    public Calendar getEnd() {
        return end;
    }

    public void setEnd(Calendar end) {
        this.end = end;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public DriversModel() {
    }

    public DriversModel(int id, String name, String surname, int phone, String email, String countryOfBorn, Calendar dateOfBorn, String typeOfDriver, String reservationID, String city, String model, Calendar start, Calendar end, int price) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.countryOfBorn = countryOfBorn;
        this.dateOfBorn = dateOfBorn;
        this.typeOfDriver = typeOfDriver;
        this.reservationID = reservationID;
        this.city = city;
        this.model = model;
        this.start = start;
        this.end = end;
        this.price = price;
    }
}
