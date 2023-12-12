package com.example.searchflightmobileapp;

import Cars.RentYourCarMenu;
import Databases.DatabaseCars;
import Databases.DatabaseFlights;
import Flights.SearchYourFlightMenu;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Spinner spn_PolandCheap;
    DatabaseFlights databaseFlights;
    DatabaseCars databaseCars;
    ImageView imageView2, imageView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spn_PolandCheap = findViewById(R.id.spn_PolandCheap);

        String[] flightsPolandCheap = getResources().getStringArray(R.array.flightsPolandCheap);

        imageView2 = findViewById(R.id.imageView2);

        imageView3 = findViewById(R.id.imageView3);

        databaseFlights = new DatabaseFlights(this);
        databaseCars = new DatabaseCars(this);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, flightsPolandCheap);
        spn_PolandCheap.setAdapter(adapter);



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