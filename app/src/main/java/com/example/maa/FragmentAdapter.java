// we make this class to set adapter to viewPager
package com.example.maa;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

//We use FragmentStatePagerAdapter because it destroys item as soon as they are not visible
// and keep only saved data of the fragment
public class FragmentAdapter extends FragmentStatePagerAdapter {
    int tabCount;
    long cookId;

    public FragmentAdapter(@NonNull FragmentManager fm, int tabCount,long id) {
        super(fm, tabCount);
    this.tabCount=tabCount;
    this.cookId=id;
    }

    //set fragment according to the tab
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new BreakfastFragment(cookId);
            case 1:
                return new LunchFragment();
            case 2:
                return new DinnerFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
