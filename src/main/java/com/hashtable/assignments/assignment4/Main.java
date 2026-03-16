package com.hashtable.assignments.assignment4;

public class Main {

    public static void main(String[] args) {

        PlagiarismDetector detector = new PlagiarismDetector();

        String doc1 =
                "machine learning improves search engine ranking and recommendation systems";

        String doc2 =
                "machine learning improves search engine ranking and recommendation quality";

        String doc3 =
                "football teams compete in world cup tournaments every four years";

        detector.indexDocument("doc1", doc1);
        detector.indexDocument("doc3", doc3);

        System.out.println("Analyzing doc2:");

        detector.analyzeDocument("doc2", doc2);
    }
}