package com.esparperez.brainiacapp.model.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.esparperez.brainiacapp.model.entity.Category;

import java.util.List;

@Dao
public interface CategoryDao {
    @Insert
    void insert(Category category);

    @Query("DELETE FROM category")
    void deleteAll();

    @Query("SELECT * from category ORDER BY name ASC")
    LiveData<List<Category>> getAll();
}
