package dev.ankulikov.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task121Test {

    Task121 task = new Task121();

    @ParameterizedTest
    @MethodSource("data")
    public void should_produce_correct_output(int[] input, int expected) {
        // when
        var actual = task.maxProfit(input);

        // then
        assertEquals(expected, actual);

    }

    private static Stream<Arguments> data() {
        return Stream.of(
            Arguments.of(new int[]{7, 1, 5, 3, 6, 4}, 5),
            Arguments.of(new int[]{7, 6, 4, 3, 1}, 0),
            Arguments.of(new int[]{2, 10, 1, 6}, 8),
            Arguments.of(new int[]{3, 8, 1, 7}, 6),
            Arguments.of(new int[]{1}, 0)
        );
    }

}