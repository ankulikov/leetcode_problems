package dev.ankulikov.leetcode;

/**
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a
 * given target value.
 * <p>
 * If target is not found in the array, return [-1, -1].
 * <p>
 * Follow up: Could you write an algorithm with O(log n) runtime complexity?
 *
 * @see <a href="https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/"></a>
 */

public class Task34 {

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        final var targetIdx = binarySearchWithBoundaries(0, nums.length - 1, target, nums);
        if (targetIdx == -1) {
            return new int[]{-1, -1};
        }
        int lowerBoundIdx = targetIdx;
        int upperBoundIdx = targetIdx;
        for (int i = lowerBoundIdx - 1; i >= 0; i--) {
            if (nums[i] == target) {
                lowerBoundIdx = i;
            }
        }
        for (int i = upperBoundIdx + 1; i <= nums.length - 1; i++) {
            if (nums[i] == target) {
                upperBoundIdx = i;
            }
        }
        return new int[]{lowerBoundIdx, upperBoundIdx};
    }

    public int binarySearchWithBoundaries(int fromIdx, int toIdx, int target, int[] arr) {

        if (fromIdx == toIdx) {
            return target == arr[fromIdx] ? fromIdx : -1;
        }
        int splitIdx = (fromIdx + toIdx) / 2;
        if (arr[splitIdx] >= target) {
            return binarySearchWithBoundaries(fromIdx, splitIdx, target, arr);
        } else {
            return binarySearchWithBoundaries(splitIdx + 1, toIdx, target, arr);
        }
    }

}
