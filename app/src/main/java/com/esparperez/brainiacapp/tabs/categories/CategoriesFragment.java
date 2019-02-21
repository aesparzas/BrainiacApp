package com.esparperez.brainiacapp.tabs.categories;

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
import com.esparperez.brainiacapp.model.entity.Game;
import com.esparperez.brainiacapp.tabs.play.PlayAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoriesFragment extends Fragment {

    public CategoriesFragment() {}

    public static CategoriesFragment newInstance() {
        CategoriesFragment fragment = new CategoriesFragment();
        return fragment;
    }

    @BindView(R.id.recycler_categories)
    RecyclerView recyclerView;

    private CategoryAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_categories, container, false);
        ButterKnife.bind(this, view);
        setupRecycler();
        return view;
    }

    private void setupRecycler() {
        if (mAdapter == null) mAdapter = new CategoryAdapter(getContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(mAdapter);

        // Sólo para prueba
        List<CategoryTest> categories = new ArrayList<>();
        String [] arrTitle = {getString(R.string.title_cv_anime), getString(R.string.title_cv_book),
                getString(R.string.title_cv_movie), getString(R.string.title_cv_music),
                getString(R.string.title_cv_tv)};
        String [] arrDesc = {getString(R.string.description_cv_anime), getString(R.string.description_cv_book),
                getString(R.string.description_cv_movie), getString(R.string.description_cv_music),
                getString(R.string.description_cv_tv)};
        for (int i = 0; i < arrTitle.length; i++) {
            CategoryTest categoryTest = new CategoryTest();
            categoryTest.setName(arrTitle[i]);
            categoryTest.setDescription(arrDesc[i]);
            categoryTest.setImageResource(R.drawable.img_profile_picture);
            categories.add(categoryTest);
        }
        mAdapter.setValues(categories);
    }
}
