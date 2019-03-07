package com.esparperez.brainiacapp.game;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.esparperez.brainiacapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class InGameActivity extends AppCompatActivity implements InGameInterface.InGameView {

    private static final String GAME_MODE = "game_mode";

    private InGameInterface.InGamePresenter mPresenter;
    private int mGameMode;

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
    @BindView(R.id.in_game_toolbar)
    Toolbar toolbar;

    public InGameActivity() {}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_game);
        ButterKnife.bind(this);
        if (getIntent() != null) {
            mGameMode = getIntent().getIntExtra(GAME_MODE,-1);
        }
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }

    @Override
    public void onResume() {
        super.onResume();
        setPresenter();
        mPresenter.startGame(mGameMode);
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
    public Context setContext() {
        return this;
    }

    @Override
    public void showAnimationCategory() {

    }

    @Override
    public void showAnimationGameMode() {

    }

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
        Toast.makeText(this, answer, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showTimer(String time) {
        btnAnswer.setText(time);
    }

    @Override
    public void showResults() {

    }
}
