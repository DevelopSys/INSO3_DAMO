package com.example.ejerciciopedido;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.ejerciciopedido.utils.Pedido;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null){
            // recupera datos
            Pedido pedido = (Pedido) savedInstanceState.getSerializable("Pedido");
            //editNombre.setText(pedido.getNombre());

        }

        Pedido pedido = new Pedido();

        Intent intent = new Intent();
        intent.putExtra("pedido",pedido);
        startActivity(intent);

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        //outState.putSerializable("editNombre", editNombre.getText());
        outState.putSerializable("pedido", new Pedido());
    }
}