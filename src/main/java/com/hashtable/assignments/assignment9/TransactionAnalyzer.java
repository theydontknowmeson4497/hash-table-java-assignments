package com.hashtable.assignments.assignment9;

import java.util.*;

public class TransactionAnalyzer {

    public void findTwoSum(List<Transaction> transactions, int target) {

        Map<Integer, Transaction> map = new HashMap<>();

        for (Transaction t : transactions) {

            int complement = target - t.amount;

            if (map.containsKey(complement)) {

                Transaction match = map.get(complement);

                System.out.println(
                        "Two-Sum Match → " +
                                match.id + " + " + t.id +
                                " = " + target
                );
            }

            map.put(t.amount, t);
        }
    }

    public void detectDuplicates(List<Transaction> transactions) {

        Map<String, List<Transaction>> map = new HashMap<>();

        for (Transaction t : transactions) {

            String key = t.amount + "-" + t.merchant;

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(t);
        }

        for (String key : map.keySet()) {

            List<Transaction> list = map.get(key);

            if (list.size() > 1) {

                System.out.println("Duplicate transaction group:");

                for (Transaction t : list) {

                    System.out.println(
                            "ID: " + t.id +
                                    " Amount: " + t.amount +
                                    " Merchant: " + t.merchant +
                                    " Account: " + t.account
                    );
                }
            }
        }
    }
}