package com.example.t9fragments.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.t9fragments.R;
import com.example.t9fragments.utils.Juego;

import java.util.ArrayList;

public class FragmentLista extends Fragment {

    private View view;
    private ListView lista;
    private ArrayAdapter<Juego> adaptadorJuegos;
    private ArrayList<Juego> listaJuegos, listaFiltrada;
    // 2º PASO: CREO UN OBJETO DE LA INTERFAZ y LO IGUAL AL CONTEXTO
    private OnFragmentJuegoListener listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (OnFragmentJuegoListener) context;
        listaJuegos = new ArrayList();
        listaFiltrada = new ArrayList<>();
        listaJuegos.add(new Juego("FFX","Squareix"));
        listaJuegos.add(new Juego("FFXII","Squareix"));
        listaJuegos.add(new Juego("FIFA","EA"));
        listaJuegos.add(new Juego("Madness","EA"));
        listaJuegos.add(new Juego("Resident","Campcom"));
        listaJuegos.add(new Juego("ASASD","Campcom"));
        listaJuegos.add(new Juego("arwetghfbvds","Campcom"));
        listaJuegos.add(new Juego("wretyujhgfbd","Campcom"));
        listaJuegos.add(new Juego("cvbnghy","Campcom"));
        listaJuegos.add(new Juego("asd","Campcom"));
        listaJuegos.add(new Juego("ghfjy","Campcom"));
        listaJuegos.add(new Juego("iuytr","Campcom"));
        listaJuegos.add(new Juego("Call ","Activision"));
        listaJuegos.add(new Juego("Call asdasd","Activision"));
        listaJuegos.add(new Juego("asfdgdbv cdscv","Activision"));
        listaJuegos.add(new Juego("Call asdfsffdgdfg","Activision"));
        adaptadorJuegos = new ArrayAdapter(context,
                android.R.layout.simple_list_item_1,
                listaFiltrada);
    }

    public void comunicarDato(String desarrollo){
        Log.v("comunicacion", desarrollo);
        // modificar la lista y solo mostrar los juegos que tengan capcom
        // como desarrollador

        for ( Juego item : listaJuegos ) {
            if (item.getDesarrollador().equalsIgnoreCase(desarrollo)){
                listaFiltrada.add(item);
            }

        }
        adaptadorJuegos.notifyDataSetChanged();



    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_lista,container,
                false);
        // hago las instancias aqui
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        lista = view.findViewById(R.id.lista_fragment);
        lista.setAdapter(adaptadorJuegos);
        // 4o PASO: REALIZA LA COMUNICACION CUANDO QUIERAS
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Juego juego = adaptadorJuegos.getItem(i);
                listener.onJuegoSelected(juego);
            }
        });
    }

    // 1ER PASO: CREO UNA INTERFAZ CON UN MËTODO
    public interface OnFragmentJuegoListener{
        void onJuegoSelected(Juego juego);
    }
}
