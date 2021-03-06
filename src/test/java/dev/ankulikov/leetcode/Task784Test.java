package dev.ankulikov.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task784Test {

    private final Task784 task = new Task784();

    @ParameterizedTest
    @MethodSource("data")
    public void should_provide_correct_output(String input, List<String> expected) {
        // when
        var actual = task.letterCasePermutation(input);

        // then
        assertEquals(Set.copyOf(actual), Set.copyOf(expected));
    }

    public static Stream<Arguments> data() {
        return Stream.of(
            Arguments.of("a1b2", List.of("a1b2", "a1B2", "A1b2", "A1B2")),
            Arguments.of("3z4", List.of("3z4", "3Z4")),
            Arguments.of("12345", List.of("12345")),
            Arguments.of("0", List.of("0")),
            Arguments.of("A", List.of("A", "a"))
        );
    }

}