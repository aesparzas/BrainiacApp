package com.esparperez.brainiacapp;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static int PLAY_MODES_TAB_POSITION = 0;
    private static int STATISTICS_TAB_POSITION = 1;

    @BindView(R.id.app_bar_toolbar)
    Toolbar toolbar;
    @BindView(R.id.drawer_main)
    DrawerLayout drawerLayout;
    @BindView(R.id.nav_main)
    NavigationView navigationView;
//    @BindView(R.id.view_pager)
//    ViewPager viewPager;
//    @BindView(R.id.tab_layout)
//    TabLayout tabLayout;

    private ActionBarDrawerToggle mToggle;
//    private ViewPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        mToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.action_drawer_open, R.string.action_drawer_close);
        drawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

//        setupViewPager(viewPager);
//        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        switch (menuItem.getItemId()) {
            case R.id.menu_statistics:
//                inflateTab(STATISTICS_TAB_POSITION);
                fragment = TabsContainerFragment.newInstance();
                break;
            case R.id.menu_play_mode:
//                inflateTab(PLAY_MODES_TAB_POSITION);
                fragment = TabsContainerFragment.newInstance();
                break;
            case R.id.menu_upcoming:
                fragment = UpcomingFragment.newInstance();
                break;
            case R.id.menu_terms:
                fragment = TermsFragment.newInstance();
                break;
            case R.id.menu_configurations:
                fragment = TestFragment.newInstance();
                break;
            case R.id.menu_about:
                fragment = AboutFragment.newInstance();
                break;
        }
        if (fragment != null) {
            inflateFragment(fragment);
        }
        drawerLayout.closeDrawer(Gravity.START);
//        Toast.makeText(this, test, Toast.LENGTH_SHORT).show();
        // TODO inflar el respectivo fragment
        return true;
    }

//    private void setupViewPager(ViewPager viewPager) {
//        mAdapter = new ViewPagerAdapter(getSupportFragmentManager());
//        mAdapter.addFragment(new PlayFragment().newInstance(), getString(R.string.title_tab_play));
//        mAdapter.addFragment(new StatisticsFragment().newInstance(),getString(R.string.title_tab_stats));
//        mAdapter.addFragment(new StatisticsFragment().newInstance(),getString(R.string.title_tab_categories));
//        viewPager.setAdapter(mAdapter);
//    }

//    private void inflateTab(int position) {
//        if (mAdapter == null) setupViewPager(viewPager);
//        if (tabLayout.getVisibility() == View.GONE) tabLayout.setVisibility(View.VISIBLE);
//        viewPager.setAdapter(mAdapter);
//        viewPager.setCurrentItem(position);
////        tabLayout.setVisibility(tabLayout.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
//
//    }

    private void inflateFragment(Fragment fragment) {
//        tabLayout.setVisibility(View.GONE);
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction()
                .replace(R.id.main_cointainer, fragment)
                .addToBackStack(null)
                .commit();
    }

    /*
     * Se usa un FragmentPagerAdapter puesto que se requiere que cada pestaña
     * del TabLayout contenga un fragment y el número de estas es bajo, en caso
     * de tener un número muy grande de pestañas se usaría
     * FragmentStatePagerAdapter, ya que el primero mantiene en la memoria
     * los fragments abiertos de cada pestaña.
     */

//    static class ViewPagerAdapter extends FragmentPagerAdapter {
//
//        private List<Fragment> mFragmentList = new ArrayList<>();
//        private List<String> mFragmentTitleList = new ArrayList<>();
//
//        public ViewPagerAdapter(FragmentManager fm) {
//            super(fm);
//        }
//
//        @Override
//        public Fragment getItem(int i) {
//            return mFragmentList.get(i);
//        }
//
//        @Override
//        public int getCount() {
//            return mFragmentList.size();
//        }
//
//        @Nullable
//        @Override
//        public CharSequence getPageTitle(int position) {
//            return mFragmentTitleList.get(position);
//        }
//
//        public void addFragment(Fragment fragment, String title) {
//            mFragmentList.add(fragment);
//            mFragmentTitleList.add(title);
//        }
//    }
}
