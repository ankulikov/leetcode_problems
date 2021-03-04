package dev.ankulikov.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task1593Test {

    private final Task1593 task = new Task1593();

    @ParameterizedTest
    @MethodSource("data")
    public void should_provide_correct_output(String string, int expected) {
        // when
        var actual = task.maxUniqueSplit(string);

        // then
        assertEquals(expected, actual);
    }

    public static Stream<Arguments> data() {
        return Stream.of(
            Arguments.of("ababccc", 5),
            Arguments.of("aba", 2),
            Arguments.of("aa", 1),
            Arguments.of("aaaaabbbcc", 6),
            Arguments.of("aaababccc", 6)
        );
    }

}