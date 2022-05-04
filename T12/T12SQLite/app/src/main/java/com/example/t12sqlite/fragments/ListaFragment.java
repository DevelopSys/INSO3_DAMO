package com.example.t12sqlite.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.t12sqlite.R;
import com.example.t12sqlite.database.GameOpenHelper;
import com.example.t12sqlite.database.SchemaDB;

public class ListaFragment extends Fragment {

    private View view;
    private GameOpenHelper gameHelper;
    private SQLiteDatabase database;
    private ListView listview;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        gameHelper = new GameOpenHelper(context, SchemaDB.DB_NAME, null, 1);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_list, container, false);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        listview = view.findViewById(R.id.listview_juegos);
        database = gameHelper.getReadableDatabase();
        //database.rawQuery("SELECT * FROM GAMES",null);
        String queryPat = "SELECT * FROM %s";
        Cursor cursor = database.rawQuery(String.format(queryPat, SchemaDB.TAB_NAME), null);
        /*SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(getContext(),
                android.R.layout.simple_list_item_1,
                cursor,
                new String[]{SchemaDB.COL_NAME},
                new int[]{android.R.id.text1},
                0 );
        listview.setAdapter(cursorAdapter);*/
        Log.v("basedatos", String.valueOf(cursor.getCount()));
        cursor.moveToFirst();
        //Log.v("basedatos", String.valueOf(cursor.getColumnCount()));
        //Log.v("basedatos", String.valueOf(cursor.getString(1)));

        while (cursor.moveToNext()){
            //Log.v("basedatos", String.valueOf(cursor.getColumnCount()));
            String nombre = cursor.getString(1);
            String company = cursor.getString(2);


        }

    }
}
