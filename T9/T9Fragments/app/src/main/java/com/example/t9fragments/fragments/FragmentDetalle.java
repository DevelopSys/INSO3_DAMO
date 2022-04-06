package com.example.t9fragments.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.t9fragments.R;
import com.example.t9fragments.utils.Juego;

public class FragmentDetalle extends Fragment {

    private View view;
    private TextView nombre, desarrollador;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_detalle,container, false);
        nombre = view.findViewById(R.id.nombre_detalle);
        desarrollador = view.findViewById(R.id.desarrollador_detalle);
        return view;
    }

    public void comunicarJuego(Juego juego){
        nombre.setText(juego.getNombre());
        desarrollador.setText(juego.getDesarrollador());
    }
}
