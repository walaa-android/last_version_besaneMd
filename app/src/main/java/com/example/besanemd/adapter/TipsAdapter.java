package com.example.besanemd.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.besanemd.fragments.ContagionFragment;
import com.example.besanemd.fragments.ProtectionFragment;
import com.example.besanemd.fragments.SymptomsFragment;

public class TipsAdapter extends FragmentPagerAdapter {

    private Context myContext;
    int totalTabs;

    public TipsAdapter(Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        myContext = context;
        this.totalTabs = totalTabs;
    }



    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                SymptomsFragment symptomsFragment = new SymptomsFragment();
                return symptomsFragment;
            case 1:
               ContagionFragment contagionFragment = new ContagionFragment();
                return contagionFragment;
            case 2:
                ProtectionFragment protectionFragment = new ProtectionFragment();
                return protectionFragment;
            default:
                //SymptomsFragment symptomsFragment1 = new SymptomsFragment();
             //   return symptomsFragment1;
                return  null;
        }
    }
    // this counts total number of tabs
    @Override
    public int getCount() {
        return totalTabs;
    }
}
