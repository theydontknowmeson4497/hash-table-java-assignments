package com.hashtable.assignments.assignment1;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        UsernameService service = new UsernameService();

        System.out.println("Check username availability");

        boolean available = service.checkAvailability("john_doe");
        System.out.println("john_doe available? " + available);

        available = service.checkAvailability("jane_smith");
        System.out.println("jane_smith available? " + available);

        if (!available) {
            List<String> suggestions =
                    UsernameSuggestion.suggestAlternatives("john_doe");

            System.out.println("Suggestions:");
            for (String s : suggestions) {
                System.out.println(s);
            }
        }

        System.out.println("Most attempted username:");
        System.out.println(service.getMostAttemptedUsername());
    }
}