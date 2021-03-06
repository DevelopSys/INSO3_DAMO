package com.example.t10pager.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.t10pager.R;
import com.example.t10pager.model.Juego;

import java.util.ArrayList;

public class AdaptadorXBOX extends RecyclerView.Adapter<AdaptadorXBOX.MyHolder>{

    private Context context;
    private ArrayList<Juego> listaJuegos;
    private OnXBOXListener listener;

    public AdaptadorXBOX(Context context, ArrayList<Juego> listaJuegos) {
        this.context = context;
        this.listaJuegos = listaJuegos;
        listener = (OnXBOXListener) context;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // que bruto pinto
        View view = LayoutInflater.from(context).inflate(R.layout.item_fila,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
    // pintaba cada objeto
        Juego juego = listaJuegos.get(position);
        holder.texto.setText(juego.getNombre());
        holder.imagen.setImageResource(juego.getImagen());
        holder.imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onJuegoXBOXSelected(juego);
            }
        });
    }

    @Override
    public int getItemCount() {
        // cuantos a pintar
        return listaJuegos.size();
    }

    public interface OnXBOXListener{
        void onJuegoXBOXSelected(Juego juego);
    }

    class MyHolder extends RecyclerView.ViewHolder{

        TextView texto;
        ImageView imagen;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            texto = itemView.findViewById(R.id.nombre_fila);
            imagen = itemView.findViewById(R.id.imagen_fila);
        }
    }
}
