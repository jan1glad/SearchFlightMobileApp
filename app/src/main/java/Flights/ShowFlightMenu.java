package Flights;

import Databases.DatabaseFlights;
import Models.FlightsModel;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.searchflightmobileapp.R;

public class ShowFlightMenu extends AppCompatActivity {
    boolean country;
    boolean oneWay;
    String startCity;
    String landingCity;
    String startCountry;
    String finishCountry;
    DatabaseFlights databaseFlights;
    ListView lv_list;
    ArrayAdapter<FlightsModel> flightsArrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_flight_menu);



        Log.d("niewiem", String.valueOf(country));
        Log.d("niewiem", String.valueOf(oneWay));


        lv_list = findViewById(R.id.lv_listReturn);

        databaseFlights = new DatabaseFlights(ShowFlightMenu.this);



        ShowFlightsOnListView(databaseFlights);
    }

    private void ShowFlightsOnListView(DatabaseFlights databaseFlights) {

        Intent i = getIntent();
        country = i.getBooleanExtra("country", false);
        oneWay = i.getBooleanExtra("oneWay", false);
        startCity = i.getStringExtra("StartCity");
        landingCity = i.getStringExtra("LandingCity");
        startCountry = i.getStringExtra("StartCountry");
        finishCountry = i.getStringExtra("FinishCountry");

        Log.d("coschyba", startCity);

        if (country&&!oneWay) {
            flightsArrayAdapter = new ArrayAdapter<>(ShowFlightMenu.this, android.R.layout.simple_list_item_1, databaseFlights.getYourFlightCountry(startCountry, finishCountry));
        } else if (!country && !oneWay) {
            flightsArrayAdapter = new ArrayAdapter<>(ShowFlightMenu.this, android.R.layout.simple_list_item_1, databaseFlights.getYourFlightCity(startCity, landingCity));
        }else if (!country && oneWay){
            flightsArrayAdapter = new ArrayAdapter<>(ShowFlightMenu.this, android.R.layout.simple_list_item_1, databaseFlights.getYourOneWayFlightCity(startCity));
        } else if (country && oneWay) {
            flightsArrayAdapter = new ArrayAdapter<>(ShowFlightMenu.this, android.R.layout.simple_list_item_1, databaseFlights.getYourOneWayFlightCountry(startCountry));
        }


        lv_list.setAdapter(flightsArrayAdapter);

    }
    public void setButtonReturn(View v){
        Intent i = new Intent(this, ShowReturnFlight.class);
        // pobierane są dane z klasy SearchYourFlightMenu które są podawane dalej
        // do klasy ShowReturnFlight pokazujące loty powrotne na podstawie podanych danych
        String returnLandingCity = getIntent().getStringExtra("StartCity");
        String returnStartCity = getIntent().getStringExtra("LandingCity");
        String returnStartCountry = getIntent().getStringExtra("StartCountry");
        String returnStartLanding = getIntent().getStringExtra("LandingCountry");
        country = getIntent().getBooleanExtra("country",false);
        oneWay = getIntent().getBooleanExtra("oneWay",false);


        // pobieranie ceny pierwszego lotu z listy
        if (flightsArrayAdapter != null && flightsArrayAdapter.getCount() > 0) {
            // Get the price of the first flight in the list (you may want to modify this logic based on your requirements)
            int outboundPrice = flightsArrayAdapter.getItem(0).getPrice();
            i.putExtra("FirstPrice", outboundPrice);
        }

        i.putExtra("StartCity",returnStartCity);
        i.putExtra("LandingCity",returnLandingCity);
        i.putExtra("StartCountry",returnStartCountry);
        i.putExtra("LandingCountry",returnStartLanding);
        i.putExtra("country",country);
        i.putExtra("oneWay",oneWay);
        startActivity(i);
    }
}