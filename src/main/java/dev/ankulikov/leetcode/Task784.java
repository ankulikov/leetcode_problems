package dev.ankulikov.leetcode;

import java.util.List;
import java.util.stream.Stream;

import static java.lang.Character.isAlphabetic;
import static java.lang.Character.isLowerCase;
import static java.lang.Character.toLowerCase;
import static java.lang.Character.toUpperCase;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Stream.concat;

/**
 * Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.
 * <p>
 * Return a list of all possible strings we could create. You can return the output in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: S = "a1b2"
 * Output: ["a1b2","a1B2","A1b2","A1B2"]
 * Example 2:
 * <p>
 * Input: S = "3z4"
 * Output: ["3z4","3Z4"]
 * Example 3:
 * <p>
 * Input: S = "12345"
 * Output: ["12345"]
 * Example 4:
 * <p>
 * Input: S = "0"
 * Output: ["0"]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * S will be a string with length between 1 and 12.
 * S will consist only of letters or digits.
 */

public class Task784 {

    public List<String> letterCasePermutation(String str) {
        return letterCasePermutationFrom(str, 0)
            .collect(toList());
    }

    private static Stream<String> letterCasePermutationFrom(String str, int pos) {
        if (pos == str.length()) {
            return Stream.of("");
        }
        final var currChar = str.charAt(pos);
        final var sameCasePermutations = letterCasePermutationFrom(str, pos + 1)
            .map(tail -> currChar + tail);
        final var changedCasePermutations = isAlphabetic(currChar)
                                            ? letterCasePermutationFrom(str, pos + 1)
                                                .map(tail -> changeCase(currChar) + tail)
                                            : Stream.<String>empty();
        return concat(sameCasePermutations, changedCasePermutations);

    }

    private static char changeCase(char currChar) {
        return isLowerCase(currChar)
               ? toUpperCase(currChar)
               : toLowerCase(currChar);
    }

}
