package com.esparperez.brainiacapp.tabs.play;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.esparperez.brainiacapp.R;
import com.esparperez.brainiacapp.game.InGameActivity;
import com.esparperez.brainiacapp.model.entity.Game;
import com.esparperez.brainiacapp.preferences.ConfigurationActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.esparperez.brainiacapp.Constants.SCREEN_TAG;
import static com.esparperez.brainiacapp.Constants.SCREEN_TITLE;

public class PlayAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final String GAME_MODE = "game_mode";
    private Context mContext;
    private List<Game> mValues;

    public PlayAdapter(Context context) {
        mValues = new ArrayList<>();
        this.mContext = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_categories,viewGroup,false);
        return new PlayHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        final PlayHolder holder = (PlayHolder) viewHolder;
        Game itemGame = mValues.get(i);
        Glide
                .with(mContext)
                .load(itemGame.getImageResource())
                .into(holder.ivCategory);
        holder.tvTitle.setText(itemGame.getName());
        holder.tvDescription.setText(itemGame.getDescription());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, InGameActivity.class);
                intent.putExtra(GAME_MODE, i);
                mContext.startActivity(intent);
            }
        });
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
        @BindView(R.id.iv_category)
        ImageView ivCategory;

        @OnClick(R.id.btn_item)
        void click() {
            int position = getAdapterPosition();
            String preferenceScreen = "";
            String preferenceTitle = "";
            Context context = itemView.getContext();
            switch (position) {
                case 0 :
                    preferenceScreen = itemView.getContext().getString(R.string.key_settings_roulette);
                    preferenceTitle = context.getString(R.string.title_category_roulette);
                    break;
                case 1:
                    preferenceScreen = itemView.getContext().getString(R.string.key_settings_subject);
                    preferenceTitle = context.getString(R.string.title_category_subject);
                    break;
                case 2:
                    preferenceScreen = itemView.getContext().getString(R.string.key_settings_fact);
                    preferenceTitle = context.getString(R.string.title_category_fact);
                    break;
            }
            Intent intent = new Intent(itemView.getContext(), ConfigurationActivity.class);
            intent.putExtra(SCREEN_TAG, preferenceScreen);
            intent.putExtra(SCREEN_TITLE, preferenceTitle);
            itemView.getContext().startActivity(intent);
        }

        public PlayHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
