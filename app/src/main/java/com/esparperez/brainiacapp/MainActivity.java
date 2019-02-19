package com.esparperez.brainiacapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.esparperez.brainiacapp.myStats.MyStatsFragment;
import com.esparperez.brainiacapp.play.PlayFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.app_bar_toolbar)
    Toolbar toolbar;
    @BindView(R.id.drawer_main)
    DrawerLayout drawerLayout;
    @BindView(R.id.nav_main)
    NavigationView navigationView;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.app_bar_tab_layout)
    TabLayout tabLayout;

    private ActionBarDrawerToggle mToggle;
    private ViewPagerAdapter mAdapter;

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

        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        String test = "";
        switch (menuItem.getItemId()) {
            case R.id.menu_statistics:
                test = getString(R.string.title_nav_drawer_statistics);
                break;
            case R.id.menu_play_mode:
                test = getString(R.string.title_nav_drawer_play_modes);
                break;
            case R.id.menu_upcoming:
                test = getString(R.string.title_nav_drawer_upcoming);
                break;
            case R.id.menu_terms:
                test = getString(R.string.title_nav_drawer_terms_and_conditions);
                break;
            case R.id.menu_configurations:
                test = getString(R.string.title_nav_drawer_configurations);
                break;
            case R.id.menu_about:
                test = getString(R.string.title_nav_drawer_about);
                break;
        }
        drawerLayout.closeDrawer(Gravity.START);
        Toast.makeText(this, test, Toast.LENGTH_SHORT).show();
        // TODO inflar el respectivo fragment
        return true;
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new PlayFragment().newInstance(), getString(R.string.title_tab_play));
        adapter.addFragment(new MyStatsFragment().newInstance(),getString(R.string.title_tab_stats));
        adapter.addFragment(new MyStatsFragment().newInstance(),getString(R.string.title_tab_categories));
        viewPager.setAdapter(adapter);
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
