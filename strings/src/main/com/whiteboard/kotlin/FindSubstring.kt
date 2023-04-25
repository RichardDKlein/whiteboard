package com.whiteboard.kotlin

/**
 * Find a specified substring in a string.
 */
object FindSubstring {
    /**
     * Find a specified substring in a string.
     *
     * @param string The string to search.
     * @param substring The substring to find.
     * @return The index of the specified substring in the specified
     * string, or -1 if the substring cannot be found.
     */
    fun findSubstring(string: String, substring: String): Int {
        val lastIndexToCheck = string.length - substring.length
        for (i in 0..lastIndexToCheck) {
            if (substringFound(string, substring, i)) {
                return i
            }
        }
        return -1
    }

    private fun substringFound(string: String, substring: String, index: Int): Boolean {
        for (i in substring.indices) {
            if (substring[i] != string[index + i]) {
                return false
            }
        }
        return true
    }
}