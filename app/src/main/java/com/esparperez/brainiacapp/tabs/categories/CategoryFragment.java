package com.esparperez.brainiacapp.tabs.categories;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.esparperez.brainiacapp.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryFragment extends Fragment implements CategoryInterface.CategoryView {

    public CategoryFragment() {}

    public static CategoryFragment newInstance() {
        CategoryFragment fragment = new CategoryFragment();
        return fragment;
    }

    @BindView(R.id.recycler_categories)
    RecyclerView recyclerView;

    private CategoryAdapter mAdapter;
    private CategoryInterface.CategoryPresenter mPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_categories, container, false);
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

    private void setupRecycler() {
        if (mAdapter == null) mAdapter = new CategoryAdapter(getContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(mAdapter);
    }

    private void setPresenter() {
        if (mPresenter == null) {
            mPresenter = new CategoryPresenter(this);
        }
    }

    @Override
    public void showContent(List<CategoryTest> categoryList) {
        mAdapter.setValues(categoryList);
    }

    @Override
    public Context setContext() {
        return getContext();
    }
}
