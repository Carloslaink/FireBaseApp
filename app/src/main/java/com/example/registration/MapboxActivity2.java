package com.example.registration;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseUser;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;

public class MapboxActivity2 extends AppCompatActivity {

    private MapView mapView;
    private Button btnTrack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Mapbox.getInstance(this, getString(R.string.mapbox_access_token));
        setContentView(R.layout.activity_mapbox2);
        Button btnaggdirec = findViewById(R.id.btnaggdirec);
        Button btnTrack = findViewById(R.id.btn_Track);
        Button btnverdirec = findViewById(R.id.btnverdirec);
        mapView = (MapView) findViewById(R.id.mapbox);
        mapView.onCreate(savedInstanceState);


        ///////////////7new implement 21:38
        btnTrack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });



        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(MapboxMap mapboxMap) {}
        });

        ///////////SQLITE

        btnaggdirec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MapboxActivity2.this, newDirecciones.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "¡Bienvenido!",Toast.LENGTH_LONG).show();

            }
        });

        btnverdirec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Leer.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(), "¡Todas las Ubicaciones!",Toast.LENGTH_LONG).show();
            }
        });

    }




    @Override
    protected void onStart() {
        super.onStart();
        mapView.onStart();
    }

}
