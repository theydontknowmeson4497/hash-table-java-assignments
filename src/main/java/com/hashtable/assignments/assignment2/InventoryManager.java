package com.hashtable.assignments.assignment2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class InventoryManager {

    private Map<String, Integer> inventory = new HashMap<>();
    private Map<String, Queue<Integer>> waitingList = new HashMap<>();

    public InventoryManager() {
        inventory.put("IPHONE15_256GB", 100);
        waitingList.put("IPHONE15_256GB", new LinkedList<>());
    }

    public synchronized String checkStock(String productId) {

        int stock = inventory.getOrDefault(productId, 0);

        return productId + " → " + stock + " units available";
    }

    public synchronized String purchaseItem(String productId, int userId) {

        int stock = inventory.getOrDefault(productId, 0);

        if (stock > 0) {

            inventory.put(productId, stock - 1);

            return "User " + userId + " purchased successfully. Remaining stock: "
                    + (stock - 1);
        }

        waitingList.get(productId).add(userId);

        int position = waitingList.get(productId).size();

        return "Stock finished. User " + userId +
                " added to waiting list. Position #" + position;
    }
}