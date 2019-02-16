package com.esparperez.brainiacapp.model;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.esparperez.brainiacapp.model.dao.CategoryDao;
import com.esparperez.brainiacapp.model.dao.ScoreDao;
import com.esparperez.brainiacapp.model.dao.ScoreHasCategoryDao;
import com.esparperez.brainiacapp.model.dao.UserDao;
import com.esparperez.brainiacapp.model.entity.Category;
import com.esparperez.brainiacapp.model.entity.Score;
import com.esparperez.brainiacapp.model.entity.ScoreHasCategory;
import com.esparperez.brainiacapp.model.entity.User;
import com.esparperez.brainiacapp.model.entity.UserMarksScore;

@Database(entities = {User.class, Category.class, Score.class, UserMarksScore.class,
        ScoreHasCategory.class}, version = 1, exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {
    private static final String DB_NAME = "Brainiac.db";
    private static AppDataBase instance;

    public abstract UserDao userModel();
    public abstract CategoryDao categoryModel();
    public abstract ScoreDao scoreModel();
    public abstract UserMarksScore userMarksScoreModel();
    public abstract ScoreHasCategoryDao scoreHasCategoryModel();

    public static AppDataBase getDatabase(Context context) {
        if (instance == null) {
            instance =
                    Room.databaseBuilder(context.getApplicationContext(), AppDataBase.class, DB_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}
