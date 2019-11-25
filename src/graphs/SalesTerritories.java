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

    /**
     * Helper class representing a node in the graph of cities.
     */
    private static class CityNode {
        String city;
        Set<CityNode> neighbors = new HashSet<>();
        CityNode(String city) { this.city = city; }
    }

    /**
     * The set of city pairs whose sales territories we are being
     * asked to discover.
     */
    private static Set<Pair<String, String>> cityPairs;

    /**
     * A graph showing the relationships between the cities. Each
     * node in the graph represents one city. Each edge between
     * two city nodes represents that both cities are in the same
     * sales territory.
     */
    private static Set<CityNode> cityGraph = new HashSet<>();

    /**
     * A map that maps each city's name to its node in the city
     * graph.
     */
    private static Map<String, CityNode> cityMap = new HashMap<>();

    /**
     * The set of all city nodes we have already visited during
     * our breadth-first traversal of the city node graph.
     */
    private static Set<CityNode> visited = new HashSet<>();

    /**
     * The set of sales territories. Each territory is a set
     * containing the names of the cities belonging to that
     * territory.
     */
    private static Set<Set<String>> territories = new HashSet<>();

    /**
     * Given a list of city pairs, where each pair denotes that
     * the two cities belong to the same sales territories, find
     * all the territories, i.e. find all the cities composing
     * each territory.
     *
     * This is a straightforward graph problem. Represent the
     * cities, and the relationships between them, by a graph.
     * Each node represents one city. Each edge connecting two
     * cities represents that both cities are in the same sales
     * territory.
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
        for (CityNode cityNode : cityGraph) {
            if (!visited.contains(cityNode)) {
                Set<String> newTerritory = findConnectedCities(cityNode);
                territories.add(newTerritory);
            }
        }
        return territories;
    }

    /**
     * From the given pairs of city names, build the city graph.
     */
    private static void buildCityGraph() {
        cityGraph.clear();
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

    /**
     * Find or create a node in the city graph.
     *
     * @param city The city name of the node to find or create.
     *             If a node for that city already exists in the
     *             city graph, that node will be returned.
     *
     *             If a node for that city does not already
     *             exist, it will be created, and added to the
     *             city graph. In addition, an entry will be
     *             added to the map of city names to city nodes.
     *             The new city node will be returned.
     *
     * @return The city node found or created.
     */
    private static CityNode findOrCreateNode(String city) {
        CityNode node = cityMap.get(city);
        if (node == null) {
            node = new CityNode(city);
            cityGraph.add(node);
            cityMap.put(city, node);
        }
        return node;
    }

    /**
     * Find all the cities that are in the same sales territory
     * as the given city.
     *
     * @param root The city node that we are to take as the
     *             starting point to find the entire connected
     *             subgraph of city nodes.
     *
     * @return territory A set of all the cities connected to
     * the starting 'root' city (including the root city itself).
     */
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
