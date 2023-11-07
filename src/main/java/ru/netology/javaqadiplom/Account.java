package ru.netology.javaqadiplom;

public class Account {
    protected int balance;
    protected int rate;

    public boolean pay(int amount) {
        return false;
    }

    public boolean add(int amount) {
        return false;
    }

    public int yearChange() {
        return 0;
    }

    public int getBalance() {
        return balance;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    protected int getMinBalance() {
        return 0;
    }

    protected int getMaxBalance() {
        return 0;
    }


}
