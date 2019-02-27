package com.esparperez.brainiacapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.esparperez.brainiacapp.model.entity.Category;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    class CategoryViewHolder extends RecyclerView.ViewHolder {
        private final TextView nameItemView;

        private CategoryViewHolder(View itemView) {
            super(itemView);
            nameItemView = itemView.findViewById(R.id.txtCategoryName);
        }
    }

    private final LayoutInflater mInflater;
    private List<Category> mCategories; // Cached copy of words

    CategoryAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.item_crud_category, parent, false);
        return new CategoryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {
        if (mCategories != null) {
            Category current = mCategories.get(position);
            holder.nameItemView.setText(current.getName());
        } else {
            holder.nameItemView.setText("No hay categorías");
        }
    }

    void setCategories(List<Category> categories){
        mCategories = categories;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (mCategories != null)
            return mCategories.size();
        else return 0;
    }
}
