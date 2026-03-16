package com.hashtable.assignments.assignment6;

public class TokenBucket {

    private int tokens;
    private int maxTokens;
    private long lastRefillTime;

    public TokenBucket(int maxTokens) {
        this.maxTokens = maxTokens;
        this.tokens = maxTokens;
        this.lastRefillTime = System.currentTimeMillis();
    }

    public synchronized boolean allowRequest() {

        refillTokens();

        if (tokens > 0) {
            tokens--;
            return true;
        }

        return false;
    }

    private void refillTokens() {

        long currentTime = System.currentTimeMillis();

        long elapsedSeconds = (currentTime - lastRefillTime) / 1000;

        if (elapsedSeconds >= 3600) {

            tokens = maxTokens;

            lastRefillTime = currentTime;
        }
    }

    public int getRemainingTokens() {
        return tokens;
    }
}