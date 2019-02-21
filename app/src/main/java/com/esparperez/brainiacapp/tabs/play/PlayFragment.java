package com.esparperez.brainiacapp.tabs.play;

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
import com.esparperez.brainiacapp.tabs.categories.CategoryTest;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlayFragment extends Fragment {

    public PlayFragment() {}

    public static PlayFragment newInstance() {
        PlayFragment fragment = new PlayFragment();
        return fragment;
    }
    @BindView(R.id.recycler_play)
    RecyclerView recyclerView;

    private PlayAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_play, container,false);
        ButterKnife.bind(this, view);
        setupRecycler();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    private void setupRecycler() {
        if (mAdapter == null) mAdapter = new PlayAdapter(getContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(mAdapter);

        // Sólo para prueba
        List<Game> categories = new ArrayList<>();
        String [] arrTitle = {getString(R.string.title_cv_roulette),
                getString(R.string.title_cv_subject), getString(R.string.title_cv_fact)};
        String [] arrDesc = {getString(R.string.description_cv_roulette),
                getString(R.string.description_cv_subject),getString(R.string.description_cv_fact)};
        for (int i = 0; i < arrTitle.length; i++) {
            Game game = new Game();
            game.setName(arrTitle[i]);
            game.setDescription(arrDesc[i]);
            game.setImageResource(R.drawable.img_profile_picture);
            categories.add(game);
        }
        mAdapter.setValues(categories);
    }
}
