package com.esparperez.brainiacapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.esparperez.brainiacapp.tabs.categories.CategoriesFragment;
import com.esparperez.brainiacapp.tabs.play.PlayFragment;
import com.esparperez.brainiacapp.tabs.statistics.StatisticsFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TabsContainerFragment extends Fragment {

    public TabsContainerFragment() {}

    public static TabsContainerFragment newInstance() {
        TabsContainerFragment fragment = new TabsContainerFragment();
        return fragment;
    }

    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;

    private ViewPagerAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tabs_container, container, false);
        ButterKnife.bind(this, view);
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }

    private void setupViewPager(ViewPager viewPager) {
        mAdapter = new ViewPagerAdapter(getChildFragmentManager());
        mAdapter.addFragment(PlayFragment.newInstance(), getString(R.string.title_tab_play));
        mAdapter.addFragment(StatisticsFragment.newInstance(),getString(R.string.title_tab_stats));
        mAdapter.addFragment(CategoriesFragment.newInstance(),getString(R.string.title_tab_categories));
        viewPager.setAdapter(mAdapter);
    }

    /*
     * Se usa un FragmentPagerAdapter puesto que se requiere que cada pestaña
     * del TabLayout contenga un fragment y el número de estas es bajo, en caso
     * de tener un número muy grande de pestañas se usaría
     * FragmentStatePagerAdapter, ya que el primero mantiene en la memoria
     * los fragments abiertos de cada pestaña.
     */

    static class ViewPagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> mFragmentList = new ArrayList<>();
        private List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return mFragmentList.get(i);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }
    }
}
