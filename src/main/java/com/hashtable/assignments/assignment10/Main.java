package com.hashtable.assignments.assignment10;

public class Main {

    public static void main(String[] args) {

        MultiLevelCache cache = new MultiLevelCache(3, 5);

        cache.getVideo("video1");
        cache.getVideo("video2");
        cache.getVideo("video3");

        cache.getVideo("video1");

        cache.getVideo("video4");
        cache.getVideo("video5");

        cache.getVideo("video2");
    }
}