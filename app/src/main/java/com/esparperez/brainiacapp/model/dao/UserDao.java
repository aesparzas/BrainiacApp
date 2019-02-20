package com.esparperez.brainiacapp.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.esparperez.brainiacapp.model.entity.User;

import java.util.List;

@Dao
public interface UserDao {
    @Update
    void update(User user);

    @Insert
    void insert(User user);

    @Delete
    void delete(User user);

    @Query("SELECT * FROM User LIMIT 1")
    User getDefaultUser();

    @Query("SELECT * FROM User")
    User getAll();

    @Query("SELECT * FROM User WHERE id_user = :id_user")
    User getById(int id_user);
}
