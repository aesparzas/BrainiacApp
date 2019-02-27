package com.esparperez.brainiacapp.detail;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.esparperez.brainiacapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.esparperez.brainiacapp.Constants.CATEGORY_TYPE;

public class DetailCategoryActivity extends AppCompatActivity implements DetailInterface.DetailView{

    @BindView(R.id.detail_toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_cat_title)
    TextView tvCatTitle;
    @BindView(R.id.tv_cat_desc)
    TextView tvCatDesc;
    @BindView(R.id.tv_api_title)
    TextView tvApiTitle;
    @BindView(R.id.tv_api_desc)
    TextView tvApiDesc;
    @BindView(R.id.iv_detail_cat)
    ImageView imgCat;

    private DetailCategoryPresenter mPresenter;
    private int mCategory;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_category);
        ButterKnife.bind(this);
        mCategory = getIntent().getIntExtra(CATEGORY_TYPE, -1);

//        String title = getIntent().getStringExtra(CATEGORY_TYPE);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setPresenter();
        mPresenter.getContent(mCategory);
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void showContent(String title, String catTitle, String catDesc, String apiTitle,
                              String apiDesc, int image) {
        getSupportActionBar().setTitle(title);
        tvCatTitle.setText(catTitle);
        tvCatDesc.setText(catDesc);
        tvApiTitle.setText(apiTitle);
        tvApiDesc.setText(apiDesc);
        Glide
                .with(this)
                .load(image)
                .into(imgCat);
    }

    private void setPresenter() {
        if (mPresenter == null) {
            mPresenter = new DetailCategoryPresenter(this);
        }
    }
}