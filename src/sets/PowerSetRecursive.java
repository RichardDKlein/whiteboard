package sets;

import java.util.HashSet;
import java.util.Set;

/**
 * Compute the power set of a set, i.e. the set of all subsets of
 * that set, using a recursive approach.
 */
public class PowerSetRecursive {
    private PowerSetRecursive() {}

    public static <E> Set<Set<E>> powerSetRecursive(Set<E> set) {
        Set<Set<E>> powerSet = new HashSet<>();
        if (set.isEmpty()) {
            powerSet.add(new HashSet<>());
            return powerSet;
        }
        Set<E> remainder = set;
        E firstElement = remainder.iterator().next();
        remainder.remove(firstElement);
        Set<Set<E>> remainderPowerSet = powerSetRecursive(remainder);
        for (Set<E> subset : remainderPowerSet) {
            powerSet.add(new HashSet<>(subset));
            subset.add(firstElement);
            powerSet.add(subset);
        }
        return powerSet;
    }

    public static void test() {
        System.out.println();
        System.out.println("Test PowerSetRecursive:");
        System.out.println("=======================");

        Set<Character> set = new HashSet<>();

        set.add('a');
        set.add('b');
        set.add('c');
        set.add('d');
        set.add('e');

        System.out.print("set = ");
        TestUtils.printSet(set);

        Set<Set<Character>> powerSet = powerSetRecursive(set);
        System.out.println("powerSetRecursive(set) = " + powerSet.size() +
                " subsets:");
        TestUtils.printPowerSet(powerSet);
    }
}
