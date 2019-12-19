package sets;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Compute the power set of a set, i.e. the set of all subsets of
 * that set, using an iterative approach.
 */
public final class PowerSetIterative {
    private PowerSetIterative() {}

    /**
     * Compute the power set of a set, i.e. the set of all subsets of
     * that set, using an iterative approach.
     *
     * We know that a set 's' with 'n' elements has (2 ** n) subsets.
     * So we just count from 0 to (2 ** n) - 1, using the bit pattern
     * in each count to select the elements of 's' that will form the
     * subset corresponding to that count.
     */
    public static <E> Set<Set<E>> powerSetIterative(Set<E> set) {
        Set<Set<E>> powerSet = new HashSet<>();
        int numSubsets = (int)Math.pow(2, set.size());
        for (int i = 0; i < numSubsets; ++i) {
            Set<E> subset = new HashSet<>();
            Iterator<E> iterator = set.iterator();
            for (int bit = 0; bit < set.size(); ++bit) {
                E element = iterator.next();
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
        System.out.println("Test PowerSetIterative:");
        System.out.println("=======================");

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
