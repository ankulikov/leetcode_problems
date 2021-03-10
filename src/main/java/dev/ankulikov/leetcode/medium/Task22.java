package dev.ankulikov.leetcode.medium;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Stream.concat;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * Example 2:
 * <p>
 * Input: n = 1
 * Output: ["()"]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 8
 *
 * @see <a href="https://leetcode.com/problems/generate-parentheses/"></a>
 */

public class Task22 {

        public List<String> generateParenthesis(int n) {
            return generateParenthesisPartial(0, 0, n)
                .collect(toList());

        }

        private Stream<String> generateParenthesisPartial(int openedCount, int closedCount, int pairsCount) {
            if (openedCount == pairsCount && closedCount == pairsCount) {
                return Stream.of("");
            }
            final var withOpenedOrSkipped = openedCount < pairsCount
                                            ? generateParenthesisPartial(openedCount + 1, closedCount, pairsCount)
                                                .map(tail -> "(" + tail)
                                            : Stream.<String>of();

            final var withClosedOrSkipped = openedCount > closedCount
                                            ? generateParenthesisPartial(openedCount, closedCount + 1, pairsCount)
                                                .map(tail -> ")" + tail)
                                            : Stream.<String>of();

            return concat(withOpenedOrSkipped, withClosedOrSkipped);
        }
}
