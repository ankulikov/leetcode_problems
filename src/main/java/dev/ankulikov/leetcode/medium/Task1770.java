package dev.ankulikov.leetcode.medium;

/**
 * You are given two integer arrays nums and multipliers of size n and m respectively, where n >= m. The arrays are 1-indexed.
 * <p>
 * You begin with a score of 0. You want to perform exactly m operations. On the ith operation (1-indexed), you will:
 * <p>
 * Choose one integer x from either the start or the end of the array nums.
 * Add multipliers[i] * x to your score.
 * Remove x from the array nums.
 * Return the maximum score after performing m operations.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3], multipliers = [3,2,1]
 * Output: 14
 * Explanation: An optimal solution is as follows:
 * - Choose from the end, [1,2,3], adding 3 * 3 = 9 to the score.
 * - Choose from the end, [1,2], adding 2 * 2 = 4 to the score.
 * - Choose from the end, [1], adding 1 * 1 = 1 to the score.
 * The total score is 9 + 4 + 1 = 14.
 * Example 2:
 * <p>
 * Input: nums = [-5,-3,-3,-2,7,1], multipliers = [-10,-5,3,4,6]
 * Output: 102
 * Explanation: An optimal solution is as follows:
 * - Choose from the start, [-5,-3,-3,-2,7,1], adding -5 * -10 = 50 to the score.
 * - Choose from the start, [-3,-3,-2,7,1], adding -3 * -5 = 15 to the score.
 * - Choose from the start, [-3,-2,7,1], adding -3 * 3 = -9 to the score.
 * - Choose from the end, [-2,7,1], adding 1 * 4 = 4 to the score.
 * - Choose from the end, [-2,7], adding 7 * 6 = 42 to the score.
 * The total score is 50 + 15 - 9 + 4 + 42 = 102.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == nums.length
 * m == multipliers.length
 * 1 <= m <= 103
 * m <= n <= 105
 * -1000 <= nums[i], multipliers[i] <= 1000
 *
 * @see <a href="https://leetcode.com/problems/maximum-score-from-performing-multiplication-operations/"></a>
 */

public class Task1770 {

    public int maximumScore(int[] nums, int[] multipliers) {
        final var operationsCount = multipliers.length;
        return calculateAndCacheMaximumFor(0, 0, nums, multipliers, new Integer[operationsCount][operationsCount]);
    }

    private int calculateAndCacheMaximumFor(int leftIdx, int idx, int[] nums, int[] multipliers, Integer[][] cache) {
        final var numsCount = nums.length;
        final var operationsCount = multipliers.length;
        if (idx == operationsCount) {
            return 0;
        }
        final var cachedResult = cache[leftIdx][idx];
        if (cachedResult != null) {
            return cachedResult;
        }
        int leftResult = calculateAndCacheMaximumFor(leftIdx + 1, idx + 1, nums, multipliers, cache) +
            nums[leftIdx] * multipliers[idx];
        int rightResult = calculateAndCacheMaximumFor(leftIdx, idx + 1, nums, multipliers, cache) +
            nums[(numsCount - 1) - (idx - leftIdx)] * multipliers[idx];
        final var result = Math.max(leftResult, rightResult);
        System.out.printf("%d, %d: %d\n", leftIdx, idx, result);
        return cache[leftIdx][idx] = result;
    }
}
