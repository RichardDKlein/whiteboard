package graphs;

import javafx.util.Pair;

import java.util.*;

// @TODO: ***************************************************
// @TODO: *************** ADD COMMENTS **********************
// @TODO: ***************************************************

/**
 * Given a list of city pairs, where each pair denotes that
 * the two cities belong to the same sales territories, find
 * all the territories, i.e. find all the cities composing
 * each territory.
 */
public class SalesTerritories {

    private class CityNode {
        String city;
        Set<CityNode> neighbors = new HashSet<>();
        boolean visited = false;

        CityNode(String city) {
            this.city = city;
        }
    }

    private Set<Pair<String, String>> cityPairs;
    private Set<CityNode> cityNodes = new HashSet<>();
    private Map<String, CityNode> cityMap = new HashMap<>();
    private Set<Set<String>> territories = new HashSet<>();

    public SalesTerritories(Set<Pair<String, String>> cityPairs) {
        this.cityPairs = cityPairs;
    }

    public Set<Set<String>> findSalesTerritories() {
        buildCityGraph();
        for (CityNode cityNode : cityNodes) {
            if (!cityNode.visited) {
                Set<String> newTerritory = new HashSet<>();
                addConnectedCitiesToTerritory(cityNode, newTerritory);
                this.territories.add(newTerritory);
            }
        }
        return territories;
    }

    private void buildCityGraph() {
        cityNodes.clear();
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

    private CityNode findOrCreateNode(String city) {
        CityNode node = cityMap.get(city);
        if (node == null) {
            node = new CityNode(city);
            cityNodes.add(node);
            cityMap.put(city, node);
        }
        return node;
    }

    private void addConnectedCitiesToTerritory(CityNode root, Set<String> territory) {
        // Breadth-First Search (BFS)
        Queue<CityNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            CityNode node = nodeQueue.remove();
            territory.add(node.city);
            node.visited = true;
            for (CityNode neighbor : node.neighbors) {
                if (!neighbor.visited) {
                    nodeQueue.add(neighbor);
                }
            }
        }
    }

    public static void test() {
        System.out.println();
        System.out.println("Test salesTerritories():");
        System.out.println("========================");

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

        Set<Set<String>> territories =
                new SalesTerritories(cityPairs)
                        .findSalesTerritories();

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
