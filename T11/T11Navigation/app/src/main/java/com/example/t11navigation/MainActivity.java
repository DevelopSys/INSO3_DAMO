package com.example.t11navigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.t11navigation.adapters.AdaptadorFragments;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private NavigationView navigation;
    private ViewPager pager;
    private AdaptadorFragments adaptadorFragments;
    private TabLayout tabs;
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private ActionBarDrawerToggle drawerToggle;
    private ImageView imagenHeader;
    private TextView textHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigation = findViewById(R.id.navigation_view);
        pager = findViewById(R.id.view_pager);
        tabs = findViewById(R.id.tabs);
        drawerLayout = findViewById(R.id.drawer_layout);
        toolbar = findViewById(R.id.toolbar);
        imagenHeader = navigation.getHeaderView(0).findViewById(R.id.imagen_consola);
        textHeader = navigation.getHeaderView(0).findViewById(R.id.nombre_consola);

        setSupportActionBar(toolbar);

        drawerToggle = new ActionBarDrawerToggle(MainActivity.this,drawerLayout,toolbar,0,0);
        drawerLayout.setDrawerListener(drawerToggle);
        drawerToggle.syncState();

        adaptadorFragments = new AdaptadorFragments(getSupportFragmentManager());
        pager.setAdapter(adaptadorFragments);
        tabs.setupWithViewPager(pager);

        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.ps4_menu:
                        imagenHeader.setImageResource(R.drawable.ps4);
                        textHeader.setText("PS4");
                        pager.setCurrentItem(1);
                        // cierro menu
                        break;
                    case R.id.xbox_menu:
                        imagenHeader.setImageResource(R.drawable.xbox);
                        textHeader.setText("XBOX");
                        pager.setCurrentItem(2);
                        // cierro menu
                        break;
                    case R.id.game_menu:
                        imagenHeader.setImageResource(R.drawable.game);
                        textHeader.setText("GAMES");
                        pager.setCurrentItem(1);
                        // cierro menu
                        break;
                }

                // cierro menu
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }
}