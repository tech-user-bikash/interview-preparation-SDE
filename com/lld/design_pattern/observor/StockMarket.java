package com.lld.design_pattern.observor;

public interface StockMarket {
    void registerObserver(StockObserver observer);

    void removeObserver(StockObserver observer);

    void notifyObservers(String companyName, double price);
}
