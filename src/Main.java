import arrays.TestArrays;
import bit_manipulation.TestBitManipulation;
import design_patterns.TestDesignPatterns;
import graphs.TestGraphs;
import lists.TestLists;
import math.TestMath;
import sets.TestSets;
import stacks_and_queues.TestStacksAndQueues;
import strings.TestStrings;
import threads.TestThreads;
import trees.TestTrees;

public class Main {
    public static void main(String[] args) {
        TestArrays.run();
        TestBitManipulation.run();
        TestDesignPatterns.run();
        TestGraphs.run();
        TestLists.run();
        TestMath.run();
        TestSets.run();
        TestStacksAndQueues.run();
        TestStrings.run();
        TestThreads.run();
        TestTrees.run();
    }
}
