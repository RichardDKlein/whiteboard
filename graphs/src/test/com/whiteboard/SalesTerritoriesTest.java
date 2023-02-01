package com.whiteboard;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.whiteboard.SalesTerritories.CityPair;

public class SalesTerritoriesTest {
    @Test
    public void salesTerritoriesTest() {
        System.out.println();
        System.out.println("Test SalesTerritories:");
        System.out.println("======================");

        Set<CityPair> cityPairs = new HashSet<>();
        cityPairs.add(new CityPair("San Francisco", "San Jose"));
        cityPairs.add(new CityPair("Denver", "Colorado Springs"));
        cityPairs.add(new CityPair("Los Angeles", "San Francisco"));
        cityPairs.add(new CityPair("New York City", "Buffalo"));
        cityPairs.add(new CityPair("San Jose", "San Diego"));
        cityPairs.add(new CityPair("Colorado Springs", "Aspen"));
        cityPairs.add(new CityPair("Santa Monica", "Pasadena"));
        cityPairs.add(new CityPair("Buffalo", "Yonkers"));
        cityPairs.add(new CityPair("Oakland", "Sacramento"));
        cityPairs.add(new CityPair("Fort Collins", "Aurora"));
        cityPairs.add(new CityPair("San Diego", "Los Angeles"));
        cityPairs.add(new CityPair("Syracuse", "Albany"));
        cityPairs.add(new CityPair("Los Angeles", "San Diego"));
        cityPairs.add(new CityPair("Boulder", "Aspen"));
        cityPairs.add(new CityPair("Oakland", "Santa Monica"));
        cityPairs.add(new CityPair("Rochester", "Yonkers"));
        cityPairs.add(new CityPair("San Francisco", "Oakland"));
        cityPairs.add(new CityPair("Denver", "Fort Collins"));
        cityPairs.add(new CityPair("San Jose", "San Francisco"));
        cityPairs.add(new CityPair("New York City", "Syracuse"));
        cityPairs.add(new CityPair("Pasadena", "Sacramento"));

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
        for (CityPair cityPair : cityPairs) {
            System.out.println("\t(" + cityPair.city1 +
                    ", " + cityPair.city2 + ")");
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
