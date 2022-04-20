package com.example.t10pager.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.t10pager.R;
import com.example.t10pager.adaptadores.AdaptadorListView;

import java.util.ArrayList;


public class FragmentUno extends Fragment {

    private View view;
    private String[] juegos;
    private ListView listView;
    private ArrayAdapter adaptadorPs4;
    private AdaptadorListView adaptadorListView;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        juegos = getResources().getStringArray((R.array.ps4games));
        adaptadorPs4 = new ArrayAdapter(context, android.R.layout.simple_list_item_1, juegos);
        adaptadorListView = new AdaptadorListView(
                ,getContext());

    }

    public FragmentUno() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_uno, container, false);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        listView = view.findViewById(R.id.lista_ps4);
        //listView.setAdapter(adaptadorPs4);
        listView.setAdapter(adaptadorListView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //juegos[i];
            }
        });

    }
}