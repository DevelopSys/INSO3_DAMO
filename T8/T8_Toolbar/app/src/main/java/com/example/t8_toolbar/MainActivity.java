package com.example.t8_toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {


    // REALIZAR UNA APLICACION QUE MEDIANTE UN MENU SE PUEDA SELECCIONAR EL TIEMPO DE
    // ELEMENTOS QUE SE VEN EN UN RECYCLER
    // EN EL MENU EXISTIRÄN LAS SIGUIENTES OPCIONES (CON ICONOS)
        // VER PELICULAS
        // VER JUEGOS
        // VER SERIES





    private Toolbar toolbar;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.home);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal,menu);
        return super.onCreateOptionsMenu(menu);
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.menu_opcion_1:
                Log.v("menus","Pulsado "+getResources().getString(R.string.opcion1));
                break;
            case R.id.menu_opcion_2:
                Log.v("menus","Pulsado opcion 2");
                break;
            case R.id.menu_opcion_3:
                Log.v("menus","Pulsado opcion 3");
                break;
            case R.id.menu_opcion_4:
                Log.v("menus","Pulsado opcion 4");
                break;
        }


        return super.onOptionsItemSelected(item);
    }
}