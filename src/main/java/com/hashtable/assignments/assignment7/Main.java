package com.hashtable.assignments.assignment7;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        AutocompleteSystem system = new AutocompleteSystem();

        system.addQuery("java tutorial");
        system.addQuery("javascript tutorial");
        system.addQuery("java download");
        system.addQuery("java tutorial");
        system.addQuery("java streams");
        system.addQuery("javascript tutorial");
        system.addQuery("java tutorial");

        List<String> results = system.search("jav");

        System.out.println("Search suggestions:");

        for (String suggestion : results) {
            System.out.println(suggestion);
        }
    }
}