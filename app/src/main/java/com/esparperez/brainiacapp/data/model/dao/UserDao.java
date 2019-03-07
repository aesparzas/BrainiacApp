package com.esparperez.brainiacapp.data.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.esparperez.brainiacapp.data.model.entity.User;

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

    @Query("SELECT * FROM user AS u" +
            " JOIN userPlaysGame AS upg ON u.id_user = upg.id_user" +
            " JOIN score AS s ON upg.id_game = s.id_game" +
            " WHERE u.id_user =:idUser")
    List<User> getUsersScores(final long idUser);
}
