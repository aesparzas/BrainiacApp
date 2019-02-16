package com.esparperez.brainiacapp.model.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "user")
public class User {

    @PrimaryKey(autoGenerate = true)
    private long idUser;
    private String name;
    private Date registerDate;
    private int profileImageResource;

    private int answeredCorrectly;
    private int questionsShowed;
    private int factsRead;
    private int matchesPlayed;

    public User() {
    }

    public User(long idUser, String name, Date registerDate, int profileImageResource, int answeredCorrectly, int questionsShowed, int factsRead, int matchesPlayed) {
        this.idUser = idUser;
        this.name = name;
        this.registerDate = registerDate;
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

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
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
