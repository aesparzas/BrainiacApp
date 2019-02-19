package com.esparperez.brainiacapp.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.esparperez.brainiacapp.model.entity.UserPlaysGame;

@Dao
public interface UserPlaysGameDao {

    @Insert
    void insert(UserPlaysGame userPlaysGame);
}
