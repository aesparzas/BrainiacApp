package com.esparperez.brainiacapp.play;

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

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlayFragment extends Fragment {

    public PlayFragment() {}

    public PlayFragment newInstance() {
        PlayFragment fragment = new PlayFragment();
        return fragment;
    }
    @BindView(R.id.recycler_play)
    RecyclerView recyclerView;

    private PlayRecyclerAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_play, container,false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        setupRecycler();
    }

    private void setupRecycler() {
        if (mAdapter == null) mAdapter = new PlayRecyclerAdapter(getContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(mAdapter);
        // Sólo para prueba
        List<Game> categories = new ArrayList<>();
        for (int i = 0; i<10; i++) {
            Game game = new Game();
            game.setName("TestName: " + i);
            game.setDescription("TestDescription: " + i);
            game.setImageResource(R.drawable.img_profile_picture);
            categories.add(game);
        }
        mAdapter.setValues(categories);
    }
}
