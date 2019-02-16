package com.esparperez.brainiacapp.play;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.esparperez.brainiacapp.R;
import com.esparperez.brainiacapp.model.entity.Category;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PlayRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public PlayRecyclerAdapter(Context context) {
        mValues = new ArrayList<>();
        this.mContext = context;
    }

    private Context mContext;
    private List<Category> mValues;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_categories,viewGroup,false);
        return new CategoryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        CategoryHolder holder = (CategoryHolder) viewHolder;
        Category itemCategory = mValues.get(i);
        Glide
                .with(mContext)
                .load(itemCategory.getImageResource())
                .into(holder.ivCategory);
        holder.tvTitle.setText(itemCategory.getName());
        holder.tvDescription.setText(itemCategory.getDescription());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public void setValues(List<Category> values) {
        mValues = values;
        notifyDataSetChanged();
    }

    static class CategoryHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_item_title)
        TextView tvTitle;
        @BindView(R.id.tv_item_description)
        TextView tvDescription;
        @OnClick(R.id.btn_item)
        void click() {
            Toast.makeText(itemView.getContext(), "Click", Toast.LENGTH_SHORT).show();
        }
        @BindView(R.id.iv_category)
        ImageView ivCategory;

        public CategoryHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
