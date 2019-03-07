package com.esparperez.brainiacapp.data.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.esparperez.brainiacapp.data.model.entity.Score;

import java.util.List;

@Dao
public interface ScoreDao {
    @Insert
    void insert(Score score);

    @Update
    void update(Score score);

    @Delete
    void delete(Score score);

    @Query("SELECT * FROM score")
    List<Score> getAllScores();

    @Query("SELECT * FROM score WHERE id_game=:idGame")
    List<Score> findScoresForGame(final long idGame);
}
