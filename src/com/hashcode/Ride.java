package com.hashcode;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

public class Ride {
    private int id;
    private int startX;
    private int startY;
    private int finishX;
    private int finishY;
    private int startTime;
    private int finishTime;
    private int duration;
    private int distance;
    private int distanceToCar;
    private int variableForBonus;

    public int getVariableForBonus() {
        return variableForBonus;
    }

    public void setVariableForBonus(int variableForBonus) {
        this.variableForBonus = variableForBonus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public int getFinishX() {
        return finishX;
    }

    public void setFinishX(int finishX) {
        this.finishX = finishX;
    }

    public int getFinishY() {
        return finishY;
    }

    public void setFinishY(int finishY) {
        this.finishY = finishY;
        this.distance = Math.abs(this.startX - this.finishX) + Math.abs(this.startY - this.finishY);
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(int finishTime) {
        this.finishTime = finishTime;
        this.duration = this.finishTime - this.startTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getDistanceToCar() {
        return distanceToCar;
    }

    public void setDistanceToCar(int distanceToCar) {
        this.distanceToCar = distanceToCar;
    }
}
