package Flights;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.searchflightmobileapp.R;

public class SearchYourFlightMenu extends AppCompatActivity {

    Spinner spn_StartCity, spn_FinishCity;
    Spinner spn_StartCountry, spn_FinishCountry;
    Button btn_SearchFlight;

    CheckBox box_OneWay, box_ByCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_your_flight_menu);

        String[] startCity = getResources().getStringArray(R.array.startCity);
        String[] landingCity = getResources().getStringArray(R.array.startCity);


        String[] countriesFlightStart = getResources().getStringArray(R.array.countriesFlight);
        String[] countriesFlightFinish = getResources().getStringArray(R.array.countriesFlight);

        box_OneWay = findViewById(R.id.box_OneWay);
        box_ByCountry = findViewById(R.id.box_ByCountry);

        btn_SearchFlight = findViewById(R.id.btn_SearchFlight);

        spn_StartCity = findViewById(R.id.spn_StartCity);
        spn_FinishCity = findViewById(R.id.spn_FinishCity);

        spn_StartCountry = findViewById(R.id.spn_StartCountry);
        spn_FinishCountry = findViewById(R.id.spn_FinishCountry);



        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, startCity);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, landingCity);

        spn_StartCity.setAdapter(adapter);
        spn_FinishCity.setAdapter(adapter2);



        ArrayAdapter<String> adapterCountry = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, countriesFlightStart);
        ArrayAdapter<String> adapter2Country = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, countriesFlightStart);

        spn_StartCountry.setAdapter(adapterCountry);
        spn_FinishCountry.setAdapter(adapter2Country);



        box_OneWay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (box_OneWay.isChecked()){
                    spn_FinishCity.setVisibility(View.INVISIBLE);
                    spn_FinishCountry.setVisibility(View.INVISIBLE);



                }else {

                    if (box_ByCountry.isChecked()) {
                        spn_FinishCity.setVisibility(View.INVISIBLE);
                        spn_FinishCountry.setVisibility(View.VISIBLE);
                    }else {
                        spn_FinishCity.setVisibility(View.VISIBLE);
                        spn_FinishCountry.setVisibility(View.INVISIBLE);
                    }
                }
            }
        });

        box_ByCountry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (box_ByCountry.isChecked()){
                    spn_StartCountry.setVisibility(View.VISIBLE);
                    spn_FinishCountry.setVisibility(View.VISIBLE);

                    spn_FinishCity.setVisibility(View.INVISIBLE);
                    spn_StartCity.setVisibility(View.INVISIBLE);

                    if (box_OneWay.isChecked()){

                        spn_FinishCountry.setVisibility(View.INVISIBLE);

                    }

                }else{
                    spn_StartCountry.setVisibility(View.INVISIBLE);
                    spn_FinishCountry.setVisibility(View.INVISIBLE);
                    spn_StartCity.setVisibility(View.VISIBLE);
                    if (!box_OneWay.isChecked()) {
                        spn_FinishCity.setVisibility(View.VISIBLE);
                    } else {
                        spn_FinishCity.setVisibility(View.INVISIBLE);
                    }

                }
            }
        });

        btn_SearchFlight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d("jasio", "box_ByCountry is checked: " + box_ByCountry.isChecked());
                Log.d("jasio", "box_OneWay is checked: " + box_OneWay.isChecked());


                boolean country = box_ByCountry.isChecked();
                boolean oneWay = box_OneWay.isChecked();

                String startCountry = spn_StartCountry.getSelectedItem().toString(); ;

                String startCity= spn_StartCity.getSelectedItem().toString();;

                String landingCity = spn_FinishCity.getSelectedItem().toString();

                String finishCountry = spn_FinishCountry.getSelectedItem().toString();

                Intent i = new Intent(SearchYourFlightMenu.this, ShowFlightMenu.class);

//                if (country && oneWay){
//                    startCountry = spn_StartCountry.getSelectedItem().toString();
//                    i.putExtra("StartCountry",startCountry);
//                    i.putExtra("country",country);
//                    i.putExtra("oneWay",oneWay);
//                } else if (country && !oneWay) {
//                    finishCountry = spn_FinishCountry.getSelectedItem().toString();
//                    startCountry = spn_StartCountry.getSelectedItem().toString();

//                    i.putExtra("country",country);
//                    i.putExtra("oneWay",oneWay);
//                } else if (!country && oneWay) {
//                    startCity= spn_StartCity.getSelectedItem().toString();
//                    i.putExtra("StartCity",startCity);
//                    i.putExtra("country",country);
//                    i.putExtra("oneWay",oneWay);
//                } else if (!country && !oneWay) {
//
//                    landingCity = spn_FinishCity.getSelectedItem().toString();
//                    startCity= spn_StartCity.getSelectedItem().toString();
//                    i.putExtra("StartCity",startCity);
//                    i.putExtra("FinishCity",landingCity);
//
//                }


                Log.d("lol", startCity + " " + landingCity);

                i.putExtra("country",country);
                    i.putExtra("oneWay",oneWay);

                i.putExtra("StartCountry",startCountry);
                i.putExtra("FinishCountry",finishCountry);

                i.putExtra("StartCity",startCity);

                i.putExtra("LandingCity",landingCity);
                startActivity(i);

            }
        });

    }
}