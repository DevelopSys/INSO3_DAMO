package com.example.t10pager.fragments;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.t10pager.R;
import com.example.t10pager.database.GameHelper;
import com.example.t10pager.database.SchemeDB;

public class WelcomeFragment extends Fragment {

    private View view;
    private GameHelper gameHelper;
    private SQLiteDatabase database;
    private EditText editNombre, editCompania;
    private Button botonAdd;
    private CheckBox checkBox;

    public WelcomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        gameHelper = new GameHelper(context, SchemeDB.DB_NAME,null,SchemeDB.VERSION);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_welcome, container, false);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        editCompania = view.findViewById(R.id.edit_compania);
        editNombre = view.findViewById(R.id.edit_nombre);
        botonAdd = view.findViewById(R.id.boton_anadir);
        checkBox = view.findViewById(R.id.check_fav);
        botonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database = gameHelper.getWritableDatabase();
                //database.execSQL("INSERT INTO GAMES (NAME, COMPANY, FAVORITE) VALUES ('"+editNombre.getText().toString()+"','CAPCOM',true)");
                String queryPat = "INSERT INTO %s (%s, %s, %s) VALUES ('%s','%s',%b)";
                database.execSQL(String.format(queryPat,SchemeDB.TAB_GAMES,
                        SchemeDB.COL_GAMES_NAME,SchemeDB.COL_GAMES_COMPANY, SchemeDB.COL_GAMES_FAVORITE,
                        editNombre.getText().toString(), editCompania.getText().toString(),checkBox.isChecked()));

                database.close();
            }
        });

    }
}