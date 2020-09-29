package com.whiteboard;

import com.sun.tools.javac.util.Pair;

import java.util.*;

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
            String city1 = cityPair.fst;
            String city2 = cityPair.snd;
            CityNode cityNode1 = findOrCreateCityNode(city1);
            CityNode cityNode2 = findOrCreateCityNode(city2);
            cityNode1.neighbors_.add(cityNode2);
            cityNode2.neighbors_.add(cityNode1);
        }
    }

    private CityNode findOrCreateCityNode(String city) {
        CityNode cityNode = cityMap_.get(city);
        if (cityNode == null) {
            cityNode = new CityNode(city);
            cityMap_.put(city, cityNode);
        }
        return cityNode;
    }

    private Set<String> findConnectedCities(CityNode root) {
        // Breadth-First Search (BFS)
        Set<String> territory = new HashSet<>();
        Queue<CityNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            CityNode cityNode = nodeQueue.poll();
            visited_.add(cityNode);
            territory.add(cityNode.city_);
            for (CityNode neighbor : cityNode.neighbors_) {
                if (!visited_.contains(neighbor)) {
                    nodeQueue.add(neighbor);
                }
            }
        }
        return territory;
    }

    private static class CityNode {
        String city_;
        Set<CityNode> neighbors_ = new HashSet<>();
        CityNode(String city) {
            city_ = city;
        }
    }
}
