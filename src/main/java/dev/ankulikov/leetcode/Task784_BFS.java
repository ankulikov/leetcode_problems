package dev.ankulikov.leetcode;

import java.util.LinkedList;
import java.util.List;

import static java.lang.Character.isAlphabetic;
import static java.lang.Character.toLowerCase;
import static java.lang.Character.toUpperCase;
import static java.util.stream.IntStream.range;

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

public class Task784_BFS {

    public List<String> letterCasePermutation(String str) {
        if (str == null) {
            return List.of();
        }
        final var queue = new LinkedList<String>();
        queue.offer(str);

        range(0, str.length()).forEach(charPos -> {
            if (isAlphabetic(str.charAt(charPos))) {
                final var queueSize = queue.size();
                range(0, queueSize).forEach(__ -> {
                    final var currStr = queue.poll();
                    final var currCharArr = currStr.toCharArray();

                    currCharArr[charPos] = toUpperCase(currCharArr[charPos]);
                    queue.offer(String.valueOf(currCharArr));

                    currCharArr[charPos] = toLowerCase(currCharArr[charPos]);
                    queue.offer(String.valueOf(currCharArr));
                });

            }
        });
        return List.copyOf(queue);
    }

    public static void main(String[] args) {
        final var task = new Task784_BFS();
        task.letterCasePermutation("ab1c");
    }

}
