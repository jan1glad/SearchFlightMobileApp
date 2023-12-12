package Flights;

import Databases.DatabaseFlights;
import Models.FlightsModel;
import android.content.Intent;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.searchflightmobileapp.R;

public class ShowReturnFlight extends AppCompatActivity {

    Button btn_formFlights;
    TextView totalPriceTextView;
    int totalPrice;
    int basePrice; // Define the base price variable
    DatabaseFlights databaseFlights;
    ListView lv_listReturn;
    ArrayAdapter<FlightsModel> flightsArrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_return_flight);
        lv_listReturn = findViewById(R.id.lv_listReturn);

        databaseFlights = new DatabaseFlights(ShowReturnFlight.this);

        ShowFlightsOnListView(databaseFlights);


        totalPriceTextView = findViewById(R.id.txt_cena);

        // Set the base price
        basePrice = getIntent().getIntExtra("FirstPrice", 0);
        totalPriceTextView.setText("Total price for two flights: ");

        //totalPrice = basePrice; // Initialize with the base price

        // Set item click listener for the ListView
        lv_listReturn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected flight model
                FlightsModel selectedFlight = flightsArrayAdapter.getItem(position);

                // Update the total price with the selected flight's price and display it
                totalPrice = basePrice + selectedFlight.getPrice();
                totalPriceTextView.setText("Total price for two flights: " + totalPrice);
                Intent i = getIntent();
                i.putExtra("totalPrice",totalPrice);
            }
        });
    }
    private void ShowFlightsOnListView(DatabaseFlights databaseFlights) {
        Intent i = getIntent();
        String startCity = i.getStringExtra("StartCity");
        String landingCity = i.getStringExtra("LandingCity");
        String startCountry = i.getStringExtra("StartCountry");
        String finishCountry = i.getStringExtra("LandingCountry");
        boolean country = i.getBooleanExtra("country",false);
        boolean oneWay = i.getBooleanExtra("oneWay",false);
        //int price = i.getIntExtra("FirstPrice",0);
        if (country&&!oneWay) {
            flightsArrayAdapter = new ArrayAdapter<>(ShowReturnFlight.this, android.R.layout.simple_list_item_1, databaseFlights.getYourFlightCountry(startCountry, finishCountry));
        } else if (!country && !oneWay) {
            flightsArrayAdapter = new ArrayAdapter<>(ShowReturnFlight.this, android.R.layout.simple_list_item_1, databaseFlights.getYourFlightCity(startCity, landingCity));
        }else if (!country && oneWay){
            flightsArrayAdapter = new ArrayAdapter<>(ShowReturnFlight.this, android.R.layout.simple_list_item_1, databaseFlights.getYourOneWayFlightCity(startCity));
        } else if (country && oneWay) {
            flightsArrayAdapter = new ArrayAdapter<>(ShowReturnFlight.this, android.R.layout.simple_list_item_1, databaseFlights.getYourOneWayFlightCountry(startCountry));
        }

        lv_listReturn.setAdapter(flightsArrayAdapter);


//        i.putExtra("Start1",landingCity);
//        i.putExtra("Landing1",startCity);
        /*    int totalPrice = price;

            List<FlightsModel> flightsList = new ArrayList<>();
            for (int j = 0; j < flightsArrayAdapter.getCount(); j++) {
                flightsList.add(flightsArrayAdapter.getItem(j));
            }

            for (FlightsModel flightsModel : flightsList){
                totalPrice += flightsModel.getPrice();
            }
            TextView totalPriceTextView = findViewById(R.id.txt_cena);
            totalPriceTextView.setText("Total price for two flights: " + totalPrice);
        } else {
            System.out.println("Null Null");
        }*/
        }



    public void setBtn_formFlights(View v) {

        Intent i = new Intent(this, FlightsPassengerForm.class);

        // Get values from the current activity
        String startCity = getIntent().getStringExtra("Start");
        String landingCity = getIntent().getStringExtra("Landing");
        int totalPrice = getIntent().getIntExtra("totalPrice", 0);

        // Pass values to the next activity
        i.putExtra("Start1", landingCity);
        i.putExtra("Landing1", startCity);
        i.putExtra("totalPrice", totalPrice);

        // Start the next activity
        startActivity(i);
    }
}