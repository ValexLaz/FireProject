package com.example.fireproject;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.example.fireproject.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.model.LatLngBounds;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    private static final int Request_CODE = 101;
    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private Button boton;

    private List<LatLng> region1Coordinates = new ArrayList<>();
    private List<LatLng> region2Coordinates = new ArrayList<>();
    private List<LatLng> region3Coordinates = new ArrayList<>();
    private List<LatLng> region4Coordinates = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        checkPermission();

        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        boton = findViewById(R.id.boton);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numeroEmergencia = "73609554";

                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + numeroEmergencia));

                if (checkSelfPermission(Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                    startActivity(intent);
                } else {

                    requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, 1);
                }
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MapsActivity.this, SensoresActivity.class);
                startActivity(intent);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MapsActivity.this, ProtocolActivity.class);
                startActivity(intent);
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MapsActivity.this, MapsActivity.class);
                startActivity(intent);
            }
        });

        // Agregar coordenadas para la región 1
        region1Coordinates.add(new LatLng(-14.74356, -67.11932));
        region1Coordinates.add(new LatLng(-14.73432, -67.12064));
        region1Coordinates.add(new LatLng(-14.51084, -66.47748));
        region1Coordinates.add(new LatLng(-14.51512, -66.4869));
        region1Coordinates.add(new LatLng(-14.50309, -66.48822));
        region1Coordinates.add(new LatLng(-14.48002, -66.38622));
        region1Coordinates.add(new LatLng(-14.48129, -66.39559));
        region1Coordinates.add(new LatLng(-14.48512, -66.42371));

        region1Coordinates.add(new LatLng(-14.49406, -66.48954));
        region1Coordinates.add(new LatLng(-14.46974, -66.37818));
        region1Coordinates.add(new LatLng(-14.47101, -66.38754));
        region1Coordinates.add(new LatLng(-14.47228, -66.39691));
        region1Coordinates.add(new LatLng(-14.47611, -66.42504));
        region1Coordinates.add(new LatLng(-14.47738, -66.43443));

        region1Coordinates.add(new LatLng(-14.67209, -66.44714));
        region1Coordinates.add(new LatLng(-14.50882, -66.48135));
        region1Coordinates.add(new LatLng(-14.5066, -66.49479));
        region1Coordinates.add(new LatLng(-14.50438, -66.50824));
        region1Coordinates.add(new LatLng(-14.51583, -66.37315));
        region1Coordinates.add(new LatLng(-14.51364, -66.38636));
        region1Coordinates.add(new LatLng(-14.49818, -66.47955));
        // coordenadas para la región 2
        region2Coordinates.add(new LatLng(-15.0142, -65.19711));
        region2Coordinates.add(new LatLng(-15.01165, -65.17423));
        region2Coordinates.add(new LatLng(-15.0091, -65.15144));
        region2Coordinates.add(new LatLng(-15.00657, -65.12875));
        region2Coordinates.add(new LatLng(-15.02781, -65.19544));
        region2Coordinates.add(new LatLng(-15.16679, -66.88119));

        // Agregar coordenadas para la región 3
        region3Coordinates.add(new LatLng(-14.20247, -66.20097));
        region3Coordinates.add(new LatLng(-14.20436,-66.21297));
        region3Coordinates.add(new LatLng(-13.79189,-64.93728));
        region3Coordinates.add(new LatLng(-13.64206,-64.07614));
        region3Coordinates.add(new LatLng(-13.77838,-64.92436));
        region3Coordinates.add(new LatLng(-13.63891,-64.07027));
        region3Coordinates.add(new LatLng(-13.80119,-64.89186));
        //coordenadas para la region 4

        region4Coordinates.add(new LatLng(-15.49609,-63.67794));
        region4Coordinates.add(new LatLng(-15.1286,-65.87953));
        region4Coordinates.add(new LatLng(-15.32264,-63.93656));
        region4Coordinates.add(new LatLng(-15.23518,-64.05087));
        region4Coordinates.add(new LatLng(-15.2135,-64.21095));
        region4Coordinates.add(new LatLng(-15.19033,-63.94527));

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Dibujar círculos para cada región
        drawCircle(region1Coordinates, Color.RED, Color.GREEN);
        drawCircle(region2Coordinates, Color.BLUE, Color.YELLOW);
        drawCircle(region3Coordinates, Color.GREEN, Color.BLUE);
        drawCircle(region4Coordinates, Color.GREEN, Color.RED);

        // Esperar a que el mapa se cargue completamente antes de ajustar la cámara
        mMap.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() {
            @Override
            public void onMapLoaded() {
                // Ajustar la cámara para que todos los círculos sean visibles
                LatLngBounds.Builder builder = new LatLngBounds.Builder();
                for (LatLng coordinate : region1Coordinates) {
                    builder.include(coordinate);
                }
                for (LatLng coordinate : region2Coordinates) {
                    builder.include(coordinate);
                }
                for (LatLng coordinate : region3Coordinates) {
                    builder.include(coordinate);
                }
                for (LatLng coordinate : region4Coordinates) {
                    builder.include(coordinate);
                }
                LatLngBounds bounds = builder.build();
                CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngBounds(bounds, 100);
                mMap.animateCamera(cameraUpdate);
            }
        });
    }

    private void drawCircle(List<LatLng> coordinates, int strokeColor, int fillColor) {
        // Calcular el centro y el radio del círculo
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        for (LatLng coordinate : coordinates) {
            builder.include(coordinate);
        }
        LatLngBounds bounds = builder.build();
        LatLng center = bounds.getCenter();
        double radius = calculateRadius(bounds);

        // Dibujar el círculo
        Circle circle = mMap.addCircle(new CircleOptions()
                .center(center)
                .radius(radius)
                .strokeColor(strokeColor)  // Color del borde del círculo
                .fillColor(fillColor)      // Color del relleno del círculo
                .strokeWidth(2)            // Grosor del borde
        );
    }

    private void checkPermission() {
        if (ActivityCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) ==
                PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, Request_CODE);
            return;
        }
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (Request_CODE) {
            case Request_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    checkPermission();
                }
        }
    }

    /// Método para calcular el radio del círculo utilizando la fórmula haversine
    private double calculateRadius(LatLngBounds bounds) {
        LatLng center = bounds.getCenter();
        LatLng northEast = new LatLng(bounds.northeast.latitude, bounds.northeast.longitude);

        double centerLat = Math.toRadians(center.latitude);
        double northEastLat = Math.toRadians(northEast.latitude);
        double centerLng = Math.toRadians(center.longitude);
        double northEastLng = Math.toRadians(northEast.longitude);

        double earthRadius = 6371000; // Radio de la Tierra en metros

        double dLat = northEastLat - centerLat;
        double dLng = northEastLng - centerLng;

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(centerLat) * Math.cos(northEastLat) *
                        Math.sin(dLng / 2) * Math.sin(dLng / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        // El radio del círculo es la mitad de la distancia entre el centro y el punto más alejado
        double radius = earthRadius * c / 2.0;

        return radius;
    }
}
