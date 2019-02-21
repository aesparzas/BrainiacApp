package com.esparperez.brainiacapp.tabs.statistics;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.esparperez.brainiacapp.R;
import com.esparperez.brainiacapp.model.entity.Score;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ScoreRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public ScoreRecyclerAdapter() {
        this.mValues = new ArrayList<>();
    }
    List<Score> mValues;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_points, viewGroup,false);
        return new PointsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        PointsHolder holder = (PointsHolder) viewHolder;
        Score itemStatistics = mValues.get(i);

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public void setValues(List<Score> values) {
        mValues = values;
        notifyDataSetChanged();
    }

    static class PointsHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_item_points)
        TextView tvPoints;
        @BindView(R.id.tv_item_date)
        TextView tvDate;

        public PointsHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
