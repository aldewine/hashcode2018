package com.hashcode;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        int fleetSize = 0;
        int maxTime = 0;
        int bonus = 0;
        int rideCount = 0;

        System.out.println("Working Directory = " +
                System.getProperty("user.dir"));

        int i = 0;
        List<Ride> rides = new ArrayList<Ride>();
        for (String line : Files.readAllLines(Paths.get("input.in"))) {
            String[] input = line.split(" ");
            if(i == 0){
                fleetSize = Integer.valueOf(input[2]);
                rideCount = Integer.valueOf(input[3]);
                bonus = Integer.valueOf(input[4]);
                maxTime = Integer.valueOf(input[5]);
            }else{
                Ride ride = new Ride();
                ride.setStartX(Integer.valueOf(input[0]));
                ride.setStartY(Integer.valueOf(input[1]));
                ride.setFinishX(Integer.valueOf(input[2]));
                ride.setFinishY(Integer.valueOf(input[3]));
                ride.setStartTime(Integer.valueOf(input[4]));
                ride.setFinishTime(Integer.valueOf(input[5]));
                ride.setId(i-1);
                rides.add(ride);
            }
            i++;
        }
        RideHandler.setRideList(rides);

        List<Vehicle> vehicles = new ArrayList<Vehicle>();
        for(int j = 0; j < fleetSize; j++) {
            Vehicle vehicle = new Vehicle();
            vehicle.setX(0);
            vehicle.setY(0);
            vehicle.setTimeLoc(0);
            vehicle.setNumberRides(0);
            vehicle.setResultString("");
            vehicles.add(vehicle);
        }

        List<Vehicle> finishedVehicles = new ArrayList<Vehicle>();
        while(vehicles.size() > 0){
            for(int j = 0; j < vehicles.size(); j++){
                vehicles.get(j).checkRidesForTaking(maxTime);
                if(vehicles.get(j).getTimeLoc() == maxTime){
                    finishedVehicles.add(vehicles.get(j));
                    vehicles.remove(j);
                }
            }
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter("Output.out"));

        for(Vehicle vehicle : finishedVehicles){
            writer.write(String.valueOf(vehicle.getNumberRides()) + " " + vehicle.getResultString() + "\n");
        }
        writer.close();

    }
}
