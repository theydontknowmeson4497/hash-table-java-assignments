package com.hashtable.assignments.assignment9;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Transaction> transactions = new ArrayList<>();

        transactions.add(new Transaction(1, 500, "StoreA", "acc1"));
        transactions.add(new Transaction(2, 300, "StoreB", "acc2"));
        transactions.add(new Transaction(3, 200, "StoreC", "acc3"));
        transactions.add(new Transaction(4, 500, "StoreA", "acc4"));

        TransactionAnalyzer analyzer = new TransactionAnalyzer();

        System.out.println("Two-Sum Results:");

        analyzer.findTwoSum(transactions, 500);

        System.out.println("\nDuplicate Detection:");

        analyzer.detectDuplicates(transactions);
    }
}