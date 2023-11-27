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
                "(15, 'Germany', 'Warsaw', 'Poland', 'Warsaw', 120),\n" +
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
                "(59, 'Poland', 'Krakow', 'Germany', 'Munich', 180),\n" +
                "(60, 'Germany', 'Munich', 'Poland', 'Krakow', 180),\n" +
                "(61, 'France', 'Nice', 'Spain', 'Barcelona', 220),\n" +
                "(62, 'Spain', 'Barcelona', 'France', 'Nice', 220),\n" +
                "(63, 'Italy', 'Milan', 'Greece', 'Athens', 280),\n" +
                "(64, 'Greece', 'Athens', 'Italy', 'Milan', 280),\n" +
                "(65, 'Spain', 'Valencia', 'Portugal', 'Lisbon', 200),\n" +
                "(66, 'Portugal', 'Lisbon', 'Spain', 'Valencia', 200),\n" +
                "(67, 'Germany', 'Cologne', 'Netherlands', 'Amsterdam', 150),\n" +
                "(68, 'Netherlands', 'Amsterdam', 'Germany', 'Cologne', 150),\n" +
                "(69, 'UK', 'Manchester', 'Ireland', 'Dublin', 230),\n" +
                "(70, 'Ireland', 'Dublin', 'UK', 'Manchester', 230),\n" +
                "(71, 'Belgium', 'Brussels', 'France', 'Paris', 160),\n" +
                "(72, 'France', 'Paris', 'Belgium', 'Brussels', 160),\n" +
                "(73, 'Switzerland', 'Zurich', 'Italy', 'Venice', 250),\n" +
                "(74, 'Italy', 'Venice', 'Switzerland', 'Zurich', 250),\n" +
                "(75, 'Portugal', 'Porto', 'Spain', 'Seville', 190),\n" +
                "(76, 'Spain', 'Seville', 'Portugal', 'Porto', 190),\n" +
                "(77, 'Germany', 'Frankfurt', 'Austria', 'Vienna', 210),\n" +
                "(78, 'Austria', 'Vienna', 'Germany', 'Frankfurt', 210),\n" +
                "(79, 'Czech Republic', 'Prague', 'Slovakia', 'Bratislava', 160),\n" +
                "(80, 'Slovakia', 'Bratislava', 'Czech Republic', 'Prague', 160),\n" +
                "(81, 'Hungary', 'Budapest', 'Czech Republic', 'Ostrava', 230),\n" +
                "(82, 'Czech Republic', 'Ostrava', 'Hungary', 'Budapest', 230),\n" +
                "(83, 'Greece', 'Heraklion', 'Italy', 'Florence', 320),\n" +
                "(84, 'Italy', 'Florence', 'Greece', 'Heraklion', 320),\n" +
                "(85, 'Turkey', 'Thessaloniki', 'Greece', 'Rhodes', 270),\n" +
                "(86, 'Greece', 'Rhodes', 'Turkey', 'Thessaloniki', 270),\n" +
                "(87, 'Norway', 'Oslo', 'Sweden', 'Stockholm', 180),\n" +
                "(88, 'Sweden', 'Stockholm', 'Norway', 'Oslo', 180),\n" +
                "(89, 'Denmark', 'Copenhagen', 'Norway', 'Bergen', 220),\n" +
                "(90, 'Norway', 'Bergen', 'Denmark', 'Copenhagen', 220),\n" +
                "(91, 'Finland', 'Helsinki', 'Estonia', 'Tallinn', 150),\n" +
                "(92, 'Estonia', 'Tallinn', 'Finland', 'Helsinki', 150),\n" +
                "(93, 'Russia', 'Moscow', 'Finland', 'Turku', 300),\n" +
                "(94, 'Finland', 'Turku', 'Russia', 'Moscow', 300),\n" +
                "(95, 'Poland', 'Lodz', 'Germany', 'Dusseldorf', 190),\n" +
                "(96, 'Germany', 'Dusseldorf', 'Poland', 'Lodz', 190),\n" +
                "(97, 'France', 'Lyon', 'Spain', 'Seville', 260),\n" +
                "(98, 'Spain', 'Seville', 'France', 'Lyon', 260),\n" +
                "(99, 'Italy', 'Florence', 'Greece', 'Heraklion', 320),\n" +
                "(100, 'Greece', 'Heraklion', 'Italy', 'Florence', 320),\n"+
                "(101, 'Poland', 'Krakow', 'Germany', 'Munich', 180),\n" +
                "(102, 'Germany', 'Munich', 'Poland', 'Krakow', 200),\n" +
                "(103, 'France', 'Nice', 'Spain', 'Barcelona', 220),\n" +
                "(104, 'Spain', 'Barcelona', 'France', 'Nice', 240),\n" +
                "(105, 'Italy', 'Milan', 'Greece', 'Athens', 280),\n" +
                "(106, 'Greece', 'Athens', 'Italy', 'Milan', 300),\n" +
                "(107, 'Spain', 'Valencia', 'Portugal', 'Lisbon', 200),\n" +
                "(108, 'Portugal', 'Lisbon', 'Spain', 'Valencia', 220),\n" +
                "(109, 'Germany', 'Cologne', 'Netherlands', 'Amsterdam', 150),\n" +
                "(110, 'Netherlands', 'Amsterdam', 'Germany', 'Cologne', 170),\n" +
                "(111, 'UK', 'Manchester', 'Ireland', 'Dublin', 230),\n" +
                "(112, 'Ireland', 'Dublin', 'UK', 'Manchester', 250),\n" +
                "(113, 'Belgium', 'Brussels', 'France', 'Paris', 160),\n" +
                "(114, 'France', 'Paris', 'Belgium', 'Brussels', 180),\n" +
                "(115, 'Switzerland', 'Zurich', 'Italy', 'Venice', 250),\n" +
                "(116, 'Italy', 'Venice', 'Switzerland', 'Zurich', 270),\n" +
                "(117, 'Portugal', 'Porto', 'Spain', 'Seville', 190),\n" +
                "(118, 'Spain', 'Seville', 'Portugal', 'Porto', 210),\n" +
                "(119, 'Germany', 'Frankfurt', 'Austria', 'Vienna', 210),\n" +
                "(120, 'Austria', 'Vienna', 'Germany', 'Frankfurt', 230),\n" +
                "(121, 'Czech Republic', 'Prague', 'Slovakia', 'Bratislava', 160),\n" +
                "(122, 'Slovakia', 'Bratislava', 'Czech Republic', 'Prague', 180),\n" +
                "(123, 'Hungary', 'Budapest', 'Czech Republic', 'Ostrava', 230),\n" +
                "(124, 'Czech Republic', 'Ostrava', 'Hungary', 'Budapest', 250),\n" +
                "(125, 'Greece', 'Heraklion', 'Italy', 'Florence', 320),\n" +
                "(126, 'Italy', 'Florence', 'Greece', 'Heraklion', 340),\n" +
                "(127, 'Turkey', 'Thessaloniki', 'Greece', 'Rhodes', 270),\n" +
                "(128, 'Greece', 'Rhodes', 'Turkey', 'Thessaloniki', 290),\n" +
                "(129, 'Norway', 'Oslo', 'Sweden', 'Stockholm', 180),\n" +
                "(130, 'Sweden', 'Stockholm', 'Norway', 'Oslo', 200),\n" +
                "(131, 'Denmark', 'Copenhagen', 'Norway', 'Bergen', 220),\n" +
                "(132, 'Norway', 'Bergen', 'Denmark', 'Copenhagen', 240),\n" +
                "(133, 'Finland', 'Helsinki', 'Estonia', 'Tallinn', 150),\n" +
                "(134, 'Estonia', 'Tallinn', 'Finland', 'Helsinki', 170),\n" +
                "(135, 'Russia', 'Moscow', 'Finland', 'Turku', 300),\n" +
                "(136, 'Finland', 'Turku', 'Russia', 'Moscow', 320),\n" +
                "(137, 'Poland', 'Lodz', 'Germany', 'Dusseldorf', 190),\n" +
                "(138, 'Germany', 'Dusseldorf', 'Poland', 'Lodz', 210),\n" +
                "(139, 'France', 'Lyon', 'Spain', 'Seville', 260),\n" +
                "(140, 'Spain', 'Seville', 'France', 'Lyon', 280),\n" +
                "(141, 'Italy', 'Naples', 'Greece', 'Mykonos', 300),\n" +
                "(142, 'Greece', 'Mykonos', 'Italy', 'Naples', 320),\n" +
                "(143, 'Spain', 'Malaga', 'Portugal', 'Faro', 180),\n" +
                "(144, 'Portugal', 'Faro', 'Spain', 'Malaga', 200),\n" +
                "(145, 'Germany', 'Stuttgart', 'Switzerland', 'Geneva', 240),\n" +
                "(146, 'Switzerland', 'Geneva', 'Germany', 'Stuttgart', 260),\n" +
                "(147, 'UK', 'Edinburgh', 'Ireland', 'Galway', 190),\n" +
                "(148, 'Ireland', 'Galway', 'UK', 'Edinburgh', 210),\n" +
                "(149, 'Belgium', 'Antwerp', 'Netherlands', 'Rotterdam', 160),\n" +
                "(150, 'Netherlands', 'Rotterdam', 'Belgium', 'Antwerp', 180),\n" +
                "(151, 'Switzerland', 'Lucerne', 'Austria', 'Salzburg', 220),\n" +
                "(152, 'Austria', 'Salzburg', 'Switzerland', 'Lucerne', 240),\n" +
                "(153, 'Czech Republic', 'Brno', 'Slovakia', 'Kosice', 190),\n" +
                "(154, 'Slovakia', 'Kosice', 'Czech Republic', 'Brno', 210),\n" +
                "(155, 'Hungary', 'Debrecen', 'Czech Republic', 'Liberec', 250),\n" +
                "(156, 'Czech Republic', 'Liberec', 'Hungary', 'Debrecen', 270),\n" +
                "(157, 'Greece', 'Corfu', 'Italy', 'Bologna', 280),\n" +
                "(158, 'Italy', 'Bologna', 'Greece', 'Corfu', 300),\n" +
                "(159, 'Turkey', 'Antalya', 'Greece', 'Thessaloniki', 230),\n" +
                "(160, 'Greece', 'Thessaloniki', 'Turkey', 'Antalya', 250),\n" +
                "(161, 'Norway', 'Trondheim', 'Sweden', 'Gothenburg', 180),\n" +
                "(162, 'Sweden', 'Gothenburg', 'Norway', 'Trondheim', 200),\n" +
                "(163, 'Denmark', 'Aarhus', 'Norway', 'Stavanger', 220),\n" +
                "(164, 'Norway', 'Stavanger', 'Denmark', 'Aarhus', 240),\n" +
                "(165, 'Finland', 'Oulu', 'Estonia', 'Viljandi', 150),\n" +
                "(166, 'Estonia', 'Viljandi', 'Finland', 'Oulu', 170),\n" +
                "(167, 'Russia', 'Saint Petersburg', 'Finland', 'Lappeenranta', 300),\n" +
                "(168, 'Finland', 'Lappeenranta', 'Russia', 'Saint Petersburg', 320),\n" +
                "(169, 'Poland', 'Szczecin', 'Germany', 'Hamburg', 190),\n" +
                "(170, 'Germany', 'Hamburg', 'Poland', 'Szczecin', 210),\n" +
                "(171, 'France', 'Bordeaux', 'Spain', 'Valencia', 260),\n" +
                "(172, 'Spain', 'Valencia', 'France', 'Bordeaux', 280),\n" +
                "(173, 'Italy', 'Pisa', 'Greece', 'Skiathos', 320),\n" +
                "(174, 'Greece', 'Skiathos', 'Italy', 'Pisa', 340);";




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

