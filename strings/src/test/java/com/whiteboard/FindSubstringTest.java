package java.com.whiteboard;

import org.junit.Test;

public class FindSubstringTest {
    @Test
    public void findSubstringTest() {
        System.out.println();
        System.out.println("Test FindSubstring:");
        System.out.println("===================");

        String testString = "alfalfa romeo";
        String[] testSubstrings = {
                "alfa",
                "rome",
                "alfa romeo",
                "alfa romeos",
                "alfalfa romeo",
                "alfalfa romeos",
                "x"
        };

        System.out.println("Test string = " + testString);
        for (String s : testSubstrings) {
            int index = FindSubstring.findSubstring(testString, s);
            assert(index == testString.indexOf(s));
            System.out.println("findSubstring(" + s + ") = " + index);
        }
    }
}
