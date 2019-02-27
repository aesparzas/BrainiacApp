package com.esparperez.brainiacapp;

import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.esparperez.brainiacapp.model.AppDataBase;
import com.esparperez.brainiacapp.model.dao.CategoryDao;
import com.esparperez.brainiacapp.model.entity.Category;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CrudActivity extends AppCompatActivity {
    public static final int CATEGORY_CREATE_CODE = 1;

    @BindView(R.id.listCategories)
    RecyclerView listCategories;
    @BindView(R.id.btnAddOrUpdate)
    FloatingActionButton btnAddOrUpdate;

    private CategoryDao mDao;
    private CategoryAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud);

        ButterKnife.bind(this);
        adapter = new CategoryAdapter(this);
        listCategories.setAdapter(adapter);
        listCategories.setLayoutManager(new LinearLayoutManager(this));
        AppDataBase db = AppDataBase.getDatabase(this);
        mDao = db.categoryDao();
        mDao.getAll().observe(this, new Observer<List<Category>>() {
            @Override
            public void onChanged(@Nullable final List<Category> categories) {
                adapter.setCategories(categories);
            }
        });
    }

    @OnClick(R.id.btnAddOrUpdate)
    public void onClick() {
        startActivityForResult(new Intent(CrudActivity.this, CreateUpdateActivity.class),
                CATEGORY_CREATE_CODE);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CATEGORY_CREATE_CODE && resultCode == RESULT_OK) {
            Category category = new Category(data.getStringExtra(CreateUpdateActivity.EXTRA_REPLY));
            mDao.insert(category);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    "FALLO",
                    Toast.LENGTH_LONG).show();
        }
    }
}
