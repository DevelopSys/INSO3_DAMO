package com.example.t10pager.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.t10pager.R;
import com.example.t10pager.model.Juego;

import java.util.ArrayList;

public class AdaptadorListView extends BaseAdapter {

    private ArrayList<Juego> lista;
    private Context context;

    public AdaptadorListView(ArrayList<Juego> lista, Context context) {
        this.lista = lista;
        this.context = context;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.item_fila, viewGroup,false);
        ImageView imagen = view.findViewById(R.id.imagen_fila);
        TextView textView = view.findViewById(R.id.nombre_fila);
        Juego juego = lista.get(i);
        imagen.setImageResource(juego.getImagen());
        textView.setText(juego.getNombre());

        return view;
    }
}
