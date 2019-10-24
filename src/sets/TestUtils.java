package sets;

import java.util.Set;

public class TestUtils {
    static <T> void printSet(Set<T> set) {
        System.out.print("{ ");
        for (T element : set) {
            System.out.print(element + " ");
        }
        System.out.println("}");
    }

    static <T> void printPowerSet(Set<Set<T>> powerSet) {
        System.out.println("{");
        for (Set set : powerSet) {
            System.out.print("\t");
            printSet(set);
        }
        System.out.println("}");
    }
}
