package com.hashtable.assignments.assignment1;

import java.util.ArrayList;
import java.util.List;

public class UsernameSuggestion {

    public static List<String> suggestAlternatives(String username) {

        List<String> suggestions = new ArrayList<>();

        suggestions.add(username + "1");
        suggestions.add(username + "2");
        suggestions.add(username.replace("_", "."));
        suggestions.add(username + "_official");

        return suggestions;
    }
}