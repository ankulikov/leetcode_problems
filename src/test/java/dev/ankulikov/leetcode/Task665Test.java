package dev.ankulikov.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task665Test {

    private final Task665 task = new Task665();

    @ParameterizedTest
    @MethodSource("data")
    public void should_provide_correct_output(int[] input, boolean expected) {
        // when
        var actual = task.checkPossibility(input);

        // then
        assertEquals(expected, actual);
    }

    public static Stream<Arguments> data() {
        return Stream.of(
            Arguments.of(new int[]{4, 2, 3}, true),
            Arguments.of(new int[]{4, 2, 1}, false),
            Arguments.of(new int[]{3, 4, 2, 3}, false),
            Arguments.of(new int[]{-1, 4, 2, 3}, true),
            Arguments.of(new int[]{1, 3, 2}, true),
            Arguments.of(new int[]{5, 7, 1, 8}, true)
            );

        // 1   2
        // 7   8
    }

}