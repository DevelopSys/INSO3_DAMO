package com.example.t9fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.t9fragments.fragments.FragmentDetalle;
import com.example.t9fragments.utils.Juego;

public class ThirdActivity extends AppCompatActivity {
    private Juego juego;
    private FragmentDetalle fragmentDetalle;
    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        juego = (Juego) getIntent().getExtras().getSerializable("juego");
    }

    @Override
    protected void onResume() {
        super.onResume();
        fragmentManager = getSupportFragmentManager();
        fragmentDetalle = (FragmentDetalle) fragmentManager.findFragmentById(R.id.fragment_detalle);
        fragmentDetalle.comunicarJuego(juego);

    }
}