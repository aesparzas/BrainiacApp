package com.esparperez.brainiacapp.data.model.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.esparperez.brainiacapp.data.model.DateConverter;

import java.util.Date;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "score",
        indices = @Index("id_game"),
        foreignKeys = {
                @ForeignKey(entity = Game.class,
                        parentColumns = "id_game",
                        childColumns = "id_game",
                        onDelete = CASCADE),
        })
public class Score {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_score")
    private long idScore;
    @ColumnInfo(name = "points")
    private int points;
    @ColumnInfo(name = "date")
    @TypeConverters(DateConverter.class)
    private Date date;
    @ColumnInfo(name = "id_game")
    private long idGame;

    @Ignore
    public Score() {}

    public Score(long idScore, int points, Date date, long idGame) {
        this.idScore = idScore;
        this.points = points;
        this.date = date;
        this.idGame = idGame;
    }

    public long getIdScore() {
        return idScore;
    }

    public void setIdScore(long idScore) {
        this.idScore = idScore;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getIdGame() {
        return idGame;
    }

    public void setIdGame(long idGame) {
        this.idGame = idGame;
    }
}
