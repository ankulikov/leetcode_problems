package dev.ankulikov.leetcode.medium;

import dev.ankulikov.leetcode.medium.Task784_BFS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Task784_BFSTest {

    private final Task784_BFS task = new Task784_BFS();

    @ParameterizedTest
    @MethodSource("data")
    public void should_provide_correct_output(String input, List<String> expected) {
        // when
        var actual = task.letterCasePermutation(input);

        // then
        assertEquals(Set.copyOf(expected), Set.copyOf(actual));
    }

    public static Stream<Arguments> data() {
        return Stream.of(
            Arguments.of("a1b2", List.of("a1b2", "a1B2", "A1b2", "A1B2")),
            Arguments.of("3z4", List.of("3z4", "3Z4")),
            Arguments.of("12345", List.of("12345")),
            Arguments.of("0", List.of("0")),
            Arguments.of("A", List.of("A", "a"))
        );
    }

}