package com.esparperez.brainiacapp.detail;

public class DetailCategoryPresenter implements DetailInterface.DetailPresenter, DetailInterface.DetailListener{

    private DetailInterface.DetailView mView;
    private DetailInterface.DetailInteractor mInteractor;

    public DetailCategoryPresenter(DetailInterface.DetailView view) {
        this.mView = view;
        this.mInteractor = new DetailCategoryInteractor(this, mView.getContext());
    }

    @Override
    public void getContent(int category) {
        mInteractor.fillContent(category);
    }

    @Override
    public void onContentRetrieved(String title, String catTitle, String catDesc, String apiTitle,
                                   String apiDesc, int image) {
        mView.showContent(title, catTitle, catDesc, apiTitle, apiDesc, image);
    }
}
