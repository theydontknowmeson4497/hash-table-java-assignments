package com.hashtable.assignments.assignment3;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class DNSCache {

    private Map<String, DNSEntry> cache = new HashMap<>();

    private int cacheHits = 0;
    private int cacheMiss = 0;

    public String resolve(String domain) {

        DNSEntry entry = cache.get(domain);

        if (entry != null && !entry.isExpired()) {

            cacheHits++;
            return "Cache HIT → " + entry.ipAddress;
        }

        cacheMiss++;

        String newIp = queryUpstreamDNS(domain);

        cache.put(domain, new DNSEntry(domain, newIp, 10));

        return "Cache MISS → Upstream resolved: " + newIp;
    }

    private String queryUpstreamDNS(String domain) {

        Random random = new Random();

        return "172.217." + random.nextInt(255) + "." + random.nextInt(255);
    }

    public void getCacheStats() {

        int total = cacheHits + cacheMiss;

        double hitRate = total == 0 ? 0 : (cacheHits * 100.0) / total;

        System.out.println("Cache Hits: " + cacheHits);
        System.out.println("Cache Misses: " + cacheMiss);
        System.out.println("Hit Rate: " + hitRate + "%");
    }
}