package Databases;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import Models.CarsModel;

import java.util.ArrayList;
import java.util.List;

public class DatabaseCars extends SQLiteOpenHelper {

    public static final String CARS_TABLE = "CARS_TABLE";
    public static final String COLUMN_CARS_ID = "COLUMN_CARS_ID";
    public static final String COLUMN_CARS_MODEL = "COLUMN_CARS_MODEL";
    public static final String COLUMN_CARS_YEAR = "COLUMN_CARS_YEAR";
    public static final String COLUMN_CARS_TYPE = "COLUMN_CARS_TYPE";
    public static final String COLUMN_CARS_GAS = "COLUMN_CARS_GAS";
    public static final String COLUMN_CARS_PRICE = "COLUMN_CARS_PRICE";
    public static final String COLUMN_CARS_CITY = "COLUMN_CARS_CITY";

    public DatabaseCars(@Nullable Context context) {
        super(context, "cars.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + CARS_TABLE + " (" + COLUMN_CARS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_CARS_MODEL + " TEXT, " + COLUMN_CARS_YEAR + " INTEGER, " + COLUMN_CARS_TYPE + " TEXT, " +
                COLUMN_CARS_GAS + " TEXT, "  + COLUMN_CARS_PRICE + " INTEGER, "+ COLUMN_CARS_CITY + " TEXT)";
        db.execSQL(createTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addCars() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + CARS_TABLE);
        String cars = "INSERT INTO " + CARS_TABLE + "(`COLUMN_CARS_ID`, `COLUMN_CARS_MODEL`, `COLUMN_CARS_YEAR`, `COLUMN_CARS_TYPE`, `COLUMN_CARS_GAS`, `COLUMN_CARS_PRICE`, `COLUMN_CARS_CITY`) VALUES\n"
                + "(1, 'Tiguan', 2019, 'SUV', 'Diesel', 250, 'Rome'),\n" +
                "(2, 'Passat', 2021, 'Kombi', 'Diesel', 400, 'Lisbon'),\n" +
                "(3, 'Golf', 2020, 'Hatchback', 'Diesel', 300, 'Madrid'),\n" +
                "(4, 'Polo', 2022, 'Kompakt', 'Benzyna', 260, 'Lisbon'),\n" + "(5, 'Eos', 2017, 'Kabriolet', 'Benzyna', 500, 'Rome'),\n" +
                "(6, 'Compact', 2018, 'Sedan', 'Benzyna', 360, 'Madrid'),\n" + "(7, 'Vitara', 2019, 'SUV', 'Hybryda', 450, 'Lisbon'),\n" +
                "(8, 'Civic', 2021, 'Hatchback', 'Benzyna', 270, 'Madrid'),\n" + "(9, 'Astra', 2020, 'Sedan', 'Diesel', 330, 'Rome'),\n" +
                "(10, 'Renegade', 2017, 'SUV', 'Benzyna', 290, 'Madrid'),\n" + "(11, 'Megane', 2022, 'Cabriolet', 'Benzyna', 590, 'Lisbon'),\n" +
                "(12, 'Clio', 2018, 'Hatchback', 'Benzyna', 220, 'Rome');";
        db.execSQL(cars);
    }

    public List<CarsModel> getEveryone(){
        List<CarsModel> returnList = new ArrayList<>();

        String queryString = "SELECT * FROM " + CARS_TABLE;

        return getCars(returnList, queryString);
    }
    private List<CarsModel> getCars(List<CarsModel> returnList, String queryString) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()){

            do {
                int carsID = cursor.getInt(0);
                String model = cursor.getString(1);
                int year = cursor.getInt(2);
                String type = cursor.getString(3);
                String gas = cursor.getString(4);
                int price = cursor.getInt(5);
                String city = cursor.getString(6);

                CarsModel carsModel = new CarsModel(carsID, model, year, type, gas, price, city);

                returnList.add(carsModel);

            }while (cursor.moveToNext());

        }
        cursor.close();
        db.close();

        return returnList;
    }
    public List<CarsModel> getYourCar(String carCity){
        List<CarsModel> returnList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String queryString = "SELECT * FROM " + CARS_TABLE + " WHERE " + COLUMN_CARS_CITY + " = ? ";


        Cursor cursor = db.rawQuery(queryString, new String[]{carCity});

        if (cursor.moveToFirst()) {
            do {
                int carsID = cursor.getInt(0);
                String model = cursor.getString(1);
                int year = cursor.getInt(2);
                String type = cursor.getString(3);
                String gas = cursor.getString(4);
                int price = cursor.getInt(5);

                CarsModel carsModel = new CarsModel(carsID, model, year, type, gas, price, carCity);

                returnList.add(carsModel);

            }while (cursor.moveToNext());

        }
        cursor.close();
        db.close();

        return returnList;
    }

}
