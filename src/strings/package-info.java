package strings;

/**
 * ========================================================================
 *                                  HINTS
 * ========================================================================
 *
 * FindSubstring
 * -------------
 * Loop thru string from 0 to last possible index where substring could fit.
 * Look for first char of substring.
 * When you find it, see if the rest of the chars match.
 *
 * LongestPalindromicSubstring
 * ---------------------------
 * Static inner helper class Interval.
 * For each char in string, find longest odd- and even-length palindrome centered at that char.
 * Use helper class longestCenteredAt() for that.
 *
 * ParseStringIntoWords
 * --------------------
 * Return an empty list if given string is empty, null list if cannot parse it.
 * Use for loop to try longer and longer first words, until find one that allows
 *     the remainder to be parsed.
 * Don't forget to check whether the first word is in the dictionary!
 * If no such first word is found, return null.
 *
 * PermutationsOfString
 * --------------------
 * If given string is empty, it is its only permutation. Add it to result list and return.
 */
