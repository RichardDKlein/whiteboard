package com.whiteboard;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import com.whiteboard.SalesTerritories.UnorderedPair;

class SalesTerritoriesTest {
    @Test
    void salesTerritoriesTest() {
        System.out.println();
        System.out.println("Test SalesTerritories:");
        System.out.println("======================");

        Set<UnorderedPair<String>> cityUnorderedPairs = new HashSet<>();
        cityUnorderedPairs.add(new UnorderedPair<>("San Francisco", "San Jose"));
        cityUnorderedPairs.add(new UnorderedPair<>("Denver", "Colorado Springs"));
        cityUnorderedPairs.add(new UnorderedPair<>("Los Angeles", "San Francisco"));
        cityUnorderedPairs.add(new UnorderedPair<>("New York City", "Buffalo"));
        cityUnorderedPairs.add(new UnorderedPair<>("San Jose", "San Diego"));
        cityUnorderedPairs.add(new UnorderedPair<>("Colorado Springs", "Aspen"));
        cityUnorderedPairs.add(new UnorderedPair<>("Santa Monica", "Pasadena"));
        cityUnorderedPairs.add(new UnorderedPair<>("Buffalo", "Yonkers"));
        cityUnorderedPairs.add(new UnorderedPair<>("Oakland", "Sacramento"));
        cityUnorderedPairs.add(new UnorderedPair<>("Fort Collins", "Aurora"));
        cityUnorderedPairs.add(new UnorderedPair<>("San Diego", "Los Angeles"));
        cityUnorderedPairs.add(new UnorderedPair<>("Syracuse", "Albany"));
        cityUnorderedPairs.add(new UnorderedPair<>("Los Angeles", "San Diego"));
        cityUnorderedPairs.add(new UnorderedPair<>("Boulder", "Aspen"));
        cityUnorderedPairs.add(new UnorderedPair<>("Oakland", "Santa Monica"));
        cityUnorderedPairs.add(new UnorderedPair<>("Rochester", "Yonkers"));
        cityUnorderedPairs.add(new UnorderedPair<>("San Francisco", "Oakland"));
        cityUnorderedPairs.add(new UnorderedPair<>("Denver", "Fort Collins"));
        cityUnorderedPairs.add(new UnorderedPair<>("San Jose", "San Francisco"));
        cityUnorderedPairs.add(new UnorderedPair<>("New York City", "Syracuse"));
        cityUnorderedPairs.add(new UnorderedPair<>("Pasadena", "Sacramento"));

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

        System.out.println("City UnorderedPairs = ");
        for (UnorderedPair<String> cityUnorderedPair : cityUnorderedPairs) {
            System.out.println("\t(" + cityUnorderedPair.first +
                    ", " + cityUnorderedPair.second + ")");
        }
        System.out.println();

        Set<Set<String>> territories = SalesTerritories.salesTerritories(cityUnorderedPairs);
//        assert(territories.equals(expected));

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
