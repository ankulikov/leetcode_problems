package dev.ankulikov.leetcode.medium;

import dev.ankulikov.leetcode.medium.Task1706;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Task1706Test {

    private final Task1706 task = new Task1706();

    @ParameterizedTest
    @MethodSource("data")
    public void should_provide_correct_output(int[][] grid, int[] expected) {
        // when
        var actual = task.findBall(grid);

        // then
        assertArrayEquals(expected, actual);
    }

    public static Stream<Arguments> data() {
        return Stream.of(
            Arguments.of(new int[][]{
                {1, 1, 1, -1, -1},
                {1, 1, 1, -1, -1},
                {-1, -1, -1, 1, 1},
                {1, 1, 1, 1, -1},
                {-1, -1, -1, -1, -1}
            }, new int[]{1, -1, -1, -1, -1}),
            Arguments.of(new int[][]{{-1}}, new int[]{-1}),
            Arguments.of(new int[][]{
                    {1, 1, 1, 1, 1, 1},
                    {-1, -1, -1, -1, -1, -1},
                    {1, 1, 1, 1, 1, 1},
                    {-1, -1, -1, -1, -1, -1}
                }, new int[]{0, 1, 2, 3, 4, -1}
            ));
    }

}