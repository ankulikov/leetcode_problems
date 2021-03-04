package dev.ankulikov.leetcode;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number
 * could represent. Return the answer in any order.
 * <p>
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map
 * to any letters.
 *
 * <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/7/73/Telephone-keypad2.svg/200px-Telephone-keypad2.svg.png"/>
 *
 * @see <a href="https://leetcode.com/problems/letter-combinations-of-a-phone-number/"></a>
 */

public class Task17 {

    private static final Map<Character, List<Character>> DIGIT_TO_LETTERS = Map.of(
        '2', List.of('a', 'b', 'c'),
        '3', List.of('d', 'e', 'f'),
        '4', List.of('g', 'h', 'i'),
        '5', List.of('j', 'k', 'l'),
        '6', List.of('m', 'n', 'o'),
        '7', List.of('p', 'q', 'r', 's'),
        '8', List.of('t', 'u', 'v'),
        '9', List.of('w', 'x', 'y', 'z')
    );

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return List.of();
        }
        return generateCombinations(digits, 0)
            .collect(toList());

    }

    private Stream<String> generateCombinations(String str, int pos) {
        if (pos == str.length()) {
            return Stream.of("");
        }
        final var letters = DIGIT_TO_LETTERS.get(str.charAt(pos));
        return letters.stream()
            .flatMap(letter -> generateCombinations(str, pos + 1)
                .map(tail -> letter + tail));
    }

}
