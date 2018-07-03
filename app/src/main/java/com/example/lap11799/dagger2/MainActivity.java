package com.example.lap11799.dagger2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Vehicle vehicle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView = findViewById(R.id.textView);
        Button button = findViewById(R.id.button);
        VehicleComponent component = DaggerVehicleComponent.builder()
                .vehicleModule(new VehicleModule())
                .build();
        final Vehicle vehicle = component.provideVehicle();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vehicle.increaseSpeed(50);
                textView.setText(String.valueOf(vehicle.getSpeed()));
            }
        });

    }
}
