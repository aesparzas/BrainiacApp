package com.esparperez.brainiacapp.model.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "userPlaysGame",
        indices = @Index("id_game"),
        primaryKeys = {"id_user", "id_game"},
        foreignKeys = {
        @ForeignKey(entity = User.class,
                parentColumns = "id_user",
                childColumns = "id_user",
                onDelete = CASCADE),
        @ForeignKey(entity = Game.class,
                parentColumns = "id_game",
                childColumns = "id_game",
                onDelete = CASCADE)
        })
public class UserPlaysGame {
    @ColumnInfo(name = "id_user")
    private long idUser;
    @ColumnInfo(name = "id_game")
    private long idGame;

    public UserPlaysGame(long idUser, long idGame) {
        this.idUser = idUser;
        this.idGame = idGame;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public long getIdGame() {
        return idGame;
    }

    public void setIdGame(long idGame) {
        this.idGame = idGame;
    }
}
