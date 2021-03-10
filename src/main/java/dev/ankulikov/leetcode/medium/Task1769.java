package dev.ankulikov.leetcode.medium;

/**
 * You have n boxes. You are given a binary string boxes of length n, where boxes[i] is '0' if the ith box is empty,
 * and '1' if it contains one ball.
 * <p>
 * In one operation, you can move one ball from a box to an adjacent box. Box i is adjacent to box j if abs(i - j) == 1.
 * Note that after doing so, there may be more than one ball in some boxes.
 * <p>
 * Return an array answer of size n, where answer[i] is the minimum number of operations needed to move all the balls to
 * the ith box.
 * <p>
 * Each answer[i] is calculated considering the initial state of the boxes.
 * <p>
 * Example 1:
 * <p>
 * Input: boxes = "110"
 * Output: [1,1,3]
 * Explanation: The answer for each box is as follows:
 * 1) First box: you will have to move one ball from the second box to the first box in one operation.
 * 2) Second box: you will have to move one ball from the first box to the second box in one operation.
 * 3) Third box: you will have to move one ball from the first box to the third box in two operations, and move one ball
 * from the second box to the third box in one operation.
 * Example 2:
 * <p>
 * Input: boxes = "001011"
 * Output: [11,8,5,4,3,4]
 *
 * @see <a href="https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/"></a>
 */
public class Task1769 {

    public int[] minOperations(String boxes) {
        final int[] output = new int[boxes.length()];
        // going from left to the right
        for (int idx = 0, countAccum = 0, movesAccum = 0; idx < boxes.length(); idx++) {
            output[idx] += movesAccum;
            countAccum += boxes.charAt(idx) == '1' ? 1 : 0;
            movesAccum += countAccum;
        }

        // going from right to the left
        for (int idx = boxes.length() - 1, countAccum = 0, movesAccum = 0; idx >=0; idx--) {
            output[idx] += movesAccum;
            countAccum += boxes.charAt(idx) == '1' ? 1 : 0;
            movesAccum += countAccum;
        }
        return output;
    }
}


