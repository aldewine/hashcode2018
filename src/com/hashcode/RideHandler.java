package com.hashcode;

import java.util.List;

public class RideHandler {
    private static List<Ride> rideList;

    private RideHandler(){

    }

    public static List<Ride> getRideList() {
        return rideList;
    }

    public static void setRideList(List<Ride> rideList) {
        RideHandler.rideList = rideList;
    }

    public static void removeRide(int id){
        for(int i = 0; i < rideList.size();i++){
            if(rideList.get(i).getId() == id) {
                rideList.remove(i);
            }
        }
    }
}
