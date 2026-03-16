package com.hashtable.assignments.assignment6;

public class Main {

    public static void main(String[] args) {

        RateLimiter limiter = new RateLimiter();

        String clientId = "client123";

        for (int i = 1; i <= 12; i++) {

            System.out.print("Request " + i + ": ");

            limiter.checkRateLimit(clientId);
        }
    }
}