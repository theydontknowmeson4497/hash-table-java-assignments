package com.hashtable.assignments.assignment10;

import java.util.LinkedHashMap;
import java.util.Map;

public class MultiLevelCache {

    private LinkedHashMap<String, Video> L1;
    private LinkedHashMap<String, Video> L2;

    public MultiLevelCache(int l1Size, int l2Size) {

        L1 = new LinkedHashMap<>(l1Size, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry<String, Video> eldest) {
                return size() > l1Size;
            }
        };

        L2 = new LinkedHashMap<>(l2Size, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry<String, Video> eldest) {
                return size() > l2Size;
            }
        };
    }

    public Video getVideo(String videoId) {

        if (L1.containsKey(videoId)) {

            System.out.println("L1 Cache HIT");

            return L1.get(videoId);
        }

        if (L2.containsKey(videoId)) {

            System.out.println("L2 Cache HIT → Promoting to L1");

            Video video = L2.get(videoId);

            L1.put(videoId, video);

            return video;
        }

        System.out.println("Cache MISS → Fetching from database");

        Video video = fetchFromDatabase(videoId);

        L2.put(videoId, video);

        return video;
    }

    private Video fetchFromDatabase(String videoId) {

        return new Video(videoId, "Video Title for " + videoId);
    }
}