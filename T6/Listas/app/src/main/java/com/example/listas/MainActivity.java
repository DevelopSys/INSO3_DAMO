package com.example.listas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.listas.adaptadores.AdaptadorJuegos;
import com.example.listas.utils.Juego;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lista;
    private ArrayList<Juego> listaJuegos;
    // Adaptador simple
    private ArrayAdapter<String> adapterSimple;
    private AdaptadorJuegos adaptadorJuegos;
    private EditText edit;
    private Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listaJuegos = new ArrayList();
        adaptadorJuegos = new AdaptadorJuegos(listaJuegos, getApplicationContext());
        adapterSimple = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, listaJuegos);
        setContentView(R.layout.activity_main);
        lista = findViewById(R.id.lista_datos);
        edit = findViewById(R.id.edit_juego);
        boton = findViewById(R.id.boton_juego);

        lista.setAdapter(adaptadorJuegos);
        listaJuegos.add(new Juego("God of war", R.drawable.god));
        listaJuegos.add(new Juego("Fifa", R.drawable.fifa));
         adapterSimple.notifyDataSetChanged();


        /*boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listaJuegos.add(edit.getText().toString());
                adapterSimple.notifyDataSetChanged();
            }
        });*/
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.v("lista", adapterSimple.getItem(i));
                Log.v("lista", adapterView.getAdapter().getItem(i).toString());

            }
        });

    }
}