package com.example.t10pager.fragments;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.t10pager.R;
import com.example.t10pager.database.GameHelper;
import com.example.t10pager.database.SchemeDB;

public class PS4Fragment extends Fragment {

    private View view;
    private ListView lista;
    private SQLiteDatabase database;
    private GameHelper gameHelper;
    private Cursor cursor;
    private SimpleCursorAdapter adapter;


    public PS4Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        gameHelper = new GameHelper(context, SchemeDB.DB_NAME, null, SchemeDB.VERSION);
        database = gameHelper.getReadableDatabase();
        cursor = database.rawQuery("SELECT * FROM "+SchemeDB.TAB_GAMES,null);
        adapter = new SimpleCursorAdapter(context,
                android.R.layout.simple_list_item_1,
                cursor,
                new String[]{SchemeDB.COL_GAMES_NAME},
                new int[]{android.R.id.text1});
        //int elementos = cursor.getCount();
        //Log.v("juegos",String.valueOf(elementos));

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
        lista.setAdapter(adapter);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

    }
}