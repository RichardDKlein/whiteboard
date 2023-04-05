package com.whiteboard;

/**
 * Alphabetize a given string.
 */
public final class AlphabetizeString {
    private AlphabetizeString() {
    }

    /**
     * Alphabetize a given string, WITHOUT using any of the Java
     * sorting utilities.
     *
     * We will use the bubble sort, due to its simplicity. True,
     * its performance is O(n*n), but that is acceptable for short
     * strings.
     *
     * @param string The string to search.
     * @return A copy of the given string, but in alphabetical
     * order.
     */
    public static String alphabetizeString(String string) {
        char[] buf = string.toCharArray();
        boolean swapOccurred;
        do {
            swapOccurred = false;
            for (int i = 0; i < buf.length - 1; ++i) {
                if (buf[i] > buf[i + 1]) {
                    char tmp = buf[i];
                    buf[i] = buf[i + 1];
                    buf[i + 1] = tmp;
                    swapOccurred = true;
                }
            }
        } while (swapOccurred);
        return new String(buf);
    }
}
