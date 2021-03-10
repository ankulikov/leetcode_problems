package dev.ankulikov.leetcode.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task1325Test {

    Task1325 task = new Task1325();

    @ParameterizedTest
    @MethodSource("data")
    public void should_produce_correct_output(TreeNode rootNode, int target, TreeNode expected) {
        // when
        var actual = task.removeLeafNodes(rootNode, target);

        // then
        assertEquals(expected, actual);

    }

    private static Stream<Arguments> data() {
        return Stream.of(
            Arguments.of(
                new TreeNode(1,
                    new TreeNode(2,
                        new TreeNode(2),
                        null),
                    new TreeNode(3,
                        new TreeNode(2),
                        new TreeNode(4))),
                2,
                new TreeNode(1,
                    null,
                    new TreeNode(3,
                        null,
                        new TreeNode(4)))),
            Arguments.of(
                new TreeNode(1,
                    new TreeNode(3,
                        new TreeNode(3),
                        new TreeNode(2)),
                    new TreeNode(3)),
                3,
                new TreeNode(1,
                    new TreeNode(3,
                        null,
                        new TreeNode(2)),
                    null)),
            Arguments.of(
                new TreeNode(1,
                    new TreeNode(2,
                        new TreeNode(2,
                            new TreeNode(2),
                            null),
                        null),
                    null),
                2,
                new TreeNode(1)),
            Arguments.of(
                new TreeNode(1,
                    new TreeNode(1,
                        new TreeNode(1),
                        null),
                    null),
                1,
                null)
        );
    }

}