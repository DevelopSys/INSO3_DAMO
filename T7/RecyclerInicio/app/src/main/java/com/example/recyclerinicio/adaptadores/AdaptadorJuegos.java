package com.example.recyclerinicio.adaptadores;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerinicio.R;
import com.example.recyclerinicio.utils.Juego;

import java.util.ArrayList;

public class AdaptadorJuegos extends RecyclerView.Adapter<AdaptadorJuegos.MyHolder> {

    // variables
    private ArrayList<Juego> listaJuegos;
    private Context context;
    private OnRecyclerListener listener;

    public AdaptadorJuegos(ArrayList<Juego> listaJuegos, Context context) {
        this.listaJuegos = listaJuegos;
        this.context = context;
        this.listener = (OnRecyclerListener) context;

    }

    // retorna un objeto holder con una vista puesta
    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycler,parent,
                false);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    // metodo que se encarga de pintar cada uno de los contenedores
    // asocio todas las acciones a los elementos
    // ejecutado tantas veces como elementos de la lista
    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        // aqui holder.textView pongo el nombre del juego del de la position correspondiente;
        // aqui holder.imageView pongo la imagen del juego;

        Juego juegoActual = listaJuegos.get(position);
        holder.textView.setText(juegoActual.getNombre());
        holder.imageView.setImageResource(juegoActual.getImagen());
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // realizo comunicacion
                listener.onJuegoSelected(juegoActual);
                Log.v("imagen","Juego seleccionado: "+juegoActual.getNombre());
            }
        });
    }

    // numero de filas que tengo que pintar
    @Override
    public int getItemCount() {
        return listaJuegos.size();
    }

    public interface OnRecyclerListener{

        void onJuegoSelected(Juego juego);

    }

    // clase que se utilizar para el "cacheo" de cada una de las filas
    // marca el aspecto "generico" de una fila
    class MyHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imagen_fila);
            textView = itemView.findViewById(R.id.nombre_fila);

        }
    }

}
