package sets;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Compute the power set of a set, i.e. the set of all subsets of
 * that set, using an iterative approach.
 *
 * We know that a set 's' with 'n' elements has (2 ** n) subsets.
 * So we just count from 0 to (2 ** n) - 1, using the bit pattern
 * in each count to select the elements of 's' that will form the
 * subset corresponding to that count.
 */
public class PowerSetIterative {
    private PowerSetIterative() {}

    public static <T> Set<Set<T>> powerSetIterative(Set<T> set) {
        Set<Set<T>> powerSet = new HashSet<>();
        int numSubsets = (int)Math.pow(2, set.size());
        for (int i = 0; i < numSubsets; ++i) {
            Set<T> subset = new HashSet<>();
            Iterator<T> iterator = set.iterator();
            for (int bit = 0; bit < set.size(); ++bit) {
                T element = iterator.next();
                if ((i & (1 << bit)) != 0) {
                    subset.add(element);
                }
            }
            powerSet.add(subset);
        }
        return powerSet;
    }

    public static void test() {
        System.out.println();
        System.out.println("Test powerSetIterative():");
        System.out.println("=========================");

        Set<Character> set = new HashSet<>();

        set.add('a');
        set.add('b');
        set.add('c');
        set.add('d');
        set.add('e');

        System.out.print("set = ");
        TestUtils.printSet(set);

        Set<Set<Character>> powerSet = powerSetIterative(set);
        System.out.println("powerSetIterative(set) = " + powerSet.size() +
                " subsets:");
        TestUtils.printPowerSet(powerSet);
    }
}
