package com.esparperez.brainiacapp.model.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;

import com.esparperez.brainiacapp.model.DateConverter;

import java.util.Date;

@Entity(tableName = "user")
public class User {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_user")
    private long idUser;
    private String name;
    @TypeConverters(DateConverter.class)
    @ColumnInfo(name = "registration_date")
    private Date registrationDate;
    @ColumnInfo(name = "profile_image_resource")
    private int profileImageResource;

    @ColumnInfo(name = "answered_correctly")
    private int answeredCorrectly;
    @ColumnInfo(name = "questions_showed")
    private int questionsShowed;
    @ColumnInfo(name = "facts_read")
    private int factsRead;
    @ColumnInfo(name = "matches_played")
    private int matchesPlayed;

    @Ignore
    public User() {
    }

    public User(long idUser, String name, Date registrationDate, int profileImageResource,
                int answeredCorrectly, int questionsShowed, int factsRead, int matchesPlayed) {
        this.idUser = idUser;
        this.name = name;
        this.registrationDate = registrationDate;
        this.profileImageResource = profileImageResource;
        this.answeredCorrectly = answeredCorrectly;
        this.questionsShowed = questionsShowed;
        this.factsRead = factsRead;
        this.matchesPlayed = matchesPlayed;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public int getProfileImageResource() {
        return profileImageResource;
    }

    public void setProfileImageResource(int profileImageResource) {
        this.profileImageResource = profileImageResource;
    }

    public int getAnsweredCorrectly() {
        return answeredCorrectly;
    }

    public void setAnsweredCorrectly(int answeredCorrectly) {
        this.answeredCorrectly = answeredCorrectly;
    }

    public int getQuestionsShowed() {
        return questionsShowed;
    }

    public void setQuestionsShowed(int questionsShowed) {
        this.questionsShowed = questionsShowed;
    }

    public int getFactsRead() {
        return factsRead;
    }

    public void setFactsRead(int factsRead) {
        this.factsRead = factsRead;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }
}
