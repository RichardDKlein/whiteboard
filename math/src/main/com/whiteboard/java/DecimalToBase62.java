package com.whiteboard.java;

/**
 * Converts a decimal number (positive integer) to base 36.
 */
public final class DecimalToBase62 {
    private DecimalToBase62() {
    }

    /**
     * Converts a decimal number (positive integer) to base 62.
     *
     * The base 62 version of the number will use the characters
     * 0-9, A-Z, and a-z to represent each digit.
     *
     * This function could be useful in a `URL Shortener` service,
     * which redirects a short URL to a desired (and longer) target
     * URL. Such a service might be useful when you want to embed
     * a link in a Twitter/X tweet, for example.
     *
     * The implementation of the service could have a database
     * table that maps short URLs to long URLs. The ID of each
     * row in the table could be passed to decimalToBase62() to
     * generate the short URL.
     *
     * @param n The decimal number (positive integer) to convert
     *          to base 62.
     * @return The base 62 representation of the given decimal
     * number.
     */
    public static String decimalToBase62(int n) {
        String BASE62_DIGITS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String result = "";
        while (n > 0) {
            int digit = n % 62;
            result = BASE62_DIGITS.charAt(digit) + result;
            n /= 62;
        }
        return result;
    }
}
