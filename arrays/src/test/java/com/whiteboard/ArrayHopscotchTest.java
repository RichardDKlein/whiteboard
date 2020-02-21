package com.whiteboard;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class ArrayHopscotchTest {

    @Test
    void arrayHopscotch() {
        System.out.println();
        System.out.println("Test ArrayHopscotch:");
        System.out.println("====================");

        int[][] a = {
                {2, 3, 1, 0, 5},
                {2, 2, 2, 0, 2},
                {1, 1, 1, 3, 1, 2, 0, 3}
        };

        int[] iStart = {
                0,
                0,
                5
        };
        for (int i = 0; i < a.length; ++i) {
            System.out.println(Arrays.toString(a[i]) + ", start = " + iStart[i]);
            ArrayHopscotch instance = new ArrayHopscotch();
            List<Integer> winningHops = instance.arrayHopscotch(a[i], iStart[i]);
            System.out.println("Winning hops = " + winningHops);
        }
    }
}
