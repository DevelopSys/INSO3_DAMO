package com.example.t11navigation.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.t11navigation.fragments.FragmentPS4;
import com.example.t11navigation.fragments.FragmentWelcome;
import com.example.t11navigation.fragments.FragmentXBOX;

import java.util.ArrayList;

public class AdaptadorFragments extends FragmentPagerAdapter {

    private ArrayList<Fragment> listaFragments;

    public AdaptadorFragments(@NonNull FragmentManager fm) {
        super(fm);
        listaFragments = new ArrayList<>();
        listaFragments.add(new FragmentWelcome());
        listaFragments.add(new FragmentPS4());
        listaFragments.add(new FragmentXBOX());
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return listaFragments.get(position);
    }

    @Override
    public int getCount() {
        return listaFragments.size();
    }
}
