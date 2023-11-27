package com.example.searchflightmobileapp;

import Databases.DatabaseCars;
import Models.CarsModel;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class RentCarsMenu extends AppCompatActivity {
    ListView lv_cars;
    DatabaseCars databaseCars;
    ArrayAdapter<CarsModel> carsArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent_cars_menu);

        lv_cars = findViewById(R.id.lv_cars);

        databaseCars = new DatabaseCars(RentCarsMenu.this);

        ShowCarsOnListView(databaseCars);
    }

    private void ShowCarsOnListView(DatabaseCars databaseCars) {
        carsArrayAdapter = new ArrayAdapter<>(RentCarsMenu.this, android.R.layout.simple_list_item_1, databaseCars.getEveryone());

        lv_cars.setAdapter(carsArrayAdapter);
    }
}