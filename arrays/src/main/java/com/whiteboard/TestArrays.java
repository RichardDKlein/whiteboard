package com.whiteboard;

public final class TestArrays {
    private TestArrays() {}

    public static void run() {
        System.out.println();
        System.out.println("=============================================");
        System.out.println("                    ARRAYS                   ");
        System.out.println("=============================================");

        ArrayHopscotch.test();
        CircularBuffer.test();
        FindPrimes.test();
        FloodFillBreadthFirstSearch.test();
        FloodFillRecursive.test();
        LinesThruPoints.test();
        MaxSubarray.test();
        MergeTwoSortedArrays.test();
        Rotate2dArray.test();
        SearchSorted2dArray.test();
        SearchSortedAndRotatedArray.test();
        ShortestClosure.test();
        SolveMaze.test();
        SpiralTraverse2dArray.test();
        SumPairsInSortedArray.test();
        SumPairsInUnsortedArray.test();
        TrappedWater.test();
    }
}
