package com.esparperez.brainiacapp.model.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "game")
public class Game {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_game")
    private long idGame;
    private String name;
    private String description;
    @ColumnInfo(name = "image_resource")
    private int imageResource;
    @ColumnInfo(name = "points_per_question")
    private int pointsPerQuestion;

    @Ignore
    public Game() {}

    public Game(long idGame, String name, String description, int imageResource, int pointsPerQuestion) {
        this.idGame = idGame;
        this.name = name;
        this.description = description;
        this.imageResource = imageResource;
        this.pointsPerQuestion = pointsPerQuestion;
    }

    public void setIdGame(long idGame) {
        this.idGame = idGame;
    }

    public int getPointsPerQuestion() {
        return pointsPerQuestion;
    }

    public void setPointsPerQuestion(int pointsPerQuestion) {
        this.pointsPerQuestion = pointsPerQuestion;
    }

    public long getIdGame() {
        return idGame;
    }

    public void setIdGame(int idGame) {
        this.idGame = idGame;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }
}
