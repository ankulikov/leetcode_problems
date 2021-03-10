package dev.ankulikov.leetcode.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task1732Test {

    Task1732 task = new Task1732();

    @ParameterizedTest
    @MethodSource("data")
    public void should_produce_correct_output(int[] gain, int expected) {
        // when
        var actual = task.largestAltitude(gain);

        // then
        assertEquals(expected, actual);

    }

    private static Stream<Arguments> data() {
        return Stream.of(
            Arguments.of(new int[]{-5, 1, 5, 0, -7}, 1),
            Arguments.of(new int[]{-4, -3, -2, -1, 4, 3, 2}, 0),
            Arguments.of(new int[]{1}, 1),
            Arguments.of(new int[]{-100}, 0)
        );
    }

}