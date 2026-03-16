package com.hashtable.assignments.assignment6;

import java.util.HashMap;
import java.util.Map;

public class RateLimiter {

    private Map<String, TokenBucket> clientBuckets = new HashMap<>();

    private int maxRequests = 10;

    public boolean checkRateLimit(String clientId) {

        clientBuckets.putIfAbsent(clientId, new TokenBucket(maxRequests));

        TokenBucket bucket = clientBuckets.get(clientId);

        boolean allowed = bucket.allowRequest();

        if (allowed) {
            System.out.println(
                    "Allowed → Remaining requests: "
                            + bucket.getRemainingTokens()
            );
        } else {
            System.out.println("Denied → Rate limit exceeded");
        }

        return allowed;
    }
}