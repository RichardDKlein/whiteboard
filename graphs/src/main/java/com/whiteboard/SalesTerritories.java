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

    static class UnorderedPair<E> {
        E first;
        E second;

        UnorderedPair(E first, E second) {
            this.first = first;
            this.second = second;
        }
    }

    static class CityNode {
        String cityName;
        Set<CityNode> neighboringCities = new HashSet<>();

        CityNode(String cityName) {
            this.cityName = cityName;
        }
    }

    static Set<UnorderedPair<String>> cityPairs;
    static Map<String, CityNode> cityMap = new HashMap<>();
    static Set<String> visited = new HashSet<>();

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
     * @return The given cities, organized into sets representing
     * their sales territories.
     */
    public static Set<Set<String>>
    salesTerritories(Set<UnorderedPair<String>> cityPairs) {
        Set<Set<String>> result = new HashSet<>();
        SalesTerritories.cityPairs = cityPairs;
        buildCityMap();
        for (String cityName : cityMap.keySet()) {
            if (!visited.contains(cityName)) {
                Set<String> territory = findNeighboringCities(cityName);
                result.add(territory);
            }
        }
        return result;
    }

    private static void buildCityMap() {
        for (UnorderedPair<String> cityPair : cityPairs) {
            CityNode cityNode1 = findOrCreateCityNode(cityPair.first);
            CityNode cityNode2 = findOrCreateCityNode(cityPair.second);
            cityNode1.neighboringCities.add(cityNode2);
            cityNode2.neighboringCities.add(cityNode1);
        }
    }

    private static CityNode findOrCreateCityNode(String cityName) {
        CityNode result = cityMap.get(cityName);
        if (result == null) {
            result = new CityNode(cityName);
            cityMap.put(cityName, result);
        }
        return result;
    }

    private static Set<String> findNeighboringCities(String cityName) {
        Set<String> result = new HashSet<>();
        Queue<CityNode> cityNodeQueue = new LinkedList<>();
        CityNode rootCityNode = cityMap.get(cityName);
        cityNodeQueue.add(rootCityNode);
        while (!cityNodeQueue.isEmpty()) {
            CityNode cityNode = cityNodeQueue.poll();
            if (visited.contains(cityNode.cityName)) {
                continue;
            }
            visited.add(cityNode.cityName);
            result.add(cityNode.cityName);
            cityNodeQueue.addAll(cityNode.neighboringCities);
        }
        return result;
    }
}
