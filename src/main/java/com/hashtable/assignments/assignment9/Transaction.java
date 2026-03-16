package com.hashtable.assignments.assignment9;

public class Transaction {

    int id;
    int amount;
    String merchant;
    String account;

    public Transaction(int id, int amount, String merchant, String account) {
        this.id = id;
        this.amount = amount;
        this.merchant = merchant;
        this.account = account;
    }
}
