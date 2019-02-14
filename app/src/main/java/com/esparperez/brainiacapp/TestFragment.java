package com.esparperez.brainiacapp;

import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TestFragment extends Fragment {

    public TestFragment() { }

    public TestFragment newInstance() {
        TestFragment fragment = new TestFragment();
        return fragment;
    }

    @BindView(R.id.iv_loader)
    ImageView ivLoader;

    AnimatedVectorDrawableCompat loader;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_loader, container, false);
        ButterKnife.bind(this, view);
        ((Animatable) ivLoader.getDrawable()).start();
        return view;
    }
}
