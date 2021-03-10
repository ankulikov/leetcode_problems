package dev.ankulikov.leetcode.medium;

import dev.ankulikov.leetcode.medium.Task34;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Task34Test {

    private final Task34 task = new Task34();

    @ParameterizedTest
    @MethodSource("data")
    public void should_provide_correct_output(int[] nums, int target, int[] expected) {
        // when
        var actual = task.searchRange(nums, target);

        // then
        assertArrayEquals(expected, actual);
    }

    public static Stream<Arguments> data() {
        return Stream.of(
            Arguments.of(new int[]{5, 7, 7, 8, 8, 10}, 8, new int[]{3, 4}),
            Arguments.of(new int[]{5, 7, 7, 8, 8, 10}, 6, new int[]{-1, -1}),
            Arguments.of(new int[]{4, 4, 4, 4, 4, 4}, 4, new int[]{0, 5}),
            Arguments.of(new int[]{3, 3, 3}, 3, new int[]{0, 2}),
            Arguments.of(new int[]{3, 3, 3}, 2, new int[]{-1, -1}),
            Arguments.of(new int[]{1, 1, 2, 2, 3}, 3, new int[]{4, 4}),
            Arguments.of(new int[]{}, 0, new int[]{-1, -1})
        );
    }
}