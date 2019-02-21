package com.esparperez.brainiacapp.game.inGame;

public interface InGameInterface {

    interface InGameView {
        void showQuestion();
        void showAnswer();
        void showTimer();
        void showResults();
    }

    interface InGamePresenter {
        void getQuestion();
        void startTimer();
        void stopTimer();
        void getResult();
    }

    interface InGameInteractor {






























        
        void
    }

    interface InGameListener {

    }
}
