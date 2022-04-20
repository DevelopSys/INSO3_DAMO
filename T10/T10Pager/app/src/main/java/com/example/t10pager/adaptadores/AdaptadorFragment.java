package com.example.t10pager.adaptadores;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.t10pager.fragments.FragmentDos;
import com.example.t10pager.fragments.FragmentTres;
import com.example.t10pager.fragments.FragmentUno;

import java.util.ArrayList;

public class AdaptadorFragment extends FragmentPagerAdapter {

    ArrayList<Fragment> listaFragments;

    public AdaptadorFragment(@NonNull FragmentManager fm) {
        super(fm);
        listaFragments = new ArrayList<>();
        listaFragments.add(new FragmentUno());
        listaFragments.add(new FragmentDos());
        listaFragments.add(new FragmentTres());

    }

    public void addFragment(Fragment fragment){
        listaFragments.add(fragment);
    }

    public void removeFragment(Fragment fragment){
        listaFragments.remove(fragment);
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
