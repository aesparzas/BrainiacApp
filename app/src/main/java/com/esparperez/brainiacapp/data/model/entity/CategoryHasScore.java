package com.esparperez.brainiacapp.data.model.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "categoryHasScore",
        indices = @Index("id_score"),
        primaryKeys = {"id_category", "id_score"},
        foreignKeys = {
                @ForeignKey(entity = Category.class,
                        parentColumns = "id_category",
                        childColumns = "id_category",
                        onDelete = CASCADE),
                @ForeignKey(entity = Score.class,
                        parentColumns = "id_score",
                        childColumns = "id_score",
                        onDelete = CASCADE)
        })
public class CategoryHasScore {
    @ColumnInfo(name = "id_category")
    private long idCategory;
    @ColumnInfo(name = "id_score")
    private long idScore;

    public CategoryHasScore(long idCategory, long idScore) {
        this.idCategory = idCategory;
        this.idScore = idScore;
    }

    public long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(long idCategory) {
        this.idCategory = idCategory;
    }

    public long getIdScore() {
        return idScore;
    }

    public void setIdScore(long idScore) {
        this.idScore = idScore;
    }
}
