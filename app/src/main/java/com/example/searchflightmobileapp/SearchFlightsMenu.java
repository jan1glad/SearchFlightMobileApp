package com.example.searchflightmobileapp;

import Databases.DatabaseFlights;
import Models.FlightsModel;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class SearchFlightsMenu extends AppCompatActivity {

    ListView lv_flights;
    DatabaseFlights databaseFlights;
    ArrayAdapter<FlightsModel> flightsArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_flights_menu);
        lv_flights = findViewById(R.id.lv_flights);

        databaseFlights = new DatabaseFlights(SearchFlightsMenu.this);

        ShowFlightsOnListView(databaseFlights);

    }

    private void ShowFlightsOnListView(DatabaseFlights databaseFlights) {
        flightsArrayAdapter = new ArrayAdapter<>(SearchFlightsMenu.this, android.R.layout.simple_list_item_1, databaseFlights.getEveryone());

        lv_flights.setAdapter(flightsArrayAdapter);
    }
}