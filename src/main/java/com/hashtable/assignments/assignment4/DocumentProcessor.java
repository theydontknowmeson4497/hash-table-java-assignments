package com.hashtable.assignments.assignment4;

import java.util.ArrayList;
import java.util.List;

public class DocumentProcessor {

    public static List<String> generateNGrams(String text, int n) {

        String[] words = text.split("\\s+");

        List<String> ngrams = new ArrayList<>();

        for (int i = 0; i <= words.length - n; i++) {

            StringBuilder gram = new StringBuilder();

            for (int j = 0; j < n; j++) {
                gram.append(words[i + j]).append(" ");
            }

            ngrams.add(gram.toString().trim());
        }

        return ngrams;
    }
}