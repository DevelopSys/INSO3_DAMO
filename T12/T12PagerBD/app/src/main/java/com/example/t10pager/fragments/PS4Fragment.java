package com.example.t10pager.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.t10pager.R;

public class PS4Fragment extends Fragment {

    private View view;
    private ListView lista;
    private ArrayAdapter<String> adaptadorJuegos;

    public PS4Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        adaptadorJuegos = new ArrayAdapter(context, android.R.layout.simple_list_item_1,getResources().getTextArray(R.array.ps4games));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_ps4, container, false);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        lista = view.findViewById(R.id.list_view_ps4);
        lista.setAdapter(adaptadorJuegos);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                adaptadorJuegos.getItem(i);
            }
        });
    }
}