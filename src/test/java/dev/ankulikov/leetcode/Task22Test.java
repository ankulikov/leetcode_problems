package dev.ankulikov.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task22Test {

    private final Task22 task = new Task22();

    @ParameterizedTest
    @MethodSource("data")
    public void should_provide_correct_output(int pairsCount, List<String> expected) {
        // when
        var actual = task.generateParenthesis(pairsCount);

        // then
        assertEquals(expected, actual);
    }

    public static Stream<Arguments> data() {
        return Stream.of(
            Arguments.of(3, List.of("((()))","(()())","(())()","()(())","()()()")),
            Arguments.of(1, List.of("()")),
            Arguments.of(2, List.of("(())", "()()"))
        );
    }

}