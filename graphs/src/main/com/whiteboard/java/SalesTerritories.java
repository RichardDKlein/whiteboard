package com.whiteboard.java;

import java.util.*;

public final class SalesTerritories {
    private static class CityNode {
        String cityName;
        Set<CityNode> neighbors;

        CityNode(String cityName) {
            this.cityName = cityName;
            neighbors = new HashSet<>();
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof CityNode other)) {
                return false;
            }
            return this.cityName.equals(other.cityName);
        }

        @Override
        public int hashCode() {
            return cityName.hashCode();
        }
    }
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
        Map<String, CityNode> cityGraph = buildCityGraph(cityPairs);
        return findSalesTerritories(cityGraph);
    }

    private static Map<String, CityNode> buildCityGraph(Set<Set<String>> cityPairs) {
        Map<String, CityNode> cityGraph = new HashMap<>();
        for (Set<String> cityPair : cityPairs) {
            Iterator<String> iterator = cityPair.iterator();
            String cityName1 = iterator.next();
            String cityName2 = iterator.next();
            CityNode cityNode1 = cityGraph.computeIfAbsent(cityName1, CityNode::new);
            CityNode cityNode2 = cityGraph.computeIfAbsent(cityName2, CityNode::new);
            cityNode1.neighbors.add(cityNode2);
            cityNode2.neighbors.add(cityNode1);
        }
        return cityGraph;
    }

    private static Set<Set<String>> findSalesTerritories(Map<String, CityNode> cityGraph) {
        Set<Set<String>> territories = new HashSet<>();
        Set<CityNode> visited = new HashSet<>();
        for (CityNode cityNode : cityGraph.values()) {
            if (visited.contains(cityNode)) {
                continue;
            }
            Set<String> territory = findConnectedCities(cityNode, visited);
            territories.add(territory);
        }
        return territories;
    }

    private static Set<String> findConnectedCities(CityNode cityNode, Set<CityNode> visited) {
        Set<String> connectedCities = new HashSet<>();
        Queue<CityNode> queue = new LinkedList<>();
        queue.add(cityNode);
        while (!queue.isEmpty()) {
            CityNode node = queue.poll();
            if (visited.contains(node)) {
                continue;
            }
            visited.add(node);
            connectedCities.add(node.cityName);
            queue.addAll(node.neighbors);
        }
        return connectedCities;
    }
}
