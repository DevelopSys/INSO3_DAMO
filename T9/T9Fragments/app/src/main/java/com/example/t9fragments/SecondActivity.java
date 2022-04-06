package com.example.t9fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.t9fragments.fragments.FragmentLista;
import com.example.t9fragments.utils.Juego;

public class SecondActivity extends AppCompatActivity implements FragmentLista.OnFragmentJuegoListener {
        // 3er PASO IMPLEMENTO LA INTERFAZ
    private FragmentLista fragmentLista;
    private String desarrollador;
    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        desarrollador = getIntent().getExtras()
                .getString("desarrollador");

        fragmentManager = this.getSupportFragmentManager();
        fragmentLista = (FragmentLista) fragmentManager
                .findFragmentById(R.id.fragmente_estatico);
        //fragmentManager.findFragmentByTag("fragment_lista");


        fragmentLista.comunicarDato(desarrollador);
    }

    @Override
    public void onJuegoSelected(Juego juego) {
        //Log.v("comunicacion",juego.getNombre());
        Intent intent = new Intent(getApplicationContext(), ThirdActivity.class);
        intent.putExtra("juego", juego);
        startActivity(intent);
    }
}