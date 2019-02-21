package com.esparperez.brainiacapp.game.inGame;

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

    private static final String ARG_GAME_MODE = "gameMode";

    private int mGameMode;

    @BindView(R.id.tv_category_title)
    TextView tvCategoryName;
    @BindView(R.id.tv_question)
    TextView tvQuestion;
    @BindView(R.id.radio_group)
    RadioGroup radioGroup;

    public InGame() { }

    public InGame newInstance(int gameMode) {
        InGame fragment = new InGame();
        Bundle args = new Bundle();
        args.putInt(ARG_GAME_MODE, gameMode);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mGameMode = getArguments().getInt(ARG_GAME_MODE);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_in_game, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
    }
}
