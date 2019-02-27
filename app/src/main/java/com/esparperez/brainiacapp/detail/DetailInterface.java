package com.esparperez.brainiacapp.detail;

import android.content.Context;

public interface DetailInterface {
    interface DetailView {
        Context getContext();
        void showContent(String title, String catTitle, String catDesc, String apiTitle,
                         String apiDesc, int image);
    }

    interface DetailPresenter {
        void getContent(int category);
    }

    interface DetailInteractor {
        void fillContent(int category);
    }

    interface DetailListener {
        void onContentRetrieved(String title, String catTitle, String catDesc, String apiTitle,
                                String apiDesc, int image);
    }
}
