package Databases;

import Models.DriversModel;
import Models.PassengersModel;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;

public class DatabaseDrivers extends SQLiteOpenHelper {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());

    public static final String DRIVERS_TABLE = "DRIVERS_TABLE";
    public static final String COLUMN_DRIVERS_ID = "COLUMN_DRIVERS_ID";
    public static final String COLUMN_DRIVERS_NAME = "COLUMN_DRIVERS_NAME";
    public static final String COLUMN_DRIVERS_SURNAME = "COLUMN_DRIVERS_SURNAME";
    public static final String COLUMN_DRIVERS_PHONE = "COLUMN_DRIVERS_PHONE";
    public static final String COLUMN_DRIVERS_EMAIL = "COLUMN_DRIVERS_EMAIL";
    public static final String COLUMN_DRIVERS_COUNTRY_OF_BORN = "COLUMN_DRIVERS_COUNTRY_OF_BORN";
    public static final String COLUMN_DRIVERS_DATE_OF_BORN = "COLUMN_DRIVERS_DATE_OF_BORN";
    public static final String COLUMN_DRIVERS_TYPE_OF_DRIVER = "COLUMN_DRIVERS_TYPE_OF_DRIVER";
    public static final String COLUMN_DRIVERS_RESERVATION_ID = "COLUMN_DRIVERS_RESERVATION_ID";
    public static final String COLUMN_DRIVERS_CITY_RESERVATION = "COLUMN_DRIVERS_CITY_RESERVATION";
    public static final String COLUMN_DRIVERS_MODEL = "COLUMN_DRIVERS_MODEL";
    public static final String COLUMN_DRIVERS_START_DATE = "COLUMN_DRIVERS_START_DATE";
    public static final String COLUMN_DRIVERS_END_DATE = "COLUMN_DRIVERS_END_DATE";
    public static final String COLUMN_DRIVERS_PRICE = "COLUMN_DRIVERS_PRICE";
    public DatabaseDrivers(@Nullable Context context) {
        super(context, "drivers.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + DRIVERS_TABLE + " (" + COLUMN_DRIVERS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_DRIVERS_NAME + " TEXT, " + COLUMN_DRIVERS_SURNAME + " TEXT, " + COLUMN_DRIVERS_PHONE + " INTEGER, " +
                COLUMN_DRIVERS_EMAIL + " TEXT, " + COLUMN_DRIVERS_COUNTRY_OF_BORN + " TEXT, "+ COLUMN_DRIVERS_DATE_OF_BORN + " DATE, "
                + COLUMN_DRIVERS_TYPE_OF_DRIVER + " TEXT, "
                + COLUMN_DRIVERS_RESERVATION_ID + " TEXT, "  + COLUMN_DRIVERS_CITY_RESERVATION + " TEXT, " + COLUMN_DRIVERS_MODEL + " TEXT, "
                + COLUMN_DRIVERS_START_DATE + " DATE, " + COLUMN_DRIVERS_END_DATE + " DATE, "
                + COLUMN_DRIVERS_PRICE + " INTEGER)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean addDrivers(DriversModel driversModel) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());


        String name = driversModel.getName();
        String surname = driversModel.getSurname();
        int phone  = driversModel.getPhone();
        String email = driversModel.getEmail();
        String country = driversModel.getCountryOfBorn();
        Calendar dateOfBorn = driversModel.getDateOfBorn();
        String typeOfDriver = driversModel.getTypeOfDriver();
        String reservationID = driversModel.getReservationID();
        String city = driversModel.getCity();
        String model = driversModel.getModel();
        Calendar startDate = driversModel.getStart();
        Calendar endDate = driversModel.getEnd();
        int price = driversModel.getPrice();

        cv.put(COLUMN_DRIVERS_NAME, name);
        cv.put(COLUMN_DRIVERS_SURNAME, surname);
        cv.put(COLUMN_DRIVERS_PHONE,phone);
        cv.put(COLUMN_DRIVERS_EMAIL,email);
        cv.put(COLUMN_DRIVERS_COUNTRY_OF_BORN,country);
        cv.put(COLUMN_DRIVERS_DATE_OF_BORN, dateFormat.format(dateOfBorn.getTime()));
        cv.put(COLUMN_DRIVERS_TYPE_OF_DRIVER,typeOfDriver);
        cv.put(COLUMN_DRIVERS_RESERVATION_ID,reservationID);
        cv.put(COLUMN_DRIVERS_CITY_RESERVATION,city);
        cv.put(COLUMN_DRIVERS_MODEL,model);
        cv.put(COLUMN_DRIVERS_START_DATE, dateFormat.format(startDate.getTime()));
        cv.put(COLUMN_DRIVERS_END_DATE, dateFormat.format(endDate.getTime()));
        cv.put(COLUMN_DRIVERS_PRICE,price);

        long insert = db.insert(DRIVERS_TABLE, null, cv);

        db.close();

        if (insert == -1) {
            return false;
        } else return true;

    }
}
