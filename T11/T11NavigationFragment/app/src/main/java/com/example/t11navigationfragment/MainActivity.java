package com.example.t11navigationfragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.t11navigationfragment.fragments.FragmentPS4;
import com.example.t11navigationfragment.fragments.FragmentWelcome;
import com.example.t11navigationfragment.fragments.FragmentXBOX;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.navigation);
        drawerLayout = findViewById(R.id.drawer);

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.sitio_fragments, new FragmentWelcome());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();


        setSupportActionBar(toolbar);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();

                switch (item.getItemId()){
                    case R.id.menu_f1:
                        fragmentTransaction.replace(R.id.sitio_fragments,new FragmentPS4());
                        fragmentTransaction.addToBackStack("f1");
                        break;
                    case R.id.menu_f2:
                        fragmentTransaction.replace(R.id.sitio_fragments,new FragmentXBOX());
                        fragmentTransaction.addToBackStack("f2");
                        break;
                    case R.id.menu_f3:
                        fragmentTransaction.replace(R.id.sitio_fragments,new FragmentWelcome());
                        fragmentTransaction.addToBackStack("f3");
                        break;
                }
                fragmentTransaction.commit();
                drawerLayout.closeDrawer(GravityCompat.START);

                return true;
            }
        });
    }
}