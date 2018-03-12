package com.hashcode;

import java.util.Iterator;
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
        for(Iterator<Ride> iterator = rideList.iterator(); iterator.hasNext();){
            Ride ride = (Ride) iterator.next();
            if(ride.getId() == id) {
                iterator.remove();
            }
        }
    }
}
