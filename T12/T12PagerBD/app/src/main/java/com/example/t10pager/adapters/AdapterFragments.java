package com.example.t10pager.adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.t10pager.fragments.PS4Fragment;
import com.example.t10pager.fragments.WelcomeFragment;
import com.example.t10pager.fragments.XBOXFragment;

import java.util.ArrayList;

public class AdapterFragments extends FragmentPagerAdapter {


    ArrayList<Fragment> listaFragments;
    String[] nombres = new String[]{"WELCOME","PS4","XBOX"};
    Fragment[] lista;

    public AdapterFragments(@NonNull FragmentManager fm) {
        super(fm);
        //lista = new Fragment[]{new WelcomeFragment(),new PS4Fragment(), new XBOXFragment()};
        listaFragments = new ArrayList<>();
        listaFragments.add(new WelcomeFragment());
        listaFragments.add(new PS4Fragment());
        listaFragments.add(new XBOXFragment());
    }

    // pinta el el fragmente de la posicion correspondiente
    @NonNull
    @Override
    public Fragment getItem(int position) {
        return listaFragments.get(position);
    }

    // numero de fragments que podras pintar
    @Override
    public int getCount() {
        return listaFragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        //return listaFragments.get(position).getClass().getSimpleName();
        return nombres[position];
    }
}
