package com.example.t10pager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.t10pager.adaptadores.AdaptadorFragment;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private AdaptadorFragment adaptadorFragment;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.view_pager);
        //fragmentManager = getSupportFragmentManager();
        adaptadorFragment = new AdaptadorFragment(getSupportFragmentManager());
        viewPager.setAdapter(adaptadorFragment);
    }
}