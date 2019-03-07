package com.esparperez.brainiacapp.game;

import com.esparperez.brainiacapp.game.usecases.DataInteractor;

public class InGamePresenter implements InGameInterface.InGamePresenter, InGameInterface.InGameListener {

    private static final int ROULETTE = 0;
    private static final int SUBJECT = 1;
    private static final int FACT = 2;

    private InGameInterface.InGameView mView;
    private InGameInterface.InGameInteractor mInteractor;

    private InGameInterface.DataInteractor mDataInteractor;
    private InGameInterface.AnimationInteractor mAnimationInteractor;
    private InGameInterface.TimerInteractor mTimerInteractor;

    public InGamePresenter(InGameInterface.InGameView view) {
        this.mView = view;
        this.mInteractor = new InGameInteractor(this, mView.setContext());
        this.mDataInteractor = new DataInteractor(this, mView.setContext());
    }

    @Override
    public void startGame(int gameMode) {
//        mInteractor.requestInformation(category);
        switch (gameMode) {
            case ROULETTE:
//                mAnimationInteractor.getGameModeAnimation();
                mDataInteractor.loadData(3);
                break;
            case SUBJECT:
//                mAnimationInteractor.getGameModeAnimation();
                mDataInteractor.loadData(3);
                break;
            case FACT:
//                mAnimationInteractor.getGameModeAnimation();
                mDataInteractor.loadData(3);
                break;
        }
    }

    @Override
    public void startTimer() {

    }

    @Override
    public void stopTimer() {

    }

    @Override
    public void getResult(int option) {

    }

    /*
     * Listener
     */

    // Data

    @Override
    public void retrieveQuestion(String category, String question, String opt1, String opt2, String opt3, String opt4) {
        mView.showQuestion(category, question, opt1, opt2, opt3, opt4);
    }

    @Override
    public void retrieveResults(String results) {
        mView.showResults();
    }

    // Timer

    @Override
    public void retrieveTimer(String time) {
        mView.showTimer(time);
    }

    // Animation

    @Override
    public void retrieveCategoryAnimation() {

    }

    @Override
    public void retrieveGameModeAnimation() {

    }
}
