package sets;

import java.util.Set;

public class TestUtils {
    static <E> void printSet(Set<E> set) {
        System.out.print("{ ");
        for (E element : set) {
            System.out.print(element + " ");
        }
        System.out.println("}");
    }

    static <E> void printPowerSet(Set<Set<E>> powerSet) {
        System.out.println("{");
        for (Set set : powerSet) {
            System.out.print("\t");
            printSet(set);
        }
        System.out.println("}");
    }
}
