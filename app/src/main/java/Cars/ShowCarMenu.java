package Cars;

import Databases.DatabaseCars;
import Models.CarsModel;
import Models.DriversModel;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.searchflightmobileapp.R;

public class ShowCarMenu extends AppCompatActivity {


    String model;
    int year;
    int price;
    String gas;
    String city;

    Button btn_next;
    ListView lv_listOfCars;
    DatabaseCars databaseCars;
    ArrayAdapter<CarsModel> carsArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_car_menu);

        lv_listOfCars = findViewById(R.id.lv_listOfCars);

        btn_next = findViewById(R.id.btn_next);


        databaseCars = new DatabaseCars(ShowCarMenu.this);

        ShowCarsOnListView(databaseCars);


        lv_listOfCars.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                CarsModel carsModel = carsArrayAdapter.getItem(position);

                model = carsModel.getModel();
                year = carsModel.getYear();
                price = carsModel.getPrice();
                gas = carsModel.getGas();
                city = carsModel.getCity();

            }
        });


        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ShowCarMenu.this, CarsDriverForm.class);

                if (carsArrayAdapter != null && carsArrayAdapter.getCount() > 0) {

                    i.putExtra("model", model);
                    i.putExtra("year", year);
                    i.putExtra("gas", gas);
                    i.putExtra("price", price);
                    i.putExtra("city", city);
                }

                startActivity(i);
            }
        });
    }


    private void ShowCarsOnListView(DatabaseCars databaseCars) {
        Intent i = getIntent();
        String carCity = i.getStringExtra("City");
        carsArrayAdapter = new ArrayAdapter<>(ShowCarMenu.this, android.R.layout.simple_list_item_single_choice, databaseCars.getYourCar(carCity));

        lv_listOfCars.setAdapter(carsArrayAdapter);
    }
}

