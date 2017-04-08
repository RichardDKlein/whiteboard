package graphs;

import com.sun.tools.javac.util.Pair;

/**
 * Represent a pair of cities.
 */
public class CityPair {
    public Pair<City, City> cities;
    public CityPair(String city1, String city2) {
        cities = new Pair(new City(city1), new City(city2));
    }
}
