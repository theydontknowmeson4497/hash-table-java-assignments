package com.hashtable.assignments.assignment2;

public class Main {

    public static void main(String[] args) {

        InventoryManager manager = new InventoryManager();

        System.out.println(manager.checkStock("IPHONE15_256GB"));

        for (int i = 1; i <= 120; i++) {

            PurchaseRequest request =
                    new PurchaseRequest(manager, "IPHONE15_256GB", i);

            request.start();
        }
    }
}