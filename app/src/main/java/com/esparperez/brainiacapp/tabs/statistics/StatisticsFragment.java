package com.esparperez.brainiacapp.tabs.statistics;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.esparperez.brainiacapp.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StatisticsFragment extends Fragment {

    public StatisticsFragment() {}
    public static StatisticsFragment newInstance() {
        StatisticsFragment fragment = new StatisticsFragment();
        return fragment;
    }

    @BindView(R.id.tv_detail_questions)
    TextView tvQuestion;
    @BindView(R.id.tv_detail_answers)
    TextView tvAnswer;
    @BindView(R.id.tv_detail_facts)
    TextView tvFact;
    @BindView(R.id.tv_detail_matches)
    TextView tvMatch;

    @BindView(R.id.recycler_points)
    RecyclerView recyclerView;
    @BindView(R.id.btn_see_all)
    Button btnSeeAll;

    private ScoreAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_statistics, container, false);
        ButterKnife.bind(this, view);
        setupRecycler();
        return view;
    }

    private void setupRecycler() {
        if (mAdapter == null) mAdapter = new ScoreAdapter();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(mAdapter);

        List<PointsTest> pointsTestList = new ArrayList<>();
        for (int i = 0; i<5; i++) {
            int points = (int) Math.random()*20 + i;
            Date date = Calendar.getInstance().getTime();
            PointsTest score = new PointsTest();
            score.setPoints(points);
            score.setDate(date);
            pointsTestList.add(score);
        }
        mAdapter.setValues(pointsTestList);
    }
}
