package com.esparperez.brainiacapp.game.usecases;

import android.content.Context;

import com.esparperez.brainiacapp.game.DataResult;
import com.esparperez.brainiacapp.game.InGameInterface;
import com.esparperez.brainiacapp.game.Question;

public class DataInteractor implements InGameInterface.DataInteractor {

    private static final int ANIME_CATEGORY = 0;
    private static final int BOOK_CATEGORY = 1;
    private static final int MOVIE_CATEGORY = 2;
    private static final int MUSIC_CATEGORY = 3;
    private static final int TV_CATEGORY = 4;

    private InGameInterface.InGameListener mListener;
    private Context mContext;
    private DataResult dataResult;

    public DataInteractor(InGameInterface.InGameListener listener, Context context) {
        this.mListener = listener;
        this.mContext = context;
        this.dataResult = new DataResult();
    }

    @Override
    public void loadData(int category) {
        Question question = null;
        switch (category) {
            case ANIME_CATEGORY:
                break;
            case BOOK_CATEGORY:
                break;
            case MOVIE_CATEGORY:
                break;
            case MUSIC_CATEGORY:
                dataResult.loadMusicData();
                question = dataResult.getQuestion();
                break;
            case TV_CATEGORY:
                break;
        }

        mListener.retrieveQuestion("category", question.getQuestion(), question.getFirstOption(),
                question.getSecondOption(), question.getThirdOption(), question.getFourthOption());
    }
}
