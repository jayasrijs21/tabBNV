package com.example.tabbnv;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MyAdapter extends FragmentStateAdapter {


    public MyAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new tabaFragment();
            case 1:
                return new tabbFragment();
            case 2 :
                return new tabcFragment();
            default:
                return new tabaFragment();
        }


    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
