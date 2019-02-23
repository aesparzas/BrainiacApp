package com.esparperez.brainiacapp.game;

public class InGamePresenter implements InGameInterface.InGamePresenter, InGameInterface.InGameListener {

    private InGameInterface.InGameView mView;
    private InGameInterface.InGameInteractor mInteractor;

    public InGamePresenter(InGameInterface.InGameView view) {
        this.mView = view;
        this.mInteractor = new InGameInteractor(this);
    }

    @Override
    public void getQuestion(int category) {
        mInteractor.requestInformation(category);
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

    @Override
    public void retrieveQuestion(String category, String question, String opt1, String opt2, String opt3, String opt4) {
        mView.showQuestion(category, question, opt1, opt2, opt3, opt4);
    }

    @Override
    public void retrieveTimer(String time) {
        mView.showTimer(time);
    }

    @Override
    public void retrieveResults(String results) {
        mView.showResults();
    }

}
