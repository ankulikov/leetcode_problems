package dev.ankulikov.leetcode;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Given a string s, return the maximum number of unique substrings that the given string can be split into.
 * <p>
 * You can split string s into any list of non-empty substrings, where the concatenation of the substrings forms the original string. However, you must split the substrings such that all of them are unique.
 * <p>
 * A substring is a contiguous sequence of characters within a string.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "ababccc"
 * Output: 5
 * Explanation: One way to split maximally is ['a', 'b', 'ab', 'c', 'cc']. Splitting like ['a', 'b', 'a', 'b', 'c', 'cc'] is not valid as you have 'a' and 'b' multiple times.
 * Example 2:
 * <p>
 * Input: s = "aba"
 * Output: 2
 * Explanation: One way to split maximally is ['a', 'ba'].
 * Example 3:
 * <p>
 * Input: s = "aa"
 * Output: 1
 * Explanation: It is impossible to split the string any further.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 16
 * <p>
 * s contains only lower case English letters.
 *
 * @see <a href="https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings/">   </a>
 */

public class Task1593 {

    public int maxUniqueSplit(String s) {
        return splitFromPos(0, s, new HashSet<>());
    }

    private int splitFromPos(int pos, String s, Set<String> substrings) {
        if (pos == s.length()) {
            return substrings.size();
        }

        int max = 0;
        for (int i = pos; i < s.length(); i++) {
            final var word = s.substring(pos, i + 1);
            if (!substrings.contains(word)) {
                substrings.add(word);
                max = Math.max(max, splitFromPos(i + 1, s, substrings));
                System.out.println(substrings);
                substrings.remove(word);
            }
        }
        return max;
    }

}
