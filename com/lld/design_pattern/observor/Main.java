package com.lld.design_pattern.observor;

public class Main {
    public static void main(String[] args) {
        StockMarketImpl stockMarket = new StockMarketImpl();

        Investor investor1 = new Investor("Alice");
        Investor investor2 = new Investor("Bob");

        stockMarket.registerObserver(investor1);
        stockMarket.registerObserver(investor2);

        stockMarket.setStockPrice("INFY", 1245.65);
        stockMarket.setStockPrice("WIPRO", 343.23);

        stockMarket.removeObserver(investor1);

        stockMarket.setStockPrice("M&M", 12548.21);
    }
}
