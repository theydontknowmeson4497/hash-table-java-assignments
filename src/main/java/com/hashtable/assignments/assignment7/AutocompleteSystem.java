package com.hashtable.assignments.assignment7;

import java.util.*;

public class AutocompleteSystem {

    private Map<String, Integer> queryFrequency = new HashMap<>();

    public void addQuery(String query) {

        queryFrequency.put(
                query,
                queryFrequency.getOrDefault(query, 0) + 1
        );
    }

    public List<String> search(String prefix) {

        List<Map.Entry<String, Integer>> matches = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : queryFrequency.entrySet()) {

            if (entry.getKey().startsWith(prefix)) {
                matches.add(entry);
            }
        }

        matches.sort((a, b) -> b.getValue() - a.getValue());

        List<String> results = new ArrayList<>();

        int limit = Math.min(10, matches.size());

        for (int i = 0; i < limit; i++) {

            results.add(
                    matches.get(i).getKey() +
                            " (" + matches.get(i).getValue() + " searches)"
            );
        }

        return results;
    }
}