package com.esparperez.brainiacapp.gameMods.inGame;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.esparperez.brainiacapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InGame extends Fragment {

    public InGame() { }

    public InGame newInstance() {
        InGame fragment = newInstance();
        return fragment;
    }

    @BindView(R.id.tv_category_title)
    TextView tvCategoryName;
    @BindView(R.id.tv_question)
    TextView tvQuestion;
    @BindView(R.id.radio_group)
    RadioGroup radioGroup;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_in_game, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        menu.findItem(R.id.app_bar_tab_layout).setVisible(false);
    }
}
