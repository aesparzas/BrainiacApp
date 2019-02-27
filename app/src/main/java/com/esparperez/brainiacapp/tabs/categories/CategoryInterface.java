package com.esparperez.brainiacapp.tabs.categories;

import android.content.Context;

import java.util.List;

public interface CategoryInterface {

    interface CategoryView {
        void showContent(List<CategoryTest> categoryList);
        Context setContext();
    }

    interface CategoryPresenter {
        void getContent();
    }

    interface CategoryInteractor {
        void fillContent();
    }

    interface CategoryListener {
        void onRetrievedContent(List<CategoryTest> categoryList);
    }

}
