package dev.ankulikov.leetcode;

/**
 * You have a 2-D grid of size m x n representing a box, and you have n balls. The box is open on the top and bottom sides.
 * <p>
 * Each cell in the box has a diagonal board spanning two corners of the cell that can redirect a ball to the right or
 * to the left.
 * <p>
 * A board that redirects the ball to the right spans the top-left corner to the bottom-right corner and is represented
 * in the grid as 1.
 * A board that redirects the ball to the left spans the top-right corner to the bottom-left corner and is represented
 * in the grid as -1.
 * We drop one ball at the top of each column of the box. Each ball can get stuck in the box or fall out of the bottom.
 * A ball gets stuck if it hits a "V" shaped pattern between two boards or if a board redirects the ball into either
 * wall of the box.
 * <p>
 * Return an array answer of size n where answer[i] is the column that the ball falls out of at the bottom after dropping
 * the ball from the ith column at the top, or -1 if the ball gets stuck in the box.
 * <p>
 * <p>
 * <p>
 * Example 1:
 *
 * <img src="https://assets.leetcode.com/uploads/2019/09/26/ball.jpg" />
 * <p>
 * Input: grid = [[1,1,1,-1,-1],[1,1,1,-1,-1],[-1,-1,-1,1,1],[1,1,1,1,-1],[-1,-1,-1,-1,-1]]
 * Output: [1,-1,-1,-1,-1]
 * Explanation: This example is shown in the photo.
 * Ball b0 is dropped at column 0 and falls out of the box at column 1.
 * Ball b1 is dropped at column 1 and will get stuck in the box between column 2 and 3 and row 1.
 * Ball b2 is dropped at column 2 and will get stuck on the box between column 2 and 3 and row 0.
 * Ball b3 is dropped at column 3 and will get stuck on the box between column 2 and 3 and row 0.
 * Ball b4 is dropped at column 4 and will get stuck on the box between column 2 and 3 and row 1.
 * Example 2:
 * <p>
 * Input: grid = [[-1]]
 * Output: [-1]
 * Explanation: The ball gets stuck against the left wall.
 * Example 3:
 * <p>
 * Input: grid = [[1,1,1,1,1,1],[-1,-1,-1,-1,-1,-1],[1,1,1,1,1,1],[-1,-1,-1,-1,-1,-1]]
 * Output: [0,1,2,3,4,-1]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 100
 * grid[i][j] is 1 or -1.
 */

public class Task1706 {

    public int[] findBall(int[][] grid) {
        final var colCount = grid[0].length;
        int[] ballsPos = new int[colCount];
        for (int ballIdx = 0; ballIdx < colCount; ballIdx++) {
            int colIdx = ballIdx;
            for (int rowIdx = 0; rowIdx < grid.length; rowIdx++) {
                if ((colIdx = calculateNextColIdx(rowIdx, colIdx, grid)) == -1) {
                    break;
                }
            }
            ballsPos[ballIdx] = colIdx;

        }
        return ballsPos;
    }

    private int calculateNextColIdx(int rowIdx, int colIdx, int[][] grid) {
        int nextColIdx = colIdx + grid[rowIdx][colIdx];
        if (nextColIdx < 0 || nextColIdx >= grid[0].length || grid[rowIdx][nextColIdx] != grid[rowIdx][colIdx]) {
            return -1;
        }
        return nextColIdx;
    }

}
