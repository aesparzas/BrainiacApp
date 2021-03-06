package com.esparperez.brainiacapp.model;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import com.esparperez.brainiacapp.model.dao.CategoryDao;
import com.esparperez.brainiacapp.model.dao.CategoryHasScoreDao;
import com.esparperez.brainiacapp.model.dao.GameDao;
import com.esparperez.brainiacapp.model.dao.GameHasCategoryDao;
import com.esparperez.brainiacapp.model.dao.ScoreDao;
import com.esparperez.brainiacapp.model.dao.UserDao;
import com.esparperez.brainiacapp.model.dao.UserPlaysGameDao;
import com.esparperez.brainiacapp.model.entity.Category;
import com.esparperez.brainiacapp.model.entity.CategoryHasScore;
import com.esparperez.brainiacapp.model.entity.Game;
import com.esparperez.brainiacapp.model.entity.GameHasCategory;
import com.esparperez.brainiacapp.model.entity.Score;
import com.esparperez.brainiacapp.model.entity.User;
import com.esparperez.brainiacapp.model.entity.UserPlaysGame;

@Database(entities = {Category.class, Game.class, Score.class, User.class, CategoryHasScore.class,
        GameHasCategory.class, UserPlaysGame.class}, version = 1, exportSchema = false)
@TypeConverters(DateConverter.class)
public abstract class AppDataBase extends RoomDatabase {
    private static final String DB_NAME = "Brainiac.db";
    private static AppDataBase instance;

    public abstract CategoryDao categoryDao();
    public abstract CategoryHasScoreDao categoryHasScoreDao();
    public abstract GameDao gameDao();
    public abstract GameHasCategoryDao gameHasCategoryDao();
    public abstract ScoreDao scoreDao();
    public abstract UserDao userDao();
    public abstract UserPlaysGameDao userPlaysGameDao();

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