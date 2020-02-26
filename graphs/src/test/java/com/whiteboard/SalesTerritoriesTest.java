package com.whiteboard;

import java.util.HashSet;
import java.util.Set;
import javafx.util.Pair;

import org.junit.jupiter.api.Test;

class SalesTerritoriesTest {
    @Test
    void salesTerritories() {
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

        Set<Set<String>> territories =
                new SalesTerritories().salesTerritories(cityPairs);

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
