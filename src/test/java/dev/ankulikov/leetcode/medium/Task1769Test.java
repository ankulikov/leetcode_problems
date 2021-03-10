package dev.ankulikov.leetcode.medium;

import dev.ankulikov.leetcode.medium.Task1769;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Task1769Test {

    private final Task1769 task = new Task1769();

    @ParameterizedTest
    @MethodSource("data")
    public void should_provide_correct_output(String boxes, int[] expected) {
        // when
        var actual = task.minOperations(boxes);

        // then
        assertArrayEquals(expected, actual);
    }

    public static Stream<Arguments> data() {
        return Stream.of(
            Arguments.of("110", new int[]{1, 1, 3}),
            Arguments.of("001011", new int[]{11, 8, 5, 4, 3, 4}),
            Arguments.of("111", new int[]{3, 2, 3})
        );
    }

}