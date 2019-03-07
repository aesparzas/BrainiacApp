package com.esparperez.brainiacapp.game;

import android.content.Context;

public class InGameInteractor implements InGameInterface.InGameInteractor {

    private static final int ANIME_CATEGORY = 0;
    private static final int BOOK_CATEGORY = 1;
    private static final int MOVIE_CATEGORY = 2;
    private static final int MUSIC_CATEGORY = 3;
    private static final int TV_CATEGORY = 4;

    private InGameInterface.InGameListener mListener;
    private DataResult dataResult;
    private Context mContext;

    public InGameInteractor(InGameInterface.InGameListener listener, Context context) {
        this.mListener = listener;
        this.mContext = context;
    }

    @Override
    public void requestInformation(int category) {
        dataResult = new DataResult();
        switch (category) {
            case ANIME_CATEGORY:
                dataResult.loadAnimeData();
                break;
            case BOOK_CATEGORY:
                break;
            case MOVIE_CATEGORY:
                break;
            case MUSIC_CATEGORY:
                break;
            case TV_CATEGORY:
                break;
        }
    }
}
