package com.esparperez.brainiacapp.model.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "scoreHasCategory",
        primaryKeys = {"idScore", "idCategory"},
        foreignKeys = {
            @ForeignKey(entity = Score.class,
                    parentColumns = "idScore",
                    childColumns = "idScore",
                    onDelete = CASCADE),
            @ForeignKey(entity = Category.class,
                    parentColumns = "idCategory",
                    childColumns = "idCategory",
                    onDelete = CASCADE),
        })
public class ScoreHasCategory {
    @ColumnInfo(name = "id_score")
    private long idScore;
    @ColumnInfo(name = "id_category")
    private long idCategory;

    public ScoreHasCategory(long idScore, long idCategory) {
        this.idScore = idScore;
        this.idCategory = idCategory;
    }
}
