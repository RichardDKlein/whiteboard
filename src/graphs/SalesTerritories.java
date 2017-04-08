package graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Given a list of city pairs, where each pair denotes that
 * the two cities belong to the same sales territories, find
 * all the territories, i.e. find all the cities composing
 * each territory.
 */
public class SalesTerritories {

    private class CityNode {
        public City city;
        public int territory = -1;
        List<CityNode> neighbors = new LinkedList<>();

        public CityNode(City city) {
            this.city = city;
        }
    }

    private CityPair[] cityPairs;
    private Territory[] territories;
    private int currTerritory = 0;
    private Map<City, CityNode> cityMap = new HashMap<>();

    public SalesTerritories(CityPair[] cityPairs) {
        this.cityPairs = cityPairs;
    }

    public Territory[] compute() {
        buildCityGraph();
        findConnectedSubgraphs();
        collateTerritories();
        return territories;
    }

    private void buildCityGraph() {
        for (CityPair cityPair : cityPairs) {
            City city1 = cityPair.cities.fst;
            City city2 = cityPair.cities.snd;
            CityNode node1 = findOrCreateNode(city1);
            CityNode node2 = findOrCreateNode(city2);
            node1.neighbors.add(node2);
            node2.neighbors.add(node1);
        }
    }

    private CityNode findOrCreateNode(City city) {
        CityNode node = cityMap.get(city);
        if (node == null) {
            node = new CityNode(city);
            cityMap.put(city, node);
        }
        return node;
    }

    private void findConnectedSubgraphs() {
        for (Map.Entry<City, CityNode> entry : cityMap.entrySet()) {
            CityNode node = entry.getValue();
            if (node.territory < 0) {
                labelConnectedNodes(node, currTerritory);
                ++currTerritory;
            }
        }
    }

    private void labelConnectedNodes(CityNode root, int territory) {
        // Breadth-First Search (BFS)
        Queue<CityNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            CityNode node = nodeQueue.remove();
            node.territory = territory;
            for (CityNode neighbor : node.neighbors) {
                if (neighbor.territory < 0) {
                    nodeQueue.add(neighbor);
                }
            }
        }
    }

    private void collateTerritories() {
        territories = new Territory[currTerritory];
        for (int i = 0; i < territories.length; ++i) {
            territories[i] = new Territory();
        }
        for (Map.Entry<City, CityNode> entry : cityMap.entrySet()) {
            City city = entry.getKey();
            CityNode node = entry.getValue();
            territories[node.territory].cities.add(city);
        }
    }

    public static void test() {
        System.out.println();
        System.out.println("Test salesTerritories():");
        System.out.println("========================");


        CityPair[] cityPairs = {
            new CityPair("San Francisco", "San Jose"),
            new CityPair("Denver", "Colorado Springs"),
            new CityPair("Los Angeles", "San Francisco"),
            new CityPair("New York City", "Buffalo"),
            new CityPair("San Jose", "San Diego"),
            new CityPair("Colorado Springs", "Aspen"),
            new CityPair("Santa Monica", "Pasadena"),
            new CityPair("Buffalo", "Yonkers"),
            new CityPair("Oakland", "Sacramento"),
            new CityPair("Fort Collins", "Aurora"),
            new CityPair("San Diego", "Los Angeles"),
            new CityPair("Syracuse", "Albany"),
            new CityPair("Los Angeles", "San Diego"),
            new CityPair("Boulder", "Aspen"),
            new CityPair("Oakland", "Santa Monica"),
            new CityPair("Rochester", "Yonkers"),
            new CityPair("San Francisco", "Oakland"),
            new CityPair("Denver", "Fort Collins"),
            new CityPair("San Jose", "San Francisco"),
            new CityPair("New York City", "Syracuse"),
            new CityPair("Pasadena", "Sacramento")
        };

        System.out.println("City pairs = ");
        for (CityPair cityPair : cityPairs) {
            System.out.println("\t(" + cityPair.cities.fst.name +
                ", " + cityPair.cities.snd.name + ")");
        }
        System.out.println();

        Territory[] territories = new SalesTerritories(cityPairs).compute();

        System.out.println("Territories = ");
        for (Territory territory : territories) {
            System.out.println("{");
            for (City city : territory.cities) {
                System.out.println("\t" + city.name);
            }
            System.out.println("}");
        }
    }
}
