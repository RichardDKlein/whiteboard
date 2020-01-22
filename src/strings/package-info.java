package strings;

/**
 * ========================================================================
 *                                  HINTS
 * ========================================================================
 *
 * FindSubstring
 * -------------
 * Loop thru string from 0 to last possible index where substring could fit
 * Look for first char of substring
 * When you find it, see if the rest of the chars match
 *
 * LongestPalindromicSubstring
 * ---------------------------
 * Static inner helper class Interval
 * For each char in string, find longest odd- and even-length palindrome centered at that char
 * Use helper class longestCenteredAt() for that
 */
