
package com.hatmath.mapdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button showMap;
    EditText longitudeEditText, latitudeEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showMap = findViewById(R.id.showMap);
        longitudeEditText = findViewById(R.id.longitude);
        latitudeEditText = findViewById(R.id.latitude);

        showMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double longitude = Double.parseDouble(longitudeEditText.getText().toString());
                    double latitude = Double.parseDouble(latitudeEditText.getText().toString());

                    Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                    intent.putExtra("LONGITUDE", longitude);
                    intent.putExtra("LATITUDE", latitude);
                    startActivity(intent);
                } catch (NumberFormatException e) {
                    // Gérer l'erreur si la conversion échoue
                    Toast.makeText(MainActivity.this, "Veuillez entrer des valeurs valides pour la longitude et la latitude", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}