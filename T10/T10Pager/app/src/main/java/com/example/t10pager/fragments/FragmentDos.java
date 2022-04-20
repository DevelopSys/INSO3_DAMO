package com.example.t10pager.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.t10pager.R;
import com.example.t10pager.adaptadores.AdaptadorXBOX;
import com.example.t10pager.model.Juego;

import java.util.ArrayList;


public class FragmentDos extends Fragment {


   private View view;
   private RecyclerView recyclerView;
   private AdaptadorXBOX adaptadorXBOX;
   private ArrayList<Juego> lista;
   private Context context;
    public FragmentDos() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
        lista = new ArrayList<>();
        lista.add(new Juego("Halo", R.drawable.bytheway));
        lista.add(new Juego("Sonic", R.drawable.gateway));
        lista.add(new Juego("Forza", R.drawable.gateway));
        adaptadorXBOX = new AdaptadorXBOX(context,lista);
        // recyclerView = null

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_dos, container, false);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        recyclerView = view.findViewById(R.id.recycler_xbox);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        recyclerView.setAdapter(adaptadorXBOX);


    }
}