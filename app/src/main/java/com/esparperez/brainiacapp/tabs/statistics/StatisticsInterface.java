package com.esparperez.brainiacapp.tabs.statistics;

import android.content.Context;

import java.util.List;

public interface StatisticsInterface {
    interface StatisticsView {
        void showSummaryContent(String totalQuestions, String correctAnswers, String facts, String matches);
        void showPointsContent(String totalPoints, String currentDate, List<PointsTest> points);
        Context setContext();
    }

    interface StatisticsPresenter {
        void getContent();
    }

    interface StatisticsInteractor {
        void fillSummary();
        void fillPoints();
    }

    interface StatisticsListener {
        void onSummaryRetrieved(String totalQuestions, String correctAnswers, String facts, String matches);
        void onPointsRetrieved(String totalPoints, String currentDate, List<PointsTest> points);
    }
}
