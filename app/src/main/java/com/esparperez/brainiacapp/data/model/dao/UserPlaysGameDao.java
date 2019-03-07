package com.esparperez.brainiacapp.data.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;

import com.esparperez.brainiacapp.data.model.entity.UserPlaysGame;

@Dao
public interface UserPlaysGameDao {

    @Insert
    void insert(UserPlaysGame userPlaysGame);
}
