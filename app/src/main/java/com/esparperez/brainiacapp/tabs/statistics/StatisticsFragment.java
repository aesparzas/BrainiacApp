package com.esparperez.brainiacapp.tabs.statistics;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.esparperez.brainiacapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StatisticsFragment extends Fragment {

    public StatisticsFragment() {}
    public StatisticsFragment newInstance() {
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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_statistics, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
}
