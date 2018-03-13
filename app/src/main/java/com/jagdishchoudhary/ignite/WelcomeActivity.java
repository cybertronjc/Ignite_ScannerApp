package com.jagdishchoudhary.ignite;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class WelcomeActivity extends AppCompatActivity {
    private Button btnMicro, btnWater, btnMaterial, btnEnergy, btnInstru, btnPhotonics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        btnMicro = (Button)findViewById(R.id.btnMicro);
        btnMaterial = (Button)findViewById(R.id.btnMaterial);
        btnWater = (Button)findViewById(R.id.btnWater);
        btnEnergy = (Button)findViewById(R.id.btnEnergy);
        btnInstru = (Button)findViewById(R.id.btnInstru);
        btnPhotonics = (Button)findViewById(R.id.btnPhotonics);


        ActionBar bar = getSupportActionBar();
        bar.hide();

        btnMicro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                ((Loading)getApplication()).setEventName("Microsoft");
                ((Loading)getApplication()).setDisplayName(btnMicro.getText().toString());
                startActivity(intent);
                finish();
            }
        });
        btnMaterial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                ((Loading)getApplication()).setEventName("Material");
                ((Loading)getApplication()).setDisplayName(btnMaterial.getText().toString());
                startActivity(intent);
                finish();
            }
        });
        btnWater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                ((Loading)getApplication()).setEventName("Water");
                ((Loading)getApplication()).setDisplayName(btnWater.getText().toString());
                startActivity(intent);
                finish();
            }
        });
        btnEnergy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                ((Loading)getApplication()).setEventName("Energy");
                ((Loading)getApplication()).setDisplayName(btnEnergy.getText().toString());
                startActivity(intent);
                finish();
            }
        });
        btnInstru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                ((Loading)getApplication()).setEventName("Instru");
                ((Loading)getApplication()).setDisplayName(btnInstru.getText().toString());
                startActivity(intent);
                finish();
            }
        });
        btnPhotonics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                ((Loading)getApplication()).setEventName("Photonics");
                ((Loading)getApplication()).setDisplayName(btnPhotonics.getText().toString());

                startActivity(intent);
                finish();
            }
        });

    }
}
