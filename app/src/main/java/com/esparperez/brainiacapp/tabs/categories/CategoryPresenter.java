package com.esparperez.brainiacapp.tabs.categories;

import java.util.List;

public class CategoryPresenter implements CategoryInterface.CategoryPresenter,
        CategoryInterface.CategoryListener {

    private CategoryInterface.CategoryInteractor mInteractor;
    private CategoryInterface.CategoryView mView;

    public CategoryPresenter(CategoryInterface.CategoryView view) {
        this.mView = view;
        mInteractor = new CategoryInteractor(this, mView.setContext());
    }

    @Override
    public void getContent() {
        mInteractor.fillContent();
    }

    @Override
    public void onRetrievedContent(List<CategoryTest> categoryList) {
        mView.showContent(categoryList);
    }
}
