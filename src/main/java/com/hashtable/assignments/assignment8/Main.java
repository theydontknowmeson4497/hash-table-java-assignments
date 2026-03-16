package com.hashtable.assignments.assignment8;

public class Main {

    public static void main(String[] args) {

        ParkingLot lot = new ParkingLot(10);

        lot.parkVehicle("ABC123");
        lot.parkVehicle("XYZ999");
        lot.parkVehicle("CAR777");

        lot.exitVehicle("ABC123");
    }
}