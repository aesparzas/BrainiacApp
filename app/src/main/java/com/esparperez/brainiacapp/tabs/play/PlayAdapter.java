package com.esparperez.brainiacapp.tabs.play;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.esparperez.brainiacapp.R;
import com.esparperez.brainiacapp.model.entity.Game;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PlayAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public PlayAdapter(Context context) {
        mValues = new ArrayList<>();
        this.mContext = context;
    }

    private Context mContext;
    private List<Game> mValues;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_categories,viewGroup,false);
        return new PlayHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        PlayHolder holder = (PlayHolder) viewHolder;
        Game itemGame = mValues.get(i);
        Glide
                .with(mContext)
                .load(itemGame.getImageResource())
                .into(holder.ivCategory);
        holder.tvTitle.setText(itemGame.getName());
        holder.tvDescription.setText(itemGame.getDescription());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public void setValues(List<Game> values) {
        mValues = values;
        notifyDataSetChanged();
    }

    static class PlayHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_item_title)
        TextView tvTitle;
        @BindView(R.id.tv_item_description)
        TextView tvDescription;
        @OnClick(R.id.btn_item)
        void click() {
            int position = getAdapterPosition();
            Fragment fragment = null;
            switch (position) {
                case 0 :
                    break;
                case 1:
                    break;
                case 2:
                    break;
            }
        }
        @BindView(R.id.iv_category)
        ImageView ivCategory;

        public PlayHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
