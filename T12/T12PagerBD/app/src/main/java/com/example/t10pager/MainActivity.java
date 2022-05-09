package com.example.t10pager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.t10pager.adapters.AdapterFragments;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private ViewPager pager;
    private AdapterFragments adapterFragments;
    private Toolbar toolbar;
    private TabLayout tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapterFragments = new AdapterFragments(getSupportFragmentManager());
        pager = findViewById(R.id.view_pager);
        toolbar = findViewById(R.id.toolbar);
        tabs = findViewById(R.id.tabs);

        setSupportActionBar(toolbar);
        tabs.setupWithViewPager(pager);

        pager.setAdapter(adapterFragments);



    }
}