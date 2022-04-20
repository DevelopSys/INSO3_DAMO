package com.example.t10pager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;

import com.example.t10pager.adaptadores.AdaptadorFragment;
import com.example.t10pager.adaptadores.AdaptadorXBOX;
import com.example.t10pager.model.Juego;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements AdaptadorXBOX.OnXBOXListener {

    private ViewPager viewPager;
    private AdaptadorFragment adaptadorFragment;
    private FragmentManager fragmentManager;
    private Toolbar toolbar;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.view_pager);
        toolbar = findViewById(R.id.toolbar);
        tabLayout = findViewById(R.id.tablayout);
        setSupportActionBar(toolbar);
        adaptadorFragment = new AdaptadorFragment(getSupportFragmentManager());
        viewPager.setAdapter(adaptadorFragment);
        tabLayout.setupWithViewPager(viewPager);


        //fragmentManager = getSupportFragmentManager();

    }

    @Override
    public void onJuegoXBOXSelected(Juego juego) {
        Log.v("juegos", juego.getNombre());
    }
}