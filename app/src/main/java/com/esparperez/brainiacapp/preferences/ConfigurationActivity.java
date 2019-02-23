package com.esparperez.brainiacapp.preferences;

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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);
        String screen = getIntent().getStringExtra(SCREEN_TAG);
        String title = getIntent().getStringExtra(SCREEN_TITLE);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle(title);
        inflateFragment(screen);
    }

    @Override
    public boolean onPreferenceStartScreen(PreferenceFragmentCompat preferenceFragmentCompat,
                                           PreferenceScreen preferenceScreen) {
        inflateFragment(preferenceScreen.getKey());
        return false;
    }

    private void inflateFragment(String screenTag) {
        Fragment fragment = SettingsFragment.newInstance(screenTag);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.settings_container, fragment)
                .addToBackStack(getString(R.string.key_settings_main))
                .commit();
    }

    public static class SettingsFragment extends PreferenceFragmentCompat {

        private static final String SCREEN_TAG = "screen_tag";
        private String mScreen;

        public SettingsFragment() {}

        public static SettingsFragment newInstance(String screenTag) {
            SettingsFragment fragment = new SettingsFragment();
            Bundle args = new Bundle();
            args.putString(SCREEN_TAG, screenTag);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public void onCreatePreferences(Bundle bundle, String screen) {
            this.mScreen = getArguments().getString(SCREEN_TAG);
            setPreferencesFromResource(R.xml.preferences_main, mScreen);
        }
    }
}