package com.example.t12sqlite.fragments;

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
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.t12sqlite.R;
import com.example.t12sqlite.database.GameOpenHelper;
import com.example.t12sqlite.database.SchemaDB;

public class AddFragment extends Fragment {

    private View view;
    private EditText editNombre, editCompany;
    private CheckBox checkFav;
    private Button boton;
    private SQLiteDatabase baseDatos;
    private GameOpenHelper gameHelper;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        gameHelper = new GameOpenHelper(context, SchemaDB.DB_NAME,null, SchemaDB.VERSION);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_add,container,false);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        editCompany = view.findViewById(R.id.edit_compania);
        editNombre = view.findViewById(R.id.edit_nombre);
        boton = view.findViewById(R.id.boton_add);
        checkFav = view.findViewById(R.id.check_fav);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO agregar juego a la base de datos;
                baseDatos = gameHelper.getWritableDatabase();
                //baseDatos.execSQL("INSERT into GAMES (NAME, COMPANY, FAVORITE) VALUES ('"+editNombre.getText().toString()+"','"+editCompany.getText().toString()+"',1)");
                String queryPat = "INSERT into %s (%s,%s,%s) VALUES ('%s','%s',%b)" ;

                baseDatos.execSQL(String.format(queryPat,SchemaDB.TAB_NAME,
                        SchemaDB.COL_NAME,SchemaDB.COL_COMPANY, SchemaDB.COL_FAVORITE,
                        editNombre.getText().toString(), editCompany.getText().toString(), checkFav.isChecked()));

            }
        });
    }
}
