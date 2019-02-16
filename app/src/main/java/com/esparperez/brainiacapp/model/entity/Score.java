package com.esparperez.brainiacapp.model.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "score")
public class Score {

    @PrimaryKey(autoGenerate = true)
    private long idScore;
    private int points;
    private Date date;

    public Score() {}

    public Score(long idScore, int points, Date date) {
        this.idScore = idScore;
        this.points = points;
        this.date = date;
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
}
