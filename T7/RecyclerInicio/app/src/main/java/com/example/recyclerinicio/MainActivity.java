package com.example.recyclerinicio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.recyclerinicio.adaptadores.AdaptadorJuegos;
import com.example.recyclerinicio.utils.Juego;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdaptadorJuegos.OnRecyclerListener {

    private RecyclerView recyclerView;
    private AdaptadorJuegos adaptadorJuegos;
    private ArrayList<Juego> listaDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_juegos);
        listaDatos = new ArrayList<>();
        listaDatos.add(new Juego("GOD", R.drawable.god));
        listaDatos.add(new Juego("FIFA", R.drawable.fifa));
        listaDatos.add(new Juego("LAST", R.drawable.last));
        listaDatos.add(new Juego("GTA", R.drawable.gta));
        listaDatos.add(new Juego("GT", R.drawable.gt));
        listaDatos.add(new Juego("COD", R.drawable.call));
        listaDatos.add(new Juego("RESIDENT", R.drawable.resident));
        adaptadorJuegos = new AdaptadorJuegos(listaDatos,MainActivity.this);
        recyclerView.setAdapter(adaptadorJuegos);
        //recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
        //        RecyclerView.HORIZONTAL, false));
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
        } else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL,false));
        }

        acciones();

    }

    private void acciones() {

    }

    @Override
    public void onJuegoSelected(Juego juego) {
        Log.v("comunicacion", juego.getNombre() +" comunicado con exito");
    }
}