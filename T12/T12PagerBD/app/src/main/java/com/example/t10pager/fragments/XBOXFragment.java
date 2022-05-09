package com.example.t10pager.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.t10pager.R;
import com.example.t10pager.adapters.AdaptadorXBOX;
import com.example.t10pager.model.Game;

import java.util.ArrayList;

public class XBOXFragment extends Fragment {

    private View view;
    private RecyclerView recyclerView;
    private AdaptadorXBOX adaptadorXBOX;
    private ArrayList<Game> listaJuegos;
    public XBOXFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listaJuegos = new ArrayList<>();
        listaJuegos.add(new Game("Forza",R.drawable.gateway));
        listaJuegos.add(new Game("Juego2",R.drawable.bytheway));
        listaJuegos.add(new Game("Juego3",R.drawable.unlimited));
        adaptadorXBOX = new AdaptadorXBOX(listaJuegos, context);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_xbox, container, false);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        recyclerView = view.findViewById(R.id.recycler_xbox);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()
                , LinearLayoutManager.VERTICAL
                ,false));
        recyclerView.setAdapter(adaptadorXBOX);

    }
}