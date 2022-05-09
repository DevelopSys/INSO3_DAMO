package com.example.t10pager.adapters;

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
import com.example.t10pager.model.Game;

import java.util.ArrayList;

public class AdaptadorXBOX extends RecyclerView.Adapter<AdaptadorXBOX.MyHolder> {

    private ArrayList<Game> listaJuegos;
    private Context context;

    public AdaptadorXBOX(ArrayList<Game> listaJuegos, Context context) {
        this.listaJuegos = listaJuegos;
        this.context = context;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_xbox,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        Game game = listaJuegos.get(position);
        holder.texto.setText(game.getNombre());
        holder.imagen.setImageResource(game.getImagen());
    }

    @Override
    public int getItemCount() {
        return listaJuegos.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{

        ImageView imagen;
        TextView texto;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            imagen = itemView.findViewById(R.id.imagen_fila);
            texto = itemView.findViewById(R.id.texto_fila);
        }
    }

}
