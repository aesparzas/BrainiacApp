package com.esparperez.brainiacapp.tabs.categories;

import android.content.Context;

import com.esparperez.brainiacapp.R;

import java.util.ArrayList;
import java.util.List;

public class CategoryInteractor implements CategoryInterface.CategoryInteractor {

    private CategoryInterface.CategoryListener mListener;
    private Context mContext;

    public CategoryInteractor(CategoryInterface.CategoryListener listener, Context context) {
        this.mListener = listener;
        this.mContext = context;
    }

    @Override
    public void fillContent() {
        List<CategoryTest> categoryList = new ArrayList<>();
        String [] arrTitle = {
                mContext.getString(R.string.title_cv_anime), mContext.getString(R.string.title_cv_book),
                mContext.getString(R.string.title_cv_movie), mContext.getString(R.string.title_cv_music),
                mContext.getString(R.string.title_cv_tv)};
        String [] arrDesc = {
                mContext.getString(R.string.description_cv_anime), mContext.getString(R.string.description_cv_book),
                mContext.getString(R.string.description_cv_movie), mContext.getString(R.string.description_cv_music),
                mContext.getString(R.string.description_cv_tv)};
        int [] arrDrawable = {
                R.drawable.img_cv_anime, R.drawable.img_cv_book,
                R.drawable.img_cv_movie, R.drawable.img_cv_music,
                R.drawable.img_cv_tv};
        for (int i = 0; i < arrTitle.length; i++) {
            CategoryTest categoryTest = new CategoryTest();
            categoryTest.setName(arrTitle[i]);
            categoryTest.setDescription(arrDesc[i]);
            categoryTest.setImageResource(arrDrawable[i]);
            categoryList.add(categoryTest);
        }
        mListener.onRetrievedContent(categoryList);
    }
}
