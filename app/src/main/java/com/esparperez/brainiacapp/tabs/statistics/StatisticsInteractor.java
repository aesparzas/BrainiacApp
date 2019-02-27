package com.esparperez.brainiacapp.tabs.statistics;

import android.content.Context;

import com.esparperez.brainiacapp.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class StatisticsInteractor implements StatisticsInterface.StatisticsInteractor {

    private StatisticsInterface.StatisticsListener mListener;
    private Context mContext;

    public StatisticsInteractor(StatisticsInterface.StatisticsListener listener, Context context) {
        this.mListener = listener;
        this.mContext = context;
    }

    @Override
    public void fillSummary() {

        // Queries
        String totalAux = "1";
        String correctAux = "2";
        String factsAux = "3";
        String matchesAux = "4";

        String totalQuestions = mContext.getString(R.string.summary_total_questions_showed).concat(totalAux);
        String correctAnswers = mContext.getString(R.string.summary_questions_answered).concat(correctAux);
        String facts = mContext.getString(R.string.summary_facts_read).concat(factsAux);
        String matches = mContext.getString(R.string.summary_matches_played).concat(matchesAux);
        mListener.onSummaryRetrieved(totalQuestions, correctAnswers, facts, matches);
    }

    @Override
    public void fillPoints() {
        int points;
        int auxPoints = 0;
        Date date;
        List<PointsTest> pointsList = new ArrayList<>();
        String currentDate = Calendar.getInstance().getTime().toString();
        String totalPoints;

        for (int i = 0; i<5; i++) {
            points = (int) Math.random()*20 + i;
            date = Calendar.getInstance().getTime();
            PointsTest score = new PointsTest();
            score.setPoints(points);
            score.setDate(date);
            pointsList.add(score);
            auxPoints = auxPoints + points;
        }

        totalPoints = String.valueOf(auxPoints);
        mListener.onPointsRetrieved(totalPoints, currentDate, pointsList);
    }
}
