package com.hashtable.assignments.assignment8;

public class ParkingLot {

    private ParkingSpot[] table;
    private int capacity;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.table = new ParkingSpot[capacity];
    }

    private int hash(String licensePlate) {

        int hash = 0;

        for (char c : licensePlate.toCharArray()) {
            hash += c;
        }

        return hash % capacity;
    }

    public void parkVehicle(String licensePlate) {

        int index = hash(licensePlate);

        int probes = 0;

        while (table[index] != null) {

            index = (index + 1) % capacity;

            probes++;
        }

        table[index] = new ParkingSpot(licensePlate);

        System.out.println(
                licensePlate +
                        " parked at spot #" + index +
                        " (" + probes + " probes)"
        );
    }

    public void exitVehicle(String licensePlate) {

        int index = hash(licensePlate);

        while (table[index] != null) {

            if (table[index].licensePlate.equals(licensePlate)) {

                long duration =
                        (System.currentTimeMillis() - table[index].entryTime) / 1000;

                table[index] = null;

                System.out.println(
                        licensePlate +
                                " exited. Parking time: " + duration + " seconds"
                );

                return;
            }

            index = (index + 1) % capacity;
        }

        System.out.println("Vehicle not found");
    }
}