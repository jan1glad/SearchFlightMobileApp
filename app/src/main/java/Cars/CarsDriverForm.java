package Cars;

import Databases.DatabaseDrivers;
import Models.DriversModel;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.searchflightmobileapp.MainActivity;
import com.example.searchflightmobileapp.R;
import com.example.searchflightmobileapp.Try;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class CarsDriverForm extends AppCompatActivity {

    String carModel="";
    int carYear=0;
    String carGas="";
    String carCity="";
    int numberOfDrivers=0;

    long daysDifference=0;
    int price=0;
    public Calendar pickupDateCalendar;
    public Calendar endDateCalendar;
    public Calendar dateOfBorn;
    TextView txt_ShowPickupDate,txt_ShowEndDate, txt_NumberOfDays,txt_Price;
    Button btn_SetPickupDate, btn_SetEndDate, btn_SetBornDate;
    TextView txt_CarChose;
    Button btn_AddDriver;
    EditText[] nameEditTexts, surnameEditTexts, bornEditTexts;
    EditText edt_PhoneDriver, edt_EmailDriver, edt_Country;
    AutoCompleteTextView[] countryAutoCompleteTextViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cars_driver_form);

        txt_NumberOfDays = findViewById(R.id.txt_NumberOfDays);
        txt_Price = findViewById(R.id.txt_Price);

        txt_ShowPickupDate = findViewById(R.id.txt_ShowPickupDate);
        btn_SetPickupDate = findViewById(R.id.btn_SetPickupDate);

        txt_ShowEndDate = findViewById(R.id.txt_ShowEndDate);
        btn_SetEndDate = findViewById(R.id.btn_SetEndDate);

        btn_SetBornDate = findViewById(R.id.btn_SetBornDate);

        edt_PhoneDriver = findViewById(R.id.edt_PhoneDriver);

        edt_EmailDriver = findViewById(R.id.edt_EmailDriver);


        pickupDateCalendar = Calendar.getInstance();
        endDateCalendar = Calendar.getInstance();
        dateOfBorn = Calendar.getInstance();


        btn_SetBornDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialogBorn();
            }
        });

        btn_SetPickupDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openDialogStart();

            }
        });
        btn_SetEndDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openDialogEnd();

            }
        });




        Intent x = getIntent();

        carModel = x.getStringExtra("model");
        carYear = x.getIntExtra("year",0);
        price = x.getIntExtra("price",0);
        carGas = x.getStringExtra("gas");
        carCity = x.getStringExtra("city");

        txt_CarChose = findViewById(R.id.txt_CarChose);

        txt_CarChose.setText("Choosen car: "+carModel+", "+carYear+", "+carGas );



        nameEditTexts = new EditText[]{findViewById(R.id.edt_NameDriver), findViewById(R.id.edt_NameDriver2)};

        surnameEditTexts = new EditText[]{findViewById(R.id.edt_SurnameDriver), findViewById(R.id.edt_SurnameDriver2)};

        bornEditTexts = new EditText[]{findViewById(R.id.edt_BornDriver), findViewById(R.id.edt_BornDriver2)};

        countryAutoCompleteTextViews = new AutoCompleteTextView[]{findViewById(R.id.ac_CountryDriver),
                findViewById(R.id.ac_CountryDriver2)};


        for (int i = 1; i < nameEditTexts.length; i++) {
            nameEditTexts[i].setVisibility(View.INVISIBLE);
            surnameEditTexts[i].setVisibility(View.INVISIBLE);
            bornEditTexts[i].setVisibility(View.INVISIBLE);
            countryAutoCompleteTextViews[i].setVisibility(View.INVISIBLE);
        }
    }

    public void setBtn_AddDriver(View v) {
        nameEditTexts[1].setVisibility(View.VISIBLE);
        surnameEditTexts[1].setVisibility(View.VISIBLE);
        bornEditTexts[1].setVisibility(View.VISIBLE);
        countryAutoCompleteTextViews[1].setVisibility(View.VISIBLE);
        numberOfDrivers++;
    }

    public void setBtn_goBack(View v) {
        finish();
    }

    private String formatDate(Calendar calendar) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd", Locale.getDefault());
        return dateFormat.format(calendar.getTime());
    }

    private void updatePickupDateDisplay(){
        txt_ShowPickupDate.setText(formatDate(pickupDateCalendar));
    }
    private void updateEndDateDisplay(){
        txt_ShowEndDate.setText(formatDate(endDateCalendar));
    }

    private void openDialogStart(){
        //in DarkMode on my phone I don't see anything but this is used with themes to design the calendar R.style.DialogTheme,
        // it should be between this and new DatePickerDialog.OnDateSetListener()
        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                pickupDateCalendar.set(year, month, day);
                updatePickupDateDisplay();

            }
        }, 2023, 10, 20);

        dialog.show();
    }

    private void openDialogEnd(){
        //in DarkMode on my phone I don't see anything but this is used with themes to design the calendar R.style.DialogTheme,
        // it should be between this and new DatePickerDialog.OnDateSetListener()
        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                endDateCalendar.set(year, month, day);
                updateEndDateDisplay();
                calculateAndDisplayNumberOfDays();

            }
        }, 2023, 10, 20);

        dialog.show();
    }

    private void openDialogBorn(){
        //in DarkMode on my phone I don't see anything but this is used with themes to design the calendar R.style.DialogTheme,
        // it should be between this and new DatePickerDialog.OnDateSetListener()
        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                dateOfBorn.set(year, month, day);
                Log.d("Date", "Date of Born: " + dateOfBorn);
                btn_SetBornDate.setText(formatDate(dateOfBorn));

            }
        }, 2023, 10, 20);

        dialog.show();
    }

    private void calculateAndDisplayNumberOfDays() {
        long differenceInMillis = endDateCalendar.getTimeInMillis() - pickupDateCalendar.getTimeInMillis();
        daysDifference = differenceInMillis / (24 * 60 * 60 * 1000);
        daysDifference+=1;
        price*= (int) daysDifference;
        txt_Price.setText("Price: "+price);
        txt_NumberOfDays.setText("Number of full days: "+daysDifference);
    }

    public void setBtn_NextInsertDriver(View v){

        Log.d("ButtonClick", "Next button clicked");
        Log.d("Date", "Date of start: " + dateOfBorn.toString());
        Log.d("Date", "Date of start: " + pickupDateCalendar.toString());
        Log.d("Date", "Date of end: " + endDateCalendar.toString());


        List<DriversModel> driversModelList = new ArrayList<>();

        Intent x = getIntent();

       // dateOfBorn.set(2012,10,10);

        carModel = x.getStringExtra("model");
        carYear = x.getIntExtra("year",0);
        carGas = x.getStringExtra("gas");
        carCity = x.getStringExtra("city");

        String typeOfDriver="Main Driver";

        int randomNumber = (int) (Math.random() * 90000) + 10000;
        String reservationID = "CAR " + randomNumber;

        String phoneText = edt_PhoneDriver.getText().toString();


        try {
            /*for (int y = 0; y < numberOfDrivers; y++) {
                if (y==0){
                    typeOfDriver="Main Driver";
                }else {
                    typeOfDriver="Second Driver";
                } */
                // pierwszy pickupDateCalendar trzeba zamienic na dateOfBorn
                // najpierw trzeba stworzyc aby uzytkownik mogl wybrac swoja date urodzin
                // jest problem poniewaz pickup i enddate jest wprowadzony w tej klasie jako Calendar
                // w klasie DriversModel jest jako LocalDate wiec trzeba to naprawic w najlepszy mozliwy sposob
                DriversModel driversModel = new DriversModel(-1,nameEditTexts[0].getText().toString(), surnameEditTexts[0].getText().toString(),
                        Integer.parseInt(phoneText), edt_EmailDriver.getText().toString(),
                        countryAutoCompleteTextViews[0].getText().toString(), dateOfBorn, typeOfDriver, reservationID, carCity,carModel, pickupDateCalendar,
                    endDateCalendar,price);
                driversModelList.add(driversModel);
           // }
        } catch (Exception e){
            e.printStackTrace();
        }

        DatabaseDrivers databaseDrivers = new DatabaseDrivers(CarsDriverForm.this);


        for (DriversModel driversModel : driversModelList){
            boolean succes = databaseDrivers.addDrivers(driversModel);
            if (succes){
                Toast.makeText(CarsDriverForm.this,"Success",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, Try.class);
                startActivity(intent);
            }else Toast.makeText(CarsDriverForm.this,"Something went wrong",Toast.LENGTH_SHORT).show();

        }

    }
}

