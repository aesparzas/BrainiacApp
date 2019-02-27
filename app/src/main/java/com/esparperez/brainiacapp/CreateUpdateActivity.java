package com.esparperez.brainiacapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import com.esparperez.brainiacapp.model.dao.CategoryDao;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CreateUpdateActivity extends AppCompatActivity {
    @BindView(R.id.txtCategoryName)
    EditText txtCategoryName;
    @BindView(R.id.btnSave)
    Button btnSave;

    private CategoryDao mCategoryDao;

    public static final String EXTRA_REPLY = "EXTRA_REPLY";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createupdate);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnSave)
    public void onClick() {

        Intent replyIntent = new Intent();
        if (TextUtils.isEmpty(txtCategoryName.getText())) {
            setResult(RESULT_CANCELED, replyIntent);
        } else {
            String word = txtCategoryName.getText().toString();
            replyIntent.putExtra(EXTRA_REPLY, word);
            setResult(RESULT_OK, replyIntent);
        }
        finish();
    }
}
