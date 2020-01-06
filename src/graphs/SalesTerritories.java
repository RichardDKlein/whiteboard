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
        String city;
        Set<CityNode> neighbors = new HashSet<>();
        CityNode(String city) { this.city = city; }
    }

    private static Set<Pair<String, String>> cityPairs;
    private static Map<String, CityNode> cityMap = new HashMap<>();
    private static Set<CityNode> visited = new HashSet<>();
    private static Set<Set<String>> territories = new HashSet<>();

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
        cityPairs = theCityPairs;
        buildCityGraph();
        for (CityNode cityNode : cityMap.values()) {
            if (!visited.contains(cityNode)) {
                Set<String> newTerritory = findConnectedCities(cityNode);
                territories.add(newTerritory);
            }
        }
        return territories;
    }

    private static void buildCityGraph() {
        cityMap.clear();
        for (Pair<String, String> cityPair : cityPairs) {
            String city1 = cityPair.getKey();
            String city2 = cityPair.getValue();
            CityNode node1 = findOrCreateNode(city1);
            CityNode node2 = findOrCreateNode(city2);
            node1.neighbors.add(node2);
            node2.neighbors.add(node1);
        }
    }

    private static CityNode findOrCreateNode(String city) {
        CityNode node = cityMap.get(city);
        if (node == null) {
            node = new CityNode(city);
            cityMap.put(city, node);
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
            territory.add(node.city);
            visited.add(node);
            for (CityNode neighbor : node.neighbors) {
                if (!visited.contains(neighbor)) {
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
