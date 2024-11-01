package com.dsa.graph;

import java.util.*;

// https://www.geeksforgeeks.org/problems/cheapest-flights-within-k-stops/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=cheapest-flights-within-k-stops
// https://www.youtube.com/watch?v=9XybHVqTHcQ&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=38
public class CheapestFlightWithKStops {
    static class Pair {
        int node, price, stops;

        Pair(int _n, int _c, int _s) {
            this.node = _n;
            this.price = _c;
            this.stops = _s;
        }
    }

    public static void main(String[] args) {
        int n = 4, src = 0, dst = 3, k = 1;
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
        var ans = cheapestFLight(n, flights, src, dst, k);
        System.out.println(ans);
    }
    // TC: E = flights.length
    public static int cheapestFLight(int n, int[][] flights, int src, int dst, int k) {

        int r = flights.length;
        int c = flights[0].length;

        // create adj list
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];
            adj.get(from).add(new Pair(to, price, 0));
        }

        int[] priceArr = new int[n];
        Arrays.fill(priceArr, (int) 1e9);
        priceArr[src] = 0;

        Queue<Pair> Q = new LinkedList<>();
        Q.add(new Pair(src, 0, 0));

        while (!Q.isEmpty()) {
            Pair p = Q.poll();
            if (p.stops > k) {
                continue;
            }
            // visit neighbours
            for (Pair pair : adj.get(p.node)) {
                if (p.price + pair.price < priceArr[pair.node] && p.stops <= k) {
                    priceArr[pair.node] = p.price + pair.price;
                    Q.add(new Pair(pair.node, priceArr[pair.node], p.stops + 1));
                }
            }
        }
        return priceArr[dst] == (int) 1e9 ? -1 : priceArr[dst];
    }
}
