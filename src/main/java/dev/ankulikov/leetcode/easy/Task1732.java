package dev.ankulikov.leetcode.easy;

/**
 * 1732. Find the Highest Altitude
 * There is a biker going on a road trip. The road trip consists of n + 1 points at different altitudes.
 * The biker starts his trip on point 0 with altitude equal 0.
 * <p>
 * You are given an integer array gain of length n where gain[i] is the net gain in altitude between points
 * i and i + 1 for all (0 <= i < n). Return the highest altitude of a point.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: gain = [-5,1,5,0,-7]
 * Output: 1
 * Explanation: The altitudes are [0,-5,-4,1,1,-6]. The highest is 1.
 * Example 2:
 * <p>
 * Input: gain = [-4,-3,-2,-1,4,3,2]
 * Output: 0
 * Explanation: The altitudes are [0,-4,-7,-9,-10,-6,-3,-1]. The highest is 0.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == gain.length
 * 1 <= n <= 100
 * -100 <= gain[i] <= 100
 *
 * @see <a href="https://leetcode.com/problems/find-the-highest-altitude/"></a>
 */

public class Task1732 {

    public int largestAltitude(int[] gain) {
        int max = 0;
        int current = 0;
        for (int j : gain) {
            current += j;
            if (current > max) {
                max = current;
            }
        }
        return max;
    }

}
