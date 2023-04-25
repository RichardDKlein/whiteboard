package com.whiteboard.java;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SalesTerritoriesTest {
    @Test
    public void salesTerritoriesTest() {
        System.out.println();
        System.out.println("Test SalesTerritories:");
        System.out.println("======================");

        String[][] cityPairsArray = {
                {"San Francisco", "San Jose"},
                {"Denver", "Colorado Springs"},
                {"Los Angeles", "San Francisco"},
                {"New York City", "Buffalo"},
                {"San Jose", "San Diego"},
                {"Colorado Springs", "Aspen"},
                {"Santa Monica", "Pasadena"},
                {"Buffalo", "Yonkers"},
                {"Oakland", "Sacramento"},
                {"Fort Collins", "Aurora"},
                {"San Diego", "Los Angeles"},
                {"Syracuse", "Albany"},
                {"Los Angeles", "San Diego"},
                {"Boulder", "Aspen"},
                {"Oakland", "Santa Monica"},
                {"Rochester", "Yonkers"},
                {"San Francisco", "Oakland"},
                {"Denver", "Fort Collins"},
                {"San Jose", "San Francisco"},
                {"New York City", "Syracuse"},
                {"Pasadena", "Sacramento"}
        };

        Set<Set<String>> cityPairs = new HashSet<>();
        for (String[] cityPair : cityPairsArray) {
            cityPairs.add(new HashSet<>(Arrays.asList(cityPair)));
        }

        Set<Set<String>> expected = new HashSet<>();
        expected.add(new HashSet<>(Arrays.asList(
                "San Francisco",
                "Santa Monica",
                "San Diego",
                "Sacramento",
                "Los Angeles",
                "Oakland",
                "Pasadena",
                "San Jose"
        )));
        expected.add(new HashSet<>(Arrays.asList(
                "Aurora",
                "Fort Collins",
                "Boulder",
                "Denver",
                "Colorado Springs",
                "Aspen"
        )));
        expected.add(new HashSet<>(Arrays.asList(
                "New York City",
                "Rochester",
                "Yonkers",
                "Syracuse",
                "Buffalo",
                "Albany"
        )));

        System.out.println("City Pairs = ");
        for (Set<String> cityPair : cityPairs) {
            Iterator<String> iterator = cityPair.iterator();
            String city1 = iterator.next();
            String city2 = iterator.next();
            System.out.println("\t(" + city1 + ", " + city2 + ")");
        }
        System.out.println();

        Set<Set<String>> territories = SalesTerritories.salesTerritories(cityPairs);
        assert(territories.equals(expected));

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
