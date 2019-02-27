package com.esparperez.brainiacapp.tabs.statistics;

import java.util.List;

public class StatisticsPresenter implements StatisticsInterface.StatisticsPresenter,
        StatisticsInterface.StatisticsListener {

    private StatisticsInterface.StatisticsView mView;
    private StatisticsInterface.StatisticsInteractor mInteractor;

    public StatisticsPresenter(StatisticsInterface.StatisticsView view) {
        this.mView = view;
        this.mInteractor = new StatisticsInteractor(this, mView.setContext());
    }

    @Override
    public void getContent() {
        mInteractor.fillSummary();
        mInteractor.fillPoints();
    }

    @Override
    public void onSummaryRetrieved(String totalQuestions, String correctAnswers, String facts, String matches) {
        mView.showSummaryContent(totalQuestions, correctAnswers, facts, matches);
    }

    @Override
    public void onPointsRetrieved(String totalPoints, String currentDate, List<PointsTest> points) {
        mView.showPointsContent(totalPoints, currentDate, points);
    }
}
