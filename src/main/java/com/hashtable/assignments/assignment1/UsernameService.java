package com.hashtable.assignments.assignment1;

import java.util.HashMap;
import java.util.Map;

public class UsernameService {

    private Map<String, Integer> usernameToUserId = new HashMap<>();
    private Map<String, Integer> attemptFrequency = new HashMap<>();

    public UsernameService() {
        // Preload some usernames
        usernameToUserId.put("john_doe", 1);
        usernameToUserId.put("admin", 2);
        usernameToUserId.put("guest", 3);
    }

    public boolean checkAvailability(String username) {

        attemptFrequency.put(username,
                attemptFrequency.getOrDefault(username, 0) + 1);

        return !usernameToUserId.containsKey(username);
    }

    public void registerUser(String username, int userId) {
        usernameToUserId.put(username, userId);
    }

    public String getMostAttemptedUsername() {

        String mostAttempted = null;
        int max = 0;

        for (Map.Entry<String, Integer> entry : attemptFrequency.entrySet()) {
            if (entry.getValue() > max) {
                mostAttempted = entry.getKey();
                max = entry.getValue();
            }
        }

        return mostAttempted + " (" + max + " attempts)";
    }
}