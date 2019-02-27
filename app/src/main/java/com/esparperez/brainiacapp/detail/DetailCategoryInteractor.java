package com.esparperez.brainiacapp.detail;

import android.content.Context;

import com.esparperez.brainiacapp.R;

public class DetailCategoryInteractor implements DetailInterface.DetailInteractor {

    private DetailInterface.DetailListener mListener;
    private Context mContext;

    public DetailCategoryInteractor(DetailInterface.DetailListener listener, Context context) {
        this.mListener = listener;
        this.mContext = context;
    }

    @Override
    public void fillContent(int category) {
        String title = "";
        String catTitle = "";
        String catDesc = "";
        String apiTitle = "";
        String apiDesc = "";
        int image = -1;
        switch (category) {
            case 0:
                title = mContext.getString(R.string.title_cv_anime);
                catTitle = mContext.getString(R.string.title_cv_anime);
                catDesc = mContext.getString(R.string.description_cv_anime);
                apiTitle = mContext.getString(R.string.title_api);
                apiDesc = mContext.getString(R.string.title_description);
                image = R.drawable.img_cat_anime;
                break;
            case 1:
                title = mContext.getString(R.string.title_cv_book);
                catTitle = mContext.getString(R.string.title_cv_book);
                catDesc = mContext.getString(R.string.description_cv_book);
                apiTitle = mContext.getString(R.string.title_api);
                apiDesc = mContext.getString(R.string.title_description);
                image = R.drawable.img_cat_book;
                break;
            case 2:
                title = mContext.getString(R.string.title_cv_movie);
                catTitle = mContext.getString(R.string.title_cv_movie);
                catDesc = mContext.getString(R.string.title_cv_movie);
                apiTitle = mContext.getString(R.string.title_api);
                apiDesc = mContext.getString(R.string.title_description);
                image = R.drawable.img_cat_movies;
                break;
            case 3:
                title = mContext.getString(R.string.title_cv_music);
                catTitle = mContext.getString(R.string.title_cv_music);
                catDesc = mContext.getString(R.string.title_cv_music);
                apiTitle = mContext.getString(R.string.title_api);
                apiDesc = mContext.getString(R.string.title_description);
                image = R.drawable.img_cat_music;
                break;
            case 4:
                title = mContext.getString(R.string.title_cv_tv);
                catTitle = mContext.getString(R.string.title_cv_tv);
                catDesc = mContext.getString(R.string.title_cv_tv);
                apiTitle = mContext.getString(R.string.title_api);
                apiDesc = mContext.getString(R.string.title_description);
                image = R.drawable.img_cat_tv;
                break;
        }
        mListener.onContentRetrieved(title, catTitle, catDesc, apiTitle, apiDesc, image);
    }
}
