package com.whiteboard;

import java.util.*;
import javafx.util.Pair;

/**
 * Given a list of city pairs, where each pair denotes that
 * the two cities belong to the same sales territories, find
 * all the territories, i.e. find all the cities composing
 * each territory.
 */
public class SalesTerritories {
    private Set<Pair<String, String>> cityPairs_;
    private Map<String, CityNode> cityMap_ = new HashMap<>();
    private Set<CityNode> visited_ = new HashSet<>();
    private Set<Set<String>> territories_ = new HashSet<>();

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
    public Set<Set<String>>
    salesTerritories(Set<Pair<String, String>> cityPairs) {
        cityPairs_ = cityPairs;
        buildCityMap();
        for (CityNode cityNode : cityMap_.values()) {
            if (!visited_.contains(cityNode)) {
                Set<String> territory = findConnectedCities(cityNode);
                territories_.add(territory);
            }
        }
        return territories_;
    }

    private void buildCityMap() {
        for (Pair<String, String> cityPair : cityPairs_) {
            String city1 = cityPair.getKey();
            String city2 = cityPair.getValue();
            CityNode node1 = findOrCreateNode(city1);
            CityNode node2 = findOrCreateNode(city2);
            node1.neighbors_.add(node2);
            node2.neighbors_.add(node1);
        }
    }

    private CityNode findOrCreateNode(String city) {
        CityNode node = cityMap_.get(city);
        if (node == null) {
            node = new CityNode(city);
            cityMap_.put(city, node);
        }
        return node;
    }

    private Set<String> findConnectedCities(CityNode root) {
        // Breadth-First Search (BFS)
        Set<String> territory = new HashSet<>();
        Queue<CityNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            CityNode node = queue.poll();
            visited_.add(node);
            territory.add(node.city_);
            for (CityNode neighbor : node.neighbors_) {
                if (!visited_.contains(neighbor)) {
                    queue.add(neighbor);
                }
            }
        }
        return territory;
    }

    // ===================================================================
    // INNER CLASSES
    // ===================================================================

    private static class CityNode {
        String city_;
        Set<CityNode> neighbors_ = new HashSet<>();
        CityNode(String city) {
            city_ = city;
        }
    }
}
