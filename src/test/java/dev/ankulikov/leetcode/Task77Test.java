package dev.ankulikov.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task77Test {

    private final Task77 task = new Task77();

    @ParameterizedTest
    @MethodSource("data")
    public void should_provide_correct_output(int n, int k, List<List<Integer>> expected) {
        // when
        var actual = task.combine(n, k);

        // then
        assertEquals(expected, actual);
    }

    public static Stream<Arguments> data() {
        return Stream.of(
            Arguments.of(4, 2, List.of(
                List.of(1, 2),
                List.of(1, 3),
                List.of(1, 4),
                List.of(2, 3),
                List.of(2, 4),
                List.of(3, 4))
            ),
            Arguments.of(1, 1, List.of(List.of(1)))
        );
    }

}