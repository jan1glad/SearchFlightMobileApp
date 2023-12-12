package Databases;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import Models.FlightsModel;

import java.util.ArrayList;
import java.util.List;


public class DatabaseFlights extends SQLiteOpenHelper {

    public static final String FLIGHTS_TABLE = "FLIGHTS_TABLE";
    public static final String COLUMN_FLIGHT_ID = "COLUMN_FLIGHT_ID";
    public static final String COLUMN_FLIGHT_START_COUNTRY = "COLUMN_FLIGHT_START_COUNTRY";
    public static final String COLUMN_FLIGHT_START_CITY = "COLUMN_FLIGHT_START_CITY";
    public static final String COLUMN_FLIGHT_LANDING_COUNTRY = "COLUMN_FLIGHT_LANDING_COUNTRY";
    public static final String COLUMN_FLIGHT_LANDING_CITY = "COLUMN_FLIGHT_LANDING_CITY";
    public static final String COLUMN_FLIGHT_PRICE = "COLUMN_FLIGHT_PRICE";

    public DatabaseFlights(@Nullable Context context) {
        super(context, "flights.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + FLIGHTS_TABLE);

        String createTable = "CREATE TABLE " + FLIGHTS_TABLE + " (" + COLUMN_FLIGHT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_FLIGHT_START_COUNTRY + " TEXT, " + COLUMN_FLIGHT_START_CITY + " TEXT, " + COLUMN_FLIGHT_LANDING_COUNTRY + " TEXT, " +
                COLUMN_FLIGHT_LANDING_CITY + " TEXT, "  + COLUMN_FLIGHT_PRICE + " INTEGER)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addFlights() {

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + FLIGHTS_TABLE);
        String flights = "INSERT INTO " + FLIGHTS_TABLE + "(`COLUMN_FLIGHT_ID`, `COLUMN_FLIGHT_START_COUNTRY`, `COLUMN_FLIGHT_START_CITY`, `COLUMN_FLIGHT_LANDING_COUNTRY`, `COLUMN_FLIGHT_LANDING_CITY`, `COLUMN_FLIGHT_PRICE`) VALUES\n" +
                "(1, 'Poland', 'Warsaw', 'Germany', 'Berlin', 300),\n" +
                "(2, 'Poland', 'Warsaw', 'UK', 'London', 250),\n" +
                "(3, 'Poland', 'Warsaw', 'Netherlands', 'Amsterdam', 450),\n" +
                "(4, 'Poland', 'Warsaw', 'Spain', 'Madrid', 650),\n" +
                "(5, 'Poland', 'Warsaw', 'Italy', 'Rome', 120),\n" +
                "(6, 'France', 'Paris', 'Netherlands', 'Amsterdam', 200),\n" +
                "(7, 'Poland', 'Warsaw', 'Netherlands', 'Amsterdam', 280),\n" +
                "(8, 'Poland', 'Gdansk', 'Poland', 'Warsaw', 99),\n" +
                "(9, 'Poland', 'Gdansk', 'Germany', 'Berlin', 140),\n" +
                "(10, 'Poland', 'Wroclaw', 'Czech Republic', 'Praga', 65),\n" +
                "(11, 'Poland', 'Krakow', 'UK', 'London', 110),\n" +
                "(12, 'Poland', 'Poznan', 'Portugal', 'Lisbon', 199),\n" +
                "(13, 'Poland', 'Poznan', 'Italy', 'Rome', 320),\n" +
                "(14, 'France', 'Paris', 'UK', 'London', 170),\n" +
                "(15, 'Germany', 'Berlin', 'Poland', 'Warsaw', 120),\n" +
                "(16, 'UK', 'London', 'Poland', 'Warsaw', 79),\n" +
                "(17, 'Netherlands', 'Amsterdam', 'Poland', 'Warsaw', 230),\n" +
                "(18, 'Spain', 'Madrid', 'Poland', 'Warsaw', 500),\n" +
                "(19, 'Italy', 'Rome', 'Poland', 'Warsaw', 90),\n" +
                "(20, 'Poland', 'Warsaw', 'Poland', 'Gdansk', 64),\n" +
                "(21, 'Germany', 'Berlin', 'Poland', 'Gdansk', 100),\n" +
                "(22, 'Czech Republic', 'Praga', 'Poland', 'Wroclaw', 80),\n" +
                "(23, 'UK', 'London', 'Poland', 'Krakow', 70),\n" +
                "(24, 'Portugal', 'Lisbon', 'Poland', 'Poznan', 360),\n" +
                "(25, 'Italy', 'Rome', 'Poland', 'Poznan', 100),\n" +
                "(26, 'UK', 'London', 'France', 'Paris', 160),\n" +
                "(27, 'Spain', 'Barcelona', 'UK', 'London', 300),\n" +
                "(28, 'UK', 'London', 'Spain', 'Barcelona', 420),\n" +
                "(29, 'Czech Republic', 'Praga', 'Italy', 'Rome', 199),\n" +
                "(30, 'Italy', 'Rome', 'Czech Republic', 'Praga', 135),\n" +
                "(31, 'Italy', 'Rome', 'Spain', 'Barcelona', 70),\n" +
                "(32, 'Spain', 'Barcelona', 'Italy', 'Rome', 60),\n" +
                "(33, 'UK ', 'London', 'Italy', 'Rome', 130),\n" +
                "(34, 'Italy', 'Rome', 'UK ', 'London', 170),\n" +
                "(35, 'France', 'Paris', 'Czech Republic', 'Praga', 300),\n" +
                "(36, 'Czech Republic', 'Praga', 'France', 'Paris', 270),\n" +
                "(37, 'Poland', 'Gdansk', 'Spain', 'Barcelona', 220),\n" +
                "(38, 'Spain', 'Barcelona', 'Poland', 'Gdansk', 230),\n" +
                "(39, 'Poland', 'Poznan', 'UK', 'London', 90),\n" +
                "(40, 'UK', 'London', 'Poland', 'Poznan', 90),\n" +
                "(41, 'Poland', 'Wroclaw', 'France', 'Paris', 190),\n" +
                "(42, 'France', 'Paris', 'Poland', 'Wroclaw', 250),\n" +
                "(43, 'Germany', 'Berlin', 'Netherlands', 'Amsterdam', 199),\n" +
                "(44, 'Netherlands', 'Amsterdam', 'Germany', 'Berlin', 350),\n" +
                "(45, 'Netherlands', 'Amsterdam', 'Czech Republic', 'Praga', 110),\n" +
                "(46, 'Czech Republic', 'Praga', 'Netherlands', 'Amsterdam', 290),\n" +
                "(47, 'Germany', 'Berlin', 'Portugal', 'Lisbon', 580),\n" +
                "(48, 'Portugal', 'Lisbon', 'Germany', 'Berlin', 430),\n" +
                "(49, 'Poland', 'Krakow', 'Spain', 'Madrid', 85),\n" +
                "(50, 'Spain', 'Madrid', 'Poland', 'Krakow', 175),\n" +
                "(51, 'Poland', 'Poznan', 'Turkey', 'Istanbul', 700),\n" +
                "(52, 'Turkey', 'Istanbul', 'Poland', 'Poznan', 620),\n" +
                "(53, 'Italy', 'Rome', 'Poland', 'Gdansk', 140),\n" +
                "(54, 'Poland', 'Gdansk', 'Italy', 'Rome', 170),\n" +
                "(55, 'Czech Republic', 'Praga', 'Portugal', 'Lisbon', 300),\n" +
                "(56, 'Portugal', 'Lisbon', 'Czech Republic', 'Praga', 470),\n" +
                "(57, 'UK ', 'London', 'Turkey', 'Istanbul', 780),\n" +
                "(58, 'Turkey', 'Istanbul', 'UK ', 'London', 640),\n" +
                "(59, 'France', 'Paris', 'Germany', 'Berlin', 210),\n" +
                "(60, 'Germany', 'Berlin', 'France', 'Paris', 190),\n" +
                "(61, 'Spain', 'Madrid', 'France', 'Paris', 380),\n" +
                "(62, 'France', 'Paris', 'Spain', 'Madrid', 400),\n" +
                "(63, 'Netherlands', 'Amsterdam', 'Germany', 'Berlin', 110),\n" +
                "(64, 'Germany', 'Berlin', 'Netherlands', 'Amsterdam', 130),\n" +
                "(65, 'Italy', 'Rome', 'Spain', 'Madrid', 270),\n" +
                "(66, 'Spain', 'Madrid', 'Italy', 'Rome', 250),\n" +
                "(67, 'Portugal', 'Lisbon', 'Spain', 'Barcelona', 180),\n" +
                "(68, 'Spain', 'Barcelona', 'Portugal', 'Lisbon', 200),\n" +
                "(69, 'France', 'Paris', 'Germany', 'Munich', 240),\n" +
                "(70, 'Germany', 'Munich', 'France', 'Paris', 220),\n" +
                "(71, 'Netherlands', 'Amsterdam', 'Netherlands', 'Rotterdam', 40),\n" +
                "(72, 'Netherlands', 'Rotterdam', 'Netherlands', 'Amsterdam', 40),\n" +
                "(73, 'Germany', 'Frankfurt', 'Germany', 'Hamburg', 300),\n" +
                "(74, 'Germany', 'Hamburg', 'Germany', 'Frankfurt', 300),\n" +
                "(75, 'Austria', 'Vienna', 'Hungary', 'Budapest', 220),\n" +
                "(76, 'Hungary', 'Budapest', 'Austria', 'Vienna', 240),\n" +
                "(77, 'Poland', 'Warsaw', 'Austria', 'Vienna', 290),\n" +
                "(78, 'Austria', 'Vienna', 'Poland', 'Warsaw', 310),\n" +
                "(79, 'Czech Republic', 'Praga', 'Hungary', 'Budapest', 160),\n" +
                "(80, 'Hungary', 'Budapest', 'Czech Republic', 'Praga', 180),\n" +
                "(81, 'Italy', 'Milan', 'Italy', 'Florence', 90),\n" +
                "(82, 'Italy', 'Florence', 'Italy', 'Milan', 90),\n" +
                "(83, 'Spain', 'Barcelona', 'Spain', 'Seville', 300),\n" +
                "(84, 'Spain', 'Seville', 'Spain', 'Barcelona', 300);";




        db.execSQL(flights);
    }
    public List<FlightsModel> getEveryone(){
        List<FlightsModel> returnList = new ArrayList<>();

        String queryString = "SELECT * FROM " + FLIGHTS_TABLE;

        return getFlights(returnList, queryString);
    }
    private List<FlightsModel> getFlights(List<FlightsModel> returnList, String queryString) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()){

            do {
                int flightID = cursor.getInt(0);
                String startCountry = cursor.getString(1);
                String startCity = cursor.getString(2);
                String landingCountry = cursor.getString(3);
                String landingCity = cursor.getString(4);
                int price = cursor.getInt(5);

                FlightsModel flightsModel = new FlightsModel(flightID, startCountry, startCity, landingCountry, landingCity,price);

                returnList.add(flightsModel);

            }while (cursor.moveToNext());

        }
        cursor.close();
        db.close();

        return returnList;
    }
    public List<FlightsModel> getYourFlightCity(String startCity, String finishCity){
        List<FlightsModel> returnList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String queryString = "SELECT * FROM " + FLIGHTS_TABLE + " WHERE " + COLUMN_FLIGHT_START_CITY + " = ? AND " + COLUMN_FLIGHT_LANDING_CITY + " = ?";

        if (startCity == null || finishCity == null) {
            return returnList;
        }

        Cursor cursor = db.rawQuery(queryString, new String[]{startCity, finishCity});

        if (cursor.moveToFirst()) {
            do {
                int flightID = cursor.getInt(0);
                String startCountry = cursor.getString(1);
                String landingCountry = cursor.getString(3);
                int price = cursor.getInt(5);

                FlightsModel flightsModel = new FlightsModel(flightID, startCountry, startCity, landingCountry, finishCity, price);

                returnList.add(flightsModel);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return returnList;
    }

    public List<FlightsModel> getYourFlightCountry(String startCountry, String finishCountry){
        List<FlightsModel> returnList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String queryString = "SELECT * FROM " + FLIGHTS_TABLE + " WHERE " + COLUMN_FLIGHT_START_COUNTRY + " = ? AND " + COLUMN_FLIGHT_LANDING_COUNTRY + " = ?";


        if (startCountry == null || finishCountry == null) {
            return returnList;
        }

        Cursor cursor = db.rawQuery(queryString, new String[]{startCountry, finishCountry});

        if (cursor.moveToFirst()) {
            do {
                int flightID = cursor.getInt(0);
                String startCity = cursor.getString(2);
                String finishCity = cursor.getString(4);
                int price = cursor.getInt(5);

                FlightsModel flightsModel = new FlightsModel(flightID, startCountry, startCity, finishCountry, finishCity, price);

                returnList.add(flightsModel);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return returnList;
    }

    public List<FlightsModel> getYourOneWayFlightCity(String startCity){
        List<FlightsModel> returnList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String queryString = "SELECT * FROM " + FLIGHTS_TABLE + " WHERE " + COLUMN_FLIGHT_START_CITY + " = ? ";




        Cursor cursor = db.rawQuery(queryString, new String[]{startCity});

        if (cursor.moveToFirst()) {
            do {
                int flightID = cursor.getInt(0);
                String startCountry = cursor.getString(1);

                String finishCity = cursor.getString(3);
                String finishCountry = cursor.getString(4);
                int price = cursor.getInt(5);

                FlightsModel flightsModel = new FlightsModel(flightID, startCountry, startCity, finishCountry, finishCity, price);

                returnList.add(flightsModel);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return returnList;
    }

    public List<FlightsModel> getYourOneWayFlightCountry(String startCountry){
        List<FlightsModel> returnList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String queryString = "SELECT * FROM " + FLIGHTS_TABLE + " WHERE " + COLUMN_FLIGHT_START_COUNTRY + " = ? ";


        Cursor cursor = db.rawQuery(queryString, new String[]{startCountry});

        if (cursor.moveToFirst()) {
            do {
                int flightID = cursor.getInt(0);
                String startCity = cursor.getString(2);

                String finishCity = cursor.getString(3);
                String finishCountry = cursor.getString(4);
                int price = cursor.getInt(5);

                FlightsModel flightsModel = new FlightsModel(flightID, startCountry, startCity, finishCountry, finishCity, price);

                returnList.add(flightsModel);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return returnList;
    }
   /* private List<FlightsModel> getFlights() {
        SQLiteDatabase db = this.getReadableDatabase();

        // Query to retrieve flight data
        String query = "SELECT * FROM " + FLIGHTS_TABLE;
        Cursor cursor = db.rawQuery(query, null);

        // Iterate through the cursor and create Flight objects
        if (cursor.moveToFirst()) {
            do {
                int flightID = cursor.getInt(cursor.getColumnIndex(0));
                String startCountry = cursor.getString(cursor.getColumnIndex(1));
                String startCity = cursor.getString(cursor.getColumnIndex(2));
                String landingCountry = cursor.getString(cursor.getColumnIndex(3));
                String landingCity = cursor.getString(cursor.getColumnIndex(4));
                String flightHourStr = cursor.getString(cursor.getColumnIndex(5));
                LocalTime flightHour = LocalTime.parse(flightHourStr);
                int price = cursor.getInt(cursor.getColumnIndex(6));

                FlightsModel flight = new FlightsModel(flightID, startCountry, startCity, landingCountry, landingCity, flightHour, price);
                flight.add(flight);
            } while (cursor.moveToNext());
        }

        // Close the cursor and database
        cursor.close();
        db.close();
        // Now, you have a list of Flight objects (flightList) that you can use in your app.
    }*/
}

