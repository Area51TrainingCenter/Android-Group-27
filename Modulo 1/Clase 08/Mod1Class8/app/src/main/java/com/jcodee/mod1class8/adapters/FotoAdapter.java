package com.jcodee.mod1class8.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.jcodee.mod1class8.MainActivity;
import com.jcodee.mod1class8.fragmentos.FotoFragment;

/**
 * Created by johannfjs on 25/10/16.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class FotoAdapter extends FragmentPagerAdapter {
    public FotoAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        FotoFragment fragment = new FotoFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("posicion", position);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return MainActivity.lista.size();
    }
}
