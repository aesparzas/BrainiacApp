package com.esparperez.brainiacapp.tabs.statistics;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.esparperez.brainiacapp.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StatisticsFragment extends Fragment implements StatisticsInterface.StatisticsView {

    public StatisticsFragment() {}
    public static StatisticsFragment newInstance() {
        StatisticsFragment fragment = new StatisticsFragment();
        return fragment;
    }

    @BindView(R.id.tv_summary_questions)
    TextView tvQuestion;
    @BindView(R.id.tv_summary_answers)
    TextView tvAnswer;
    @BindView(R.id.tv_summary_facts)
    TextView tvFact;
    @BindView(R.id.tv_summary_matches)
    TextView tvMatch;

    @BindView(R.id.recycler_points)
    RecyclerView recyclerView;
    @BindView(R.id.tv_subtitle_points)
    TextView tvPoints;
    @BindView(R.id.tv_subtitle_date)
    TextView tvDate;

    private ScoreAdapter mAdapter;
    private StatisticsPresenter mPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_statistics, container, false);
        ButterKnife.bind(this, view);
        setupRecycler();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        setPresenter();
        mPresenter.getContent();
    }

    private void setPresenter() {
        if (mPresenter == null) {
            mPresenter = new StatisticsPresenter(this);
        }
    }

    private void setupRecycler() {
        if (mAdapter == null) mAdapter = new ScoreAdapter();
        recyclerView.setFocusable(false);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(setContext()));
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public Context setContext() {
        return getContext();
    }

    @Override
    public void showSummaryContent(String totalQuestions, String correctAnswers, String facts, String matches) {
        tvQuestion.setText(totalQuestions);
        tvAnswer.setText(correctAnswers);
        tvFact.setText(facts);
        tvMatch.setText(matches);
    }

    @Override
    public void showPointsContent(String totalPoints, String currentDate, List<PointsTest> points) {
        tvPoints.setText(totalPoints);
        tvDate.setText(currentDate);
        if (mAdapter == null) mAdapter = new ScoreAdapter();
        mAdapter.setValues(points);
    }
}
