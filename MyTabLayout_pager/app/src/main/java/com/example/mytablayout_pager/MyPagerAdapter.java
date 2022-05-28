package com.example.mytablayout_pager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.RecyclerView;

public class MyPagerAdapter extends FragmentPagerAdapter {

    public MyPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = new FragmentShopping();
                break;
            case 1:
                fragment = new FragmentTwoNews();
                break;
            case 2:
                fragment = new FragmentThreeWebtoon();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
