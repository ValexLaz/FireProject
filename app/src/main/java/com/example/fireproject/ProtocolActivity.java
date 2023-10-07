package com.example.fireproject;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class ProtocolActivity extends AppCompatActivity {


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_protocol);

            Button button4 = findViewById(R.id.button4);
            Button button5 = findViewById(R.id.button5);
            Button button6 = findViewById(R.id.button6);
            ImageView imageButton = findViewById(R.id.imageButton);

            Button boton = findViewById(R.id.boton);

            // OnClickListener para el ImageButton
            imageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Redirige a la pantalla deseada cuando se presiona el ImageButton
                    Intent intent = new Intent(ProtocolActivity.this, SensoresActivity.class);
                    startActivity(intent);
                }
            });

            boton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String numeroEmergencia = "73609554";

                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:" + numeroEmergencia));

                    if (checkSelfPermission(android.Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                        startActivity(intent);
                    } else {

                        requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, 1);
                    }
                }
            });

            button4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(ProtocolActivity.this, SensoresActivity.class);
                    startActivity(intent);
                }
            });

            button5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(ProtocolActivity.this, ProtocolActivity.class);
                    startActivity(intent);
                }
            });

            button6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(ProtocolActivity.this, MapsActivity.class);
                    startActivity(intent);
                }
            });
        }
    }
