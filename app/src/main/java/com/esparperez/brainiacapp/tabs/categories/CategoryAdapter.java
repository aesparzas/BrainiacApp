package com.esparperez.brainiacapp.tabs.categories;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.esparperez.brainiacapp.detail.DetailCategoryActivity;
import com.esparperez.brainiacapp.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.esparperez.brainiacapp.Constants.CATEGORY_TYPE;

public class CategoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public CategoryAdapter(Context context) {
        mValues = new ArrayList<>();
        this.mContext = context;
    }

    private Context mContext;
    private List<CategoryTest> mValues;

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
        CategoryTest item = mValues.get(i);
        Glide
                .with(mContext)
                .load(item.getImageResource())
                .into(holder.ivCategory);
        holder.tvTitle.setText(item.getName());
        holder.tvDescription.setText(item.getDescription());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public void setValues(List<CategoryTest> values) {
        mValues = values;
        notifyDataSetChanged();
    }

    static class CategoryHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_item_title)
        TextView tvTitle;
        @BindView(R.id.tv_item_description)
        TextView tvDescription;
        @BindView(R.id.btn_item)
        Button btnItem;
        @BindView(R.id.iv_category)
        ImageView ivCategory;

        private Context context = itemView.getContext();
        private String btnLabel = context.getString(R.string.action_see_more);

        @OnClick(R.id.btn_item)
        void click() {
            int position = getAdapterPosition();

            Intent intent = new Intent(context, DetailCategoryActivity.class);
            intent.putExtra(CATEGORY_TYPE, position);
            context.startActivity(intent);
        }

        public CategoryHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            btnItem.setText(btnLabel);
        }
    }
}