package Flights;

import Databases.DatabaseFlights;
import Models.FlightsModel;
import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.searchflightmobileapp.R;

public class ShowFlightMenu extends AppCompatActivity {
    DatabaseFlights databaseFlights;
    ListView lv_list;
    ArrayAdapter<FlightsModel> flightsArrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_flight_menu);

        lv_list = findViewById(R.id.lv_listReturn);

        databaseFlights = new DatabaseFlights(ShowFlightMenu.this);



        ShowFlightsOnListView(databaseFlights);
    }

    private void ShowFlightsOnListView(DatabaseFlights databaseFlights) {
        Intent i = getIntent();
        String startCity = i.getStringExtra("Start");
        String landingCity = i.getStringExtra("Landing");
        flightsArrayAdapter = new ArrayAdapter<>(ShowFlightMenu.this, android.R.layout.simple_list_item_1, databaseFlights.getYourFlightCity(startCity,landingCity));

        lv_list.setAdapter(flightsArrayAdapter);

    }
    public void setButtonReturn(View v){
        Intent i = new Intent(this, ShowReturnFlight.class);
        // pobierane są dane z klasy SearchYourFlightMenu które są podawane dalej
        // do klasy ShowReturnFlight pokazujące loty powrotne na podstawie podanych danych
        String returnLandingCity = getIntent().getStringExtra("Start");
        String returnStartCity = getIntent().getStringExtra("Landing");

        // pobieranie ceny pierwszego lotu z listy
        if (flightsArrayAdapter != null && flightsArrayAdapter.getCount() > 0) {
            // Get the price of the first flight in the list (you may want to modify this logic based on your requirements)
            int outboundPrice = flightsArrayAdapter.getItem(0).getPrice();
            i.putExtra("FirstPrice", outboundPrice);
        }

        i.putExtra("Start",returnStartCity);
        i.putExtra("Landing",returnLandingCity);
        startActivity(i);
    }
}