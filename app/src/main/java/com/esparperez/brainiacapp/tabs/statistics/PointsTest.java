package com.esparperez.brainiacapp.tabs.statistics;

import java.util.Date;

public class PointsTest {

    private int points;
    private Date date;

    public PointsTest(){}

    public PointsTest(int points, Date date) {
        this.points = points;
        this.date = date;
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
