package graphs;

import javafx.util.Pair;

import java.util.*;

/**
 * Given a list of city pairs, where each pair denotes that
 * the two cities belong to the same sales territories, find
 * all the territories, i.e. find all the cities composing
 * each territory.
 */
public final class SalesTerritories {
    private SalesTerritories() {}

    private static class CityNode {
        String city_;
        Set<CityNode> neighbors_ = new HashSet<>();
        CityNode(String city) {
            city_ = city;
        }
    }

    private static Set<Pair<String, String>> cityPairs_;
    private static Map<String, CityNode> cityMap_ = new HashMap<>();
    private static Set<CityNode> visited_ = new HashSet<>();
    private static Set<Set<String>> territories_ = new HashSet<>();

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
    salesTerritories(Set<Pair<String, String>> theCityPairs) {
        cityPairs_ = theCityPairs;
        buildCityGraph();
        for (CityNode cityNode : cityMap_.values()) {
            if (!visited_.contains(cityNode)) {
                Set<String> newTerritory = findConnectedCities(cityNode);
                territories_.add(newTerritory);
            }
        }
        return territories_;
    }

    private static void buildCityGraph() {
        for (Pair<String, String> cityPair : cityPairs_) {
            String city1 = cityPair.getKey();
            String city2 = cityPair.getValue();
            CityNode node1 = findOrCreateNode(city1);
            CityNode node2 = findOrCreateNode(city2);
            node1.neighbors_.add(node2);
            node2.neighbors_.add(node1);
        }
    }

    private static CityNode findOrCreateNode(String city) {
        CityNode node = cityMap_.get(city);
        if (node == null) {
            node = new CityNode(city);
            cityMap_.put(city, node);
        }
        return node;
    }

    private static Set<String> findConnectedCities(CityNode root) {
        // Breadth-First Search (BFS)
        Set<String> territory = new HashSet<>();
        Queue<CityNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            CityNode node = nodeQueue.remove();
            territory.add(node.city_);
            visited_.add(node);
            for (CityNode neighbor : node.neighbors_) {
                if (!visited_.contains(neighbor)) {
                    nodeQueue.add(neighbor);
                }
            }
        }
        return territory;
    }

    public static void test() {
        System.out.println();
        System.out.println("Test SalesTerritories:");
        System.out.println("======================");

        Set<Pair<String, String>> cityPairs = new HashSet<>();
        cityPairs.add(new Pair<>("San Francisco", "San Jose"));
        cityPairs.add(new Pair<>("Denver", "Colorado Springs"));
        cityPairs.add(new Pair<>("Los Angeles", "San Francisco"));
        cityPairs.add(new Pair<>("New York City", "Buffalo"));
        cityPairs.add(new Pair<>("San Jose", "San Diego"));
        cityPairs.add(new Pair<>("Colorado Springs", "Aspen"));
        cityPairs.add(new Pair<>("Santa Monica", "Pasadena"));
        cityPairs.add(new Pair<>("Buffalo", "Yonkers"));
        cityPairs.add(new Pair<>("Oakland", "Sacramento"));
        cityPairs.add(new Pair<>("Fort Collins", "Aurora"));
        cityPairs.add(new Pair<>("San Diego", "Los Angeles"));
        cityPairs.add(new Pair<>("Syracuse", "Albany"));
        cityPairs.add(new Pair<>("Los Angeles", "San Diego"));
        cityPairs.add(new Pair<>("Boulder", "Aspen"));
        cityPairs.add(new Pair<>("Oakland", "Santa Monica"));
        cityPairs.add(new Pair<>("Rochester", "Yonkers"));
        cityPairs.add(new Pair<>("San Francisco", "Oakland"));
        cityPairs.add(new Pair<>("Denver", "Fort Collins"));
        cityPairs.add(new Pair<>("San Jose", "San Francisco"));
        cityPairs.add(new Pair<>("New York City", "Syracuse"));
        cityPairs.add(new Pair<>("Pasadena", "Sacramento"));

        System.out.println("City pairs = ");
        for (Pair<String, String> cityPair : cityPairs) {
            System.out.println("\t(" + cityPair.getKey() +
                ", " + cityPair.getValue() + ")");
        }
        System.out.println();

        Set<Set<String>> territories = salesTerritories(cityPairs);

        System.out.println("Territories = ");
        for (Set<String> territory : territories) {
            System.out.println("{");
            for (String city : territory) {
                System.out.println("\t" + city);
            }
            System.out.println("}");
        }
    }
}
