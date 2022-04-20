package com.example.t10pager.adaptadores;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.t10pager.fragments.FragmentDos;
import com.example.t10pager.fragments.FragmentTres;
import com.example.t10pager.fragments.FragmentUno;

import java.util.ArrayList;

public class AdaptadorFragment extends FragmentPagerAdapter {

    ArrayList<Fragment> listaFragments;
    String[] nombres= new String[]{"PS4","XBOX","Vacio"};

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

    public void comunicarDato(String dato){
        FragmentUno fragmentUno = (FragmentUno) listaFragments.get(0);
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

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return listaFragments.get(position).getClass().getSimpleName();
    }
}
