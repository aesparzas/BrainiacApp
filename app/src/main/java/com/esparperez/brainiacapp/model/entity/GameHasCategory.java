package com.esparperez.brainiacapp.model.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "gameHasCategory",
        indices = @Index("id_category"),
        primaryKeys = {"id_game", "id_category"},
        foreignKeys = {
        @ForeignKey(entity = Game.class,
                parentColumns = "id_game",
                childColumns = "id_game",
                onDelete = CASCADE),
        @ForeignKey(entity = Category.class,
                parentColumns = "id_category",
                childColumns = "id_category",
                onDelete = CASCADE),
        })
public class GameHasCategory {
    @ColumnInfo(name = "id_game")
    private long idGame;
    @ColumnInfo(name = "id_category")
    private long idCategory;

    public GameHasCategory(long idGame, long idCategory) {
        this.idGame = idGame;
        this.idCategory = idCategory;
    }

    public long getIdGame() {
        return idGame;
    }

    public void setIdGame(long idGame) {
        this.idGame = idGame;
    }

    public long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(long idCategory) {
        this.idCategory = idCategory;
    }
}
