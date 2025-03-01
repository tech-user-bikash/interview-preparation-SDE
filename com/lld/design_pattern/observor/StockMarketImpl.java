package com.lld.design_pattern.observor;

import java.util.ArrayList;
import java.util.List;

public class StockMarketImpl implements StockMarket {
    private final List<StockObserver> stockObservorList = new ArrayList<>();

    @Override
    public void registerObserver(StockObserver observer) {
        stockObservorList.add(observer);
    }

    @Override
    public void removeObserver(StockObserver observer) {
        stockObservorList.remove(observer);
    }

    @Override
    public void notifyObservers(String companyName, double price) {
        stockObservorList.forEach(obs -> obs.update(companyName, price));
    }

    // Simulate stock price changes
    public void setStockPrice(String stockSymbol, double stockPrice) {
        notifyObservers(stockSymbol, stockPrice);
    }
}
