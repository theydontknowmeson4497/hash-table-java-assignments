package com.hashtable.assignments.assignment5;

import java.util.*;

public class AnalyticsDashboard {

    private Map<String, Integer> pageViews = new HashMap<>();
    private Map<String, Set<String>> uniqueVisitors = new HashMap<>();
    private Map<String, Integer> trafficSources = new HashMap<>();

    public void processEvent(PageEvent event) {

        // Count page views
        pageViews.put(
                event.url,
                pageViews.getOrDefault(event.url, 0) + 1
        );

        // Track unique visitors
        uniqueVisitors
                .computeIfAbsent(event.url, k -> new HashSet<>())
                .add(event.userId);

        // Count traffic source
        trafficSources.put(
                event.source,
                trafficSources.getOrDefault(event.source, 0) + 1
        );
    }

    public void showDashboard() {

        System.out.println("Top Pages:");

        pageViews.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .limit(10)
                .forEach(entry -> {

                    String url = entry.getKey();
                    int views = entry.getValue();
                    int unique = uniqueVisitors.get(url).size();

                    System.out.println(
                            url + " - " + views +
                                    " views (" + unique + " unique)"
                    );
                });

        System.out.println("\nTraffic Sources:");

        int total = trafficSources.values().stream().mapToInt(i -> i).sum();

        for (String source : trafficSources.keySet()) {

            int count = trafficSources.get(source);

            double percent = (count * 100.0) / total;

            System.out.println(source + ": " + percent + "%");
        }
    }
}