import arrays.TestArrays;
import bit_manipulation.TestBitManipulation;
import design_patterns.TestDesignPatterns;
import graphs.TestGraphs;
import lists_homegrown.TestListsHomegrown;
import lists_standardlib.TestListsStandardLib;

public class Main {
    public static void main(String[] args) {
        TestArrays.run();
        TestBitManipulation.run();
        TestDesignPatterns.run();
        TestGraphs.run();
        TestListsHomegrown.run();
        TestListsStandardLib.run();
        //TestSets().run();
        //TestStacksAndQueues().run();
        //TestStrings().run();
        //TestThreads().run();
        //TestTrees().run();
    }
}
