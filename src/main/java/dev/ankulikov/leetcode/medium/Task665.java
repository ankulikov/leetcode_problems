package dev.ankulikov.leetcode.medium;

/**
 * Given an array nums with n integers, your task is to check if it could become non-decreasing by
 * modifying at most one element.
 * <p>
 * We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for every i (0-based) such that (0 <= i <= n - 2).
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [4,2,3]
 * Output: true
 * Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
 * Example 2:
 * <p>
 * Input: nums = [4,2,1]
 * Output: false
 * Explanation: You can't get a non-decreasing array by modify at most one element.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == nums.length
 * 1 <= n <= 104
 * -105 <= nums[i] <= 105
 *
 * @see <a href="https://leetcode.com/problems/non-decreasing-array/"></a>
 */

public class Task665 {

    public boolean checkPossibility(int[] nums) {
        boolean modified = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                if (modified) {
                    return false;
                }
                modified = true;
                if (i == 1 || nums[i] >= nums[i - 2]) {
                    nums[i - 1] = nums[i];
                } else {
                    nums[i] = nums[i - 1];
                }
            }
        }
        return true;

    }
}
