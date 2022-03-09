package com.example.listas.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.listas.R;
import com.example.listas.utils.Juego;

import java.util.ArrayList;

public class AdaptadorJuegos extends BaseAdapter {

    private ArrayList<Juego> lista;
    private Context context;
    public AdaptadorJuegos(ArrayList<Juego> lista, Context context){
        this.lista = lista;
        this.context = context;
    }


    // Indica el número de elementos que se tienen que pintar
    @Override
    public int getCount() {
        return lista.size();
    }

    // Devuelve el eobjeto asociado a una posicion (i)
    @Override
    public Object getItem(int i) {
        return lista.get(i);
    }

    // Devuelve el ID del elemento pulsado en una posicion(i)
    @Override
    public long getItemId(int i) {
        return i;
    }

    // Devuelve el aspecto de la fila ya asociada con sus datos
    // i-> posicion de la fila
    // view --> lo que retorna el pintado (XML)
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = LayoutInflater.from(context).inflate(R.layout.item_fila,viewGroup,false);
        ImageView imageView = view.findViewById(R.id.imagen_fila);
        TextView nombre = view.findViewById(R.id.nombre_fila);
        Juego juego = lista.get(i);
        nombre.setText(juego.getNombre());
        imageView.setImageResource(juego.getImagen());
        return view;
    }
}
