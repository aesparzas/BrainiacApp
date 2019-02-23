package com.esparperez.brainiacapp.game;

public class InGameInteractor implements InGameInterface.InGameInteractor {

    private InGameInterface.InGameListener mListener;
    private static final int ROULETTE = 1;
    private static final int SUBJECT = 2;
    private static final int FACT = 3;

    public InGameInteractor(InGameInterface.InGameListener listener) {
        this.mListener = listener;
    }

    @Override
    public void requestInformation(int category) {
        switch (category) {
            case ROULETTE:
                modeRoulette();
                break;
            case SUBJECT:
                modeSubject();
                break;
            case FACT:
                modeFact();
                break;
        }
    }

    @Override
    public void startTimer() {
    }

    @Override
    public void stopTimer() {
    }

    /*
     * Gamemodes
     */

    private void modeRoulette() {

    }

    private void modeSubject() {

    }

    private void modeFact() {

    }
}
