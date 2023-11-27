package Flights;

import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.searchflightmobileapp.R;

public class SearchYourFlightMenu extends AppCompatActivity {

    AutoCompleteTextView actv_Start, actv_Finish;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_your_flight_menu);

        String[] startCity = getResources().getStringArray(R.array.startCity);
        String[] landingCity = getResources().getStringArray(R.array.startCity);

        button = findViewById(R.id.button2);
        actv_Start = findViewById(R.id.actv_Start);
        actv_Finish = findViewById(R.id.actv_Finish);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, startCity);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, landingCity);
        actv_Start.setAdapter(adapter);
        actv_Finish.setAdapter(adapter2);

    }

    public void setButton(View v){
        Intent i = new Intent(this, ShowFlightMenu.class);
        String startCity = actv_Start.getText().toString();
        String landingCity = actv_Finish.getText().toString();
        i.putExtra("Start",startCity);
        i.putExtra("Landing",landingCity);
        startActivity(i);
    }
}