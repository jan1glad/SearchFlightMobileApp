package Flights;

import Databases.DatabasePassengers;
import Models.PassengersModel;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.searchflightmobileapp.EndingBasket;
import com.example.searchflightmobileapp.R;
import com.example.searchflightmobileapp.Try;

import java.text.SimpleDateFormat;
import java.util.*;

public class FlightsPassengerForm extends AppCompatActivity {

    int liczba = 0;

    int numberOfPassengers=1;
    public Calendar bornDatePass1, bornDatePass2, bornDatePass3;

    public Calendar [] dates;

    Button btn_AddPassenger2, btn_AddPassenger3;
    Button [] btn_bornDatePass;
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


        bornDatePass1 = Calendar.getInstance();
        bornDatePass2 = Calendar.getInstance();
        bornDatePass3 = Calendar.getInstance();

        dates = new Calendar[3];

       /* sr_NumberOfPassengers = findViewById(R.id.sr_NumberOfPassengers);

        String [] number = {"1","2","3","4"};
        ArrayAdapter<String> numberPass = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, number);
        sr_NumberOfPassengers.setAdapter(numberPass);
*/
        btn_bornDatePass = new Button[]{findViewById(R.id.btn_bornDatePass1),
                findViewById(R.id.btn_bornDatePass2),
                findViewById(R.id.btn_bornDatePass3)};
        btn_bornDatePass[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialogBorn();
            }
        });
        btn_bornDatePass[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialogBorn();
                liczba++;
            }
        });
        btn_bornDatePass[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialogBorn();
                liczba++;
            }
        });

        // Initialize arrays of views
        nameEditTexts = new EditText[]{findViewById(R.id.edt_NamePassenger1), findViewById(R.id.edt_NamePassenger2),
                findViewById(R.id.edt_NamePassenger3)};

        surnameEditTexts = new EditText[]{findViewById(R.id.edt_SurnamePassenger1), findViewById(R.id.edt_SurnamePassenger2),
                findViewById(R.id.edt_SurnamePassenger3)};

        countryAutoCompleteTextViews = new AutoCompleteTextView[]{findViewById(R.id.ac_CountryPassenger1),
                findViewById(R.id.ac_CountryPassenger2), findViewById(R.id.ac_CountryPassenger3)};


        for (int i = 1; i < nameEditTexts.length; i++) {
            nameEditTexts[i].setVisibility(View.INVISIBLE);
            surnameEditTexts[i].setVisibility(View.INVISIBLE);
            btn_bornDatePass[i].setVisibility(View.INVISIBLE);

            countryAutoCompleteTextViews[i].setVisibility(View.INVISIBLE);
        }
        btn_AddPassenger2 = findViewById(R.id.btn_AddPassenger2);
        btn_AddPassenger3 = findViewById(R.id.btn_AddPassenger3);
        btn_AddPassenger3.setVisibility(View.INVISIBLE);
    }

    public void setBtn_AddPassenger2(View v) {
        nameEditTexts[1].setVisibility(View.VISIBLE);
        surnameEditTexts[1].setVisibility(View.VISIBLE);
        btn_bornDatePass[1].setVisibility(View.VISIBLE);
        countryAutoCompleteTextViews[1].setVisibility(View.VISIBLE);
        btn_AddPassenger3.setVisibility(View.VISIBLE);
        numberOfPassengers++;
    }

    public void setBtn_AddPassenger3(View v) {
        nameEditTexts[2].setVisibility(View.VISIBLE);
        surnameEditTexts[2].setVisibility(View.VISIBLE);
        btn_bornDatePass[2].setVisibility(View.VISIBLE);
        countryAutoCompleteTextViews[2].setVisibility(View.VISIBLE);
        numberOfPassengers++;
    }


    private void openDialogBorn(){
        //in DarkMode on my phone I don't see anything but this is used with themes to design the calendar R.style.DialogTheme,
        // it should be between this and new DatePickerDialog.OnDateSetListener()
        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                if (liczba==0) {

                    bornDatePass1.set(year, month, day);
                    Log.d("Date", "Date of Born: " + bornDatePass1);
                    btn_bornDatePass[0].setText(formatDate(bornDatePass1));
                    dates[0] = bornDatePass1;
                } else if (liczba<=1) {
                    bornDatePass1.set(year, month, day);
                    Log.d("Date", "Date of Born: " + bornDatePass1);
                    btn_bornDatePass[0].setText(formatDate(bornDatePass1));
                    dates[0] = bornDatePass1;

                    bornDatePass2.set(year, month, day);
                    Log.d("Date", "Date of Born: " + bornDatePass2);
                    btn_bornDatePass[1].setText(formatDate(bornDatePass2));
                    dates[1] = bornDatePass2;
                } else if (liczba<=2) {

                    bornDatePass1.set(year, month, day);
                    Log.d("Date", "Date of Born: " + bornDatePass1);
                    btn_bornDatePass[0].setText(formatDate(bornDatePass1));
                    dates[0] = bornDatePass1;

                    bornDatePass2.set(year, month, day);
                    Log.d("Date", "Date of Born: " + bornDatePass2);
                    btn_bornDatePass[1].setText(formatDate(bornDatePass2));
                    dates[1] = bornDatePass2;

                    bornDatePass3.set(year, month, day);
                    Log.d("Date", "Date of Born: " + bornDatePass3);
                    btn_bornDatePass[2].setText(formatDate(bornDatePass3));
                    dates[2] = bornDatePass3;
                }
            }
        }, 2023, 10, 20);

        dialog.show();
    }

    private String formatDate(Calendar calendar) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd", Locale.getDefault());
        return dateFormat.format(calendar.getTime());
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
                        countryAutoCompleteTextViews[y].getText().toString(), dates[y], reservationID, startCity, landingCity, totalPrice);
                passengersModelList.add(passengersModel);
            }
            //Toast.makeText(FlightsPassengerForm.this, "Success", Toast.LENGTH_SHORT).show();
        } catch (NumberFormatException e) {
            e.printStackTrace();
            // Handle the parsing error (e.g., show an error message to the user)
        }


        DatabasePassengers databasePassengers = new DatabasePassengers(FlightsPassengerForm.this);


        // Intent wyjac z petli zeby nie odpalo sie dwa razy tylko raz
        // bo pozniej przy cofaniu z mainpage trzeba dwa razy kliknac

        for (PassengersModel passengersModel : passengersModelList) {
            boolean success = databasePassengers.addPassengers(passengersModel);
            if (success) {
                Toast.makeText(FlightsPassengerForm.this, "Success", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, EndingBasket.class);
                startActivity(intent);
            } else Toast.makeText(FlightsPassengerForm.this, "Something went wrong", Toast.LENGTH_SHORT).show();

        }
    }

}