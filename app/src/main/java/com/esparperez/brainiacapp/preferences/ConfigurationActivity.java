package com.esparperez.brainiacapp.preferences;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.support.v7.widget.Toolbar;


import com.esparperez.brainiacapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ConfigurationActivity extends AppCompatActivity {

    @BindView(R.id.config_toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Configurations");
        Fragment fragment = MainSettingsFragment.newInstance();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.settings_container, fragment)
                .commit();
    }

    public static class MainSettingsFragment extends PreferenceFragmentCompat {

        public MainSettingsFragment() {}

        public static MainSettingsFragment newInstance() {
            MainSettingsFragment fragment = new MainSettingsFragment();
            return fragment;
        }

        @Override
        public void onCreatePreferences(Bundle bundle, String s) {
            addPreferencesFromResource(R.xml.preferences_main);
        }
    }
}
