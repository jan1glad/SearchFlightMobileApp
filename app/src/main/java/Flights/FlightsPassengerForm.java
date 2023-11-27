package Flights;

import Databases.DatabasePassengers;
import Models.PassengersModel;
import android.content.Intent;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.searchflightmobileapp.R;
import com.example.searchflightmobileapp.Try;

import java.util.ArrayList;
import java.util.List;

public class FlightsPassengerForm extends AppCompatActivity {
    int numberOfPassengers=1;
    Button btn_AddPassenger2, btn_AddPassenger3;
    EditText[] nameEditTexts, surnameEditTexts, bornEditTexts;
    EditText edt_PhonePassenger, edt_EmailPassenger, edt_Country;
    AutoCompleteTextView[] countryAutoCompleteTextViews;
    //Spinner sr_NumberOfPassengers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flights_passenger_form);

        edt_PhonePassenger = findViewById(R.id.edt_PhonePassenger);
        edt_EmailPassenger = findViewById(R.id.edt_EmailPassenger);

        int randomNumber = (int) (Math.random() * 90000) + 10000;
        String reservationID = "LOT " + randomNumber;

        Intent intent = getIntent();
        String startCity = intent.getStringExtra("Start1");
        String landingCity = intent.getStringExtra("Landing1");
        int totalPrice = intent.getIntExtra("totalPrice", 0);



       /* sr_NumberOfPassengers = findViewById(R.id.sr_NumberOfPassengers);

        String [] number = {"1","2","3","4"};
        ArrayAdapter<String> numberPass = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, number);
        sr_NumberOfPassengers.setAdapter(numberPass);
*/

        // Initialize arrays of views
        nameEditTexts = new EditText[]{findViewById(R.id.edt_NamePassenger1), findViewById(R.id.edt_NamePassenger2),
                findViewById(R.id.edt_NamePassenger3), findViewById(R.id.edt_NamePassenger4)};

        surnameEditTexts = new EditText[]{findViewById(R.id.edt_SurnamePassenger1), findViewById(R.id.edt_SurnamePassenger2),
                findViewById(R.id.edt_SurnamePassenger3), findViewById(R.id.edt_SurnamePassenger4)};

        bornEditTexts = new EditText[]{findViewById(R.id.edt_BornPassenger1), findViewById(R.id.edt_BornPassenger2),
                findViewById(R.id.edt_BornPassenger3), findViewById(R.id.edt_BornPassenger4)};

        countryAutoCompleteTextViews = new AutoCompleteTextView[]{findViewById(R.id.ac_CountryPassenger1),
                findViewById(R.id.ac_CountryPassenger2), findViewById(R.id.ac_CountryPassenger3),
                findViewById(R.id.ac_CountryPassenger4)};


        for (int i = 1; i < nameEditTexts.length; i++) {
            nameEditTexts[i].setVisibility(View.INVISIBLE);
            surnameEditTexts[i].setVisibility(View.INVISIBLE);
            bornEditTexts[i].setVisibility(View.INVISIBLE);
            countryAutoCompleteTextViews[i].setVisibility(View.INVISIBLE);
        }
        btn_AddPassenger3 = findViewById(R.id.btn_AddPassenger3);
        btn_AddPassenger3.setVisibility(View.INVISIBLE);
    }

    public void setBtn_AddPassenger2(View v) {
        nameEditTexts[1].setVisibility(View.VISIBLE);
        surnameEditTexts[1].setVisibility(View.VISIBLE);
        bornEditTexts[1].setVisibility(View.VISIBLE);
        countryAutoCompleteTextViews[1].setVisibility(View.VISIBLE);
        btn_AddPassenger3.setVisibility(View.VISIBLE);
        numberOfPassengers++;
    }

    public void setBtn_AddPassenger3(View v) {
        nameEditTexts[2].setVisibility(View.VISIBLE);
        surnameEditTexts[2].setVisibility(View.VISIBLE);
        bornEditTexts[2].setVisibility(View.VISIBLE);
        countryAutoCompleteTextViews[2].setVisibility(View.VISIBLE);
        numberOfPassengers++;
    }
    /*
        // Set the listener for the spinner
        sr_NumberOfPassengers.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Set visibility based on the selected number
                setVisibility(Integer.parseInt(number[position]));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Do nothing here
            }
        });
    }

    // Method to set visibility based on the selected number
    private void setVisibility(int numberOfPassengers) {
        for (int i = 0; i < 4; i++) {
            nameEditTexts[i].setVisibility(i < numberOfPassengers ? View.VISIBLE : View.GONE);
            surnameEditTexts[i].setVisibility(i < numberOfPassengers ? View.VISIBLE : View.GONE);
            bornEditTexts[i].setVisibility(i < numberOfPassengers ? View.VISIBLE : View.GONE);
            countryAutoCompleteTextViews[i].setVisibility(i < numberOfPassengers ? View.VISIBLE : View.GONE);
        }
    } */

    public void setBtn_goBack(View v) {
        finish();
    }

    public void setBtn_Next(View v) {
        List<PassengersModel> passengersModelList = new ArrayList<>();

        Intent i = getIntent();
        String startCity = i.getStringExtra("Start1");
        String landingCity = i.getStringExtra("Landing1");
        int totalPrice = i.getIntExtra("totalPrice", 0);

        int randomNumber = (int) (Math.random() * 90000) + 10000;
        String reservationID = "LOT " + randomNumber;

        String phoneText = edt_PhonePassenger.getText().toString();

        try {
            for (int y = 0; y < numberOfPassengers; y++) {
                PassengersModel passengersModel = new PassengersModel(-1, nameEditTexts[y].getText().toString(), surnameEditTexts[y].getText().toString(),
                        Integer.parseInt(phoneText), edt_EmailPassenger.getText().toString(),
                        countryAutoCompleteTextViews[y].getText().toString(), reservationID, startCity, landingCity, totalPrice);
                passengersModelList.add(passengersModel);
            }
            //Toast.makeText(FlightsPassengerForm.this, "Success", Toast.LENGTH_SHORT).show();
        } catch (NumberFormatException e) {
            e.printStackTrace();
            // Handle the parsing error (e.g., show an error message to the user)
        }


        DatabasePassengers databasePassengers = new DatabasePassengers(FlightsPassengerForm.this);


        for (PassengersModel passengersModel : passengersModelList) {
            boolean success = databasePassengers.addPassengers(passengersModel);
            if (success) {
                Toast.makeText(FlightsPassengerForm.this, "Success", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, Try.class);
                startActivity(intent);
            } else Toast.makeText(FlightsPassengerForm.this, "Something went wrong", Toast.LENGTH_SHORT).show();

        }
    }

}