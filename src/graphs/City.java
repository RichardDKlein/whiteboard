package graphs;

/**
 * Represent a city.
 */
public class City {
    public String name;

    public City(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof City)) {
            return false;
        }
        City other = (City)obj;
        return other.name == this.name;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
