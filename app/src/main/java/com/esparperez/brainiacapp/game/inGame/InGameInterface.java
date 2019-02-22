package com.esparperez.brainiacapp.game.inGame;

public interface InGameInterface {

    interface InGameView {
        void showQuestion(String category, String question, String opt1, String opt2, String opt3, String opt4);
        void showAnswer(String answer);
        void showTimer(String time);
        void showResults();
    }

    interface InGamePresenter {
        void getQuestion(int category);
        void startTimer();
        void stopTimer();
        void getResult(int option);
    }

    interface InGameInteractor {
        void requestInformation(int category);
        void startTimer();
        void stopTimer();
    }

    interface InGameListener {
        void retrieveQuestion(String category, String question, String opt1, String opt2, String opt3, String opt4);
        void retrieveTimer(String time);
        void retrieveResults(String results);
    }
}
