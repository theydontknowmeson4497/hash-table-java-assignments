package com.hashtable.assignments.assignment2;

public class PurchaseRequest extends Thread {

    private InventoryManager manager;
    private String productId;
    private int userId;

    public PurchaseRequest(InventoryManager manager, String productId, int userId) {
        this.manager = manager;
        this.productId = productId;
        this.userId = userId;
    }

    @Override
    public void run() {

        String result = manager.purchaseItem(productId, userId);

        System.out.println(result);
    }
}