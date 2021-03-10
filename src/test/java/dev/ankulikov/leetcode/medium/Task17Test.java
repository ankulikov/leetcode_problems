package dev.ankulikov.leetcode.medium;

import dev.ankulikov.leetcode.medium.Task17;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task17Test {

    private final Task17 task = new Task17();

    @ParameterizedTest
    @MethodSource("data")
    public void should_provide_correct_output(String digits, List<String> expected) {
        // when
        var actual = task.letterCombinations(digits);

        // then
        assertEquals(Set.copyOf(expected), Set.copyOf(actual));
    }

    public static Stream<Arguments> data() {
        return Stream.of(
            Arguments.of("23", List.of("ad","ae","af","bd","be","bf","cd","ce","cf")),
            Arguments.of("", List.of()),
            Arguments.of("2", List.of("a", "b", "c"))
        );
    }
}