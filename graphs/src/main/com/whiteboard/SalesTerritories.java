package com.whiteboard;

import java.util.*;

/**
 * Given a list of city pairs, where each pair denotes that
 * the two cities belong to the same sales territories, find
 * all the territories, i.e. find all the cities composing
 * each territory.
 */
public final class SalesTerritories {
    private SalesTerritories() {
    }

    static class CityPair {
        String city1;
        String city2;

        CityPair(String city1, String city2) {
            this.city1 = city1;
            this.city2 = city2;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof CityPair other)) {
                return false;
            }
            return (this.city1 == other.city2 && this.city2 == other.city2) ||
                    (this.city1 == other.city2 && this.city2 == other.city1);
        }

        @Override
        public int hashCode() {
            return city1.hashCode() + city2.hashCode();
        }
    }

    static class CityNode {
        String cityName;
        Set<CityNode> neighboringCities = new HashSet<>();

        CityNode(String cityName) {
            this.cityName = cityName;
        }
    }

    private static Set<CityPair> cityPairs;
    private static Map<String, CityNode> cityMap = new HashMap<>();
    private static Set<CityNode> visited = new HashSet<>();

    /**
     * Given a list of city pairs, where each pair denotes that
     * the two cities belong to the same sales territories, find
     * all the territories, i.e. find all the cities composing
     * each territory.
     *
     * This is a straightforward graph problem, where each graph
     * node represents a city, and each edge between two city
     * nodes means that those cities are in the same territory.
     *
     * Finding the sales territories amounts to finding all the
     * connected subgraphs of cities. We do this with a simple
     * Breadth-First Search (BFS).
     *
     * Running time is O(n).
     *
     * @return The given cities, grouped into sets representing
     * their sales territories.
     */
    public static Set<Set<String>>
    salesTerritories(Set<CityPair> cityPairs) {
        SalesTerritories.cityPairs = cityPairs;
        buildCityMap();
        return findTerritories();
    }

    private static void buildCityMap() {
        for (CityPair cityPair : cityPairs) {
            CityNode cityNode1 = findOrCreateCityNode(cityPair.city1);
            CityNode cityNode2 = findOrCreateCityNode(cityPair.city2);
            cityNode1.neighboringCities.add(cityNode2);
            cityNode2.neighboringCities.add(cityNode1);
        }
    }

    private static CityNode findOrCreateCityNode(String cityName) {
        CityNode cityNode = cityMap.get(cityName);
        if (cityNode == null) {
            cityNode = new CityNode(cityName);
            cityMap.put(cityName, cityNode);
        }
        return cityNode;
    }

    private static Set<Set<String>> findTerritories() {
        Set<Set<String>> result = new HashSet<>();
        for (CityNode cityNode : cityMap.values()) {
            if (visited.contains(cityNode)) {
                continue;
            }
            Set<String> territory = findConnectedCities(cityNode);
            result.add(territory);
        }
        return result;
    }

    private static Set<String> findConnectedCities(CityNode rootNode) {
        Set<String> result = new HashSet<>();
        Queue<CityNode> cityNodeQueue = new LinkedList<>();
        cityNodeQueue.add(rootNode);
        while (!cityNodeQueue.isEmpty()) {
            CityNode cityNode = cityNodeQueue.poll();
            if (visited.contains(cityNode)) {
                continue;
            }
            visited.add(cityNode);
            result.add(cityNode.cityName);
            cityNodeQueue.addAll(cityNode.neighboringCities);
        }
        return result;
    }
}
