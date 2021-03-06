package dev.ankulikov.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task1689Test {

    private final Task1689 task = new Task1689();

    @ParameterizedTest
    @MethodSource("data")
    public void should_provide_correct_output(String input, int expected) {
        // when
        var actual = task.minPartitions(input);

        // then
        assertEquals(expected, actual);
    }

    public static Stream<Arguments> data() {
        return Stream.of(
            Arguments.of("32", 3),
            Arguments.of("82734", 8),
            Arguments.of("27346209830709182346", 9)
        );
    }
}