import arrays.TestArrays;
import bit_manipulation.TestBitManipulation;
import design_patterns.TestDesignPatterns;
import graphs.TestGraphs;
import lists.TestLists;
import math.TestMath;
import sets.TestSets;
import strings.TestStrings;

public class Main {
    public static void main(String[] args) {
        TestArrays.run();
        TestBitManipulation.run();
        TestDesignPatterns.run();
        TestGraphs.run();
        TestLists.run();
        TestMath.run();
        TestSets.run();
        //TestStacksAndQueues.run();
        TestStrings.run();
        //TestThreads.run();
        //TestTrees.run();
    }
}
