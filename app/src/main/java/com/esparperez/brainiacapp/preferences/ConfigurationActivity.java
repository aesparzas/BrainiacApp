package com.esparperez.brainiacapp.preferences;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.support.v7.preference.PreferenceScreen;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;


import com.esparperez.brainiacapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ConfigurationActivity extends AppCompatActivity
        implements PreferenceFragmentCompat.OnPreferenceStartScreenCallback {

    @BindView(R.id.config_toolbar)
    Toolbar toolbar;

    private static final String SCREEN_TAG = "screen_tag";
    private static final String SCREEN_TITLE = "screen_title";

    private String mKey;
    private String mTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);
        ButterKnife.bind(this);
        mKey = getIntent().getStringExtra(SCREEN_TAG);
        mTitle = getIntent().getStringExtra(SCREEN_TITLE);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        inflateFragment(mKey, mTitle);
    }

    @Override
    public boolean onPreferenceStartScreen(PreferenceFragmentCompat preferenceFragmentCompat,
                                           PreferenceScreen preferenceScreen) {
        inflateFragment(preferenceScreen.getKey(), preferenceScreen.getTitle().toString());
        return false;
    }

    private void inflateFragment(String screenTag, String screenTitle) {
        Fragment fragment = SettingsFragment.newInstance(screenTag, screenTitle);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.settings_container, fragment)
                .addToBackStack(screenTag)
                .commit();
    }

    public static class SettingsFragment extends PreferenceFragmentCompat {

        private String mScreen;
        private String mTitle;

        public SettingsFragment() {}

        public static SettingsFragment newInstance(String screenTag, String screenTitle) {
            SettingsFragment fragment = new SettingsFragment();
            Bundle args = new Bundle();
            args.putString(SCREEN_TAG, screenTag);
            args.putString(SCREEN_TITLE, screenTitle);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public void onCreatePreferences(Bundle bundle, String screen) {
            this.mScreen = getArguments().getString(SCREEN_TAG);
            this.mTitle = getArguments().getString(SCREEN_TITLE);
            getActivity().setTitle(mTitle);
            setPreferencesFromResource(R.xml.preferences_main, mScreen);
        }
    }
}