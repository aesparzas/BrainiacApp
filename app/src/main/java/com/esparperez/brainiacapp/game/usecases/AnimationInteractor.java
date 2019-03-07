package com.esparperez.brainiacapp.game.usecases;

import android.content.Context;

import com.esparperez.brainiacapp.game.InGameInterface;

public class AnimationInteractor implements InGameInterface.AnimationInteractor{

    private InGameInterface.InGameListener mListener;
    private Context mContext;

    public AnimationInteractor(InGameInterface.InGameListener listener, Context context) {
        this.mListener = listener;
        mContext = context;
    }


    @Override
    public void getGameModeAnimation() {

    }

    @Override
    public void getCategoryAnimation() {

    }
}
