package Cars;

import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.searchflightmobileapp.R;

public class RentYourCarMenu extends AppCompatActivity {
    AutoCompleteTextView actv_CityCar;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent_your_car_menu);

        String[] carCity = getResources().getStringArray(R.array.carCity);

        actv_CityCar = findViewById(R.id.actv_CityCar);
        button = findViewById(R.id.button3);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, carCity);
        actv_CityCar.setAdapter(adapter);
    }

    public void setButton(View v){
        Intent i = new Intent(this, ShowCarMenu.class);
        String carCity = actv_CityCar.getText().toString();
        i.putExtra("City",carCity);
        startActivity(i);
    }
}