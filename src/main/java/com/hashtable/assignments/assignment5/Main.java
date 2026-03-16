package com.hashtable.assignments.assignment5;

public class Main {

    public static void main(String[] args) {

        AnalyticsDashboard dashboard = new AnalyticsDashboard();

        dashboard.processEvent(new PageEvent("/article/news", "user1", "google"));
        dashboard.processEvent(new PageEvent("/article/news", "user2", "facebook"));
        dashboard.processEvent(new PageEvent("/sports/cricket", "user3", "google"));
        dashboard.processEvent(new PageEvent("/article/news", "user1", "direct"));
        dashboard.processEvent(new PageEvent("/sports/cricket", "user4", "google"));
        dashboard.processEvent(new PageEvent("/tech/ai", "user5", "direct"));

        dashboard.showDashboard();
    }
}