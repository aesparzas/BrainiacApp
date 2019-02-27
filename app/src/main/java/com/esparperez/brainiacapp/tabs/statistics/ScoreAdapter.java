package com.esparperez.brainiacapp.tabs.statistics;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.esparperez.brainiacapp.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Optional;

public class ScoreAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int VIEW_TYPE_FOOTER = 0;
    private static final int VIEW_TYPE_CELL = 1;

    public ScoreAdapter() {
        this.mValues = new ArrayList<>();
    }

    List<PointsTest> mValues;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view;
        if (viewType == VIEW_TYPE_CELL) {
            view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.item_points, viewGroup,false);
        } else {
            view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.item_btn_points, viewGroup,false);
        }

        return new PointsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, int i) {
        final PointsHolder holder = (PointsHolder) viewHolder;
        if (viewHolder.getItemViewType() == VIEW_TYPE_CELL ) {
            PointsTest item = mValues.get(i);
            holder.tvPoints.setText(String.valueOf(item.getPoints()));
            holder.tvDate.setText(item.getDate().toString());
        } else {
            holder.btnSeeAll.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(viewHolder.itemView.getContext(), "Click", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mValues.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        return (position == mValues.size()) ? VIEW_TYPE_FOOTER : VIEW_TYPE_CELL;
    }

    public void setValues(List<PointsTest> values) {
        mValues = values;
        notifyDataSetChanged();
    }

    static class PointsHolder extends RecyclerView.ViewHolder {
        @Nullable
        @BindView(R.id.tv_item_points)
        TextView tvPoints;
        @Nullable
        @BindView(R.id.tv_item_date)
        TextView tvDate;
        @Nullable
        @BindView(R.id.btn_see_all)
        Button btnSeeAll;

        public PointsHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    static class VerticalItemDecoration extends RecyclerView.ItemDecoration {

    }
}
