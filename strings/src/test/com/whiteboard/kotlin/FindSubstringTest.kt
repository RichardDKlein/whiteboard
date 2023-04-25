package com.whiteboard.kotlin

import com.whiteboard.java.FindSubstring
import org.junit.Test

class FindSubstringTest {
    @Test
    fun findSubstringTest() {
        println()
        println("Test FindSubstring:")
        println("===================")
        val testString = "alfalfa romeo"
        val testSubstrings = arrayOf(
            "alfa",
            "rome",
            "alfa romeo",
            "alfa romeos",
            "alfalfa romeo",
            "alfalfa romeos",
            "x"
        )
        println("Test string = $testString")
        for (s in testSubstrings) {
            val index = FindSubstring.findSubstring(testString, s)
            assert(index == testString.indexOf(s))
            println("findSubstring($s) = $index")
        }
    }
}