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

    private ActionBarDrawerToggle mToggle;

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

        Fragment fragment = TabsContainerFragment.newInstance();
        inflateFragment(fragment);
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
        return true;
    }


    private void inflateFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction()
                .replace(R.id.main_cointainer, fragment)
                .addToBackStack(null)
                .commit();
    }
}
