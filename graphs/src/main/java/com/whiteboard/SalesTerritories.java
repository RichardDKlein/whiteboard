package com.whiteboard;

import com.sun.tools.javac.util.Pair;

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

    private static class CityNode {
        String city;
        Set<CityNode> neighbors = new HashSet<>();
        CityNode(String city) {
            this.city = city;
        }
    }

    private static Set<Pair<String, String>> cityPairs;
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
     * @return The given cities, organized into sets representing
     * their sales territories.
     */
    public static Set<Set<String>>
    salesTerritories(Set<Pair<String, String>> cityPairs) {
        Set<Set<String>> result = new HashSet<>();
        SalesTerritories.cityPairs = cityPairs;
        buildCityMap();
        for (CityNode cityNode : cityMap.values()) {
            if (!visited.contains(cityNode)) {
                Set<String> territory = findConnectedCities(cityNode);
                result.add(territory);
            }
        }
        return result;
    }

    private static void buildCityMap() {
        for (Pair<String, String> cityPair : cityPairs) {
            String city1 = cityPair.fst;
            String city2 = cityPair.snd;
            CityNode cityNode1 = findOrCreateCityNode(city1);
            CityNode cityNode2 = findOrCreateCityNode(city2);
            cityNode1.neighbors.add(cityNode2);
            cityNode2.neighbors.add(cityNode1);
        }
    }

    private static CityNode findOrCreateCityNode(String city) {
        CityNode cityNode = cityMap.get(city);
        if (cityNode == null) {
            cityNode = new CityNode(city);
            cityMap.put(city, cityNode);
        }
        return cityNode;
    }

    private static Set<String> findConnectedCities(CityNode root) {
        // Breadth-First Search (BFS)
        Set<String> territory = new HashSet<>();
        Queue<CityNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            CityNode cityNode = nodeQueue.poll();
            if (visited.contains(cityNode)) {
                continue;
            }
            visited.add(cityNode);
            territory.add(cityNode.city);
            for (CityNode neighbor : cityNode.neighbors) {
                nodeQueue.add(neighbor);
            }
        }
        return territory;
    }
}
