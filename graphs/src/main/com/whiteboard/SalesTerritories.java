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

    private static class CityNode {
        String cityName;
        Set<CityNode> adjacentCities = new HashSet<>();

        CityNode(String cityName) {
            this.cityName = cityName;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof CityNode other)) {
                return false;
            }
            return (this.cityName.equals(other.cityName));
        }

        @Override
        public int hashCode() {
            return cityName.hashCode();
        }
    }

    private static Set<Set<String>> cityPairs;
    private static Map<String, CityNode> cityGraph = new HashMap<>();
    private static Set<CityNode> visited = new HashSet<>();

    /**
     * Given a collection of city pairs, where each pair denotes
     * that the two cities belong to the same sales territories,
     * find all the territories, i.e. find all the cities composing
     * each territory.
     *
     * This is a straightforward graph problem, where each graph
     * node represents a city, and each edge between two city
     * nodes means that those cities are in the same territory.
     *
     * Finding the sales territories amounts to finding all the
     * connected subgraphs of cities. We do this with a simple
     * Breadth-First Search (BFS), taking care to avoid loops.
     *
     * Running time is O(n).
     *
     * @param cityPairs A set of pairs of city names, where each
     *                  pair is represented by a set containing
     *                  the names of two cities that are in the
     *                  same sales territory.
     * @return The given cities, grouped into sets representing
     * their sales territories.
     */
    public static Set<Set<String>> salesTerritories(Set<Set<String>> cityPairs) {
        saveCallingParameter(cityPairs);
        buildCityGraph();
        return findTerritories();
    }

    private static void saveCallingParameter(Set<Set<String>> cityPairs) {
        SalesTerritories.cityPairs = cityPairs;
    }

    private static void buildCityGraph() {
        cityGraph.clear();
        for (Set<String> cityPair : cityPairs) {
            Iterator<String> iterator = cityPair.iterator();
            String cityName1 = iterator.next();
            String cityName2 = iterator.next();
            CityNode cityNode1 = findOrCreateCityNode(cityName1);
            CityNode cityNode2 = findOrCreateCityNode(cityName2);
            cityNode1.adjacentCities.add(cityNode2);
            cityNode2.adjacentCities.add(cityNode1);
        }
    }

    private static CityNode findOrCreateCityNode(String cityName) {
        CityNode cityNode = cityGraph.get(cityName);
        if (cityNode == null) {
            cityNode = new CityNode(cityName);
            cityGraph.put(cityName, cityNode);
        }
        return cityNode;
    }

    private static Set<Set<String>> findTerritories() {
        Set<Set<String>> result = new HashSet<>();
        for (CityNode cityNode : cityGraph.values()) {
            if (visited.contains(cityNode)) {
                continue;
            }
            Set<String> territory = findConnectedCities(cityNode);
            result.add(territory);
        }
        return result;
    }

    private static Set<String> findConnectedCities(CityNode startingNode) {
        Set<String> result = new HashSet<>();
        Queue<CityNode> cityNodeQueue = new LinkedList<>();
        cityNodeQueue.add(startingNode);
        while (!cityNodeQueue.isEmpty()) {
            CityNode cityNode = cityNodeQueue.poll();
            if (visited.contains(cityNode)) {
                continue;
            }
            visited.add(cityNode);
            result.add(cityNode.cityName);
            cityNodeQueue.addAll(cityNode.adjacentCities);
        }
        return result;
    }
}
