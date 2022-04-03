package com.example.t9fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.t9fragments.fragments.FragmentLista;

public class SecondActivity extends AppCompatActivity {

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
}