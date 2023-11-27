package com.example.searchflightmobileapp;

import Cars.RentYourCarMenu;
import Databases.DatabaseCars;
import Databases.DatabaseFlights;
import Flights.SearchYourFlightMenu;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    DatabaseFlights databaseFlights;
    DatabaseCars databaseCars;
    ImageView flightsIMG, carsIMG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flightsIMG = findViewById(R.id.flightsIMG);

        carsIMG = findViewById(R.id.carsIMG);

        databaseFlights = new DatabaseFlights(this);
        databaseCars = new DatabaseCars(this);
    }

    public void setFlights(View v){
        Log.d("MainActivity", "setFlights: Clicked");
        databaseFlights.addFlights();
        Intent i = new Intent(this, SearchYourFlightMenu.class);
        startActivity(i);
    }

    public void setCarsIMG(View v){
        Log.d("MainActivity", "setCarsIMG: Clicked");
        databaseCars.addCars();
        Intent i = new Intent(this, RentYourCarMenu.class);
        startActivity(i);
    }

    public void proba(View v){
        Intent i = new Intent(this, SearchFlightsMenu.class);
        startActivity(i);
    }
    public void proba2(View v){
        Intent i = new Intent(this, RentCarsMenu.class);
        startActivity(i);
    }
}