package Databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import Models.PassengersModel;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DatabasePassengers extends SQLiteOpenHelper {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());

    public static final String PASSENGERS_TABLE = "PASSENGERS_TABLE";
    public static final String COLUMN_PASSENGER_ID = "COLUMN_PASSENGER_ID";
    public static final String COLUMN_PASSENGER_NAME = "COLUMN_PASSENGER_NAME";
    public static final String COLUMN_PASSENGER_SURNAME = "COLUMN_PASSENGER_SURNAME";
    public static final String COLUMN_PASSENGER_PHONE = "COLUMN_PASSENGER_PHONE";
    public static final String COLUMN_PASSENGER_EMAIL = "COLUMN_PASSENGER_EMAIL";
    public static final String COLUMN_PASSENGER_COUNTRY = "COLUMN_PASSENGER_COUNTRY";
    public static final String COLUMN_PASSENGER_DATE_OF_BORN = "COLUMN_PASSENGER_DATE_OF_BORN";
    public static final String COLUMN_PASSENGER_RESERVATION_ID = "COLUMN_PASSENGER_RESERVATION_ID";
    public static final String COLUMN_PASSENGER_STARTING = "COLUMN_PASSENGER_STARTING";
    public static final String COLUMN_PASSENGER_LANDING = "COLUMN_PASSENGER_LANDING";
    public static final String COLUMN_PASSENGER_PRICE = "COLUMN_PASSENGER_PRICE";

    public DatabasePassengers(@Nullable Context context) {
        super(context, "passengers.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createTable = "CREATE TABLE " + PASSENGERS_TABLE + " (" + COLUMN_PASSENGER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_PASSENGER_NAME + " TEXT, " + COLUMN_PASSENGER_SURNAME + " TEXT, " + COLUMN_PASSENGER_PHONE + " INTEGER, " +
                COLUMN_PASSENGER_EMAIL + " TEXT, " + COLUMN_PASSENGER_COUNTRY + " TEXT, " + COLUMN_PASSENGER_DATE_OF_BORN + " DATE, " + COLUMN_PASSENGER_RESERVATION_ID + " TEXT, "  + COLUMN_PASSENGER_STARTING + " TEXT, " + COLUMN_PASSENGER_LANDING + " TEXT, "
                + COLUMN_PASSENGER_PRICE + " INTEGER)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addPassengers(PassengersModel passengersModel) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        String name = passengersModel.getName();
        String surname = passengersModel.getSurname();
        int phone  = passengersModel.getPhone();
        String email = passengersModel.getEmail();
        String country = passengersModel.getCountry();
        Calendar dateOfBorn = passengersModel.getDateOfBorn();
        String reservation = passengersModel.getReservation();
        String starting = passengersModel.getStarting();
        String landing = passengersModel.getLanding();
        int price = passengersModel.getPrice();

        cv.put(COLUMN_PASSENGER_NAME, name);
        cv.put(COLUMN_PASSENGER_SURNAME, surname);
        cv.put(COLUMN_PASSENGER_PHONE,phone);
        cv.put(COLUMN_PASSENGER_EMAIL,email);
        cv.put(COLUMN_PASSENGER_COUNTRY,country);
        cv.put(COLUMN_PASSENGER_DATE_OF_BORN,dateFormat.format(dateOfBorn.getTime()));
        cv.put(COLUMN_PASSENGER_RESERVATION_ID,reservation);
        cv.put(COLUMN_PASSENGER_STARTING,starting);
        cv.put(COLUMN_PASSENGER_LANDING,landing);
        cv.put(COLUMN_PASSENGER_PRICE,price);

        long insert = db.insert(PASSENGERS_TABLE, null, cv);

        if (insert == -1) {
            return false;
        } else return true;

    }
}
