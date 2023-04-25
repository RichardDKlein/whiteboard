package com.whiteboard.kotlin

import org.junit.Test

class AreStringsPermutationsTest {
    @Test
    fun stringsArePermutationsTest() {
        println()
        println("Test AreStringsPermutations:")
        println("============================")
        val testStrings = arrayOf(
                arrayOf("Hello, world!", "Hello, world!"),
                arrayOf("Hello, world!", "Hello, World!"),
                arrayOf("Hello, world!", "!dlrow ,olleH"),
                arrayOf("aabbb", "aabbb"),
                arrayOf("aabbb", "babab"),
                arrayOf("aabbb", "ababa"))

        val expected = booleanArrayOf(
                true,
                false,
                true,
                true,
                true,
                false
        )

        for (i in testStrings.indices) {
            val s1 = testStrings[i][0]
            val s2 = testStrings[i][1]
            println("s1 = $s1, s2 = $s2")
            val arePermutations = AreStringsPermutations.areStringsPermutations(s1, s2)
            assert(arePermutations == expected[i])
            println("stringsArePermutations(\"" +
                    s1 + "\", \"" + s2 + "\") = " + arePermutations)
        }
    }
}