package com.whiteboard.kotlin

import java.util.HashMap

/**
 * Determine whether two strings are permutations of each other.
 */
object AreStringsPermutations {
    /**
     * Determine whether two strings are permutations of each other.
     *
     * @param s1 One of the strings.
     * @param s2 The other string.
     * @return A boolean indicating whether ('true) or not ('false')
     * s1 and s2 are permutations of each other.
     */
    fun areStringsPermutations(s1: String, s2: String): Boolean {
        val s1Inventory = inventoryStringChars(s1)
        val s2Inventory = inventoryStringChars(s2)
        return s1Inventory == s2Inventory
    }

    private fun inventoryStringChars(s: String): Map<Char, Int> {
        val result: MutableMap<Char, Int> = HashMap()
        for (c in s) {
            val count = result.getOrDefault(c, 0)
            result[c] = count + 1
        }
        return result
    }
}
