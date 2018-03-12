package com.hashcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Vehicle {
    private int x;
    private int y;
    private int timeLoc;
    private int numberRides;
    private String resultString;

    public void checkRidesForTaking(int maxTime){
        Object[] rideList = RideHandler.getRideList().toArray();
        List<Ride> finalRides = new ArrayList<Ride>();
        for(int i = 0; i < rideList.length; i++){
            Ride ride = (Ride) rideList[i];
            int distanceToCar = calculateDistanceToCar(ride);
            ride.setDistanceToCar(distanceToCar);

            int tempTimeLoc = calculateTimeAfterRide(ride, this.timeLoc);

            if(ride.getFinishTime() >= tempTimeLoc){

                ride.setVariableForBonus(ride.getStartTime() - (this.timeLoc + ride.getDistanceToCar()));

                finalRides.add(ride);
            }
        }

        if(finalRides.size() > 0){
            //finalRides.sort(Comparator.comparing(Ride::getStartTime));

            finalRides.sort(Comparator.comparing(Ride::getVariableForBonus));

            Ride ride = finalRides.get(0);
            resultString = resultString + ride.getId() + " ";
            this.numberRides++;
            RideHandler.removeRide(ride.getId());
            this.timeLoc = calculateTimeAfterRide(ride, this.timeLoc);
            this.x = ride.getFinishX();
            this.y = ride.getFinishY();
            finalRides.clear();
        }else{
            this.timeLoc = maxTime;
        }
    }

    private int calculateTimeAfterRide(Ride ride, int initTime){
        initTime = initTime + ride.getDistanceToCar();
        if(ride.getStartTime() > initTime){
            initTime = ride.getStartTime();
        }
        initTime = initTime + ride.getDistance();
        return initTime;
    }

    private int calculateDistanceToCar(Ride ride){
        return (Math.abs(x - ride.getStartX()) + Math.abs(y - ride.getStartY()));
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getTimeLoc() {
        return timeLoc;
    }

    public void setTimeLoc(int timeLoc) {
        this.timeLoc = timeLoc;
    }

    public int getNumberRides() {
        return numberRides;
    }

    public void setNumberRides(int numberRides) {
        this.numberRides = numberRides;
    }

    public String getResultString() {
        return resultString;
    }

    public void setResultString(String resultString) {
        this.resultString = resultString;
    }
}
