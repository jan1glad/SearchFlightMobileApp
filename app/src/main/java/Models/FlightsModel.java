package Models;

import java.time.LocalTime;

public class FlightsModel {

    private int flightID;
    private String startCountry;
    private String startCity;
    private String landingCountry;
    private String landingCity;
    private int price;

    public FlightsModel(int flightID, String startCountry, String startCity, String landingCountry, String landingCity, int price) {
        this.flightID = flightID;
        this.startCountry = startCountry;
        this.startCity = startCity;
        this.landingCountry = landingCountry;
        this.landingCity = landingCity;

        this.price = price;
    }

    @Override
    public String toString() {
        return "From: " + startCity + " , " + startCountry+'\n'
                 + "To: " + landingCountry + " , " + landingCity + '\n' +
                "Price: " + price;

    }

    public FlightsModel() {
    }

    public int getFlightID() {
        return flightID;
    }

    public void setFlightID(int flightID) {
        this.flightID = flightID;
    }

    public String getStartCountry() {
        return startCountry;
    }

    public void setStartCountry(String startCountry) {
        this.startCountry = startCountry;
    }

    public String getStartCity() {
        return startCity;
    }

    public void setStartCity(String startCity) {
        this.startCity = startCity;
    }

    public String getLandingCountry() {
        return landingCountry;
    }

    public void setLandingCountry(String landingCountry) {
        this.landingCountry = landingCountry;
    }

    public String getLandingCity() {
        return landingCity;
    }

    public void setLandingCity(String landingCity) {
        this.landingCity = landingCity;
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
