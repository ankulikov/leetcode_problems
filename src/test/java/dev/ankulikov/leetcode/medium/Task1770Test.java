package dev.ankulikov.leetcode.medium;

import dev.ankulikov.leetcode.medium.Task1770;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task1770Test {

    private final Task1770 task = new Task1770();

    @ParameterizedTest
    @MethodSource("data")
    public void should_provide_correct_output(int[] nums, int[] multipliers, int expected) {
        // when
        var actual = task.maximumScore(nums, multipliers);

        // then
        assertEquals(expected, actual);
    }

    public static Stream<Arguments> data() {
        return Stream.of(
            Arguments.of(new int[]{1, 2, 3}, new int[]{3, 2, 1}, 14),
            Arguments.of(new int[]{-5, -3, -3, -2, 7, 1}, new int[]{-10, -5, 3, 4, 6}, 102)
        );
    }
}