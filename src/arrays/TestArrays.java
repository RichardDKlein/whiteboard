package arrays;

public class TestArrays {
    private TestArrays() {}
    public static void run() {
        System.out.println();
        System.out.println("=============================================");
        System.out.println("                    ARRAYS                   ");
        System.out.println("=============================================");

        HistogramWater.test();
        //testLinesThruPoints();
        MergeTwoSortedArrays.test();
        SearchSorted2dArray.test();
        SearchSortedAndRotatedArray.test();
        ShortestClosure.test();
        ShuffleArray.test();
        SumPairsInSortedArray.test();
        SumPairsInUnsortedArray.test();
    }
}
