package com.lld.design_pattern.observor;

public class Investor implements StockObserver {
    private String name;

    public Investor(String name){
        this.name = name;
    }

    @Override
    public void update(String companyName, double price) {
        System.out.println("Investor "+name+" received an update for "+ companyName+ ": $" + price);
    }
}
