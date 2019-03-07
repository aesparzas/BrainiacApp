package com.esparperez.brainiacapp.game;

import android.content.Context;

public interface InGameInterface {

    interface InGameView {
        Context setContext();
        void showAnimationCategory();
        void showAnimationGameMode();
        void showQuestion(String category, String question, String opt1, String opt2, String opt3, String opt4);
        void showAnswer(String answer);
        void showTimer(String time);
        void showResults();
    }

    interface InGamePresenter {
        void startGame(int gameMode);
        void startTimer();
        void stopTimer();
        void getResult(int option);
    }

    interface InGameListener {
        // Data
        void retrieveQuestion(String category, String question, String opt1, String opt2, String opt3, String opt4);
        void retrieveResults(String results);

        // Timer
        void retrieveTimer(String time);

        //Animation
        void retrieveCategoryAnimation();
        void retrieveGameModeAnimation();
    }

    // Interactors

    interface AnimationInteractor {
        void getGameModeAnimation();
        void getCategoryAnimation();
    }

    interface DataInteractor {
        void loadData(int category);
    }

    interface TimerInteractor {
        void startTimer();
        void stopTimer();
    }

    interface InGameInteractor {
        void requestInformation(int category);
    }
}
