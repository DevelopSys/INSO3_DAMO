package com.example.t12sqlite;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.t12sqlite.fragments.AddFragment;
import com.example.t12sqlite.fragments.ListaFragment;
import com.example.t12sqlite.fragments.RemoveFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private NavigationView navigationView;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = findViewById(R.id.navigation);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                switch (item.getItemId()){
                    case R.id.menu_add:


                        fragmentTransaction.replace(R.id.sitio_fragments, new AddFragment());

                        break;
                    case R.id.menu_remove:
                        fragmentTransaction.replace(R.id.sitio_fragments, new RemoveFragment());


                        break;
                    case R.id.menu_list:
                        fragmentTransaction.replace(R.id.sitio_fragments, new ListaFragment());


                        break;
                }

                fragmentTransaction.commit();

                return true;
            }
        });
    }
}