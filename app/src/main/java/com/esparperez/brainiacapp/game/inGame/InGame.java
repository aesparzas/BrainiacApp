package com.esparperez.brainiacapp.game.inGame;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.esparperez.brainiacapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class InGame extends Fragment implements InGameInterface.InGameView {

    private static final String ARG_GAME_MODE = "gameMode";

    private int mGameMode;
    private InGameInterface.InGamePresenter mPresenter;

    @BindView(R.id.tv_category_title)
    TextView tvCategoryName;
    @BindView(R.id.tv_question)
    TextView tvQuestion;
    @BindView(R.id.radio_group)
    RadioGroup radioGroup;
    @BindView(R.id.radio_opt_1)
    RadioButton radioOption1;
    @BindView(R.id.radio_opt_2)
    RadioButton radioOption2;
    @BindView(R.id.radio_opt_3)
    RadioButton radioOption3;
    @BindView(R.id.radio_opt_4)
    RadioButton radioOption4;
    @BindView(R.id.btn_answer)
    Button btnAnswer;

    public InGame() {}

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
        mPresenter.getQuestion(mGameMode);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        setPresenter();
    }

    @OnClick(R.id.btn_answer)
    void answerQuestion() {
        RadioButton button = radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());
        mPresenter.getResult(radioGroup.indexOfChild(button));
    }

    private void setPresenter() {
        if (mPresenter == null) {
            mPresenter = new InGamePresenter(this);
        }
    }

    /*
     * Métodos de View
     */

    @Override
    public void showQuestion(String category, String question, String opt1, String opt2, String opt3, String opt4) {
        tvCategoryName.setText(category);
        tvQuestion.setText(question);
        radioOption1.setText(opt1);
        radioOption2.setText(opt2);
        radioOption3.setText(opt3);
        radioOption4.setText(opt4);
    }

    @Override
    public void showAnswer(String answer) {
        Toast.makeText(getContext(), answer, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showTimer(String time) {
        btnAnswer.setText(time);
    }

    @Override
    public void showResults() {

    }
}
