package com.example.ejerciciopedido;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.ejerciciopedido.utils.Pedido;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Pedido pedido = (Pedido) getIntent().getExtras().getSerializable("pedido");
        // textoNombre.setText(ped.getNombre())

    }
}