package com.example.besanemd.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.besanemd.fragments.FifthStepFragment;
import com.example.besanemd.fragments.FirstStepFragment;
import com.example.besanemd.fragments.FourthStepFragment;
import com.example.besanemd.fragments.SecStepFragment;
import com.example.besanemd.fragments.SixthStepFragment;
import com.example.besanemd.fragments.ThirdStepFragment;


public class StepTabsAdapter extends FragmentPagerAdapter {

    private Context Context;

    public StepTabsAdapter(Context context, FragmentManager fm) {
        super(fm);
       Context = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
               return new FirstStepFragment();
                case 1:
                    return new SecStepFragment();
                    case 2:
                return new ThirdStepFragment();
            case 3:
                return new FourthStepFragment();
            case 4:
                return new FifthStepFragment();


        }
        return  new SixthStepFragment();

    }

    @Override
    public int getCount() {
        return
                6;
    }
}
