package com.hashtable.assignments.assignment4;

import java.util.*;

public class PlagiarismDetector {

    private Map<String, Set<String>> ngramIndex = new HashMap<>();

    public void indexDocument(String docId, String text) {

        List<String> ngrams = DocumentProcessor.generateNGrams(text, 5);

        for (String gram : ngrams) {

            ngramIndex
                    .computeIfAbsent(gram, k -> new HashSet<>())
                    .add(docId);
        }
    }

    public void analyzeDocument(String docId, String text) {

        List<String> ngrams = DocumentProcessor.generateNGrams(text, 5);

        Map<String, Integer> matchCount = new HashMap<>();

        for (String gram : ngrams) {

            if (ngramIndex.containsKey(gram)) {

                for (String otherDoc : ngramIndex.get(gram)) {

                    if (!otherDoc.equals(docId)) {

                        matchCount.put(
                                otherDoc,
                                matchCount.getOrDefault(otherDoc, 0) + 1
                        );
                    }
                }
            }
        }

        for (String doc : matchCount.keySet()) {

            int matches = matchCount.get(doc);

            double similarity =
                    (matches * 100.0) / ngrams.size();

            System.out.println(
                    "Match with " + doc +
                            " → " + matches +
                            " n-grams (" +
                            similarity + "% similarity)"
            );
        }
    }
}