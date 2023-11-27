package Cars;

import Databases.DatabaseCars;
import Models.CarsModel;
import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.searchflightmobileapp.R;

public class ShowCarMenu extends AppCompatActivity {
    Button btn_next;
    ListView lv_listOfCars;
    DatabaseCars databaseCars;
    ArrayAdapter<CarsModel> carsArrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_car_menu);

        lv_listOfCars = findViewById(R.id.lv_listOfCars);

        databaseCars = new DatabaseCars(ShowCarMenu.this);

        ShowCarsOnListView(databaseCars);
    }
    private void ShowCarsOnListView(DatabaseCars databaseCars) {
        Intent i = getIntent();
        String carCity = i.getStringExtra("City");
        carsArrayAdapter = new ArrayAdapter<>(ShowCarMenu.this, android.R.layout.simple_list_item_single_choice, databaseCars.getYourCar(carCity));

        lv_listOfCars.setAdapter(carsArrayAdapter);
    }

    public void setBtn_next(View v){
        Intent i = new Intent(this, CarsDriverForm.class);

        if (carsArrayAdapter != null && carsArrayAdapter.getCount() > 0) {
            // Get the price of the first flight in the list (you may want to modify this logic based on your requirements)
            String model = carsArrayAdapter.getItem(0).getModel();
            int year = carsArrayAdapter.getItem(0).getYear();
            int price = carsArrayAdapter.getItem(0).getPrice();
            String gas = carsArrayAdapter.getItem(0).getGas();
            String city = carsArrayAdapter.getItem(0).getCity();
            i.putExtra("model", model);
            i.putExtra("year", year);
            i.putExtra("gas", gas);
            i.putExtra("price", price);
            i.putExtra("city", city);
        }

        startActivity(i);
    }
}